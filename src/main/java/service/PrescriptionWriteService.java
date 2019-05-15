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
    public int updateObject(Prescription object) {
        return 0;
    }

    @Override
    public int insertObject(Prescription object) {
        return ((PrescriptionDao) app.getBean("predao")).insertInfo("insert into Prescription values(?,?,?,?,?,?)", object.getId(),
                Utils.findUserNumber(((UserReadService) app.getBean("usrres")).queryAll(), object.getId()), object.getPharmacist().getPhoneNumber(),
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
}
