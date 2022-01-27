import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;



public class AddMark extends JFrame{
    private JComboBox StudentChoose;
    private JComboBox GroupChoose;
    private JTable markTable;
    private JPanel MarkPanel;
    private JComboBox Sub1;
    private JComboBox FieldChoose;
    private JScrollPane ScrollMark;

    private int i;



    private String isSelected;
    private String select;
    private String select2;

    private final DefaultTableModel model = new DefaultTableModel(0, 6);


    //String[] header = {"ID","Przedmiot1", "Przedmiot2", "Przedmiot3", "Przedmiot4","Przedmiot5","StID"};

    public AddMark() {
        JFrame marks = this;
        marks.setSize(400, 400);
        marks.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(MarkPanel);

        //model.setColumnIdentifiers(header);
        //markTable = new JTable(model);

        GroupChoose.addItem("Wybierz grupę");
        StudentChoose.addItem("Wybierz studenta");


        groupCombo();


        GroupChoose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(GroupChoose.getSelectedItem()!="Wybierz grupę") {
                    AddMark.this.isSelected = GroupChoose.getSelectedItem().toString();
                    studentCombo(isSelected);
                    System.out.println("AAAA");
                }

            }
        });


        StudentChoose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if(StudentChoose.getItemCount()==0){
                    StudentChoose.addItem("Wybierz studenta");
                }

                if(StudentChoose.getSelectedItem()!="Wybierz studenta") {
                    System.out.println("CCC");
                    AddMark.this.select = StudentChoose.getSelectedItem().toString();
                    System.out.println("AAA");
                    markCombo(select);
                    System.out.println("BBBB");
                }

            }
        });

        Sub1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("XPPP");

                AddMark.this.select2 = Sub1.getSelectedItem().toString();
                System.out.println("XXX");

            }
        });



        //ScrollMark = new JScrollPane(markTable);
        //marks.add(ScrollMark);
        //markTable.setVisible(true);
        marks.setVisible(true);

    }


    private void groupCombo(){
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
            Statement stmt = con.createStatement();
            System.out.println("GConnection is created successfully:");
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

    private void studentCombo(String group){

        StudentChoose.removeAllItems();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
            Statement stmt = con.createStatement();
            System.out.println("Connection is created successfully:");
            ResultSet rs = stmt.executeQuery("select studentid from studenci where groupid = " + group);
            while(rs.next())
            {
                StudentChoose.addItem(rs.getString("studentid"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /*private void makeTable(String studentID){

            try {


                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
                Statement stmt = con.createStatement();
                System.out.println("Connection is created successfully:");
                System.out.println("MAKE: " + studentID);
                ResultSet rs = stmt.executeQuery("select * from oceny Join studenci on oceny.studentid=studenci.studentid where studenci.firstname = '" + studentID + "'");
                while (rs.next()) {
                    Object[] row = {rs.getInt("OcenaID"), rs.getString("Sub1"), rs.getString("Sub2"), rs.getString("Sub3"), rs.getString("Sub4"), rs.getString("Sub5"), rs.getInt("studentID")};
                    model.addRow(row);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

    }*/

    private void markCombo(String studentID){
        Sub1.removeAllItems();
        for(int i = 2; i < 6; i++){
            Sub1.addItem(i);
        }
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
            Statement stmt = con.createStatement();
            System.out.println("MConnection is created successfully:");
            ResultSet rs = stmt.executeQuery("select Sub1 from oceny where studentid = " + studentID);
            while(rs.next())
            {
                Sub1.setSelectedItem(rs.getInt("Sub1"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void changeMark(String studentID, String mark){
        System.out.println(studentID);
        System.out.println(mark);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
            Statement stmt = con.createStatement();
            System.out.println("Connection is created successfully:");

            int count = stmt.executeUpdate("update oceny set Sub1 = " + mark + " where studentid = " + studentID);
            if(count>0)
                System.out.println("records inserted succesfully");
            else
                System.out.println("records insertion failed");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



}
