/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import sun.applet.Main;

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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
