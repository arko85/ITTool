package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class JavaDB {
	public static Connection polacz(String baza) {
        Connection polaczenie = null;
        try {
            // Wskazanie jaki rodzaj bazy danych b�dzie wykorzystany, tu sqlite
            Class.forName("org.sqlite.JDBC");
            // Po��czenie, wskazujemy rodzaj bazy i jej nazw�
            polaczenie = DriverManager.getConnection("jdbc:sqlite:"+baza+".db");
            System.out.println("Po��czy�em si� z baz� "+baza);
        } catch (Exception e) {
            System.err.println("B��d w po��czeniu z baz�: \n" + e.getMessage());
            return null;
        }
        return polaczenie;
    }

}
