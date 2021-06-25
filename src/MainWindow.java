import javax.swing.*;
import javax.swing.event.ListDataEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {

    private JPanel rootPanel;
    private JComboBox chKeycb;
    private JComboBox chChordcb;

    private static Data data;

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch(Exception ignored){}

        data = new Data();

        JFrame frame = new JFrame("MainWindow");
        frame.setContentPane(new MainWindow().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public MainWindow(){
        populateChordKeysComboBox();
        populateChordChordsComboBox();
        //        chKeycb.addActionListener(e -> {
        //            System.out.println("dsdsad");
        //        });
    }

    private void populateChordKeysComboBox(){
        for(Note key: data.getKeys()){
            chKeycb.addItem(key);
        }
    }

    private void populateChordChordsComboBox(){
        for(Chord chord: data.getChords()){
            chChordcb.addItem(chord);
        }
    }

}
