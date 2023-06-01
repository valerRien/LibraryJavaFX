package fx.project.javafxtest.util;

public class DataKeeper {

    private static final DataKeeper instance = new DataKeeper();
    private String readerStringData;

    private String bookStringData;


    private int readerIntData;
    private int bookIntData;

    public int getBookIntData() {
        return bookIntData;
    }

    public void setBookIntData(int bookIntData) {
        this.bookIntData = bookIntData;
    }

    private DataKeeper() {
    }

    public static DataKeeper getInstance() {
        return instance;
    }

    public String getReaderStringData() {
        return readerStringData;
    }

    public void setReaderStringData(String readerStringData) {
        this.readerStringData = readerStringData;
    }

    public int getReaderIntData() {
        return readerIntData;
    }

    public void setReaderIntData(int readerIntData) {
        this.readerIntData = readerIntData;
    }

    public String getBookStringData() {
        return bookStringData;
    }

    public void setBookStringData(String bookStringData) {
        this.bookStringData = bookStringData;
    }
}
