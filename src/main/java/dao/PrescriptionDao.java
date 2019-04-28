package dao;

import pojo.Pharmacist;
import pojo.Prescription;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PrescriptionDao extends Dao {
    @Override
    public Object selectOne(String sql, String primaryKey) {
        Prescription prescription = null;
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Utils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, primaryKey);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String id = resultSet.getString(1);
                String phonenumber_phr = resultSet.getString(3);
                String start = resultSet.getString(4);
                String end = resultSet.getString(5);
                int num = resultSet.getInt(6);
                Pharmacist pharmacist = (Pharmacist) new PharmacistDao().selectOne("select * from Pharmacist where phonenumber=?", phonenumber_phr);
                prescription = new Prescription(id, start, end, num, pharmacist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.close(resultSet);
            Utils.close(preparedStatement);
            Utils.close(connection);
        }
        return prescription;
    }

    @Override
    public ArrayList<? extends Object> selectAll(String sql) {
        return null;
    }


}
