package service;

import com.google.auto.service.AutoService;

@AutoService(WriteService.class)
public class UserWriteService implements WriteService {

    @Override
    public int deleteObject(String sql, Object... name) {

        return ((WriteServiceImpl) WriteServiceFactory.getWriteService(WriteServiceImpl.class)).deleteObject(sql, name);
    }

    @Override
    public int updateObject(String sql, Object... name) {
        return ((WriteServiceImpl) WriteServiceFactory.getWriteService(WriteServiceImpl.class)).updateObject(sql, name);
    }

    @Override
    public int insertObject(String sql, Object... name) {
        return ((WriteServiceImpl) WriteServiceFactory.getWriteService(WriteServiceImpl.class)).insertObject(sql, name);
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
    public int insertUser(String phone, String name, String birthday, String company, String number) {
        return insertObject("insert into User values(?,?,?,?,?)", phone, name, birthday, company, number);
    }


    /**
     * 删除用户
     *
     * @param phone
     */
    public int deleteUser(String phone) {
        return deleteObject("delete from User where phonenumber=?", phone);
    }
}
