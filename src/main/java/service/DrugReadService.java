package service;

import com.google.auto.service.AutoService;
import dao.DaoFactory;
import dao.DrugDO;
import dao.DrugDao;
import domain.Drug;
import utils.Utils;

import java.util.ArrayList;

//@AutoService(ReadService.class)
public class DrugReadService implements ReadService {
    @Override
    public Drug queryObject(String sql, Object... name) {
        DrugDao drugDao = (DrugDao) app.getBean("drudao");
        DrugDO drugDO = drugDao.queryObject(sql, name);
        if (drugDO != null) {
            Drug drug = new Drug(drugDO.getName(), drugDO.getUnit(), drugDO.getSideEffect());
            drug.setAlternatives(Utils.string2Array(drugDO.getAlternatives(), ","));
            return drug;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Drug> queryObjectList(String sql, Object... args) {
        ArrayList<Drug> drugArrayList = new ArrayList<>();
        DrugDao drugDao = (DrugDao) app.getBean("drudao");
        ArrayList<DrugDO> arrayList = drugDao.queryObjectList(sql, args);
        if (arrayList != null) {
            for (DrugDO drugDO : arrayList) {
                Drug drug = new Drug(drugDO.getName(), drugDO.getUnit(), drugDO.getSideEffect());
                drug.setAlternatives(Utils.string2Array(drugDO.getAlternatives(), ","));
                drugArrayList.add(drug);
            }
            return drugArrayList;
        } else {
            return null;
        }
    }


    /**
     * 返回单个Drug
     *
     * @param args
     * @return
     */
    public Drug queryOne(Object... args) {
        return queryObject("select * from Drug where name=?", args);
    }

    /**
     * 返回所有的Drug
     *
     * @param args
     * @return
     */
    public ArrayList<Drug> queryAll(Object... args) {
        return queryObjectList("select * from Drug", args);
    }


    /**
     * 显示替代药物
     *
     * @param name
     * @return
     */
    public String displayAlternatives(String name) {
        Drug drug = queryOne(name);
        if (drug != null) {
            return name + "的替换药物有：" + drug.getAlternatives();
        } else {
            return "不存在该药物";
        }
    }

    /**
     * 显示药物信息
     *
     * @param name
     * @return
     */
    public String dispalyDrug(String name) {
        Drug drug = queryOne(name);
        if (drug != null) {
            return drug.toString();
        } else {
            return "不存在该药物";
        }
    }


}
