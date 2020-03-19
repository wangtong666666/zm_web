
package cn.wt.zmweb.entity;
import java.util.List;

/**
* ********************************************************
* @ClassName: TSysRole
* @Description: id
* @author 用wt写的自动生成
* @date 2019-10-09 上午 06:20:17 
*******************************************************
*/
public class TSysRole extends BaseEntity{

	private String name;		//
	private String description;		//
	private Integer id;		//
	private List<TSysPermission> permissionList;


	public List<TSysPermission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<TSysPermission> permissionList) {
		this.permissionList = permissionList;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}

