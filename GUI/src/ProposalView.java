import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JTextField subject;
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

    public ProposalView() {
        JFrame proposal = this;
        proposal.setSize(400, 400);
        proposal.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(ProposalPanel);
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

        if (e.getSource() == resetButton) {
            name.setText("");
            surname.setText("");
            subject.setText("");
            this.session.setText("");
            id.setText("");
            this.date.setText("");
            this.income.setText("");
            this.avg.setText("");
        }
        else if(e.getSource() == sendButton){
            if (isSelected == "Stypendium socjalne") {

                if(!this.date.getText().isEmpty()) {
                    String dateFormString = this.date.getText();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH);
                    date = LocalDate.parse(dateFormString, formatter);
                }
               if(!this.session.getText().isEmpty()) {
                    session = Integer.parseInt(this.session.getText());
                }
               if(!this.income.getText().isEmpty()) {
                   income = Integer.parseInt(this.income.getText());
               }
                if(!this.avg.getText().isEmpty()) {
                     avg = Double.parseDouble(this.avg.getText());
                }

                Proposal SocialGrantForm = new Proposal("Stypendium socjalne",name.getText(),surname.getText(),
                        subject.getText(),id.getText(),date,session,income);
            }
            else if(isSelected == "Stypendium naukowe"){
                Proposal FellowShipForm = new Proposal("Stypendium naukowe",name.getText(),surname.getText(),
                        subject.getText(),id.getText(),date,session,avg);
            }
        }

    }


}
