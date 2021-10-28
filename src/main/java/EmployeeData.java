import java.sql.*;

public class EmployeeData {
    static final String DB_URL = "jdbc:mysql://localhost:3306/payroll_service";
    static final String USER = "root";
    static final String PASS = "abhishek";
    JDBCConnection mySql=new JDBCConnection();


    public  void getData()  {
        String sql=("select * from employee_payroll;");
        try(
                Connection con= DriverManager.getConnection(DB_URL,USER,PASS);
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery(sql)){
            while (rs.next()) {
                System.out.println(rs.getString("id")+ "\t" + rs.getString("name") + "\t"
                                   + rs.getString("salary") + "\t" + rs.getString("startDate") + "\t"
                        + rs.getString("gender") + "\t" + rs.getString("address") + "\t"
                        + rs.getString("phone") + "\t" + rs.getString("department") + "\t"
                        + rs.getString("basic_pay") + "\t" + rs.getString("deducation") + "\t"
                        + rs.getString("income_tax") + "\t" + rs.getString("net_pay") + "\t"
                        + rs.getString("taxable_pay"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void updateDataPrepareStatement(){
        String sqlUpdate="update employee_payroll set salary=30000 where name='abhi'";
        PreparedStatement psmt;

        try(Connection conn=DriverManager.getConnection(DB_URL,USER,PASS))
        {

            psmt=conn.prepareStatement(sqlUpdate);
             psmt.execute();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args){
        EmployeeData connection=new EmployeeData();
        connection.getData();
        connection.updateDataPrepareStatement();
        connection.getData();
    }
}
