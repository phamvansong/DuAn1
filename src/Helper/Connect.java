/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author pvsla
 */
public class Connect {

    public Connection con = null;

    public Connect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dburl = "jdbc:sqlserver://localhost:1433;databasename=DA1_QLTV;integratedSecurity=true";
            con = DriverManager.getConnection(dburl);
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String url = "jdbc:sqlserver://localhost:1433;databaseName=DA1_QLTV";
//            con = DriverManager.getConnection(url, "sa", "songpvph12665");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
