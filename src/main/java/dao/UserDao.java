package dao;


import pojo.Prescription;
import pojo.User;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao extends Dao {
    @Override
    public Object selectOne(String sql, String primaryKey) {
        User user = null;
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Utils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, primaryKey);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String phonenumber = resultSet.getString(1);
                String name = resultSet.getString(2);
                String birthday = resultSet.getString(3);
                String insuranceCompany = resultSet.getString(4);
                String insurranceNumber = resultSet.getString(5);
                user = new User(phonenumber, name, birthday, insuranceCompany, insurranceNumber);
                ArrayList<Prescription> arrayList = PrescriptionDao.selectByPhoneNumber("select * from Prescription where phonenumber_user=?", phonenumber);
                for (Prescription t : arrayList) {
                    user.addHistory(t);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.close(resultSet);
            Utils.close(preparedStatement);
            Utils.close(connection);
        }
        return user;
    }

    @Override
    public ArrayList<? extends Object> selectAll(String sql) {
        ArrayList<User> arrayList = new ArrayList<>();
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Utils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String phonenumber = resultSet.getString(1);
                String name = resultSet.getString(2);
                String birthday = resultSet.getString(3);
                String insuranceCompany = resultSet.getString(4);
                String insurranceNumber = resultSet.getString(5);
                User user = new User(name, phonenumber, birthday, insuranceCompany, insurranceNumber);
                ArrayList<Prescription> arrayList1 = PrescriptionDao.selectByPhoneNumber("select * from Prescription where phonenumber_user=?", phonenumber);
                for (Prescription t : arrayList1) {
                    user.addHistory(t);
                }
                arrayList.add(user);
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
