package eip.mvc.model.util;
/*
 * DB ������ ���� �ε�, ����, �ݱ� ��� Ŭ����
 * 
 * */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
   private static Properties proFile = new Properties();
   /**
    * �ε�
    * */
   static {
      try{
            //2���� properties���� �ε��ϱ�!
            proFile.load(new FileInputStream("properties/dbInfo.properties"));
            proFile.load(new FileInputStream("properties/project.properties"));
            
            Class.forName(proFile.getProperty("driverName"));
         } catch (Exception e){
            e.printStackTrace();
         }
   }
   public static Properties getProFile() {
      return proFile;
   }
   /**
    * ����
    * */
   public static Connection getConnection() throws SQLException{ 
      //������ try catch ���ִ°Ÿ� ���⼭ �Ѳ����� ���ִ°� ����
      return DriverManager.getConnection(
            proFile.getProperty("url"),
            proFile.getProperty("userName"),
            proFile.getProperty("userPass"));
   }
   
   /**
    * �ݱ� (insert, update, delete�� ���)
    * */
   public static void dbClose(Statement st, Connection con) {
      try {
      if(st!=null) st.close();
      if(con!=null) con.close();
      }catch(SQLException e) {
         e.printStackTrace();
      }
   }
   /**
    * �ݱ� (select�� ���)
    * */
   public static void dbClose(ResultSet rs, Statement st, Connection con) {
      if(rs!=null)
         try {
            rs.close();
            dbClose(st, con);
         } catch (SQLException e) {
            e.printStackTrace();
         }
   }
   public static void main(String[] args) {
      System.out.println(1111);
   }
}