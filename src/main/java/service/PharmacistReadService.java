package service;

import com.google.auto.service.AutoService;
import dao.DaoFactory;
import dao.PharmacistDO;
import dao.PharmacistDao;
import domain.Pharmacist;

import java.util.ArrayList;

@AutoService(ReadService.class)
public class PharmacistReadService implements ReadService {
    @Override
    public Pharmacist queryObject(String sql, Object... args) {
        PharmacistDao pharmacistDao = (PharmacistDao) DaoFactory.getDao(PharmacistDao.class);
        PharmacistDO pharmacistDO = pharmacistDao.queryObject(sql, args);
        if (pharmacistDO != null) {
            return new Pharmacist(pharmacistDO.getName(), pharmacistDO.getPhonenumber());
        } else {
            return null;
        }

    }

    @Override
    public ArrayList<Pharmacist> queryObjectList(String sql, Object... args) {
        ArrayList<Pharmacist> arrayList = new ArrayList<>();
        PharmacistDao pharmacistDao = (PharmacistDao) DaoFactory.getDao(PharmacistDao.class);
        ArrayList<PharmacistDO> pharmacistDOS = pharmacistDao.queryObjectList(sql, args);
        if (pharmacistDOS != null) {
            for (PharmacistDO t : pharmacistDOS) {
                arrayList.add(new Pharmacist(t.toString(), t.getPhonenumber()));
            }
            return arrayList;
        } else {
            return null;
        }
    }


    /**
     * 查询医生
     * @param args
     * @return
     */
    public Pharmacist queryOne(Object... args) {
        return queryObject("select * from Pharmacist where phonenumber=?", args);
    }
}
