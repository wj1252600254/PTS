package service;

import com.google.auto.service.AutoService;
import dao.*;
import domain.Drug;
import domain.Pharmacist;
import domain.Prescription;
import domain.PrescriptionEntry;

import java.util.ArrayList;
import java.util.Date;

@AutoService(ReadService.class)
public class PrescriptionReadService implements ReadService {
    @Override
    public Prescription queryObject(String sql, Object... args) {
        PrescriptionDao prescriptionDao = (PrescriptionDao) DaoFactory.getDao(PrescriptionDao.class);
        PrescriptionDO prescriptionDO = prescriptionDao.queryObject(sql, args);
        PrescriptionEntryDao prescriptionEntryDao = (PrescriptionEntryDao) DaoFactory.getDao(PrescriptionEntryDao.class);
        if (prescriptionDO != null) {
            Pharmacist pharmacist = ((PharmacistReadService) ReadServiceFactory.getReadService(PharmacistReadService.class)).queryOne(prescriptionDO.getPhonenumberPhr());
            Prescription prescription = new Prescription(prescriptionDO.getId(), prescriptionDO.getStart(), prescriptionDO.getEnd(),
                    prescriptionDO.getNumber(), pharmacist);
            //添加PrescriptionEntry
            ArrayList<PrescriptionEntryDO> prescriptionEntryDOS = prescriptionEntryDao.queryObjectList("select * from PrescriptionEntry where pre_id=?", prescriptionDO.getId());
            for (PrescriptionEntryDO prescriptionEntryDO : prescriptionEntryDOS) {
                //获取Drug
                Drug drug = ((DrugReadService) ReadServiceFactory.getReadService(DrugReadService.class)).queryOne(prescriptionEntryDO.getDrugName());
                new PrescriptionEntry(prescriptionEntryDO.getNumber(), prescription, drug);
            }
            return prescription;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Prescription> queryObjectList(String sql, Object... args) {
        ArrayList<Prescription> arrayList = new ArrayList<>();
        PrescriptionDao prescriptionDao = (PrescriptionDao) DaoFactory.getDao(PrescriptionDao.class);
        ArrayList<PrescriptionDO> prescriptionDOArrayList = prescriptionDao.queryObjectList(sql, args);
        PrescriptionEntryDao prescriptionEntryDao = (PrescriptionEntryDao) DaoFactory.getDao(PrescriptionEntryDao.class);
        if (prescriptionDOArrayList != null) {
            for (PrescriptionDO prescriptionDO : prescriptionDOArrayList) {
                Pharmacist pharmacist = ((PharmacistReadService) ReadServiceFactory.getReadService(PharmacistReadService.class)).queryOne(prescriptionDO.getPhonenumberPhr());
                Prescription prescription = new Prescription(prescriptionDO.getId(), prescriptionDO.getStart(), prescriptionDO.getEnd(),
                        prescriptionDO.getNumber(), pharmacist);
                //添加PrescriptionEntry
                ArrayList<PrescriptionEntryDO> prescriptionEntryDOS = prescriptionEntryDao.queryObjectList("select * from PrescriptionEntry where pre_id=?", prescriptionDO.getId());
                for (PrescriptionEntryDO prescriptionEntryDO : prescriptionEntryDOS) {
                    //获取Drug
                    Drug drug = ((DrugReadService) ReadServiceFactory.getReadService(DrugReadService.class)).queryOne(prescriptionEntryDO.getDrugName());
                    new PrescriptionEntry(prescriptionEntryDO.getNumber(), prescription, drug);
                }
                arrayList.add(prescription);
            }
            return arrayList;
        } else {
            return null;
        }
    }

    /**
     * 返回指定处方
     *
     * @param args
     * @return
     */
    public ArrayList<Prescription> queryByPhone(Object... args) {
        return queryObjectList("select * from Prescription where phonenumber_user=?", args);
    }


    /**
     * 显示处方是否有效
     *
     * @param id
     * @return
     */
    public String displayIsValid(String id) {
        Prescription prescription = queryObject("select * from Prescription where id=?", id);
        if (prescription != null) {
            if (prescription.getNumber() != 0 && prescription.getEnd().after(new Date())) {
                return "处方有效";
            } else {
                return "处方无效";
            }
        } else {
            return "不存在该处方药";
        }
    }
}
