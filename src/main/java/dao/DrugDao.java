package dao;

import com.google.auto.service.AutoService;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@AutoService(Dao.class)
public class DrugDao extends Dao {

    /**
     * 查询单个Drug
     *
     * @param sql
     * @return
     */
    public DrugDO queryObject(String sql, Object... args) {
        DrugDO drug = null;
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
                String drugNmae = resultSet.getString(1);
                String drugUnit = resultSet.getString(2);
                String durgAlternatives = resultSet.getString(3);
                String sideEffe = resultSet.getString(4);
                drug = new DrugDO(drugNmae, drugUnit, durgAlternatives, sideEffe);
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
    public ArrayList<DrugDO> queryObjectList(String sql,Object ... args) {
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        ArrayList<DrugDO> arrayList = new ArrayList<>();
        try {
            connection = Utils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String drugNmae = resultSet.getString(1);
                String drugUnit = resultSet.getString(2);
                String durgAlternatives = resultSet.getString(3);
                String sideEffe = resultSet.getString(4);
                /**
                 * 转化为ArrayList在Service实现
                 */
                DrugDO drug = new DrugDO(drugNmae, drugUnit, durgAlternatives, sideEffe);
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
