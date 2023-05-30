package fx.project.javafxtest.models;

import javafx.beans.property.SimpleStringProperty;

import java.text.SimpleDateFormat;

public class BookProxy {

    private SimpleStringProperty title;
    private SimpleStringProperty author;
    private SimpleStringProperty reader;
    private SimpleStringProperty submissionDate;

    public BookProxy(Book book) {
        title = new SimpleStringProperty(book.getTitle());
        author = new SimpleStringProperty(book.getAuthor());
        reader = new SimpleStringProperty(book.getReader().getName() + " " + book.getReader().getSurname());
        String date = new SimpleDateFormat("yyyy-MM-dd").format(book.getSubmission_date());
        submissionDate = new SimpleStringProperty(date);
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getAuthor() {
        return author.get();
    }

    public SimpleStringProperty authorProperty() {
        return author;
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public String getReader() {
        return reader.get();
    }

    public SimpleStringProperty readerProperty() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader.set(reader);
    }

    public String getSubmissionDate() {
        return submissionDate.get();
    }

    public SimpleStringProperty submissionDateProperty() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate.set(submissionDate);
    }
}
