package service;

import com.google.auto.service.AutoService;
import dao.Dao;
import dao.DaoFactory;
import dao.PharmacistDao;

@AutoService(WriteService.class)
public class WriteServiceImpl implements WriteService {
    @Override
    public int deleteObject(String sql, Object... name) {
        Dao dao = DaoFactory.getDao(PharmacistDao.class);
        return dao.delete(sql, name);
    }

    @Override
    public int updateObject(String sql, Object... name) {
        Dao dao = DaoFactory.getDao(PharmacistDao.class);
        return dao.update(sql, name);
    }

    @Override
    public int insertObject(String sql, Object... name) {
        Dao dao = DaoFactory.getDao(PharmacistDao.class);
        return dao.insertInfo(sql, name);
    }
}
