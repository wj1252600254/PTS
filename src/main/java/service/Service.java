package service;

import dao.DrugDao;
import pojo.Drug;

public class Service {
    /**
     * 特定药物的通用代替药物
     *
     * @param name
     */
    public static void findAlternatives(String name) {
        Drug drug = (Drug) new DrugDao().selectOne("select * from Drug where name=?", name);
        System.out.println(name + "的替换药物有：" + drug.getAlternatives());
    }


}
