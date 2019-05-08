package dao;


import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Dao {
    /**
     * 添加记录
     *
     * @param sql
     * @param args
     * @return
     */
    public int insertInfo(String sql, Object... args) {
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
        return res;
    }

    /**
     * 更新记录
     *
     * @param sql
     * @param args
     * @return
     */
    public int update(String sql, Object... args) {
        return insertInfo(sql, args);
    }

    /**
     * 删除记录
     *
     * @param sql
     * @param args
     * @return
     */
    public int delete(String sql, Object... args) {
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
        return res;
    }

    public abstract Object queryObject(String sql, Object... args);

    public abstract ArrayList<? extends Object> queryObjectList(String sql, Object... args);


}
