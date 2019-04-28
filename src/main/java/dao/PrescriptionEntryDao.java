package dao;


import pojo.PrescriptionEntry;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PrescriptionEntryDao extends Dao {
    @Override
    public Object selectOne(String sql, String primaryKey) {
        PrescriptionEntry prescriptionEntry = null;
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
                int id = resultSet.getInt(2);
                String drug_name = resultSet.getString(3);

                /*
                如果将PrescriptionEntry的成员改成String格式，写代码会简单很多，但在类图上的关系就显示不出来了。
                 */



            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.close(resultSet);
            Utils.close(preparedStatement);
            Utils.close(connection);
        }
        return prescriptionEntry;
    }

    @Override
    public ArrayList<? extends Object> selectAll(String sql) {
        return null;
    }


}
