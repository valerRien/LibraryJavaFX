package fx.project.javafxtest.dao;

import fx.project.javafxtest.config.ConfigDB;
import fx.project.javafxtest.models.Reader;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookDAO {

    private Connection connection = new ConfigDB().getConnection();
    public BookDAO() throws Exception {
    }

    public List<Reader> getTimeOutReaders() {
        return new ArrayList<>(List.of(
                new Reader("Testname", "TestSurname", "TestEmail", "TestPhone", "TestGender"),
                new Reader("Testname", "TestSurname", "TestEmail", "TestPhone", "TestGender"),
                new Reader("Testname", "TestSurname", "TestEmail", "TestPhone", "TestGender")));
    }
}
