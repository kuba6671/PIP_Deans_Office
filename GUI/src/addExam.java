import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class addExam extends JFrame implements ActionListener {
    private JPanel addExamPanel;
    private JTextField dateField;
    private JTextField groupField;
    private JTextField subjectField;
    private JPanel examForm;
    private JPanel buttonPanel;
    private JButton submitButton;
    private JButton exitButton;
    Statement stmt;
    Connection con;
    int teacherID;

    public addExam(int teacherID,Connection con, Statement stmt){
        JFrame exam = this;
        exam.setSize(400, 300);
        exam.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(addExamPanel);
        this.teacherID = teacherID;

        this.stmt = stmt;
        this.con = con;

        submitButton.addActionListener(this);
        exitButton.addActionListener(this);

        exam.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LocalDate date = null;
        String groupName;
        String subject;
        int subjectID=0;
        int count=0;
        int groupID=0;
        if (e.getSource() == submitButton) {
            if(!this.dateField.getText().isEmpty()) {
                String dateFormString = this.dateField.getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH);
                date = LocalDate.parse(dateFormString, formatter);
            }
            if(!this.groupField.getText().isEmpty()){
                groupName = groupField.getText();
                ResultSet rs = null;
                try {
                    rs = stmt.executeQuery("select * from studentGroup where name =" + groupName);
                    if(!rs.next()){
                        System.out.println("Podana grupa nie istnieje");
                    }
                    else{
                        groupID = rs.getInt("groupID");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(!this.subjectField.getText().isEmpty()){
                subject = subjectField.getText();
                try {
                    ResultSet rs = stmt.executeQuery("select * from subject where name = '" + subject+"'");
                    if(!rs.next()){
                        count = stmt.executeUpdate("insert into subject values(subject_seq.NEXTVAL,'"+subject+"')");
                        if(count>0)
                            System.out.println("records inserted succesfully");
                        else
                            System.out.println("records insertion failed");
                        rs = stmt.executeQuery("select * from subject where name = '" + subject+"'");
                        while(rs.next()) {
                            subjectID = rs.getInt("subjectID");
                        }
                    }else {
                        subjectID = rs.getInt("subjectID");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            Exam exam = new Exam(date,groupID,teacherID,subjectID);
            try {
                count = stmt.executeUpdate("insert into exam values(exam_seq.NEXTVAL,'"
                        +exam.getDate()+"',"+exam.getGroupID()+","+exam.getTeacherID()+","+exam.getSubjectID()+")");
                if(count>0)
                    System.out.println("records inserted succesfully");
                else
                    System.out.println("records insertion failed");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if(count>0)
                System.out.println("records inserted succesfully");
            else
                System.out.println("records insertion failed");

        }
    }
}
