package music;

public class Scale {
    public String code;
    public String[] intervals;

    public Scale(String code, String[] intervals) {
        this.code = code;
        this.intervals = intervals;
    }

    @Override
    public String toString() {
        return this.code;
    }
}
