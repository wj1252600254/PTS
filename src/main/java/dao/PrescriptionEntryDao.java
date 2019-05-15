package dao;


import com.google.auto.service.AutoService;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


//@AutoService(Dao.class)
public class PrescriptionEntryDao implements Dao {
    @Override
    public PrescriptionEntryDO queryObject(String sql, Object... args) {
        PrescriptionEntryDO prescriptionEntryDO = null;
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Utils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String n = resultSet.getString(1);
                int num = resultSet.getInt(2);
                String drug = resultSet.getString(3);
                prescriptionEntryDO = new PrescriptionEntryDO(n, num, drug);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.close(resultSet);
            Utils.close(preparedStatement);
            Utils.close(connection);
        }
        return prescriptionEntryDO;
    }

    @Override
    public ArrayList<PrescriptionEntryDO> queryObjectList(String sql, Object... args) {
        ArrayList<PrescriptionEntryDO> arrayList = new ArrayList<>();
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Utils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String n = resultSet.getString(1);
                int num = resultSet.getInt(2);
                String drug = resultSet.getString(3);
                PrescriptionEntryDO prescriptionEntry = new PrescriptionEntryDO(n, num, drug);
                arrayList.add(prescriptionEntry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.close(resultSet);
            Utils.close(preparedStatement);
            Utils.close(connection);
        }
        return arrayList;
    }

}
