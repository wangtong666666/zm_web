
package cn.wt.zmweb.entity;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
* ********************************************************
* @ClassName: TSysUser
* @Description: id
* @author 用wt写的自动生成
* @date 2019-10-09 上午 06:17:54 
*******************************************************
*/
public class TSysUser extends BaseEntity{

	@NotBlank(message = "密码不能为空！")
	@Length(min=6,max=18,message = "密码格式不符合要求（6 - 18 位字符）")
	private String password;		//
	private String trueName;		//真实姓名

	@NotBlank(message = "用户名不能为空！")
	@Pattern(regexp = "^[1-9]\\d{10}$",message = "手机号格式不正确！")
	private String userName;		//
	private Integer id;		//主键id
	private String createDate;		//创建时间（yyyy-MM-dd HH:mm:ss）

	private List<TSysRole> roleList;


	public List<TSysRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<TSysRole> roleList) {
		this.roleList = roleList;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTrueName() {
		return this.trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}

