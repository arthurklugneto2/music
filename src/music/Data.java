package music;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private List<Key> keys;
    private List<Chord> chords;
    private List<Scale> scales;

    public Data(){

        keys = new ArrayList<>();
        chords = new ArrayList<>();
        scales = new ArrayList<>();

        generateKeysData();
        generateChordsData();
        generateScales();
    }

    private void generateKeysData(){
        keys.add(new Key("C"));
        keys.add(new Key("C#"));
        keys.add(new Key("D"));
        keys.add(new Key("D#"));
        keys.add(new Key("E"));
        keys.add(new Key("F"));
        keys.add(new Key("F#"));
        keys.add(new Key("G"));
        keys.add(new Key("G#"));
        keys.add(new Key("A"));
        keys.add(new Key("A#"));
        keys.add(new Key("B"));
    }

    private void generateChordsData(){
        chords.add(new Chord("",new String[]{"1","3","5"},new String[]{"4","3"},
                "X,Xmaj,XM",new String[]{"3","5"}, new String[]{"5","4"}));

        chords.add(new Chord("m",new String[]{"1","3b","5"},new String[]{"3","4"},
                "Xminor,Xmin",new String[]{"4","5"}, new String[]{"5","3"}));

        chords.add(new Chord("7",new String[]{"1","3","5","7b"},new String[]{"4","3","3"},
                "X dominant 7, Xdom7",new String[]{"3","3","2"}, new String[]{}));

        chords.add(new Chord("m7",new String[]{"1","3b","5","7b"},new String[]{"3","4","3"},
                "Xminor7, Xmin7",new String[]{}, new String[]{}));

        chords.add(new Chord("maj7",new String[]{"1","3","5","7"},new String[]{"4","3","4"},
                "X Major 7, XMaj7,XM7",new String[]{}, new String[]{}));

        chords.add(new Chord("dim",new String[]{"1","3b","5b"},new String[]{"3","3"},
                "X diminished",new String[]{"3,6"}, new String[]{"6,3"}));

        chords.add(new Chord("dim7",new String[]{"1","3b","5b","6"},new String[]{"3","3","3"},
                "X diminished 7",new String[]{}, new String[]{}));

        chords.add(new Chord("7b5",new String[]{"1","3","5b","7b"},new String[]{"4","2","4"},
                "X dominant 7 flat fifth, X7-5",new String[]{}, new String[]{}));

        chords.add(new Chord("7#5",new String[]{"1","3","5#","7"},new String[]{"4","4","2"},
                "X dominant 7 sharp fifth, X7+5",new String[]{}, new String[]{}));

        chords.add(new Chord("m7b5",new String[]{"1","3b","5b","7b"},new String[]{"3","3","4"},
                "Xm(b7), Xminor7b5",new String[]{}, new String[]{}));

        chords.add(new Chord("7b9",new String[]{"1","3","5","7b","9b"},new String[]{"4","3","3","3"},
                "X7-9, X7(add b9)",new String[]{}, new String[]{}));

        chords.add(new Chord("6",new String[]{"1","3","5","6"},new String[]{"4","3","2"},
                "X Major 6, XM6, XMaj6",new String[]{"3","2","3"}, new String[]{"2","3","4"}));

        chords.add(new Chord("m6",new String[]{"1","3b","5","6"},new String[]{"3","4","2"},
                "X minor 6, Xmin6",new String[]{"4","2","3"}, new String[]{"2","3","3"}));

        chords.add(new Chord("m6",new String[]{"1","3b","5","6"},new String[]{"3","4","2"},
                "X minor 6, Xmin6",new String[]{"4","2","3"}, new String[]{"2","3","3"}));

        chords.add(new Chord("6add9",new String[]{"1","3","5","6","9"},new String[]{"4","3","2","5"},
                "X Major 6 add 9, X6/9, X6(add9)",new String[]{}, new String[]{}));

        chords.add(new Chord("9",new String[]{"1","3","5","7b","9"},new String[]{"4","3","3","4"},
                "X dominant 9, Xdom9, X7(add9)",new String[]{}, new String[]{}));

        chords.add(new Chord("m9",new String[]{"1","3b","5","7b","9"},new String[]{"3","4","3","4"},
                "X minor 9, Xmin9, Cm7(add9)",new String[]{}, new String[]{}));

        chords.add(new Chord("maj9",new String[]{"1","3","5","7","9"},new String[]{"4","3","4","3"},
                "X Major, XM9, XMaj7(add9)",new String[]{}, new String[]{}));

        chords.add(new Chord("add9",new String[]{"1","3","5","9"},new String[]{"4","3","7"},
                "X added 9th",new String[]{}, new String[]{}));

        chords.add(new Chord("11",new String[]{"1","3","5","7b","9","11"},new String[]{"4","3","3","4","3"},
                "X dominant 11, X7(add11)",new String[]{}, new String[]{}));

        chords.add(new Chord("m11",new String[]{"1","3b","5","7b","9","11"},new String[]{"3","4","3","4","3"},
                "X minor 11, Xmin11",new String[]{}, new String[]{}));

        chords.add(new Chord("13",new String[]{"1","3","5","7b","9b","11"},new String[]{"4","3","4","3","4"},
                "X dominant 13, X7(add13)",new String[]{}, new String[]{}));

        chords.add(new Chord("sus2",new String[]{"1","2","5"},new String[]{"2","5"},
                "X suspended 2",new String[]{"5","5"}, new String[]{"5","2"}));

        chords.add(new Chord("sus4",new String[]{"1","4","5"},new String[]{"5","2"},
                "X suspended 2",new String[]{"2","5"}, new String[]{"5","5"}));

        chords.add(new Chord("aug",new String[]{"1","3","5#"},new String[]{"4","4"},
                "X augmented, X+, X+5, X(#5)",new String[]{"4","4"}, new String[]{"4","4"}));

    }

    private void generateScales(){
        scales.add(new Scale("Major",new String[]{"1","2","3","4","5","6","7"}));
        scales.add(new Scale("Natural Minor",new String[]{"1","2","3b","4","5","6","7"}));
        scales.add(new Scale("Natural Harmonic",new String[]{"1","2","3b","4","5","6b","7"}));
        scales.add(new Scale("Natural Melodic",new String[]{"1","2","3b","4","5","6b","7b"}));
    }

    public List<Key> getKeys() {
        return keys;
    }

    public List<Chord> getChords() {
        return chords;
    }

    public List<Scale> getScales() {
        return scales;
    }
}
