package com.exam.util;

import java.sql.*;
public class listCate
{
public static String listCates(int tempId,String tempStr)
{
     String sql="";
     String user="root";
     String pswd="root";
     String url="jdbc:mysql://localhost:3306/mysystem";
     Connection conn;
     Statement stmt1,stmt2;
     ResultSet rs1,rs2;
     try
     {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      conn = DriverManager.getConnection(url,user,pswd);
      sql = "select * from _point where fartherid = " + tempId + " order by id";
      stmt1 = conn.createStatement();
      rs1=stmt1.executeQuery(sql);
      while(rs1.next())
      {
       tempId = rs1.getInt("id");
       tempStr += rs1.getString("name")+"<br>";
//       sql = "select * from category where parent_id = " + tempId + " order by orders";
//       stmt2 = conn.createStatement();
//       rs2 = stmt2.executeQuery(sql);
//       if(rs2.next())
//       {
//        tempStr += "　┣";
        tempStr = listCates(tempId,tempStr);
//       }
//       rs2.close();
//       stmt2.close();
      }
      rs1.close();
      stmt1.close();
     }
     catch (Exception ex)
     {
      System.out.println("Error: " + ex.toString());
     }
//     System.out.println(tempStr); //输出到Tomcat
     return tempStr;
}
}