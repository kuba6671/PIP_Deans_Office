import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentsList extends JFrame {
    private JPanel StudentPanel;
    private JTable studentTable;
    private JScrollPane ScrollStudent;
    private JComboBox GroupChoose;

    String[] header = {"Nr indeksu", "Nazwisko", "Imię", "Nr telefonu","Email","Grupa"};


    public StudentsList(){
        JFrame students = this;
        students.setSize(400, 400);
        students.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(StudentPanel);


        ScrollStudent = new JScrollPane(studentTable);
        students.add(ScrollStudent);

        //examTable.setDefaultEditor(Object.class, null);

        studentTable.setVisible(true);
        students.setVisible(true);
    }

    

    private void createUIComponents() {
        // TODO: place custom component creation code here
        DefaultTableModel model = new DefaultTableModel(0,6);
        model.setColumnIdentifiers(header);
        try {
            studentTable = new JTable(model);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "system123");
            Statement stmt = con.createStatement();
            System.out.println("Connection is created successfully:");
            ResultSet rs = stmt.executeQuery("select * from studenci");
            while(rs.next())
            {
                Object[] row = {rs.getInt("studentid"),rs.getString("lastname"),rs.getString("firstname"),rs.getInt("phonenumber"),rs.getString("mail"),rs.getInt("groupid")};
                model.addRow(row);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

}
