package cn.wt.springbootdemo2.entity;

public class PmsPersonInfo extends BaseEntity{

    private Integer id;
    private String name;
    private Integer age;
    private String remark;

    public PmsPersonInfo() {

    }

    public PmsPersonInfo(Integer id, String name, Integer age, String remark) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getRemark() {
        return remark;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "PmsPersonInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", remark='" + remark + '\'' +
                '}';
    }

}
