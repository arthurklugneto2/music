import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Data {

    private List<Note> keys;
    private List<Chord> chords;

    public Data(){

        keys = new ArrayList<>();
        chords = new ArrayList<>();

        generateKeysData();
        generateChordsData();

    }

    private void generateKeysData(){
        keys.add(new Note("C"));
        keys.add(new Note("C#"));
        keys.add(new Note("D"));
        keys.add(new Note("D#"));
        keys.add(new Note("E"));
        keys.add(new Note("F"));
        keys.add(new Note("F#"));
        keys.add(new Note("G"));
        keys.add(new Note("G#"));
        keys.add(new Note("A"));
        keys.add(new Note("A#"));
        keys.add(new Note("B"));
    }

    private void generateChordsData(){
        //chords.add(new Chord("",new String[]{"","",""},new String[]{"",""},"",new String[]{"",""}, new String[]{"",""}));

        chords.add(new Chord("Major",new String[]{"1","3","5"},new String[]{"4","3"},
                "X,Xmaj,XM",new String[]{"3","5"}, new String[]{"5","4"}));

        chords.add(new Chord("m",new String[]{"1","3b","5"},new String[]{"3","4"},
                "Xminor,Xmin",new String[]{"4","5"}, new String[]{"5","3"}));

        chords.add(new Chord("7",new String[]{"1","3","5","7b"},new String[]{"4","3","3"},
                "X dominant 7, Xdom7",new String[]{"3","3","2"}, new String[]{}));

        chords.add(new Chord("m7",new String[]{"1","3b","5","7b"},new String[]{"3","4","3"},
                "Xminor7, Xmin7",new String[]{}, new String[]{}));

        chords.add(new Chord("maj7",new String[]{"1","3","5","7"},new String[]{"4","3","4"},
                "X Major 7, XMaj7,XM7",new String[]{}, new String[]{}));

        //Chords[5] = ["dim", "1,3b,5b", "3,3", "X diminished", "3,6", "6,3"];
        //Chords[6] = ["dim7", "1,3b,5b,6", "3,3,3", "X diminished 7"];
        //Chords[7] = ["7b5", "1,3,5b,7b", "4,2,4", "X dominant 7 flat fifth, X7-5"];
        //Chords[8] = ["7#5", "1,3,5#,7", "4,4,2", "X dominant 7 sharp fifth, X7+5"];
        //Chords[9] = ["m7b5", "1,3b,5b,7b", "3,3,4", "Xm(b7), Xminor7b5"];
        //Chords[10] = ["7b9", "1,3,5,7b,9b", "4,3,3,3", "X7-9, X7(add b9)"];
        //Chords[11] = ["6", "1,3,5,6", "4,3,2", "X Major 6, XM6, XMaj6", "3,2,3", "2,3,4"];
        //Chords[12] = ["m6", "1,3b,5,6", "3,4,2", "X minor 6, Xmin6", "4,2,3", "2,3,3"];
        //Chords[13] = ["6add9", "1,3,5,6,9", "4,3,2,5", "X Major 6 add 9, X6/9, X6(add9)"];
        //Chords[14] = ["9", "1,3,5,7b,9", "4,3,3,4", "X dominant 9, Xdom9, X7(add9)"];
        //Chords[15] = ["m9", "1,3b,5,7b,9", "3,4,3,4", "X minor 9, Xmin9, Cm7(add9)"];
        //Chords[16] = ["maj9", "1,3,5,7,9", "4,3,4,3", "X Major, XM9, XMaj7(add9)"];
        //Chords[17] = ["add9", "1,3,5,9", "4,3,7", "C added 9th"];
        //Chords[18] = ["11", "1,3,5,7b,9,11", "4,3,3,4,3", "X dominant 11, X7(add11)"];
        //Chords[19] = ["m11", "1,3b,5,7b,9,11", "3,4,3,4,3", "X minor 11, Xmin11"];
        //Chords[20] = ["13", "1,3,5,7b,9b,11", "4,3,3,4,3,4", "X dominant 13, X7(add13)"];
        //Chords[21] = ["sus2", "1,2,5", "2,5", "X suspended 2", "5,5", "5,2"];
        //Chords[22] = ["sus4", "1,4,5", "5,2", "X suspended 4", "2,5", "5,5"];
        //Chords[23] = ["aug", "1,3,5#", "4,4", "X augmented, X+, X+5, X(#5)", "4,4", "4,4"];
    }

    public List<Note> getKeys() {
        return keys;
    }

    public List<Chord> getChords() {
        return chords;
    }
}
