package service;

import com.google.auto.service.AutoService;
import dao.DaoFactory;
import dao.UserDO;
import dao.UserDao;
import domain.Prescription;
import domain.User;

import java.util.ArrayList;

//@AutoService(ReadService.class)
public class UserReadService implements ReadService {
    @Override
    public User queryObject(String sql, Object... args) {
        PrescriptionReadService prescriptionService = (PrescriptionReadService) app.getBean("preres");
        UserDao userDao = (UserDao) app.getBean("usrdao");
        UserDO userDO = userDao.queryObject(sql, args);
        if (userDO != null) {
            User user = new User(userDO.getName(), userDO.getPhonenumber(), userDO.getBirthday(), userDO.getInsuranceCompany(), userDO.getInsuranceNumber());
            user.addHistory(prescriptionService.queryByPhone(userDO.getPhonenumber()));
            return user;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<User> queryObjectList(String sql, Object... args) {
        ArrayList<User> arrayList = new ArrayList<>();
        PrescriptionReadService prescriptionService = (PrescriptionReadService) app.getBean("preres");
        UserDao userDao = (UserDao) app.getBean("usrdao");
        ArrayList<UserDO> userDOArrayList = userDao.queryObjectList(sql, args);
        if (userDOArrayList != null) {
            for (UserDO userDO : userDOArrayList) {
                User user = new User(userDO.getName(), userDO.getPhonenumber(), userDO.getBirthday(), userDO.getInsuranceCompany(), userDO.getInsuranceNumber());
                user.addHistory(prescriptionService.queryByPhone(userDO.getPhonenumber()));
                arrayList.add(user);
            }
            return arrayList;
        } else {
            return null;
        }
    }


    public ArrayList<User> queryAll() {
        return queryObjectList("select * from User");
    }

    /**
     * 显示用户的处方记录
     *
     * @param phone
     */
    public String displayHistory(String phone) {
        User user = queryObject("select * from User where phonenumber=?", phone);
        if (user != null) {
            String s = "";
            for (Prescription prescription : user.getHistory()) {
                s += prescription.toString();
            }
            return s;
        } else {
            return "不存在该用户";
        }
    }


    /**
     * 显示用户信息
     *
     * @param number
     * @return
     */
    public String displayUser(String number) {
        User user = queryObject("select * from User where phonenumber=?", number);
        if (user != null) {
            return user.toString();
        } else {
            return "不存在该用户";
        }
    }
}
