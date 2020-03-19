
package cn.wt.zmweb.entity;

/**
* ********************************************************
* @ClassName: TSysRoleUser
* @Description: id
* @author 用wt写的自动生成
* @date 2019-10-09 上午 06:22:02 
*******************************************************
*/
public class TSysRoleUser extends BaseEntity{

	private Integer roleId;		//
	private Integer userId;		//
	private String remark;		//
	private Integer id;		//

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}

