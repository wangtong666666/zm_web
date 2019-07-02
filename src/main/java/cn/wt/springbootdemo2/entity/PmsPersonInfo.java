package cn.wt.springbootdemo2.entity;

public class PmsPersonInfo extends BaseEntity {

    private Integer id;
    private String personName;
    private Integer personNumber;
    private String adress;
    private Integer userId;


    @Override
    public String toString() {
        return "PmsPersonInfo{" +
                "id=" + id +
                ", personName='" + personName + '\'' +
                ", personNumber=" + personNumber +
                ", adress='" + adress + '\'' +
                '}';
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(Integer personNumber) {
        this.personNumber = personNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}