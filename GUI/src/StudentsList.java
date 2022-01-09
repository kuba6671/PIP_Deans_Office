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

    private final DefaultTableModel model = new DefaultTableModel(0, 6);


    String[] header = {"Nr indeksu", "Nazwisko", "Imię", "Nr telefonu","Email","Grupa"};

    private String isSelected;



    public StudentsList(){
        JFrame students = this;
        students.setSize(400, 400);
        students.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(StudentPanel);

        model.setColumnIdentifiers(header);
        studentTable = new JTable(model);


        groupCombo();
        makeTable();

        //examTable.setDefaultEditor(Object.class, null);


        GroupChoose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove();
                StudentsList.this.isSelected = GroupChoose.getSelectedItem().toString();
                groupSort(isSelected);
            }
        });

        ScrollStudent = new JScrollPane(studentTable);
        students.add(ScrollStudent);
        studentTable.setVisible(true);
        students.setVisible(true);

    }

    private void groupCombo(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "system123");
            Statement stmt = con.createStatement();
            System.out.println("Connection is created successfully:");
            ResultSet rs = stmt.executeQuery("select distinct groupid from studenci order by groupid asc");
            while(rs.next())
            {
                GroupChoose.addItem(rs.getInt("groupid"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    

    private void makeTable(){
        try {


            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "system123");
            Statement stmt = con.createStatement();
            System.out.println("Connection is created successfully:");
            ResultSet rs = stmt.executeQuery("select * from studenci");
            while (rs.next()) {
                Object[] row = {rs.getInt("studentid"), rs.getString("lastname"), rs.getString("firstname"), rs.getInt("phonenumber"), rs.getString("mail"), rs.getInt("groupid")};
                model.addRow(row);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void groupSort(String group) {
        try {


            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "system123");
            Statement stmt = con.createStatement();
            System.out.println("Connection is created successfully:");
            ResultSet rs = stmt.executeQuery("select * from studenci where groupid = " + group);
            System.out.println("Wywołano z " + group);
            while (rs.next()) {
                Object[] row = {rs.getInt("studentid"), rs.getString("lastname"), rs.getString("firstname"), rs.getInt("phonenumber"), rs.getString("mail"), rs.getInt("groupid")};
                model.addRow(row);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();


        }
    }

    private void remove() {
        while (model.getRowCount()> 0) {
            model.removeRow(0);
        }
    }





}
