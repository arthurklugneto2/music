import com.bulenkov.darcula.DarculaLaf;
import music.*;
import music.Component.KeyboardComponent;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLookAndFeel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainWindow {

    private JPanel rootPanel;
    private JComboBox chKeycb;
    private JComboBox chChordcb;
    private JLabel chordSymbolText;
    private JLabel chordNotes;
    private KeyboardComponent chordKeyboard;
    private JLabel chordInterval;
    private JLabel chordAlias;
    private JComboBox scaleCb;
    private JComboBox scKeycb;
    private KeyboardComponent scaleKeyboard;
    private JLabel scaleNotesTxt;

    private static Data data;
    private ChordService chordService;
    private ScaleService scaleService;

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
        scaleService = new ScaleService();

        populateChordKeysComboBox();
        populateChordChordsComboBox();
        populateScalesComboBox();
        populateScalesKeyComboBox();

        chKeycb.addActionListener(e -> {
            updateChordKeyboard();
            setChordSymbol();
        });
        chChordcb.addActionListener(e -> {
            updateChordKeyboard();
            setChordSymbol();
        });
        scaleCb.addActionListener(e -> {
            updateScaleKeyboard();
            setScaleNotes();
        });
        scKeycb.addActionListener(e -> {
            updateScaleKeyboard();
            setScaleNotes();
        });

        scaleKeyboard.setActivatedColor(Color.BLUE);
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

    private void populateScalesComboBox(){
        for( Scale scale : data.getScales() ){
            scaleCb.addItem(scale);
        }
    }

    private void populateScalesKeyComboBox(){
        for(Key key : data.getKeys()){
            scKeycb.addItem(key);
        }
    }

    // ====================================================
    // Event Handler
    // ====================================================
    private void updateChordKeyboard(){
        chordKeyboard.setKeys(
                chordService.generateChord(
                        (Key)chKeycb.getSelectedItem(),
                        (Chord) chChordcb.getSelectedItem(),
                        data));
    }

    private void setChordSymbol(){
        Key key = (Key)chKeycb.getSelectedItem();
        Chord chord = (Chord) chChordcb.getSelectedItem();
        chordSymbolText.setText(key.getCode() + chord.getCode());

        String intervals = "";
        int i = 0;
        for(String interval : chord.getNotes()){
            intervals += interval;
            if( i != chord.getNotes().length-1) intervals += " , ";
            i += 1;
        }
        chordInterval.setText(intervals);

        String notes = "";
        int j = 0;
        for(KeyboardComponent.Note note : chordKeyboard.getActiveKeys() ){
            notes += note.key;
            if( i != chordKeyboard.getActiveKeys().size() - 1 ) notes += " , ";
            j += 1;
        }
        chordNotes.setText(notes);
        chordAlias.setText(chord.getAlias().replaceAll("X",key.getCode()));
    }

    private void updateScaleKeyboard(){
        scaleKeyboard.setKeys(
            scaleService.generateScale(
                    (Key) scKeycb.getSelectedItem(),
                    (Scale) scaleCb.getSelectedItem(),
                    data
            )
        );
    }

    private void setScaleNotes(){
        Scale selected = (Scale)scaleCb.getSelectedItem();

        String intervals = "";
        int i = 0;
        for(String interval : selected.intervals){
            intervals += interval;
            if( i != selected.intervals.length-1) intervals += " , ";
            i += 1;
        }

        scaleNotesTxt.setText(intervals);
    }
}