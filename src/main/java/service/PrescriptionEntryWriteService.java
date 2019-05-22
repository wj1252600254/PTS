package service;

import com.google.auto.service.AutoService;
import dao.PrescriptionEntryDao;
import domain.Prescription;
import domain.PrescriptionEntry;

//@AutoService(WriteService.class)
public class PrescriptionEntryWriteService implements WriteService<PrescriptionEntry> {
    @Override
    public int deleteObject(String... object) {
        return ((PrescriptionEntryDao) app.getBean("entdao")).delete("delete from PrescriptionEntry where pre_id=? and drug_name=?",
                object);
    }

    @Override
    public int updateObject(Object... object) {
        return 0;
    }

    @Override
    public int insertObject(PrescriptionEntry object) {
        return ((PrescriptionEntryDao) app.getBean("entdao")).insertInfo("insert into PrescriptionEntry values(?,?,?)", object.getPrescription().getId(),
                object.getNumber(), object.getDrug().getName());
    }

    /**
     * 添加明细
     *
     * @param prescriptionEntry
     * @return
     */
    public int insertPrescriptionEntry(PrescriptionEntry prescriptionEntry) {
        return insertObject(prescriptionEntry);
    }

    /**
     * 删除明细
     *
     * @param prescriptionEntry
     * @return
     */
    public int deletePrescriptionEntry(String... prescriptionEntry) {
        return deleteObject(prescriptionEntry);
    }
}
