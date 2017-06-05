package model;
//http://stackoverflow.com/questions/18497699/populate-a-tableview-using-database-in-javafx
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class JavaDB {
	public static Connection polacz(String baza) {
        Connection polaczenie = null;
        try {
            // Wskazanie jaki rodzaj bazy danych bêdzie wykorzystany, tu sqlite
            Class.forName("org.sqlite.JDBC");
            // Po³¹czenie, wskazujemy rodzaj bazy i jej nazwê
            polaczenie = DriverManager.getConnection("jdbc:sqlite:"+baza+".db");
            System.out.println("Po³¹czy³em siê z baz¹ "+baza);
        } catch (Exception e) {
            System.err.println("B³¹d w po³¹czeniu z baz¹: \n" + e.getMessage());
            return null;
        }
        return polaczenie;
    }
	public static void stworzTabele(Connection polaczenie, String tabela) {
	    // Obiekt odpowiadaj¹cy za wykonanie instrukcji
	        Statement stat = null;
	        try {
	            stat = polaczenie.createStatement();
	            // polecenie SQL tworz¹ce tablicê
	            String tabelaSQL = "CREATE TABLE " + tabela
	                    + " (ID INT PRIMARY KEY     NOT NULL,"
	                    + " DATA         TEXT    NOT NULL, "
	                    + " TOWAR        TEXT     NOT NULL, "
	                    + " ILOSCZAM             INT NOT NULL, "
	                    + " PO              TEXT, "
	                    + " ILOSCODEB    INT NOT NULL,"
	                    + " MPK TEXT,"
	                    + " ODBIORCA TEXT,"
	                    + " STATUS TEXT)";
	            // wywo³anie polecenia
	            stat.executeUpdate(tabelaSQL);
	            // zamykanie wywo³ania i po³¹czenia
	            stat.close();
	            polaczenie.close();
	        } catch (SQLException e) {
	            System.out.println("Nie mogê stworzyæ tabeli" + e.getMessage());
	        }
	    }

    public static ObservableList<Order> szukaj(String baza, String pole, Boolean wartosc) {
        Connection polaczenie = null;
        Statement stat = null;
        ObservableList<Order> data = null;
        data=FXCollections.observableArrayList();
        try {
            Class.forName("org.sqlite.JDBC");
            polaczenie = DriverManager.getConnection("jdbc:sqlite:" + baza + ".db");
            stat = polaczenie.createStatement();
            // Polecenie wyszukania
            String szukajSQL = "SELECT * FROM " + baza;
            		if(!wartosc){
            			szukajSQL=szukajSQL+ " WHERE " + "STATUS !='"  +"COMPLETED"+ "'";}
            szukajSQL=szukajSQL+";";
            ResultSet wynik = stat.executeQuery(szukajSQL);
            System.out.println("Polecenie:\n" + szukajSQL);

            while (wynik.next()) {

            	Order row =new Order();
                String id = wynik.getString("id");
                row.setId(wynik.getString("id"));
                System.out.println("ID:       " + id);
                row.setData(wynik.getString("data"));
                System.out.println("Data:   " + wynik.getString("data"));
                row.setTowar(wynik.getString("towar"));
                System.out.println("Towar:  " + wynik.getString("towar"));
                row.setIlosczam(wynik.getInt("ilosczam"));
                System.out.println("Ilosc zamówionych:"       + wynik.getString("ilosczam"));
                row.setpO(wynik.getString("po"));
                System.out.println("PO:        " + wynik.getString("po"));
                row.setIloscodeb(wynik.getInt("iloscodeb"));
                System.out.println("Ilosc odebranych:    " + wynik.getString("iloscodeb"));
                row.setMpk(wynik.getString("mpk"));
                System.out.println("MPK:    " + wynik.getString("mpk"));
                row.setOdbiorca(wynik.getString("odbiorca"));
                System.out.println("Odbiorca:    " + wynik.getString("odbiorca"));
                row.setStatus(Status.valueOf(wynik.getString("status")));
                System.out.println("Status:    " + wynik.getString("status"));
                System.out.println(" ---------------------- ");
                data.add(row);
            }
            wynik.close();
            stat.close();
            polaczenie.close();
        } catch (Exception e) {
            System.out.println("Nie mogê wyszukaæ danych " + e.getMessage());
        }
		return data;

    }
    public static void dodajDane(Order dane, String baza) {
        Connection polaczenie = null;
        Statement stat = null;
        try {
            Class.forName("org.sqlite.JDBC");
            polaczenie = DriverManager.getConnection("jdbc:sqlite:" + baza + ".db");

            stat = polaczenie.createStatement();
            String dodajSQL = "INSERT INTO " + baza + " (ID, DATA, TOWAR, ILOSCZAM, PO, ILOSCODEB,MPK,ODBIORCA,STATUS ) "
            		+ "VALUES ('"
                    + dane.getId() + "',"
                    + "'" + dane.getData() + "',"
                    + "'" + dane.getTowar() + "',"
                    + dane.getIlosczam() + ",'"
                    + dane.getpO() + "',"
                    + dane.getIloscodeb() + ",'"
                    + dane.getMpk()+"','"
                    +dane.getUwagi()+"','"
                    +dane.getStatus()
                    + "'  );";


            System.out.println(dodajSQL);
            stat.executeUpdate(dodajSQL);
            stat.close();
            polaczenie.close();
            // Komunikat i wydrukowanie koñcowej formy polecenia SQL
            System.out.println("Polecenie: \n" + dodajSQL + "\n wykonane.");
        } catch (Exception e) {
            System.out.println("Nie mogê dodaæ danych " + e.getMessage());
        }

    }
    public static void updateDane(Order dane, String baza) {
        Connection polaczenie = null;
        Statement stat = null;
        try {
            Class.forName("org.sqlite.JDBC");
            polaczenie = DriverManager.getConnection("jdbc:sqlite:" + baza + ".db");

            stat = polaczenie.createStatement();
            String dodajSQL = "UPDATE " + baza + " SET "
            		+ "DATA='" + dane.getData() + "',"
                    + "TOWAR='" + dane.getTowar() + "',"
                    + "ILOSCZAM="+dane.getIlosczam() + ","
                    + "PO='" +dane.getpO() + "',"
                    + "ILOSCODEB="+dane.getIloscodeb() + ","
                    + "MPK='"+dane.getMpk()+"',"
                    +"ODBIORCA='"+dane.getUwagi()+"',"
                    +"STATUS='"+dane.getStatus()
                    + "' WHERE ID='"+ dane.id+"';";
            //System.out.println(dodajSQL);
            stat.executeUpdate(dodajSQL);
            stat.close();
            polaczenie.close();
            // Komunikat i wydrukowanie koñcowej formy polecenia SQL
            System.out.println("Polecenie: \n" + dodajSQL + "\n wykonane.");
        } catch (Exception e) {
            System.out.println("Nie mogê dodaæ danych " + e.getMessage());
        }

    }

}
