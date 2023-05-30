package fx.project.javafxtest.models;

import javafx.beans.property.SimpleStringProperty;

import java.util.Date;
import java.text.SimpleDateFormat;

public class BookProxy {

    private SimpleStringProperty title;
    private SimpleStringProperty author;
    private SimpleStringProperty reader;
    private SimpleStringProperty submissionDate;

    public BookProxy(Book book) {
        title = new SimpleStringProperty(book.getTitle());
        author = new SimpleStringProperty(book.getAuthor());
        reader = book.getReader().getName() == null ? new SimpleStringProperty("В библиотеке") : new SimpleStringProperty(book.getReader().getName() + book.getReader().getSurname());
        Date date = book.getSubmission_date();
        String dateString = date == null ? "В библиотеке" : new SimpleDateFormat("yyyy-MM-dd").format(date);
        submissionDate = new SimpleStringProperty(dateString);
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
