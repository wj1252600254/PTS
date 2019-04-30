package pojo;


import utils.Utils;

import java.util.ArrayList;
import java.util.Date;

public class User extends Person {
    private Date birthday;
    private String insuranceCompany;
    private String insuranceNumber;
    private ArrayList<Prescription> history;

    @Override
    public String toString() {
        return super.toString() + "User{" +
                "birthday=" + birthday +
                ", insuranceCompany='" + insuranceCompany + '\'' +
                ", insuranceNumber='" + insuranceNumber + '\'' +
                ", history=" + history +
                '}';
    }

    public User(String name, String phonenumber, String date, String company, String insuranceNumber) {
        super(name, phonenumber);
        this.setBirthday(Utils.string2Date(date));
        this.setInsuranceCompany(company);
        this.setInsuranceNumber(insuranceNumber);
        history = new ArrayList<>();
    }

    /**
     * 添加处方
     *
     * @param prescription
     */
    public void addHistory(Prescription prescription) {
        history.add(prescription);
    }

    /**
     * 删除处方
     *
     * @param prescription
     * @return
     */
    public boolean removeHistory(Prescription prescription) {
        return history.remove(prescription);
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
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

    public ArrayList<Prescription> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Prescription> history) {
        this.history = history;
    }


}
