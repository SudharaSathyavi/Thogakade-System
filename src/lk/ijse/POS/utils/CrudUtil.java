package lk.ijse.POS.utils;

import lk.ijse.POS.db.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudUtil {

    /*private static PreparedStatement getpreparedStatement(String sql, Object...params) throws SQLException, ClassNotFoundException {
        Connection connection = DataBaseConnection.getInstance().getConnection();
        PreparedStatement stm=connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            stm.setObject((i+1),params[i]);
        }
        return stm;
    }

    public static boolean executeUpdate(String sql,Object...params) throws SQLException, ClassNotFoundException {
        return getpreparedStatement(sql, params).executeUpdate()>0;
    }
    public static ResultSet executeQuery(String sql,Object...params) throws SQLException, ClassNotFoundException {
        return getpreparedStatement(sql, params).executeQuery();
    }*/

    public static <T> T execute(String sql, Object... params) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DataBaseConnection.getInstance().getConnection().prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            stm.setObject((i + 1), params[i]);
        }
        if (sql.startsWith("SELECT")) {
            //execute query
            return (T)stm.executeQuery();
        }

        //executeUpdate
        return (T) (Boolean)(stm.executeUpdate()>0);

    }
}

