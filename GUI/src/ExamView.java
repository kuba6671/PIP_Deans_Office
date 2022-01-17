import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExamView extends JFrame {
    private JPanel ExamPanel;
    private JTable examTable;
    private JScrollPane ScrollExam;

    public ExamView(int groupID, Connection con, Statement stmt){
        JFrame exam = this;
        exam.setSize(400, 400);
        exam.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(ExamPanel);

        int i=0,j=0;
        String[][] data = new String[20][2];
        String[] columnNames = {"Przedmiot", "Data"};
        try{
            ResultSet examine = stmt.executeQuery("select subject.name, data from exam JOIN StudentGroup ON StudentGroup.groupID =exam.groupID" +
                    " JOIN subject ON exam.subjectID = subject.subjectID" +
                    " where exam.groupID ="+groupID);
            while(examine.next()){
                data[i][j] = examine.getString("name");
                j++;
                data[i][j] = examine.getString("data");
                i++;
                j=0;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        examTable = new JTable(data,columnNames);
        ScrollExam = new JScrollPane(examTable);
        exam.add(ScrollExam);

        examTable.setDefaultEditor(Object.class, null);

        examTable.setVisible(true);
        exam.setVisible(true);
    }
}
