package music;

public class Interval {

    private String code;
    private int[] intervals;
    private String[] signatures;

    public Interval(String code, int[] intervals, String[] signatures) {
        this.code = code;
        this.intervals = intervals;
        this.signatures = signatures;
    }

    public String getCode() {
        return code;
    }

    public int[] getIntervals() {
        return intervals;
    }

    public String[] getSignatures() {
        return signatures;
    }

}
