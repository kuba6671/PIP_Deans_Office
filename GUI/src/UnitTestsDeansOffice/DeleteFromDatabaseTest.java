package UnitTestsDeansOffice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteFromDatabaseTest {
    Connection con = null;
    Statement stmt = null;
    DeleteFromDatabaseTest(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "c##test", "test");
            stmt = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    void deleteStudentGroup(){
        try {
            stmt.executeQuery("DELETE FROM STUDENTGROUP WHERE GROUPID='9999'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void deleteStudent(){
        try {
            stmt.executeQuery("DELETE FROM STUDENT WHERE INDEXNUMBER='9999'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
