package fx.project.javafxtest.models;

import java.util.List;

public class Reader {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String gender;
    private Book book;

    private List<Book> booksList;

    public Reader() {
    }

    public Reader(String name, String surname, String email, String phoneNumber, String gender) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Book> booksList) {
        this.booksList = booksList;
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname() + " " + (getPhoneNumber() != null? getPhoneNumber():"") +
                (getBook() != null? " " + getBook().getTitle() + " " + getBook().getSubmission_date():"");
    }

    public String showNameSurnameEmail() {
        return getName() + " " + getSurname() + " " + getEmail();
    }
}
