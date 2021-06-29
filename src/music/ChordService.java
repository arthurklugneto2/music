package music;

import music.Component.KeyboardComponent;

import java.util.*;

public class ChordService {

    public List<KeyboardComponent.Note> generateChord(Key key, Chord chord, Data data){
        List<KeyboardComponent.Note> keys = new ArrayList<>();

        int currentOctave = 0;
        for( int i = 0 ; i < 36 ; i++ ){
            Key dataKey = data.getKeys().get(i % data.getKeys().size());
            if( i % 12 == 0) currentOctave += 1;
            keys.add(new KeyboardComponent.Note(currentOctave,dataKey.getCode(),false));
        }

        List<Key> notesForChord = getNotesForChord(key,chord,data);
        int count = getRootIndexInNotes(key,keys);
        List<Integer> intervals = new ArrayList<>();
        for( String s : chord.getIntervals() ) intervals.add(Integer.parseInt(s));

        keys.get(count).activated = true;
        for( int i : intervals ){
            count += i;
            keys.get(count).activated = true;
        }

        List<KeyboardComponent.Note> adjustedKeys = new ArrayList<>();
        int octaves = (((count)/12)+1)*12;
        System.out.println(count + "  :  " + octaves);
        for( int i = 0 ; i < octaves ; i++ ){
            adjustedKeys.add(keys.get(i));
        }
        return adjustedKeys;
    }

    public List<Key> getNotesForChord(Key key, Chord chord, Data data){

        List<Key> notes = new ArrayList<>();

        int notesCount = data.getKeys().size();
        int rootIndex = getRootIndexInData(key,data);
        List<Integer> intervals = new ArrayList<>();
        for( String s : chord.getIntervals() ) intervals.add(Integer.parseInt(s));


        notes.add( data.getKeys().get(rootIndex%notesCount) );

        for( int interval : intervals ){
            rootIndex += interval;
            notes.add( data.getKeys().get(rootIndex%notesCount) );
        }

        return notes;

    }

    private int getRootIndexInData(Key key, Data data){
        int index = 0;
        for( Key keyData : data.getKeys() ){
            if( keyData.getCode().equals( key.getCode() ) ) return index;
            index += 1;
        }
        return index;
    }

    private int getRootIndexInNotes(Key key, List<KeyboardComponent.Note> notes){
        int index = 0;
        for( KeyboardComponent.Note note : notes ){
            if( note.equals(key) ) return index;
            index += 1;
        }
        return index;
    }

}