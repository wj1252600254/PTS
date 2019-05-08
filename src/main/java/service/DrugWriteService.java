package service;

import com.google.auto.service.AutoService;

@AutoService(WriteService.class)
public class DrugWriteService implements WriteService {

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
     * 增加药物
     *
     * @param name
     * @param unit
     * @param alter
     * @param sideE
     * @return
     */
    public int insertDrug(String name, String unit, String alter, String sideE) {
        return insertObject("insert into Drug values(?,?,?,?)", name, unit, alter, sideE);
    }

    /**
     * 删除药物
     * @param name
     * @return
     */
    public int deleteDrug(String name) {
        return deleteObject("delete from Drug where name=?", name);
    }


}
