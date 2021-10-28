import java.sql.*;
import java.util.Enumeration;
import java.sql.DriverManager;


public class JDBCConnection {
    public static void main(String[] args){
        getConnect();
    }

    public static Connection getConnect() {
        String url = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "root";
        String password = "abhishek";
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver loaded");

        } catch (Exception e) {
            e.printStackTrace();
        }
        listDrivers();

        try {
            System.out.println("connecting to database" + url);
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("connection successfully" + con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void listDrivers(){
        Enumeration<Driver> driverList=DriverManager.getDrivers();
        while (driverList.hasMoreElements()){
            Driver driver=driverList.nextElement();
            System.out.println(" "+driver.getClass().getName());
        }
    }
}


