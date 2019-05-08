package dao;

public class PharmacistDO {
    private String phonenumber;
    private String name;

    public PharmacistDO() {

    }

    public PharmacistDO(String phonenumber, String name) {
        this.phonenumber = phonenumber;
        this.name = name;
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
}
