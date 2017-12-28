package com.suyati.frameworkengine;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Driver;
import java.sql.Statement;
/**
 * This program demonstrates how to establish database connection to Microsoft
 * SQL Server.
 * @author www.codejava.net
 *
 */
public class JdbcSQLServerConnection {
 
    public static void main(String[] args) throws ClassNotFoundException {
 
        Connection conn = null;
 
        try {
        	  System.out.println("inside Try1");
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        	String connectionUrl = "jdbc:sqlserver://STLDEV01:1433;" +  
        			   "databaseName=Oneviewv2;integratedSecurity=true";
        			   //+ "user=INTERFACESYS\\rijo.thomas;password=Suyati@123;";  
        	 System.out.println("inside Try2");
        			Connection con = DriverManager.getConnection(connectionUrl); 
        			Statement s1 = con.createStatement();
                    ResultSet rs = s1.executeQuery("SELECT count(*) FROM site");
                    rs.next();
                    String result = rs.getString(1);
                    System.out.println(result);
        	
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("inside catch");
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}