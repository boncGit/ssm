package com.watchme.system.role.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author mengxy
 * @since 2018-08-08
 */
@TableName("tb_role")
public class TbRole extends Model<TbRole> {

    private static final long serialVersionUID = 1L;

	private String id;
	@TableField("role_name")
	private String roleName;
	@TableField("role_code")
	private String roleCode;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
