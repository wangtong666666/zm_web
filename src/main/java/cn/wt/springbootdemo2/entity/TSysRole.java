
package cn.wt.springbootdemo2.entity;
import java.util.Date; 

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

