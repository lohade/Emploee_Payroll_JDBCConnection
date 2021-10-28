import java.sql.*;

public class EmployeeData {

    /*
    static final String DB_URL = "jdbc:mysql://localhost:3306/payroll_service";
    static final String USER = "root";
    static final String PASS = "abhishek";
    public  void getData() {

        String sql=("select * from employee_payroll;");
        try(
                Connection con= DriverManager.getConnection(DB_URL,USER,PASS);
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery(sql)){
            while (rs.next()) {
                System.out.println(rs.getString("id")+ "\t" + rs.getString("name")
                                   + rs.getString("salary") + "\t" + rs.getString("startDate")
                        + rs.getString("gender") + "\t" + rs.getString("address")
                        + rs.getString("phone") + "\t" + rs.getString("department")
                        + rs.getString("basic_pay") + "\t" + rs.getString("deducation")
                        + rs.getString("income_tax") + "\t" + rs.getString("net_pay")
                        + rs.getString("taxable_pay"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        EmployeeData data=new EmployeeData();
        data.getData();
    }

     */
}
