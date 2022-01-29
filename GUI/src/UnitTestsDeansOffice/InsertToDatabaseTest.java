package UnitTestsDeansOffice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class InsertToDatabaseTest {
    Connection con = null;
    Statement stmt = null;

    InsertToDatabaseTest() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "c##test", "test");
            stmt = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    void insertGroup(){
        try {
            stmt.executeQuery("INSERT INTO STUDENTGROUP VALUES('9999','TestName')");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    void insertStudent(){
        try {
            stmt.executeQuery("INSERT INTO STUDENT " +
                    "VALUES ('9999', 'testPass', 'TestName', 'TestSurname'," +
                    " '25', '123456789', 'rty@gmail.com', 'TestFOS', '9999')");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
