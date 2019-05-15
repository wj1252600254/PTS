package service;

import com.google.auto.service.AutoService;
import dao.UserDao;
import domain.User;
import utils.Utils;

//@AutoService(WriteService.class)
public class UserWriteService implements WriteService<User> {
    @Override
    public int deleteObject(User object) {
        return ((UserDao) app.getBean("usrdao")).delete("delete from User where phonenumber=?", object.getPhoneNumber());
    }

    @Override
    public int updateObject(User object) {
        //暂时不实现
//        return ((UserDao) app.getBean("usrdao")).update("update User set phonenumber=? where phonenumber=?", object.getPhoneNumber(),
//                object.getName(), object.getBirthday(), object.getInsuranceNumber());
        return 0;
    }

    @Override
    public int insertObject(User object) {
        return ((UserDao) app.getBean("usrdao")).insertInfo("insert into User values(?,?,?,?,?)", object.getPhoneNumber(),
                object.getName(), Utils.date2String(object.getBirthday()), object.getInsuranceCompany(), object.getInsuranceNumber());
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    public int insertUser(User user) {
        return insertObject(user);
    }


    /**
     * 删除用户
     *
     * @param user
     */
    public int deleteUser(User user) {
        return deleteObject(user);
    }
}
