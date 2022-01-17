import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class ProposalView extends JFrame implements ActionListener {
    private JComboBox ProposalChoose;
    private JPanel ProposalPanel;
    private JPanel ProposalForm;
    private JTextField name;
    private JTextField surname;
    private JTextField fieldOfStudy;
    private JTextField session;
    private JTextField id;
    private JTextField date;
    private JTextField income;
    private JTextField avg;
    private JPanel ButtonPanel;
    private JButton sendButton;
    private JButton resetButton;
    private JPanel avgPanel;
    private JPanel incomePanel;
    Statement stmt;
    Connection con;

    public ProposalView(int indexNumber, Connection con, Statement stmt) {
        JFrame proposal = this;
        proposal.setSize(400, 400);
        proposal.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(ProposalPanel);
        this.stmt = stmt;
        this.con = con;
        //this.pack();

        ProposalChoose.addItem("Stypendium socjalne");
        ProposalChoose.addItem("Stypendium naukowe");
        ProposalChoose.addActionListener(this);

        resetButton.addActionListener(this);
        sendButton.addActionListener(this);


        ProposalForm.setVisible(true);
        incomePanel.setVisible(true);
        proposal.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        incomePanel.setVisible(false);
        avgPanel.setVisible(false);
        String isSelected = (String) ProposalChoose.getSelectedItem();
        if (isSelected == "Stypendium socjalne") {
            incomePanel.setVisible(true);
        } else if (isSelected == "Stypendium naukowe") {
            avgPanel.setVisible(true);
        }

        int session=0;
        int income=0;
        double avg= 0.0;
        LocalDate date = null;
        int count=0;

        if (e.getSource() == resetButton) {
            name.setText("");
            surname.setText("");
            fieldOfStudy.setText("");
            this.session.setText("");
            id.setText("");
            this.date.setText("");
            this.income.setText("");
            this.avg.setText("");
        }
        else if(e.getSource() == sendButton){
            if(!this.session.getText().isEmpty()) {
                session = Integer.parseInt(this.session.getText());
            }
            if(!this.date.getText().isEmpty()) {
                String dateFormString = this.date.getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH);
                date = LocalDate.parse(dateFormString, formatter);
            }
            if (isSelected == "Stypendium socjalne") {
                if(!this.income.getText().isEmpty()) {
                    income = Integer.parseInt(this.income.getText());
                }
                Proposal SocialGrantForm = new Proposal("Stypendium socjalne",name.getText(),surname.getText(),
                        fieldOfStudy.getText(),id.getText(),date,session,income);

                try {
                    System.out.println("INSERT INTO PROPOSAL (PROPOSALID, PROPOSALNAME, \"date\", \"session\"" +
                            ", INCOME, INDEXNUMBER) VALUES " + "(proposal_seq.NEXTVAL,'"+SocialGrantForm.getProposalName()+
                            "','"+SocialGrantForm.getDate()+"','"+SocialGrantForm.getSession()+
                            "',"+SocialGrantForm.getIncome()+","+SocialGrantForm.getId()+")");
                    count = stmt.executeUpdate("INSERT INTO PROPOSAL (PROPOSALID, PROPOSALNAME, \"date\", \"session\"" +
                            ", INCOME, INDEXNUMBER) VALUES " + "(proposal_seq.NEXTVAL,'"+SocialGrantForm.proposalName+
                                    "','"+SocialGrantForm.date+"','"+SocialGrantForm.session+
                            "',"+SocialGrantForm.income+","+SocialGrantForm.id+")");
                    if(count>0)
                        System.out.println("records inserted succesfully");
                    else
                        System.out.println("records insertion failed");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
            else if(isSelected == "Stypendium naukowe"){
                if(!this.avg.getText().isEmpty()) {
                    avg = Double.parseDouble(this.avg.getText());
                }


                Proposal FellowShipForm = new Proposal("Stypendium naukowe",name.getText(),surname.getText(),
                        fieldOfStudy.getText(),id.getText(),date,session,avg);

                try {
                    System.out.println("INSERT INTO PROPOSAL (PROPOSALID, PROPOSALNAME, \"date\", \"session\"" +
                            ", INCOME, INDEXNUMBER) VALUES " + "(proposal_seq.NEXTVAL,'"+FellowShipForm.getProposalName()+
                            "','"+FellowShipForm.getDate()+"','"+FellowShipForm.getSession()+
                            "',"+FellowShipForm.getIncome()+","+FellowShipForm.getId()+")");
                    count = stmt.executeUpdate("INSERT INTO PROPOSAL (PROPOSALID, PROPOSALNAME, \"date\", \"session\"" +
                            ", AVG, INDEXNUMBER) VALUES " + "(proposal_seq.NEXTVAL,'"+FellowShipForm.proposalName+
                            "','"+FellowShipForm.date+"','"+FellowShipForm.session+
                            "',"+FellowShipForm.avg+","+FellowShipForm.id+")");
                    if(count>0)
                        System.out.println("records inserted succesfully");
                    else
                        System.out.println("records insertion failed");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }


}
