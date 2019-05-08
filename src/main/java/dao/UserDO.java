package dao;

public class UserDO {
    private String phonenumber;
    private String name;
    private String birthday;
    private String insuranceCompany;
    private String insuranceNumber;

    public UserDO() {

    }

    public UserDO(String phonenumber, String name, String birthday, String insuranceCompany, String insuranceNumber) {
        this.phonenumber = phonenumber;
        this.name = name;
        this.birthday = birthday;
        this.insuranceCompany = insuranceCompany;
        this.insuranceNumber = insuranceNumber;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }
}
