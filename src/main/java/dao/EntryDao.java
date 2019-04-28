package dao;

import pojo.Entry;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EntryDao {


    public ArrayList<Entry> selectEntry(String sql, String primaryKey) {
        ArrayList<Entry> arrayList = new ArrayList<>();
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Utils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, primaryKey);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String n = resultSet.getString(1);
                int num = resultSet.getInt(2);
                String drug = resultSet.getString(3);
                Entry entry = new Entry(n, num, drug);
                arrayList.add(entry);
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
