
package cn.wt.zmweb.entity;

/**
* ********************************************************
* @ClassName: PmsBookInfo
* @Description: id
* @author 用wt写的自动生成
* @date 2019-11-16 下午 03:17:25 
*******************************************************
*/
public class PmsBookInfo extends BaseEntity{

	private String price;		//价格
	private String name;		//书名
	private Integer id;		//
	private String createDate;		//创建时间
	private Integer inventory;		//库存
	private String publishDate;		//发布时间
	private String writerName;		//作者

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

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

	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Integer getInventory() {
		return this.inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public String getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getWriterName() {
		return this.writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

}

