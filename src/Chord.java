public class Chord {

    private String code;
    private String[] notes;
    private String[] intervals;
    private String alias;
    private String[] info1;
    private String[] info2;

    public Chord(String code, String[] notes, String[] intervals, String alias, String[] info1, String[] info2) {
        this.code = code;
        this.notes = notes;
        this.intervals = intervals;
        this.alias = alias;
        this.info1 = info1;
        this.info2 = info2;
    }

    public String getCode() {
        return code;
    }

    public String[] getNotes() {
        return notes;
    }

    public String[] getIntervals() {
        return intervals;
    }

    public String getAlias() {
        return alias;
    }

    public String getAlias(Note note) {
        return alias.replaceAll("X",note.getCode());
    }

    public String[] getInfo1() {
        return info1;
    }

    public String[] getInfo2() {
        return info2;
    }

    @Override
    public String toString() {
        return alias;
    }
}
