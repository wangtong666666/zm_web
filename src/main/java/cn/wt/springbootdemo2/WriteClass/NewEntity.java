package cn.wt.springbootdemo2.WriteClass;



public class NewEntity {
	
  //数据库表名
  public static String entityName="pms_test_info";
 
  public static void main(String[] args) {
	  
	new WriteEntity().Write(entityName.trim());
	  //System.out.println(entityName.toUpperCase());
  }
}