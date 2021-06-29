package music;

import music.Component.KeyboardComponent;

import java.util.ArrayList;
import java.util.List;

public class ScaleService {

    public List<KeyboardComponent.Note> generateScale(Key key, Scale scale, Data data){
        List<KeyboardComponent.Note> keys = new ArrayList<>();

        int currentOctave = 0;
        for( int i = 0 ; i < 36 ; i++ ){
            Key dataKey = data.getKeys().get(i % data.getKeys().size());
            if( i % 12 == 0) currentOctave += 1;
            keys.add(new KeyboardComponent.Note(currentOctave,dataKey.getCode(),false));
        }

        int count = getRootIndexInNotes(key,keys);
        keys.get(count).activated = true;

        int[] scaleIntegers = getScale(scale);

        for( int i : scaleIntegers ){
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

    private int[] getScale(Scale scale){
        if( scale.code.equals("Major") ){
            return getMajor();
        }
        if( scale.code.equals("Natural Minor") ){
            return getMinorMelodic();
        }
        if( scale.code.equals("Natural Harmonic") ){
            return getMinorHarmonic();
        }
        if( scale.code.equals("Natural Melodic") ){
            return getMinorMelodic();
        }
        return getMajor();
    }

    private int[] getMajor(){
        int[] scale = new int[7];
        scale[0] = 2;
        scale[1] = 2;
        scale[2] = 1;
        scale[3] = 2;
        scale[4] = 2;
        scale[5] = 2;
        scale[6] = 1;
        return scale;
    }

    private int[] getMinorNatural(){
        int[] scale = new int[7];
        scale[0] = 2;
        scale[1] = 1;
        scale[2] = 2;
        scale[3] = 2;
        scale[4] = 1;
        scale[5] = 2;
        scale[6] = 2;
        return scale;
    }

    private int[] getMinorHarmonic(){
        int[] scale = new int[7];
        scale[0] = 2;
        scale[1] = 1;
        scale[2] = 2;
        scale[3] = 2;
        scale[4] = 1;
        scale[5] = 2;
        scale[6] = 2;
        return scale;
    }

    private int[] getMinorMelodic(){
        int[] scale = new int[7];
        scale[0] = 2;
        scale[1] = 1;
        scale[2] = 2;
        scale[3] = 2;
        scale[4] = 1;
        scale[5] = 2;
        scale[6] = 2;
        return scale;
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
