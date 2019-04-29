package service;

import dao.DrugDao;
import dao.PrescriptionDao;
import dao.UserDao;
import pojo.Drug;
import pojo.Prescription;
import pojo.User;

public class Service {
    /**
     * 查询特定药物的通用代替药物
     *
     * @param name
     */
    public static String findAlternatives(String name) {
        Drug drug = (Drug) new DrugDao().selectOne("select * from Drug where name=?", name);
        if (drug != null) {
            return name + "的替换药物有：" + drug.getAlternatives();
        } else {
            return "系统没有改药物";
        }
    }

    /**
     * 显示特定用户的处方历史记录
     *
     * @param phonenumber
     */
    public static String displayPrescription(String phonenumber) {
        User user = (User) new UserDao().selectOne("select * from User where phonenumber=?", phonenumber);
        if (user != null) {
            String s = "";
            for (Prescription t : user.getHistory()) {
                s += t.display();
            }
            return s;
        } else {
            return "用户不存在";
        }
    }

    /**
     * 显示处方是否有效
     *
     * @param id
     */
    public static String dispalyIsValid(String id) {
        Prescription prescription = (Prescription) new PrescriptionDao().selectOne("select * from Prescription where id=?", id);
        if (prescription != null) {
            if (prescription.isValid()) {
                return "处方是有效的" + System.getProperty("line.separator") + "剩余取药次数：" + prescription.getNumber() + "      " + "处方到期时间:" + prescription.getEnd();
            } else {
                return "处方是无效的";
            }
        } else {
            return "系统没有该处方";
        }
    }

}
