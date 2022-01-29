package UnitTestsDeansOffice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateRowsInDatabaseTest {
    Connection con = null;
    Statement stmt = null;

    UpdateRowsInDatabaseTest(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "c##test", "test");
            stmt = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    void updateStudent(){
        try {
            stmt.executeQuery("UPDATE STUDENT SET name='updateName', surname='updateSurname' where indexNumber='9999'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    void updateStudentGroup(){
        try {
            stmt.executeQuery("UPDATE STUDENTGROUP SET name='updateName' where groupID='9999'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
