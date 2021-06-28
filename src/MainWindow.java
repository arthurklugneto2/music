import com.bulenkov.darcula.DarculaLaf;
import music.Chord;
import music.ChordService;
import music.Component.KeyboardComponent;
import music.Data;
import music.Key;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLookAndFeel;
import java.util.ArrayList;
import java.util.List;

public class MainWindow {

    private JPanel rootPanel;
    private JComboBox chKeycb;
    private JComboBox chChordcb;
    private KeyboardComponent chordKeyboard;

    private static Data data;
    private ChordService chordService;

    public static void main(String[] args) {

        try {
            BasicLookAndFeel darcula = new DarculaLaf();
            UIManager.setLookAndFeel(darcula);
        } catch(Exception ignored){}

        data = new Data();

        JFrame frame = new JFrame("MainWindow");
        frame.setContentPane(new MainWindow().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public MainWindow(){
        chordService = new ChordService();

        populateChordKeysComboBox();
        populateChordChordsComboBox();

        chKeycb.addActionListener(e -> {
            updateChordKeyboard();
        });
        chChordcb.addActionListener(e -> {
            updateChordKeyboard();
        });

    }

    // ====================================================
    // UI
    // ====================================================
    private void populateChordKeysComboBox(){
        for(Key key: data.getKeys()){
            chKeycb.addItem(key);
        }
    }

    private void populateChordChordsComboBox(){
        for(Chord chord: data.getChords()){
            chChordcb.addItem(chord);
        }
    }

    // ====================================================
    // Event Handler
    // ====================================================
    private void updateChordKeyboard(){
        chordKeyboard.setKeys(
                chordService.generateChord(
                        (Key)chKeycb.getSelectedItem(),
                        (Chord) chChordcb.getSelectedItem()
                        ));
    }

}

//        List<KeyboardComponent.Note> keys = new ArrayList<>();
//        keys.add( new KeyboardComponent.Note(1,"C",false) );
//        keys.add( new KeyboardComponent.Note(1,"C#",false) );
//        keys.add( new KeyboardComponent.Note(1,"D",true) );
//        keys.add( new KeyboardComponent.Note(1,"D#",false) );
//        keys.add( new KeyboardComponent.Note(1,"E",false) );
//        keys.add( new KeyboardComponent.Note(1,"F",false) );
//        keys.add( new KeyboardComponent.Note(1,"F#",true) );
//        keys.add( new KeyboardComponent.Note(1,"G",false) );
//        keys.add( new KeyboardComponent.Note(1,"G#",false) );
//        keys.add( new KeyboardComponent.Note(1,"A",true) );
//        keys.add( new KeyboardComponent.Note(1,"A#",false) );
//        keys.add( new KeyboardComponent.Note(1,"B",false) );
//        keys.add( new KeyboardComponent.Note(2,"C",false) );
//        keys.add( new KeyboardComponent.Note(2,"C#",false) );
//        keys.add( new KeyboardComponent.Note(2,"D",false) );
//        keys.add( new KeyboardComponent.Note(2,"D#",false) );
//        keys.add( new KeyboardComponent.Note(2,"E",false) );
//
//        chordKeyboard.setKeys(null);