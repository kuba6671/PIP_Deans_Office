import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class GUI extends JFrame implements ActionListener {

    protected static JLabel userLabel;
    protected static JLabel userLabel2;
    protected static JTextField userText;
    protected static JPanel panel;
    protected static JLabel passwordLabel;
    protected static JPasswordField passwordText;
    protected static JButton button;
    protected static JLabel success;



    public static void main(String[] args) {
        MainWindow mainwind = new MainWindow();
        mainwind.openWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame mainwind = this;
        TeacherView teacher = new TeacherView();
        StudentView student = new StudentView();
        OfficeView office = new OfficeView();
        String user = userText.getText();
        String password = passwordText.getText();
        System.out.println(user + ", " + password);

        Connection conn = null;
        Statement stmt = null;

        String name = null;
        String surname = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##test","test");
            stmt = con.createStatement();
            System.out.println("Connection is created successfully:");

            ResultSet loginStudent = stmt.executeQuery("select * from Student where indexNumber ='"+user+"' AND password='"+password+"'");
            if(loginStudent.next()){
                success.setText("Login succesful!");
                name = loginStudent.getString("name");
                surname = loginStudent.getString("surname");
                student.openWindow(user,name,surname, con, stmt);
            }
            ResultSet loginTeacher = stmt.executeQuery("select * from Teacher where teacherID ='"+user+"' AND password='"+password+"'");
            if(loginTeacher.next()){
                success.setText("Login succesful!");
                name = loginTeacher.getString("name");
                surname = loginTeacher.getString("surname");
                teacher.openWindow(user,name,surname,con, stmt);
            }
            ResultSet loginEmployee = stmt.executeQuery("select * from OfficeEmployee where OfficeEmployeeID ='"+user+"' AND password='"+password+"'");
            if(loginEmployee.next()){
                success.setText("Login succesful!");
                name = loginEmployee.getString("name");
                surname = loginEmployee.getString("surname");
                office.openWindow(user,name,surname, con, stmt);
            }
            else{
                success.setText("Login doesnt succesful");
            }
        } catch (ClassNotFoundException | SQLException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }

        //success.setText("Login succesful!");
        //office.openWindow(user,password);

        /*if(user.equals("")&&password.equals("")){
            success.setText("Login succesful!");
            teacher.openWindow(user,password);
        }

        else if(user.equals("tomasz")&&password.equals("chuma")){
            success.setText("Login succesful!");
            student.openWindow(user,password);
        }

        else if(user.equals("pracownik")&&password.equals("dziekanatu")){
            success.setText("Login succesful!");
            office.openWindow(user,password);
        }
        else
            success.setText("Login doesnt succesful");*/
    }


}
