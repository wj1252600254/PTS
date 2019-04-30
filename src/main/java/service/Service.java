package service;

import dao.DrugDao;
import dao.PharmacistDao;
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

    /**
     * 显示用户信息,在jlist中使用
     *
     * @param phonenumber
     * @return
     */
    public static String displayUser(String phonenumber) {
        User user = (User) new UserDao().selectOne("select * from User where phonenumber=?", phonenumber);
        if (user != null) {
            return "用户姓名：" + user.getName() + System.getProperty("line.separator") +
                    "用户电话：" + user.getPhoneNumber() + System.getProperty("line.separator") +
                    "用户生日：" + user.getBirthday() + System.getProperty("line.separator") +
                    "用户保险公司：" + user.getInsuranceCompany() + System.getProperty("line.separator") +
                    "用户保险单号：" + user.getInsuranceNumber() + System.getProperty("line.separator") +
                    "用户处方历史单号：" + user.getHistory();
        } else {
            return "不存在该用户";
        }
    }

    /**
     * 显示药物信息
     */
    public static String displayDrug(String name) {
        Drug drug = (Drug) new DrugDao().selectOne("select * from Drug where name=?", name);
        if (drug != null) {
            return "药物名字：" + drug.getName() + System.getProperty("line.separator") +
                    "用药单位：" + drug.getUnit() + System.getProperty("line.separator") +
                    "替代药物：" + drug.getAlternatives() + System.getProperty("line.separator") +
                    "药物副作用：" + drug.getSideEffect();
        } else {
            return "不存在该药物";
        }
    }


    /**
     * 添加用户
     *
     * @param phone
     * @param name
     * @param birthday
     * @param company
     * @param number
     * @return
     */
    public static boolean insertUser(String phone, String name, String birthday, String company, String number) {
        return new UserDao().insertInfo("insert into User values(?,?,?,?,?)", phone, name, birthday, company, number);
    }

    /**
     * 删除用户
     *
     * @param phone
     * @return
     */
    public static boolean deleteUser(String phone) {
        return new UserDao().delete("delete from User where phonenumber=?", phone);
    }

    /**
     * 添加药物
     *
     * @param name
     * @param unit
     * @param alter
     * @param sideE
     * @return
     */
    public static boolean insertDrug(String name, String unit, String alter, String sideE) {
        return new DrugDao().insertInfo("insert into Drug values(?,?,?,?)", name, unit, alter, sideE);
    }


    /**
     * 删除药物
     *
     * @param name
     * @return
     */
    public static boolean deleteDrug(String name) {
        return new UserDao().delete("delete from Drug where name=?", name);
    }

    /**
     * 添加处方单
     *
     * @param id
     * @param usr
     * @param phr
     * @param str
     * @param end
     * @param num
     * @return
     */
    public static boolean insertPrescription(String id, String usr, String phr, String str, String end, int num) {
        return new PrescriptionDao().insertInfo("insert into Prescription values(?,?,?,?,?,?)", id, usr, phr, str, end, num);
    }

    /**
     * 删除处方单
     *
     * @param name
     * @return
     */
    public static boolean deletePrescription(String name) {
        return new PrescriptionDao().delete("delete from Prescription where id=?", name);
    }

    /**
     * 添加处方明细
     *
     * @param pre
     * @param num
     * @param drug
     * @return
     */
    public static boolean insertPrescriptionEntry(String pre, String num, String drug) {
        return new PrescriptionDao().insertInfo("insert into PrescriptionEntry values(?,?,?)", pre, num, drug);
    }

    /**
     * 删除处方明细
     *
     * @param name
     * @return
     */
    public static boolean deletePrescriptionEntry(String id, String name) {
        return new PrescriptionDao().delete("delete from PrescriptionEntry where pre_id=? and drug_name=?", id, name);
    }

    /**
     * 添加药剂师
     *
     * @param name
     * @param number
     * @return
     */
    public static boolean insertPharmacist(String number, String name) {
        return new PharmacistDao().insertInfo("insert into Pharmacist values(?,?)", number, name);
    }


    /**
     * 删除药剂师
     * @param number
     * @return
     */
    public static boolean deletePharmacist(String number) {
        return new PharmacistDao().delete("delete from Pharmacist where phonenumber=?", number);
    }

}
