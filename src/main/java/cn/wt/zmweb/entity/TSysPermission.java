
package cn.wt.zmweb.entity;

/**
* ********************************************************
* @ClassName: TSysPermission
* @Description: id
* @author 用wt写的自动生成
* @date 2019-10-09 上午 06:21:34 
*******************************************************
*/
public class TSysPermission extends BaseEntity{

	private String name;		//
	private Integer id;		//
	private String url;		//

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}

