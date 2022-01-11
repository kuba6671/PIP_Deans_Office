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
    private JScrollPane ScrollMark;

    private int i;



    private String isSelected;
    private String select;

    private final DefaultTableModel model = new DefaultTableModel(0, 6);


    String[] header = {"ID","Przedmiot1", "Przedmiot2", "Przedmiot3", "Przedmiot4","Przedmiot5","StID"};

    public AddMark() {
        JFrame marks = this;
        marks.setSize(400, 400);
        marks.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(MarkPanel);

        model.setColumnIdentifiers(header);
        markTable = new JTable(model);

        GroupChoose.addItem("Wybierz grupę");
        StudentChoose.addItem("Wybierz studenta");


        groupCombo();


        GroupChoose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(GroupChoose.getSelectedItem()!="Wybierz grupę") {
                    AddMark.this.isSelected = GroupChoose.getSelectedItem().toString();
                    studentCombo(isSelected);
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
                    AddMark.this.select = StudentChoose.getSelectedItem().toString();
                    makeTable(select);
                }

            }
        });



        ScrollMark = new JScrollPane(markTable);
        marks.add(ScrollMark);
        markTable.setVisible(true);
        marks.setVisible(true);

    }


    private void groupCombo(){
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
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

    private void studentCombo(String group){

        StudentChoose.removeAllItems();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
            Statement stmt = con.createStatement();
            System.out.println("Connection is created successfully:");
            ResultSet rs = stmt.executeQuery("select firstname from studenci where groupid = " + group);
            while(rs.next())
            {
                StudentChoose.addItem(rs.getString("firstname"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void makeTable(String studentID){

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

    }


}
