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
    public static void findAlternatives(String name) {
        Drug drug = (Drug) new DrugDao().selectOne("select * from Drug where name=?", name);
        System.out.println(name + "的替换药物有：" + drug.getAlternatives());
    }

    /**
     * 显示特定用户的处方历史记录
     *
     * @param phonenumber
     */
    public static void displayPrescription(String phonenumber) {
        User user = (User) new UserDao().selectOne("select * from User where phonenumber=?", phonenumber);
        for (Prescription t : user.getHistory()) {
            t.display();
        }
    }

    /**
     * 显示处方是否有效
     *
     * @param id
     */
    public static void dispalyIsValid(String id) {
        Prescription prescription = (Prescription) new PrescriptionDao().selectOne("select * from Prescription where id=?", id);
        if (prescription.isValid()) {
            System.out.println("处方是有效的");
        } else {
            System.out.println("处方是无效的");
        }
    }

}
