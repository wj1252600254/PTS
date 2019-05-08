package domain;


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
        String s = "用户姓名：" + this.getName() + System.getProperty("line.separator") +
                "用户电话：" + this.getPhoneNumber() + System.getProperty("line.separator") +
                "用户生日：" + this.getBirthday() + System.getProperty("line.separator") +
                "用户保险公司：" + this.getInsuranceCompany() + System.getProperty("line.separator") +
                "用户保险单号：" + this.getInsuranceNumber() + System.getProperty("line.separator") +
                "用户历史处方单号：";
        for (Prescription n : history) {
            s += n.getId() + ",";
        }
        return s;
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

    public void addHistory(ArrayList<Prescription> arrayList) {
        history.addAll(arrayList);
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
