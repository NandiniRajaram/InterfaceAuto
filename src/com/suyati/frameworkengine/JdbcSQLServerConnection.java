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
    	JdbcSQLServerConnection conne =new JdbcSQLServerConnection();
    	String client="Family Dollar";
      conne.queryexecution(client);
        }
    
public void queryexecution(String client)
{
	  Connection conn = null;
	  
      try {
      	  System.out.println("inside Try1");
      	String connectionUrl = "jdbc:sqlserver://STLDEV01:1433;" +  
      			   "databaseName=Oneviewv2;user=ISSPortal;password=Interf@ceP0rt@l";  
      	
      	

      	 System.out.println("inside Try2:  "+connectionUrl);
      	 String Query ="Select count(distinct s.CompanyNumber)  from oneviewV2.dbo.Site s Inner Join oneviewV2.dbo.System sy on s.Id=sy.SiteId " +
      	 		 "where sy.code in ('IPNETW','BURG','VOIP','CCTV','INTVIDEO')  And (sy.Status = 'Active' Or sy.Status = 'Service Only')  and  s.tempclosed <> '1' and s.PermClosed  <> '1' "+
      	 		 "and s.mastercompany ='" + client +"'";
      	 System.out.println(Query );
      			Connection con = DriverManager.getConnection(connectionUrl); 
      			Statement s1 = con.createStatement();
      	
                  ResultSet rs = s1.executeQuery(Query);
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