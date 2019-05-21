package service;

import com.google.auto.service.AutoService;
import dao.PrescriptionDao;
import domain.Prescription;
import domain.User;
import utils.Utils;

//@AutoService(WriteService.class)
public class PrescriptionWriteService implements WriteService<Prescription> {

    @Override
    public int deleteObject(Prescription object) {
        return ((PrescriptionDao) app.getBean("predao")).delete("delete from Prescription where id=?", object.getId());
    }

    @Override
    public int updateObject(Object... object) {
        return ((PrescriptionDao) app.getBean("predao")).update("update Prescription set phonenumber_user=? where id=?", object);
    }

    @Override
    public int insertObject(Prescription object) {
        //因为Prescription对象中，并没有带有User_phonenumber的属性，因此必须在插入后更新
        return ((PrescriptionDao) app.getBean("predao")).insertInfo("insert into Prescription values(?,?,?,?,?,?)", object.getId(),
                null, object.getPharmacist().getPhoneNumber(),
                Utils.date2String(object.getStart()), Utils.date2String(object.getEnd()), object.getNumber());
    }

    /**
     * 增加处方
     *
     * @param prescription
     * @return
     */
    public int insertPrescription(Prescription prescription) {
        return insertObject(prescription);
    }

    /**
     * 删除药物
     *
     * @param prescription
     * @return
     */
    public int deletePrescription(Prescription prescription) {
        return deleteObject(prescription);
    }

    public int updatePrescription(Object... strings) {
        return updateObject(strings);
    }
}
