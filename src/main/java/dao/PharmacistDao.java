package dao;


import com.google.auto.service.AutoService;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//@AutoService(Dao.class)
public class PharmacistDao implements Dao {


    @Override
    public PharmacistDO queryObject(String sql, Object... args) {
        PharmacistDO pharmacist = null;
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
            if (resultSet.next()) {
                String phonenumber = resultSet.getString(2);
                String name = resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.close(resultSet);
            Utils.close(preparedStatement);
            Utils.close(connection);
        }
        return pharmacist;
    }

    @Override
    public ArrayList<PharmacistDO> queryObjectList(String sql, Object... args) {
        ArrayList<PharmacistDO> arrayList = new ArrayList<>();
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
                String phonenumber = resultSet.getString(2);
                String name = resultSet.getString(1);
                PharmacistDO pharmacist = new PharmacistDO(phonenumber, name);
                arrayList.add(pharmacist);
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
