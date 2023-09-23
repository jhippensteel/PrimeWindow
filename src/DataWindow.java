import javax.swing.*;
import java.awt.*;

public class DataWindow extends JFrame {
    private int start, end, count = 0;
    private Object [] data;
    private JLabel startLabel = new JLabel("Start: ");
    private JTextField startValue = new JTextField(10);
    private JLabel endLabel = new JLabel("End: ");
    private JTextField endValue = new JTextField(10);
    private JTextArea dataDisplay;
    private JScrollPane scrollbars;
    private JLabel countLabel = new JLabel("Count: "); private JTextField countValue = new JTextField(5);
    private JButton startButton = new JButton("Start"); private JButton clearButton = new JButton("Clear");
    private JPanel statusPanel = new JPanel();
    private JPanel controlPanel = new JPanel();

    public DataWindow (String name){
        setTitle(name);
        setSize(300, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        dataDisplay = new JTextArea(30, 11);
        scrollbars = new JScrollPane(dataDisplay);

        statusPanel.add(startLabel);statusPanel.add(startValue);;
        statusPanel.add(endLabel);statusPanel.add(endValue);
        statusPanel.add(countLabel);statusPanel.add(countValue);countValue.setText("" + count);
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        dataDisplay.setEditable(false);

        controlPanel.add(startButton);startButton.addActionListener(e -> {startCalculation();});
        controlPanel.add(clearButton);clearButton.addActionListener(e -> {clear();});

        add(statusPanel, BorderLayout.NORTH);add(scrollbars, BorderLayout.CENTER);add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
        System.out.println(startValue.getText());
    }

    public void print(int value){
        dataDisplay.append(" "+value);
    }
    public void println(int value){
        dataDisplay.append(" " + value + "\n");
    }
    public void setStart(int value){
        start = value;
        startValue.setText("" + start);
    }
    public void setEnd(int value){
        end = value;
        endValue.setText("" + end);
    }
    public void add(int value){
        data[count++] = value;
        println(value);
        countValue.setText("" + count);
    }
    public int getStart(){
        return Integer.parseInt(startValue.getText());
    }
    public int getEnd(){
        return Integer.parseInt(endValue.getText());
    }

    public void startCalculation(){
        data = PrimeCalculator.findPrimes(getStart(), getEnd()).toArray();
        for (int i=0; i<data.length; i++){
            add((Integer) data[i]);
        }
    }
    public void clear(){
        startValue.setText("");
        endValue.setText("");
        countValue.setText("");
        dataDisplay.setText("");
        start = 0; count = 0;end = 0;
    }
}
