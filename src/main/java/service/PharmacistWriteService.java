package service;

import com.google.auto.service.AutoService;
import dao.PharmacistDao;
import domain.Pharmacist;

//@AutoService(WriteService.class)
public class PharmacistWriteService implements WriteService<Pharmacist> {


    @Override
    public int deleteObject(Pharmacist object) {
        return ((PharmacistDao) app.getBean("phrdao")).delete("delete from Pharmacist where phonenumber=?", object.getPhoneNumber());
    }

    @Override
    public int updateObject(Object... object) {
        return 0;
    }

    @Override
    public int insertObject(Pharmacist object) {
        return ((PharmacistDao) app.getBean("phrdao")).insertInfo("insert into Pharmacist values(?,?)",
                object.getName(), object.getPhoneNumber());
    }

    /**
     * 添加药剂师
     *
     * @param pharmacist
     * @return
     */
    public int insertPharmacist(Pharmacist pharmacist) {
        return insertObject(pharmacist);
    }

    /**
     * 删除药剂师
     *
     * @param pharmacist
     * @return
     */
    public int deletePharmacist(Pharmacist pharmacist) {
        return deleteObject(pharmacist);
    }

}
