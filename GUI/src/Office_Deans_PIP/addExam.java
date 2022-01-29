package Office_Deans_PIP;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePicker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
    private JPanel DatePanel;
    private JPanel DateTextPanel;
    private JLabel dateText;
    JFrame exam;
    DatePicker datePicker1;
    TimePicker timePicker1;
    Statement stmt;
    Connection con;
    int teacherID;

    public addExam(int teacherID,Connection con, Statement stmt){
        exam = this;
        exam.setSize(400, 300);
        exam.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(addExamPanel);
        this.teacherID = teacherID;

        this.stmt = stmt;
        this.con = con;

        submitButton.addActionListener(this);
        exitButton.addActionListener(this);


        JPanel myDatePanel = DatePanel;
        myDatePanel.setSize(400,40);

        datePicker1 = new DatePicker();
        datePicker1.setSize(100,30);
        myDatePanel.add(datePicker1);

        timePicker1 = new TimePicker();
        timePicker1.setSize(80,30);
        myDatePanel.add(timePicker1);



        exam.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LocalDateTime date = null;
        String groupName;
        String subject;
        String dateFormString = null;
        int subjectID=0;
        int count=0;
        int groupID=0;
        if(e.getSource()==exitButton) {
            exam.dispose();
        }
        else if (e.getSource() == submitButton) {
            if(!this.datePicker1.getText().isEmpty()) {
                dateFormString = this.datePicker1.getDate().toString() +" "+ this.timePicker1.getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm",Locale.ENGLISH);
                date = LocalDateTime.parse(dateFormString, formatter);
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
                count = stmt.executeUpdate("insert into exam values(exam_seq.NEXTVAL,TO_DATE('"
                        +dateFormString+"', 'YYYY-MM-DD HH24:MI'),"+exam.getGroupID()+","
                        +exam.getTeacherID()+","+exam.getSubjectID()+")");
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
