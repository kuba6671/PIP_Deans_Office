package UnitTestsDeansOffice;

import Office_Deans_PIP.Colloquium;
import Office_Deans_PIP.Exam;
import Office_Deans_PIP.FinalTest;
import Office_Deans_PIP.ProjectDefense;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


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

    void insertSocialGrantFormProposal(){
        try {
            stmt.executeQuery("INSERT INTO PROPOSAL (PROPOSALID, PROPOSALNAME," +
                    " \"date\", \"session\", INCOME, INDEXNUMBER) VALUES( " +
                    "'9999','Stypendium socjalne',TO_DATE('2022-02-20','YYYY-MM-DD')," +
                    "'5','2000','9999')");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void insertFellowShipFormProposal(){
        try {
            stmt.executeQuery("INSERT INTO PROPOSAL(PROPOSALID, PROPOSALNAME," +
                    " \"date\", \"session\", AVG, INDEXNUMBER) VALUES( " +
                    "'8888','Stypendium naukowe',TO_DATE('2022-02-20','YYYY-MM-DD')," +
                    "'5','4,8','9999')");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void insertTeacher(){
        try {
            stmt.executeQuery("INSERT INTO TEACHER " +
                    "VALUES ('9999', 'testPass', 'TestName', 'TestSurname'," +
                    " '25', '123456789', 'rty@gmail.com')");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void insertSubject(){
        try {
            stmt.executeQuery("INSERT INTO SUBJECT " +
                    "VALUES ('9999','TestName')");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void insertExam(){
        DeleteFromDatabaseTest deleteTest = new DeleteFromDatabaseTest();
        InsertToDatabaseTest insertTest = new InsertToDatabaseTest();
        deleteTest.deleteStudent();
        deleteTest.deleteStudentGroup();
        deleteTest.deleteTeacher();
        deleteTest.deleteSubject();
        insertTest.insertGroup();
        insertTest.insertStudent();
        insertTest.insertTeacher();
        insertTest.insertSubject();

        Exam exam = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date = LocalDateTime.parse("2022-01-30 10:00", formatter);
        FinalTest tmpObject = new FinalTest(date,9999,9999,9999);
        exam = tmpObject.clone();
        System.out.println("\nExam type= "+exam.getType()+ "    Class name= "+exam.getClass().getSimpleName());
        Colloquium tmpObjectColloquium = new Colloquium(date,9999,9999,9999);
        exam = tmpObjectColloquium.clone();
        System.out.println("Exam type= "+exam.getType()+ "      Class name= "+exam.getClass().getSimpleName());
        ProjectDefense tmpObjectProject = new ProjectDefense(date,9999,9999,9999);
        exam = tmpObjectProject.clone();
        System.out.println("Exam type= "+exam.getType()+ "      Class name= "+exam.getClass().getSimpleName());





        /*
                    Exam exam = null;
            if(selectedType == "Egzamin"){
                FinalTest tmpObject = new FinalTest(date,groupID,teacherID,subjectID);
                exam = tmpObject.clone();
            }
            else if(selectedType == "Kolokwium"){
                Colloquium tmpObject = new Colloquium(date,groupID,teacherID,subjectID);
                exam = tmpObject.clone();
            }
            else if(selectedType == "Obrona projektu"){
                ProjectDefense tmpObject = new ProjectDefense(date,groupID,teacherID,subjectID);
                exam = tmpObject.clone();
            }
            exam.setType();
         */
        //FinalTest tmpObject = new FinalTest();
    }
}
