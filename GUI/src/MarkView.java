import javax.swing.*;

public class MarkView extends JFrame {
    private JTable markTable;
    private JPanel MarkPanel;
    private JScrollPane ScrollMark;

    public MarkView(){
        JFrame mark = this;
        mark.setSize(400, 400);
        mark.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(MarkPanel);

        String[] columnNames = {"Przedmiot", "Ocena"};
        String[][] data = {{"Przedmiot1", "5"}, {"Przedmiot2", "3"}};

        markTable = new JTable(data,columnNames);
        ScrollMark = new JScrollPane(markTable);
        mark.add(ScrollMark);

        markTable.setDefaultEditor(Object.class, null);

        markTable.setVisible(true);
        mark.setVisible(true);
    }
}
