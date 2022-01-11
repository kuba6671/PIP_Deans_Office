import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        if(user.equals("")&&password.equals("")){
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
            success.setText("Login doesnt succesful");
    }


}
