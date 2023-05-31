package fx.project.javafxtest.util;

public class DataKeeper {

    private static final DataKeeper instance = new DataKeeper();
    private String stringData;
    private int intData;

    private DataKeeper() {
    }

    public static DataKeeper getInstance() {
        return instance;
    }

    public String getStringData() {
        return stringData;
    }

    public void setStringData(String stringData) {
        this.stringData = stringData;
    }

    public int getIntData() {
        return intData;
    }

    public void setIntData(int intData) {
        this.intData = intData;
    }
}
