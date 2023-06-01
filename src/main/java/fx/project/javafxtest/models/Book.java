package fx.project.javafxtest.models;

import java.util.Date;

public class Book {

    private int id;
    private int readerId;
    private String title;
    private String author;

    private int yearOfProduction;

    private int previousReader;
    private Date submissionDate;

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

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
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

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    @Override
    public String toString() {
        return title + ", " + author + ", " + yearOfProduction + " " + (submissionDate != null ? submissionDate : "");
    }

    public String getTitleAndAuthor() {
        return title + " (автор: " + author + ")";
    }
}
