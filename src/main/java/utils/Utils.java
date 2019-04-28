package utils;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.StringTokenizer;

public class Utils {
    private static DataSource ds = null;

    static {
        Properties properties = new Properties();
        InputStream inputStream = Utils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(inputStream);
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(inputStream);
        }
    }


    /**
     * 分割字符串
     *
     * @param str
     * @param deli
     * @return
     */
    public static ArrayList<String> string2Array(String str, String deli) {
        ArrayList<String> arrayList = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(str, deli);
        while (stringTokenizer.hasMoreElements()) {
            arrayList.add(stringTokenizer.nextToken().trim());
        }
        return arrayList;
    }

    /**
     * String转化为Date
     *
     * @param time
     * @return
     */
    public static Date string2Date(String time) {
        Date date = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            System.out.println("Please input right format of time(e.g 1970-1-1)");
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取Connection
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 关闭Connenction
     *
     * @param connection
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 关闭preparedStatement
     *
     * @param preparedStatement
     */
    public static void close(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭ResultSet
     *
     * @param resultSet
     */
    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 关闭继承Closeable
     * @param args
     */
    public static void close(Closeable... args) {
        for (Closeable t : args) {
            if (t != null) {
                try {
                    t.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
