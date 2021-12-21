package by.fakeinstagram.dao;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class DateTimeConverter {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");



    public String localDateTimeToString(LocalDateTime localDateTimeForParsing) {
        LocalDateTime localDateTime = LocalDateTime.parse(localDateTimeForParsing.toString());
        return localDateTime.format(FORMATTER);
    }

    public LocalDateTime stringToLocalDateTime(String dateFromDb) throws SQLException {
        return LocalDateTime.parse(dateFromDb, FORMATTER);
    }
}