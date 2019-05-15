package dao;


import com.google.auto.service.AutoService;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


//@AutoService(Dao.class)
public class PrescriptionDao implements Dao {
    /**
     * 查询语局格式
     * @param sql
     * @param args
     * @return
     */
    @Override
    public PrescriptionDO queryObject(String sql, Object... args) {
        PrescriptionDO prescription = null;
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Utils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i]);
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String id = resultSet.getString(1);
                String phonenumber_user = resultSet.getString(2);
                String phonenumber_phr = resultSet.getString(3);
                String start = resultSet.getString(4);
                String end = resultSet.getString(5);
                int num = resultSet.getInt(6);
                prescription = new PrescriptionDO(id, phonenumber_user, phonenumber_user, start, end, num);
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
    public ArrayList<PrescriptionDO> queryObjectList(String sql, Object... args) {
        ArrayList<PrescriptionDO> prescriptionArrayList = new ArrayList<>();
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
                String id = resultSet.getString(1);
                String phonenumber_user = resultSet.getString(2);
                String phonenumber_phr = resultSet.getString(3);
                String start = resultSet.getString(4);
                String end = resultSet.getString(5);
                int num = resultSet.getInt(6);
                PrescriptionDO prescription = new PrescriptionDO(id, phonenumber_user, phonenumber_phr, start, end, num);
                prescriptionArrayList.add(prescription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.close(resultSet);
            Utils.close(preparedStatement);
            Utils.close(connection);
        }
        return prescriptionArrayList;
    }


    /**
     * 通过用户电话查询处方单
     *
     * @param sql
     * @param number
     * @return
     */
    public static ArrayList<PrescriptionDO> selectByPhoneNumber(String sql, String number) {
        ArrayList<PrescriptionDO> arrayList = new ArrayList<>();
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Utils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, number);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String phonenumber_user = resultSet.getString(2);
                String phonenumber_phr = resultSet.getString(3);
                String start = resultSet.getString(4);
                String end = resultSet.getString(5);
                int num = resultSet.getInt(6);
                PrescriptionDO prescription = new PrescriptionDO(id, phonenumber_user, phonenumber_phr, start, end, num);
                arrayList.add(prescription);
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
