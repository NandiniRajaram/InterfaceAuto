package com.suyati.frameworkengine;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Driver;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * This program demonstrates how to establish database connection to Microsoft
 * SQL Server.
 * @author www.codejava.net
 *
 */
public class JdbcSQLServerConnection {
 
    public static void main(String[] args) throws ClassNotFoundException {
    	JdbcSQLServerConnection conne =new JdbcSQLServerConnection();
    	ArrayList<String> it=new ArrayList();
    	String companynumber="FDOL1442";
    	 String Query ="select Address,City,state,zip,name from site where companynumber ='" + companynumber +"'";
    	
    	 
    	 String client="Family Dollar";
    	 String Query1 ="Select count(distinct s.CompanyNumber)  from oneviewV2.dbo.Site s Inner Join oneviewV2.dbo.System sy on s.Id=sy.SiteId " +
      	 		 "where sy.code in ('IPNETW','BURG','VOIP','CCTV','INTVIDEO')  And (sy.Status = 'Active' Or sy.Status = 'Service Only')  and  s.tempclosed <> '1' and s.PermClosed  <> '1' "+
      	 		 "and s.mastercompany ='" + client +"'";
    	
    	
      it=conne.Queryexecution(Query);
      for (String s: it)
      {
    	  System.out.println(s);
      }
        }
    



public ArrayList Queryexecution(String Query)
{
	  Connection conn = null;
	  ArrayList li=new  ArrayList();
	  
      try {
      	   System.out.println("inside Try1");
      	   String connectionUrl = "jdbc:sqlserver://STLDEV01:1433;" +  
      			   "databaseName=Oneviewv2;user=ISSPortal;password=Interf@ceP0rt@l";         	

      	   System.out.println("inside Try2:  "+connectionUrl);      	 
      	   System.out.println(Query );
      	   Connection con = DriverManager.getConnection(connectionUrl); 
      	   Statement s1 = con.createStatement();      	
           ResultSet rs = s1.executeQuery(Query);
          
           while(rs.next())
              {                
               for(int i=1;i<=rs.getMetaData().getColumnCount();i++)
                  {
            	
                	li.add(rs.getString(i));
                  }
               
              } 
      	
      } catch (SQLException ex) {
          ex.printStackTrace();
          System.out.println("inside catch");
      } finally {
          try {
              if (conn != null && !conn.isClosed()) {
                  conn.close();
                  System.out.println("Finally");
                  
              }
          } catch (SQLException ex) {
              ex.printStackTrace();
          }
}
	return li;
}
}