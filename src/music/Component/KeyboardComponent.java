package music.Component;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import javax.swing.*;


public class KeyboardComponent extends JComponent{

    private static int OCTAVES = 1;
    private static Dimension KEY_SIZE = new Dimension(50,200);
    private static Dimension BLACK_KEY_SIZE = new Dimension(0,0);
    private static Dimension KEYBOARD_SIZE = new Dimension(0,0);

    public static class Note{
        public int octave;
        public String key;
        public boolean activated;
        public int x;
        public int y;

        public Note(int octave, String key, boolean activated) {
            this.octave = octave;
            this.key = key;
            this.activated = activated;
        }
    }
    private List<Note> whiteKeys;
    private List<Note> blackKeys;

    public KeyboardComponent(){
        whiteKeys = new ArrayList<>();
        blackKeys = new ArrayList<>();
    }

    public void setKeys(List<Note> keys){
        whiteKeys = new ArrayList<>();
        blackKeys = new ArrayList<>();

        if( keys != null ){
            for(Note note : keys){
                if(note.key.contains("#") || note.key.contains("b")){
                    Dimension pos = generatePositionForBlackKey(note,whiteKeys);
                    note.x = pos.width;
                    note.y = pos.height;
                    blackKeys.add(note);
                }else{
                    note.x = whiteKeys.size() * KEY_SIZE.width;
                    note.y = 0;
                    whiteKeys.add(note);
                }
            }
            KEYBOARD_SIZE = new Dimension(whiteKeys.size() * KEY_SIZE.width,KEY_SIZE.height);
            BLACK_KEY_SIZE = new Dimension(KEY_SIZE.width/2,(int)(KEY_SIZE.height *.65));
        }

    }

    @Override
    public void paintComponent(Graphics graphics){
        Graphics2D g = (Graphics2D)graphics;
        Rectangle clipRect = graphics.getClipBounds();

        g.setColor(Color.WHITE);
        g.fill(clipRect);

        // Draw White Keys
        if( !whiteKeys.isEmpty() ){
            for( int i = 0 ; i < whiteKeys.size() ; i++ ){
                drawWhiteKey(whiteKeys.get(i),whiteKeys.get(i).x,whiteKeys.get(i).y,g);
            }
        }

        // Draw Black Keys
        if( !blackKeys.isEmpty() ){
            for( int i = 0 ; i < blackKeys.size() ; i++ ){
                drawBlackKey(blackKeys.get(i),blackKeys.get(i).x,blackKeys.get(i).y,g);
            }
        }
    }

    @Override
    public Dimension getPreferredSize(){
        return KEYBOARD_SIZE;
    }

    private void drawWhiteKey(Note note, int x, int y, Graphics2D context){
        context.setColor( note.activated ? Color.YELLOW : Color.WHITE );
        context.fillRoundRect(x,y,KEY_SIZE.width,KEY_SIZE.height,KEY_SIZE.width/10,KEY_SIZE.width/10);

        context.setStroke(new BasicStroke(3));
        context.setColor(Color.BLACK);
        context.drawRoundRect(x,y,KEY_SIZE.width,KEY_SIZE.height,KEY_SIZE.width/10,KEY_SIZE.width/10);

        context.setStroke(new BasicStroke(1));
    }

    private void drawBlackKey(Note note, int x, int y, Graphics2D context){
        context.setColor( note.activated ? Color.YELLOW : Color.BLACK );
        context.fillRoundRect(x,y,BLACK_KEY_SIZE.width,BLACK_KEY_SIZE.height,KEY_SIZE.width/10,KEY_SIZE.width/10);

        context.setStroke(new BasicStroke(3));
        context.setColor(Color.BLACK);
        context.drawRoundRect(x,y,BLACK_KEY_SIZE.width,BLACK_KEY_SIZE.height,KEY_SIZE.width/10,KEY_SIZE.width/10);

        context.setStroke(new BasicStroke(1));
    }

    private Dimension generatePositionForBlackKey(Note key, List<Note> whiteKeys){
        Note parent = whiteKeys
                .stream()
                .filter(
                        p -> p.key.equals(key.key.replaceAll("#","").replaceAll("b","")) &&
                                p.octave == key.octave
                )
                .findFirst()
                .orElse(null);
        if( parent != null ){
            return new Dimension(
                    (parent.x + KEY_SIZE.width/2)+KEY_SIZE.width/4,
                    parent.y);
        }
        return null;
    }

}
