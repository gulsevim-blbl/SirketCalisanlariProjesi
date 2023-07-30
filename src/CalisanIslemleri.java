
import java.beans.Statement;
import  java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CalisanIslemleri {
    
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public CalisanIslemleri(){
        
        
         // "jbdc:mysql://localhost:3306/demo" 
        String url = "jdbc:mysql://" +Database.host + ":" + Database.port + "/" + Database.db_ismi+ "?useUnicode=true&characterEncoding=utf8";
        
         
        try {
            con = DriverManager.getConnection(url, Database.kullanici_adi, Database.parola);
            System.out.println("Baglanti Basarili...");
            
            
        } catch (SQLException ex) {
            System.out.println("Baglanti Basarisiz...");
            //ex.printStackTrace();
        }

    }
    
    public static void main(String[] args) {
            CalisanIslemleri islemler = new CalisanIslemleri();
            
    }
    
    
}
