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

public class RegistrationView extends GUI {
    private JPanel RegistrationPanel;
    private JPanel ButtonPanel;
    private JPanel RegistrationForm;
    private JButton register;

    private JTextField idText;
    private JTextField surnameText;
    private JTextField nameText;
    private JTextField phoneText;
    private JTextField mailText;
    private JTextField groupText;

    private JLabel nazwiskoLabel;
    private JButton close;

    Connection conn = null;
    Statement stmt = null;
    int i;

    public RegistrationView() {
        JFrame registration = this;
        registration.setSize(400, 400);
        registration.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(RegistrationPanel);
        //this.pack();

        registration.setVisible(true);

        register.addActionListener(new ActionListener() { //dodać zabezpieczenie przed wprowadzaniem pustych wierszy i złych wartości(np. w pole numeryczne liter)
            @Override
            public void actionPerformed(ActionEvent e) {
                registerdb();
                clearform();
            }
        });

        close.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registration.dispose();
            }
        }));

    }



    private void registerdb(){
        String id = idText.getText();
        String surname = surnameText.getText();
        String name = nameText.getText();
        String phone = phoneText.getText();
        String mail = mailText.getText();
        String group = groupText.getText();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system123");
            Statement stmt = con.createStatement();
            System.out.println("Connection is created successfully:");

            int count = stmt.executeUpdate("insert into studenci values('"+id+"','"+surname+"','"+name+"','"+phone+"','"+mail+"','"+group+"')");
            if(count>0)
                System.out.println("records inserted succesfully");
            else
                System.out.println("records insertion failed");

            System.out.println("Record is inserted in the table successfully..................");
        } catch (SQLException excep) {
            excep.printStackTrace();
        } catch (Exception excep) {
            excep.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {}
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    private void clearform(){
        idText.setText("");
        surnameText.setText("");
        nameText.setText("");
        phoneText.setText("");
        mailText.setText("");
        groupText.setText("");
    }

}

