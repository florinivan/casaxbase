package com.phimes.casaxbase.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbServiceImpl implements DbService{

    private static DbService INSTANCE;
    private Properties props;

    public DbServiceImpl() {
        props = new Properties();

        props.setProperty("user", "SYSDBA");
        props.setProperty("password", "masterkey");
        props.setProperty("encoding", "UTF8");
    }

    public static DbService getInstance(){
        if (INSTANCE == null){
            INSTANCE = new DbServiceImpl();
        }
        return INSTANCE;
    }
    @Override
    public Connection getConnection() {

        try {
            return DriverManager.getConnection(
                    "jdbc:firebirdsql://localhost:3050/C:/Program Files (x86)/S2S/Imperial_Pos_Retail/VF.FDB",
                    props);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
