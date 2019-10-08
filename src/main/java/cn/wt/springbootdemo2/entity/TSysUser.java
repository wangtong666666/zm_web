
package cn.wt.springbootdemo2.entity;
import java.util.Date; 

/**
* ********************************************************
* @ClassName: TSysUser
* @Description: id
* @author 用wt写的自动生成
* @date 2019-10-09 上午 06:17:54 
*******************************************************
*/
public class TSysUser extends BaseEntity{

	private String password;		//
	private String trueName;		//真实姓名
	private String userName;		//
	private Integer id;		//主键id
	private String createDate;		//创建时间（yyyy-MM-dd HH:mm:ss）

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

