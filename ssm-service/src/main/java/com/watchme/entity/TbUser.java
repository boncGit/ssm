package com.watchme.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Mengxy
 * @since 2018-07-26
 */
@TableName("tb_user")
public class TbUser extends Model<TbUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId("ID")
	private String id;
    /**
     * 用户编码
     */
	@TableField("USER_CODE")
	private String userCode;
    /**
     * 用户名称
     */
	@TableField("USER_NAME")
	private String userName;
    /**
     * 移动电话号码
     */
	@TableField("MOBILE")
	private String mobile;
    /**
     * 邮箱
     */
	@TableField("EMAIL")
	private String email;
    /**
     * 创建人
     */
	@TableField("CREATOR")
	private String creator;
    /**
     * 创建时间
     */
	@TableField("CREATE_TIME")
	private Date createTime;
    /**
     * 更新人
     */
	@TableField("UPDATOR")
	private String updator;
    /**
     * 更新时间
     */
	@TableField("UPDATE_TIME")
	private Date updateTime;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdator() {
		return updator;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
