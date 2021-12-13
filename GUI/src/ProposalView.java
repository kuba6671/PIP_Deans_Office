import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProposalView extends JFrame implements ActionListener {
    private JComboBox ProposalChoose;
    private JPanel ProposalPanel;
    private JPanel SocialGrantForm;
    private JPanel FellowshipForm;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField subjectField;
    private JTextField sessionField;
    private JTextField idField;
    private JTextField dateField;
    private JTextField incomeField;
    private JTextField nameFieldFF;
    private JTextField surnameFieldFF;
    private JTextField subjectFieldFF;
    private JTextField sessionFieldFF;
    private JTextField idFieldFF;
    private JTextField dateFieldFF;
    private JTextField incomeFieldFF;

    public ProposalView(){
        JFrame proposal = this;
        proposal.setSize(400,400);
        proposal.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(ProposalPanel);
        //this.pack();
        ProposalChoose.addItem("Stypendium socjalne");
        ProposalChoose.addItem("Stypendium naukowe");
        ProposalChoose.addActionListener(this);

        SocialGrantForm.setVisible(true);
        proposal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SocialGrantForm.setVisible(false);
        FellowshipForm.setVisible(false);
        String isSelected = (String) ProposalChoose.getSelectedItem();
        if(isSelected == "Stypendium socjalne") {
            SocialGrantForm.setVisible(true);
        }
        else if (isSelected == "Stypendium naukowe"){
            FellowshipForm.setVisible(true);
        }
    }


   /* private void createUIComponents() {
        //String isSelected = ProposalChoose.getSelectedItem();
        String isSelected = (String) ProposalChoose.getSelectedItem();
        /*if(isSelected == "Stypendium socjalne") {
            System.out.println("Stypendium socjalne");
        }
        else if (isSelected == "Stypendium naukowe"){
            System.out.println("Stypendium naukowe");
        }
    }*/
}
