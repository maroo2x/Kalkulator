//import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
//import java.util.LinkedList;
//import java.util.List;
import java.util.Date;
//import java.text.DateFormat;
import java.text.SimpleDateFormat;
 
public class Baza {
 
    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:kalkulator.db";
    
    private Connection conn;
    private Statement stat;
    
    public Baza() {
        try {
            Class.forName(Baza.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }
 
        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }
        createTables();
    }

    public boolean createTables()  {		//create table if not exists
        String createPojazd = "CREATE TABLE IF NOT EXISTS pojazd (id INTEGER PRIMARY KEY AUTOINCREMENT, przebieg int, tankowanie float, spalanie float, full boolean, rezerwa boolean, stacja varchar(255), data date)";
        try {
            stat.execute(createPojazd);
        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    
    public boolean insert(int przebieg, float tankowanie) {
        try {
       	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        	Date date = new Date();
            ResultSet select = stat.executeQuery("SELECT * from POJAZD order by id desc limit 1");
            float spalanie = 0;
            if (select.isBeforeFirst() == true){	//if first loading, do not count
        	spalanie = (tankowanie/(przebieg-select.getFloat("przebieg"))*100);}
            PreparedStatement prepStmt = conn.prepareStatement(		//insert values
                    "insert into pojazd values (NULL, ?, ?, ?, NULL, NULL, NULL, ?);"); //id, przebieg, tankowanie, spalanie, full, rezerwa, stacja, data
            prepStmt.setInt(1, przebieg);
            prepStmt.setFloat(2, tankowanie);
            prepStmt.setFloat(3, spalanie);
            prepStmt.setString(4, dateFormat.format(date));// 
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu danych.");
            return false;
        }
        return true;
    }
    
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
        }
    }    
}
