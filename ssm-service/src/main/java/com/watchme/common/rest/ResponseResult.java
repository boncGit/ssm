/**
 * Copyright (c) 2014 Baidu, Inc. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.watchme.common.rest;

import com.alibaba.fastjson.JSON;
import com.watchme.tool.cache.CacheConstant;
import com.watchme.tool.cache.CacheUtil;
import com.watchme.tool.key.DsPubKeyTool;
import com.watchme.tool.key.DsSecurityTool;
import com.watchme.tool.key.init.ToolKeyInit;
import com.watchme.tool.utils.DSUrlUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Rest Service结果集对象，封装rest返回值
 *
 */
public class ResponseResult implements Serializable {

	private static final long serialVersionUID = -4826258907545698916L;

	public ResponseResult(boolean encFlag) {
		this.status = SUCCESS;
		this.encNeed = encFlag;
	}

	public ResponseResult() {
		this.status = SUCCESS;
		this.encNeed = false;
	}

	/**
	 * 操作成功
	 */
	public static final String SUCCESS = "0000";

	/**
	 * 入库保存失败
	 */
	public static final String ERROR = "0001";

	private boolean encNeed;// 是否需要加密

	private boolean encStatue;// 是否已经加密过
	/**
	 * 返回状态
	 */
	private String status;

	/**
	 * 返回状态信息，如提示信息、错误描述信息等
	 */
	private String statusInfo;

	/**
	 * 数据信息(对象的话，用json)，如果需要返回数据，将数据封装到集合对象中返回
	 */
	private String data;

	/**
	 * (加密后对称)密钥
	 */
	private String secretKeyText;

	/**
	 * 发送请求的sysId
	 */
	private String sysId;

	/**
	 * 其他未定属性信息
	 */
	private Map<String, Serializable> properties = new HashMap<String, Serializable>();

	/**
	 * 添加属性信息
	 *
	 * @param key
	 * @param value
	 */
	public void addProperty(String key, Serializable value) {
		this.properties.put(key, value);
	}

	/**
	 * get statusInfo
	 *
	 * @return the statusInfo
	 */
	public String getStatusInfo() {
		return statusInfo;
	}

	/**
	 * set statusInfo with statusInfo
	 *
	 * @param statusInfo
	 *            the statusInfo to set
	 */
	public void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}

	/**
	 * get status
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * set status with status
	 *
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public String getSysId() {
		return sysId;
	}

	public void setSysId(String sysId) {
		this.sysId = sysId;
	}

	public boolean isEncNeed() {
		return encNeed;
	}

	public void setEncNeed(boolean encNeed) {
		this.encNeed = encNeed;
	}

	public boolean isEncStatue() {
		return encStatue;
	}

	public void setEncStatue(boolean encStatue) {
		this.encStatue = encStatue;
	}

	/**
	 * get data
	 *
	 * @return the data
	 */
	public String getData() {
		String result = data;
		if (encNeed && SUCCESS.equals(status) && StringUtils.isNotBlank(data)) {

			if (StringUtils.isBlank(secretKeyText)) {
				return result;
			}
			String secretKeyTextPar = DSUrlUtil.parserUrl(secretKeyText);
			String dataPar = DSUrlUtil.parserUrl(data);
			Object typeObj = CacheUtil.get(CacheConstant.REGION_KEYS, CacheConstant.TRAN_ASYM_CACHE_PREFIX + sysId);
			String keyType = typeObj == null ? "4" : typeObj.toString();// 默认rsa
			String key = DsPubKeyTool.getPrivateKeyBySysId(sysId);
			try {
				// 通过非对称私钥，解密出对称秘钥
				String keyStr = DsSecurityTool.getInstance().decrypt(keyType, key, secretKeyTextPar);
				// 获得对称加密类型
				Object encTypeObj = CacheUtil.get(CacheConstant.REGION_KEYS, CacheConstant.TRAN_SYM_CACHE_PREFIX + sysId);
				String encType = encTypeObj == null ? "0" : encTypeObj.toString();// 默认aes
				// 通过对称秘钥对加密数据解密
				result = DsSecurityTool.getInstance().decrypt(encType, keyStr, dataPar);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * set data with data
	 *
	 * @param data
	 *            the data to set
	 */
	public void setData(String tempData) {
		try {
			if (encNeed && !encStatue && SUCCESS.equals(status) && tempData != null && StringUtils.isNotBlank(tempData)) {
				// 传输中，对称加密类型
				Object typeObj = CacheUtil.get(CacheConstant.REGION_KEYS, CacheConstant.TRAN_SYM_CACHE_PREFIX + sysId);
				String encType = typeObj == null ? "0" : typeObj.toString();// 默认aes
				// 1、生成对称秘钥
				String symmetricKey = ToolKeyInit.initKeyByType(encType);
				// 2、对称秘钥加密数据
				String encData = DsSecurityTool.getInstance().encrypt(encType, symmetricKey, tempData);
				// 3、非对称公钥加密对称秘钥
				String rsaV = DsPubKeyTool.encByDSPubKey(symmetricKey, sysId);
				// 4、设置结果
				this.data = DSUrlUtil.replaceUrl(encData);// 密文
				this.secretKeyText = DSUrlUtil.replaceUrl(rsaV);// 对称密钥加密
				this.encStatue = true;

			} else {
				this.data = tempData;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 如果是对象，调用本方法自动将对象转换成JSON
	 *
	 * @param dataObj
	 *            返回的对象
	 */
	public void setData(Object dataObj) {
		String tempData = null;
		if (dataObj instanceof String) {
			tempData = (String) dataObj;
		} else {
			tempData = JSON.toJSONString(dataObj);
		}
		setData(tempData);

	}

	/**
	 * get properties
	 *
	 * @return the properties
	 */
	public Map<String, Serializable> getProperties() {
		return properties;
	}

	/**
	 * set properties with properties
	 *
	 * @param properties
	 *            the properties to set
	 */
	public void setProperties(Map<String, Serializable> properties) {
		this.properties = properties;
	}

	public String getSecretKeyText() {
		return secretKeyText;
	}

	public void setSecretKeyText(String secretKeyText) {
		this.secretKeyText = secretKeyText;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResponseResult [status=" + status + ", statusInfo=" + statusInfo + ", data=" + data + ", properties=" + properties + "]";
	}
}
