package com.phimes.casaxbase.database;

import java.sql.Connection;

public interface DbService {
    Connection getConnection();
}
