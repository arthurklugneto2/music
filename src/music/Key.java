package music;

public class Key {

    private String code;

    public Key(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return this.code;
    }
}
