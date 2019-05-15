package service;

import com.google.auto.service.AutoService;
import dao.DrugDao;
import domain.Drug;
import domain.User;
import utils.Utils;

//@AutoService(WriteService.class)
public class DrugWriteService implements WriteService<Drug> {
    @Override
    public int deleteObject(Drug object) {
        return ((DrugDao) app.getBean("drudao")).delete("delete from Drug where name=?", object.getName());
    }

    @Override
    public int updateObject(Drug object) {
        return 0;
    }

    @Override
    public int insertObject(Drug object) {
        return ((DrugDao) app.getBean("drudao")).insertInfo("insert into Drug values(?,?,?,?)", object.getName(),
                object.getUnit(), Utils.Array2String(object.getAlternatives(), ","), object.getSideEffect());
    }

    /**
     * 增加药物
     *
     * @param drug
     * @return
     */
    public int insertDrug(Drug drug) {
        return insertObject(drug);
    }

    /**
     * 删除药物
     *
     * @param drug
     * @return
     */
    public int deleteDrug(Drug drug) {
        return deleteObject(drug);
    }


}
