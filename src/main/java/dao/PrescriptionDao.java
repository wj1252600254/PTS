package dao;

import pojo.*;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PrescriptionDao extends Dao {
    /**
     * 查询语局格式
     *
     * @param sql
     * @param primaryKey
     * @return
     */
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
                ArrayList<Entry> entrylist = new EntryDao().selectEntry("select * from PrescriptionEntry where pre_id=?", id);
                for (Entry t : entrylist) {
                    Drug drug = (Drug) new DrugDao().selectOne("select * from Drug where name =?", t.getDrugName());
                    new PrescriptionEntry(t.getNum(), prescription, drug);
                }
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
        ArrayList<Prescription> prescriptionArrayList = new ArrayList<>();
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Utils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String phonenumber_phr = resultSet.getString(3);
                String start = resultSet.getString(4);
                String end = resultSet.getString(5);
                int num = resultSet.getInt(6);
                Pharmacist pharmacist = (Pharmacist) new PharmacistDao().selectOne("select * from Pharmacist where phonenumber=?", phonenumber_phr);
                Prescription prescription = new Prescription(id, start, end, num, pharmacist);
                ArrayList<Entry> entrylist = new EntryDao().selectEntry("select * from PrescriptionEntry where pre_id=?", id);
                for (Entry t : entrylist) {
                    Drug drug = (Drug) new DrugDao().selectOne("select * from Drug where name =?", t.getDrugName());
                    new PrescriptionEntry(t.getNum(), prescription, drug);
                }
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
    public static ArrayList<Prescription> selectByPhoneNumber(String sql, String number) {
        ArrayList<Prescription> arrayList = new ArrayList<>();
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
                String phonenumber_phr = resultSet.getString(3);
                String start = resultSet.getString(4);
                String end = resultSet.getString(5);
                int num = resultSet.getInt(6);
                Pharmacist pharmacist = (Pharmacist) new PharmacistDao().selectOne("select * from Pharmacist where phonenumber=?", phonenumber_phr);
                Prescription prescription = new Prescription(id, start, end, num, pharmacist);
                ArrayList<Entry> entrylist = new EntryDao().selectEntry("select * from PrescriptionEntry where pre_id=?", id);
                for (Entry t : entrylist) {
                    Drug drug = (Drug) new DrugDao().selectOne("select * from Drug where name =?", t.getDrugName());
                    new PrescriptionEntry(t.getNum(), prescription, drug);
                }
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
