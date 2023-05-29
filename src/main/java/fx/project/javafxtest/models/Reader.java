package fx.project.javafxtest.models;

import java.util.List;

public class Reader {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String gender;
    private List<Book> books;

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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname() + " " + getPhoneNumber();
    }

    public String showNameSurnameEmail() {
        return getName() + " " + getSurname() + " " + getEmail();
    }
}
