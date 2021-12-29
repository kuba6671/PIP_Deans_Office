import javax.swing.*;

public class ExamView extends JFrame {
    private JPanel ExamPanel;
    private JTable examTable;
    private JScrollPane ScrollExam;

    public ExamView(){
        JFrame exam = this;
        exam.setSize(400, 400);
        exam.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(ExamPanel);

        String[] columnNames = {"Przedmiot", "Data"};
        String[][] data = {{"Przedmiot1", "10.10.2021"}, {"Przedmiot2", "20.01.2022"}};


        examTable = new JTable(data,columnNames);
        ScrollExam = new JScrollPane(examTable);
        exam.add(ScrollExam);

        //examTable.setDefaultEditor(Object.class, null);

        examTable.setVisible(true);
        exam.setVisible(true);
    }
}
