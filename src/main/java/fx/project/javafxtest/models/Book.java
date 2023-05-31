package fx.project.javafxtest.models;

import java.util.Date;

public class Book {

    private int id;
    private int reader_id;
    private String title;
    private String author;

    private int yearOfProduction;

    private int previousReader;
    private Date submission_date;

    private Reader reader;

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book() {
    }

    public Book(String title, String author, int yearOfProduction) {
        this.title = title;
        this.author = author;
        this.yearOfProduction = yearOfProduction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReader_id() {
        return reader_id;
    }

    public void setReader_id(int reader_id) {
        this.reader_id = reader_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getPreviousReader() {
        return previousReader;
    }

    public void setPreviousReader(int previousReader) {
        this.previousReader = previousReader;
    }

    public Date getSubmission_date() {
        return submission_date;
    }

    public void setSubmission_date(Date submission_date) {
        this.submission_date = submission_date;
    }

    @Override
    public String toString() {
        return title + ", " + author + ", " + yearOfProduction + " " + (submission_date != null ? submission_date : "");
    }
}
