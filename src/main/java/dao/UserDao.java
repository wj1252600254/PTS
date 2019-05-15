package dao;


import com.google.auto.service.AutoService;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


//@AutoService(Dao.class)
public class UserDao implements Dao {
    @Override
    public UserDO queryObject(String sql, Object... args) {
        UserDO user = null;
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
                String phonenumber = resultSet.getString(1);
                String name = resultSet.getString(2);
                String birthday = resultSet.getString(3);
                String insuranceCompany = resultSet.getString(4);
                String insurranceNumber = resultSet.getString(5);
                user = new UserDO(phonenumber, name, birthday, insuranceCompany, insurranceNumber);
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
    public ArrayList<UserDO> queryObjectList(String sql, Object... args) {
        ArrayList<UserDO> arrayList = new ArrayList<>();
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
                String phonenumber = resultSet.getString(1);
                String name = resultSet.getString(2);
                String birthday = resultSet.getString(3);
                String insuranceCompany = resultSet.getString(4);
                String insurranceNumber = resultSet.getString(5);
                UserDO user = new UserDO(phonenumber, name, birthday, insuranceCompany, insurranceNumber);
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
