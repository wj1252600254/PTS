package dao;


import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Dao {
    /**
     * insert
     *
     * @param sql
     * @param args
     * @return
     */
    public boolean insertInfo(String sql, Object... args) {
        int res = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Utils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            res = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.close(preparedStatement);
            Utils.close(connection);
        }
        return res > 0;
    }

    public boolean delete(String sql, Object... args) {
        int res = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Utils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            res = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.close(preparedStatement);
            Utils.close(connection);
        }
        return res > 0;
    }

    public abstract Object selectOne(String sql, String primaryKey);

    public abstract ArrayList<? extends Object> selectAll(String sql);



}
