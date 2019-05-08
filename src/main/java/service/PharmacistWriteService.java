package service;

import com.google.auto.service.AutoService;

@AutoService(WriteService.class)
public class PharmacistWriteService implements WriteService {
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
     * 添加药剂师
     *
     * @param number
     * @param name
     * @return
     */
    public int insertPharmacist(String number, String name) {
        return insertObject("insert into Pharmacist values(?,?)", number, name);
    }

    /**
     * 删除药剂师
     *
     * @param number
     * @return
     */
    public int deletePharmacist(String number) {
        return deleteObject("delete from Pharmacist where phonenumber=?", number);
    }

}
