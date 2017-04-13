package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	public static void stworzTabele(Connection polaczenie, String tabela) {
	    // Obiekt odpowiadaj�cy za wykonanie instrukcji
	        Statement stat = null;
	        try {
	            stat = polaczenie.createStatement();
	            // polecenie SQL tworz�ce tablic�
	            String tabelaSQL = "CREATE TABLE " + tabela
	                    + " (ID INT PRIMARY KEY     NOT NULL,"
	                    + " DATA         TEXT    NOT NULL, "
	                    + " TOWAR        TEXT     NOT NULL, "
	                    + " ILOSCZAM             INT NOT NULL, "
	                    + " PO              INT, "
	                    + " ILOSCODEB    TEXT,"
	                    + " MPK INT,"
	                    + " ODBIORCA TEXT,"
	                    + " STATUS TEXT)";
	            // wywo�anie polecenia
	            stat.executeUpdate(tabelaSQL);
	            // zamykanie wywo�ania i po��czenia
	            stat.close();
	            polaczenie.close();
	        } catch (SQLException e) {
	            System.out.println("Nie mog� stworzy� tabeli" + e.getMessage());
	        }
	    }

    public static void szukaj(String baza, String pole, String wartosc) {
        Connection polaczenie = null;
        Statement stat = null;
        try {
            Class.forName("org.sqlite.JDBC");
            polaczenie = DriverManager.getConnection("jdbc:sqlite:" + baza + ".db");
            stat = polaczenie.createStatement();
            // Polecenie wyszukania
            String szukajSQL = "SELECT * FROM " + baza
                    + " WHERE " + pole + "='" + wartosc + "';";

            ResultSet wynik = stat.executeQuery(szukajSQL);
            System.out.println("Polecenie:\n" + szukajSQL);

            while (wynik.next()) {
                int id = wynik.getInt("id");
                System.out.println("ID:       " + id);
                System.out.println("Data:   " + wynik.getString("data"));
                System.out.println("Towar:  " + wynik.getString("towar"));
                System.out.println("Ilosc zam�wionych:"       + wynik.getString("ilosczam"));
                System.out.println("PO:        " + wynik.getString("po"));
                System.out.println("Ilosc odebranych:    " + wynik.getString("iloscodeb"));
                System.out.println("MPK:    " + wynik.getString("mpk"));
                System.out.println("Odbiorca:    " + wynik.getString("odbiorca"));
                System.out.println("Status:    " + wynik.getString("status"));
                System.out.println(" ---------------------- ");
            }
            wynik.close();
            stat.close();
            polaczenie.close();
        } catch (Exception e) {
            System.out.println("Nie mog� wyszuka� danych " + e.getMessage());
        }

    }
    public static void dodajDane(Order takson, String baza) {
        Connection polaczenie = null;
        Statement stat = null;
        try {
            Class.forName("org.sqlite.JDBC");
            polaczenie = DriverManager.getConnection("jdbc:sqlite:" + baza + ".db");

            stat = polaczenie.createStatement();
            String dodajSQL = "INSERT INTO " + baza + " (ID, DATA, TOWAR, ILOSCZAM, PO, ILOSCODEB,MPK,ODBIORCA,STATUS) "
                    + "VALUES ("
                    + takson.getId() + ","
                    + "'" + takson.getData() + "',"
                    + "'" + takson.getTowar() + "',"
                    + takson.getIlosczam() + ",'"
                    + takson.getpO() + "',"
                    + takson.getIloscodeb() + ","
                    + takson.getMpk()+",'"
                    +takson.getOdbiorca()+"','"
                    +takson.getStatus()
                    + "'  );";
            stat.executeUpdate(dodajSQL);
            stat.close();
            polaczenie.close();
            // Komunikat i wydrukowanie ko�cowej formy polecenia SQL
            System.out.println("Polecenie: \n" + dodajSQL + "\n wykonane.");
        } catch (Exception e) {
            System.out.println("Nie mog� doda� danych " + e.getMessage());
        }

    }
}
