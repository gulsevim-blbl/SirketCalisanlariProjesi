
import java.beans.Statement;
import  java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

public class CalisanIslemleri {
    
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    
    public boolean girisYap(String kullanici_adi, String parola){
       
        
        String sorgu = "Select * from adminler where username = ? and password = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, kullanici_adi);
            preparedStatement.setString(2, parola);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            return rs.next();
           
        } catch (SQLException ex) {
            Logger.getLogger(CalisanIslemleri.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
        
        
        
        
    }
    
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
    
   
    
    
}
