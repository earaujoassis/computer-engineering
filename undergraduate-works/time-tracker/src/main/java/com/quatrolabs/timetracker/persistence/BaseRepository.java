package com.quatrolabs.timetracker.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseRepository {

    protected Connection connection;

    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:time-tracker.db");
            System.out.println("Database connection is available");
        } catch (ClassNotFoundException e) {
            System.out.println(String.format("Class not found: %s",  e.getMessage()));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
