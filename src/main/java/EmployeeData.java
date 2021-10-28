import java.sql.*;
import java.util.Scanner;

public class EmployeeData {
    static final String DB_URL = "jdbc:mysql://localhost:3306/payroll_service";
    static final String USER = "root";
    static final String PASS = "abhishek";


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
        String sqlUpdate="update employee_payroll set salary=? where name=?";
        PreparedStatement psmt;

        try(Connection conn=DriverManager.getConnection(DB_URL,USER,PASS))
        {

            psmt=conn.prepareStatement(sqlUpdate);
            double salary=20000;
            String name="abhi";
            psmt.setDouble(1,salary);
            psmt.setString(2,name);
             psmt.execute();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void updateSalary(){
        String sql1="update employee_payroll set salary=30000 where name='harsh'";
        try(Connection con= DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt=con.createStatement())
        {
            stmt.executeUpdate(sql1);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void getAllEmployee(){
        String sqlEmployee="select name,startDate from employee_payroll where startDate BETWEEN '2021-01-10' and '2021-10-01' ";
        try(
                Connection con= DriverManager.getConnection(DB_URL,USER,PASS);
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery(sqlEmployee)){
            while (rs.next()) {
                System.out.println( rs.getString("name") + "\t"
                        + rs.getString("startDate"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void aggregateFunction(){

        String sqlAggregate="select max(salary),sum(salary),avg(salary),min(salary) from employee_payroll where gender ='M' group by gender";
        try(
                Connection con= DriverManager.getConnection(DB_URL,USER,PASS);
                Statement stmt=con.createStatement();
                ResultSet res=stmt.executeQuery(sqlAggregate)){
            while (res.next()){
                System.out.println("maximum salary:"+res.getString("max(salary)"));
                System.out.println("sum of salary:"+res.getString("sum(salary)"));
                System.out.println("average salary:"+res.getString("avg(salary)"));
                System.out.println("minimum salary:"+res.getString("min(salary)"));


            }


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }



    public static void main(String[] args) {
        EmployeeData connection = new EmployeeData();
        boolean status = true;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("enter choice for:\n1:show all the data in table:\n2:update salary using create statement:\n3:update using prepare statement:\n4:show data between specific date:\n5:find aggregate function:\n6:exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    connection.getData();
                    break;

                case 2:
                    connection.updateSalary();
                    break;

                case 3:
                    connection.updateDataPrepareStatement();
                    connection.getData();
                    break;

                case 4:
                    connection.getAllEmployee();
                    break;

                case 5:
                    connection.aggregateFunction();
                    break;

                case 6:
                    status=false;
                    break;

            }
        }while (status);
    }
}
