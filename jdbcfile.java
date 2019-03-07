package kk;

import java.sql.*;
public class jdbcfile{

Connection conn=null;
Statement stmt=null;
int inorupdatevalue=-1;

public jdbcfile()  throws Exception{

   try{
      // String drivername="com.mysql.jdbc.Driver";
      // String dbURL="\"jdbc:mysql://localhost:3306/music\",\"root\",\"root\"";
       Class.forName("com.mysql.jdbc.Driver");
       conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
       stmt=conn.createStatement();
}catch(ClassNotFoundException e){
       throw new Exception("加载异常"+e.getMessage());
}catch(SQLException e){
       throw new Exception("SQL异常"+e.getMessage());
}
}
       public synchronized ResultSet executeQuery(String sql) throws Exception{
       ResultSet rs=stmt.executeQuery(sql);
       return rs;
}
       public synchronized int insert(String sql) throws Exception{
       inorupdatevalue=stmt.executeUpdate(sql);
       return inorupdatevalue;
}
       public synchronized int update(String sql)  throws Exception{
       inorupdatevalue=stmt.executeUpdate(sql);
       return inorupdatevalue;
}
       public synchronized int del(String sql) throws Exception{
       inorupdatevalue=stmt.executeUpdate(sql);
       return inorupdatevalue;
}
       public void close()  throws Exception{
       conn.close();

}

}