package service;

import com.google.auto.service.AutoService;

@AutoService(WriteService.class)
public class PrescriptionEntryWriteService implements WriteService {


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
     * 添加明细
     *
     * @param pre
     * @param num
     * @param drug
     * @return
     */
    public int insertPrescriptionEntry(String pre, String num, String drug) {
        return insertObject("insert into PrescriptionEntry values(?,?,?)", pre, num, drug);
    }

    /**
     * 删除明细
     *
     * @param id
     * @param name
     * @return
     */
    public int deletePrescriptionEntry(String id, String name) {
        return deleteObject("delete from PrescriptionEntry where pre_id=? and drug_name=?", id, name);
    }
}
