package dao;

import pojo.Drug;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DrugDao extends Dao {
    /**
     * 查询单个Drug
     *
     * @param sql
     * @param name
     * @return
     */
    public Object selectOne(String sql, String name) {
        Drug drug = null;
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Utils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String drugNmae = resultSet.getString(1);
                String drugUnit = resultSet.getString(2);
                String durga = resultSet.getString(3);
                String sideEffe = resultSet.getString(4);
                drug = new Drug(drugNmae, drugUnit, sideEffe);
                ArrayList<String> arrayList = Utils.string2Array(durga, ",");
                drug.setAlternatives(arrayList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.close(resultSet);
            Utils.close(preparedStatement);
            Utils.close(connection);
        }
        return drug;
    }

    /**
     * 查询所有的Drug
     *
     * @param sql
     * @return
     */
    @Override
    public ArrayList<? extends Object> selectAll(String sql) {
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Drug> arrayList = new ArrayList<>();
        try {
            connection = Utils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String drugNmae = resultSet.getString(1);
                String drugUnit = resultSet.getString(2);
                String durga = resultSet.getString(3);
                String sideEffe = resultSet.getString(4);
                Drug drug = new Drug(drugNmae, drugUnit, sideEffe);
                ArrayList<String> arrayList1 = Utils.string2Array(durga, ",");
                drug.setAlternatives(arrayList1);
                arrayList.add(drug);
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
