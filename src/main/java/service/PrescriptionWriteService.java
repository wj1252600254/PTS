package service;

import com.google.auto.service.AutoService;

@AutoService(WriteService.class)
public class PrescriptionWriteService implements WriteService {


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
     * 增加处方
     *
     * @param id
     * @param usr
     * @param phr
     * @param str
     * @param end
     * @param num
     * @return
     */
    public int insertPrescription(String id, String usr, String phr, String str, String end, int num) {
        return insertObject("insert into Prescription values(?,?,?,?,?,?)", id, usr, phr, str, end, num);
    }

    /**
     * 删除药物
     *
     * @param name
     * @return
     */
    public int deletePrescription(String name) {
        return deleteObject("delete from Prescription where id=?", name);
    }
}
