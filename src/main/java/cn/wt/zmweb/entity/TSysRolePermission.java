
package cn.wt.zmweb.entity;

/**
* ********************************************************
* @ClassName: TSysRolePermission
* @Description: id
* @author 用wt写的自动生成
* @date 2019-10-09 上午 06:21:48 
*******************************************************
*/
public class TSysRolePermission extends BaseEntity{

	private Integer roleId;		//
	private Integer id;		//
	private Integer permissionId;		//

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

}

