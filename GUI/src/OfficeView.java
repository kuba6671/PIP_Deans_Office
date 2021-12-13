import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OfficeView extends GUI{
    JButton button2 = new JButton();
    JButton button3 = new JButton();
    JButton button4 = new JButton();


    public void openWindow(String user, String password){
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        String s = user + " " + password;

        panel.setLayout(null);

        userLabel = new JLabel("Panel pracownika");
        userLabel.setBounds(140, 10, 130, 25);
        panel.add(userLabel);

        userLabel2 = new JLabel("Pracownik : " + s);
        userLabel2.setBounds(10, 35, 200, 25);
        panel.add(userLabel2);

        button = new JButton("Modyfikuj plan");
        button.setBounds(40, 70, 150, 25);
        panel.add(button);

        button2 = new JButton("Wnioski");
        button2.setBounds(210, 70, 150, 25);
        panel.add(button2);

        button3 = new JButton("Grupy studenckie");
        button3.setBounds(40, 110, 150, 25);
        panel.add(button3);

        button4 = new JButton("Przydział zadań");
        button4.setBounds(210, 110, 150, 25);
        panel.add(button4);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        frame.setVisible(true);
    }


}
