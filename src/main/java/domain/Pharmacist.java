package domain;

public class Pharmacist extends Person {

    public Pharmacist(String name, String phoneNumber) {
        super(name, phoneNumber);
    }

    @Override
    public String toString() {
        return "药剂师姓名：" + this.getName() + System.getProperty("line.separator") + "电话:" + this.getPhoneNumber();
    }
}
