package com.quatrolabs.timetracker.persistence;

public interface Repository {

    void assertSchema();

    void rebuildSchema();

}
