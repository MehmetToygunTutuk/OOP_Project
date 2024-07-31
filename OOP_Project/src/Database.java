import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private Connection con;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet rs;
    private String username = "root";
    private String password = "";
    private Test test;
    
   /* public ArrayList<Test.User> bringUsers(){
        ArrayList<Test.User> output = new ArrayList<Test.User>();
        String query = "Select * From users";
        try {
            statement = con.createStatement();
            rs = statement.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("ID");
                String username = rs.getString("USERNAME");
                String name = rs.getString("NAME");
                String surname = rs.getString("SURNAME");
                LocalDate birthDate = rs.getDate("BIRTH_DATE");
                String password = rs.getString("USER_PASSWORD");
                String email = rs.getString("EMAIL");
                String homeAddress = rs.getString("HOME_ADDRESS");
                String workAddress = rs.getString("WORK_ADDRESS");
                output.add(test.new User(username, name, surname, birthDate, password, email, homeAddress, workAddress));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }*/
    
    /*public ArrayList<Test.Product> bringProducts(){
        ArrayList<Test.Product> output = new ArrayList<Test.Product>();
        try {
            statement = con.createStatement();
            String query = "Select * From products";
            rs = statement.executeQuery(query);
            while(rs.next()){
                String productName = rs.getString("PRODUCT_NAME");
                String color = rs.getString("COLOR");
                String category = rs.getString("CATEGORY");
                int stock = rs.getInt("STOCK");
                double weight = rs.getDouble("WEIGHT");
                String description = rs.getString("DESCRIPTION");
                output.add(test.new Product(productName, color, category, stock, weight, description));
            }
            return output;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }*/
    
    public Database() {
        String url = "jdbc:mysql://localhost:3306/e-commerce";
        try {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("You have connected!");
        } catch (SQLException ex) {
            System.out.println("An error occured");
        }
        
    }
    
    public static void main(String[] args) {
        Database db = new Database();
    }
    
}
