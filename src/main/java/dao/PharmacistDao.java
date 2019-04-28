package dao;

import pojo.Pharmacist;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PharmacistDao extends Dao {


    @Override
    public Object selectOne(String sql, String primaryKey) {
        Pharmacist pharmacist = null;
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Utils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, primaryKey);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String phonenumber = resultSet.getString(2);
                String name = resultSet.getString(1);
                pharmacist = new Pharmacist(phonenumber, name);
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
    public ArrayList<? extends Object> selectAll(String sql) {
        ArrayList<Pharmacist> arrayList = new ArrayList<>();
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Utils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String phonenumber = resultSet.getString(2);
                String name = resultSet.getString(1);
                Pharmacist pharmacist = new Pharmacist(phonenumber, name);
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
