package com.quatrolabs.timetracker.persistence;

import com.quatrolabs.timetracker.models.TimeEntry;
import com.quatrolabs.timetracker.models.TimeTracker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TimeEntryRepository extends BaseRepository implements Repository {

    @Override
    public void assertSchema() {
        try {
            Statement statement = connection.createStatement();
            statement.execute(
                "CREATE TABLE IF NOT EXISTS entries(" +
                        "created_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP," +
                        "id                  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "description         VARCHAR(100)," +
                        "start_datetime      VARCHAR(16)," +
                        "end_datetime        VARCHAR(16))"
            );
        } catch (SQLException e) {
            System.out.println(String.format("SQL Error: %s",  e.getMessage()));
        }
    }

    @Override
    public void rebuildSchema() {
        try {
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS entries");
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS entries(" +
                            "created_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP," +
                            "id                  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                            "description         VARCHAR(100)," +
                            "start_datetime      VARCHAR(16)," +
                            "end_datetime        VARCHAR(16))"
            );
        } catch (SQLException e) {
            System.out.println(String.format("SQL Error: %s",  e.getMessage()));
        }

    }

    public void addEntry(TimeEntry entry) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO entries (description, start_datetime, end_datetime) VALUES (?, ?, ?)"
            );
            statement.setString(1, entry.getDescription());
            statement.setString(2, entry.getStartDatetime());
            statement.setString(3, entry.getEndDatetime());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(String.format("SQL Error: %s",  e.getMessage()));
        }
    }

    public TimeTracker loadEntries() {
        TimeTracker entries = new TimeTracker();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM entries ORDER BY created_at");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                TimeEntry entry = new TimeEntry(
                        resultSet.getString("description"),
                        resultSet.getString("start_datetime"),
                        resultSet.getString("end_datetime")
                );

                entries.addEntry(entry);
            }
        } catch (SQLException e) {
            System.out.println(String.format("SQL Error: %s",  e.getMessage()));
        }

        return entries;
    }

}
