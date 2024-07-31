//The OOP project of Mehmet Toygun TUTUK(230316003) and Muhammed Mustafa KÖLEOĞLU(230316020)
//Modules that we need in this project
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//Our main class that we are gonna test our project
public class Test {
    //User class
    class User{
        private String username;
        private String name;
        private String surname;
        private LocalDate birthDate;
        private String password;
        private String email;
        private String homeAdress;
        private String workAdress;
        private ArrayList<Product> orderedProducts = new ArrayList<Product>();
        private ArrayList<Product> favoriteProducts = new ArrayList<Product>();
        private ArrayList<CreditCard> creditCards = new ArrayList<CreditCard>();
        //Constructor of User
        public User(String username, String name, String surname, LocalDate birthDate, String password, String email, String homeAdress, String workAdress) {
            this.username = username;
            this.name = name;
            this.surname = surname;
            this.birthDate = birthDate;
            this.password = password;
            this.email = email;
            this.homeAdress = homeAdress;
            this.workAdress = workAdress;
        }
        //Adds an product to favorite products list
        public void addAnFavoriteProduct(Product product){
            favoriteProducts.add(product);
            System.out.println(name + " has added " + product.getProductName() + " to favorites");
        }
        //Shows favorite products list
        public void showFavoriteProducts(){
            if(favoriteProducts.isEmpty()){
                System.out.println(name + " doesn't have an favorite product list...");
            }
            else{
                System.out.println("Favorite products of " + name);
                for(Product product : favoriteProducts){
                    System.out.println("- " + product.getProductName());
                }
            }
        }
        //When a user orders a product this function works
        public void makeAnOrder(User user, CreditCard creditCard, Product product, int orderCount){
            System.out.println("-------------------------------------");
            if(product.getStock() == 0){
                System.out.println("Sorry, the product has sold out");
                System.out.println("-------------------------------------");
                
            }
            else if(product.getStock() < orderCount){
                System.out.println("Sorry, we dont have enough product");
                System.out.println("-------------------------------------");
            }
            else{
                System.out.println(user.name + " has ordered " + orderCount + " " + product.getProductName());
                product.reduceStock(orderCount);
                orderedProducts.add(product);
                System.out.println(product.getProductName() + " has added to ordered products");
            }
        }
        
        //Shows products those ordered by user
        public void showOrders(){
            if(orderedProducts.isEmpty()){
                System.out.println(name + " hasn't ordered yet...");
            }
            else{
                System.out.println(name + " has ordered these products");
                for(Product product : orderedProducts){
                    System.out.println("- " + product.getProductName());
                }
            }
        }
        //Hides the password
        public String hidePassword(String password){
            String prefix = password.substring(0, 1);
            String suffix = password.substring(password.length() - 1);
            String hidden = prefix;
            
            for(int i = 0; i < password.length() - 1; i++){
                hidden += "*";
            }
            hidden += suffix;
            return hidden;
        }
        
        //Adds a credit card to user's system
        public void addCreditCard(CreditCard card){
            creditCards.add(card);
        }
        //Gettes and setters of User class
        public String getUsername(){
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public LocalDate getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getHomeAdress() {
            return homeAdress;
        }

        public void setHomeAdress(String homeAdress) {
            this.homeAdress = homeAdress;
        }

        public ArrayList<Product> getOrderedProducts() {
            return orderedProducts;
        }

        public void setOrderedProducts(ArrayList<Product> orderedProducts) {
            this.orderedProducts = orderedProducts;
        }

        public ArrayList<Product> getFavoriteProducts() {
            return favoriteProducts;
        }

        public void setFavoriteProducts(ArrayList<Product> favoriteProducts) {
            this.favoriteProducts = favoriteProducts;
        }

        public ArrayList<CreditCard> getCreditCards() {
            return creditCards;
        }

        public void setCreditCards(ArrayList<CreditCard> creditCards) {
            this.creditCards = creditCards;
        }
        //Shows the general information about user
        public void userInfo(){
            System.out.println("User's username: " + username);
            System.out.println("User's name: " + name);
            System.out.println("User's surname: " + surname);
            System.out.println("User's birth date: " + birthDate);
            System.out.println("User's password: " + hidePassword(password));
            System.out.println("User's email: " + email);
            System.out.println("User's home address: " + homeAdress);
            System.out.println("User's work address: " + workAdress);
            System.out.println("Number of user's credit cards: " + creditCards.size());
            System.out.println("**********************************************");
        }
        
    }
    //Credit card class
    class CreditCard{
        private String cardNumber;
        private String cardUser;
        private int securityCode;
        private LocalDate expirationDate;
        //Constructor of CreditCard
        public CreditCard(String cardNumber, String cardUser, int securityCode, LocalDate expirationDate) {
            this.cardNumber = cardNumber;
            this.cardUser = cardUser;
            this.securityCode = securityCode;
            this.expirationDate = expirationDate;
        }
        //Getters and setters of CreditCard class
        public String getCardNumber() {
            return cardNumber;
        }

        public void setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        public String getCardUser() {
            return cardUser;
        }

        public void setCardUser(String cardUser) {
            this.cardUser = cardUser;
        }

        public int getSecurityCode() {
            return securityCode;
        }

        public void setSecurityCode(int securityCode) {
            this.securityCode = securityCode;
        }

        public LocalDate getExpirationDate() {
            return expirationDate;
        }

        public void setExpirationDate(LocalDate expirationDate) {
            this.expirationDate = expirationDate;
        }
        //Shows card informations
        @Override
        public String toString(){
            return "Credit card informations..."
                    + "\nCard number => " + cardNumber
                    + "\nCard user => "   + cardUser 
                    + "\nSecurity code => " + securityCode
                    + "\nExpiration date => " + expirationDate;
        }
        
    }
    //Product class
    class Product{
        private String productName;
        private String color;
        private String category;
        private int stock;
        private double weight;
        private String description;
        //Constructor of Product class
        public Product(String productName, String color, String category, int stock, double weight, String description) {
            this.productName = productName;
            this.color = color;
            this.category = category;
            this.stock = stock;
            this.weight = weight;
            this.description = description;
        }
        //Updates the product stock in every order
        public void reduceStock(int amount){
            if(stock > amount){
                stock -= amount;
                System.out.printf("New stock: %d\n",stock);
            }
            else{
                if(stock == 0){
                    System.out.println("The product sold out!");
                }
                else{
                    System.out.println("Not enough stock available");
                }
            }
        }
        //Getters and setters of Product class
        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
        //Shows general informations about product
        public void productInfo(){
            System.out.println("Product's name => " + productName);
            System.out.println("Product's color => " + color);
            System.out.println("Product's category => " + category);
            System.out.println("Product's stock => " + stock);
            System.out.println("Product's weight => " + weight);
            System.out.println("Product's description => " + description);
            System.out.println("************************************");
        }
        
    }
    //Order class
    class Order{
        private User user;
        private Product product;
        private CreditCard creditcard;
        //Constructor of Order class
        public Order(User user, Product product, CreditCard creditcard, int orderCount) {
            this.user = user;
            this.product = product;
            this.creditcard = creditcard;
            user.makeAnOrder(user, creditcard, product, orderCount);
        }
        //Getter and setters of Order class
        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public CreditCard getCreditcard() {
            return creditcard;
        }

        public void setCreditcard(CreditCard creditcard) {
            this.creditcard = creditcard;
        }
        
    }
    //Database class
    class Database{
        private Connection con;
        private Statement statement;
        private ResultSet rs;
        private String username = "root";
        private String password = "";
        //Constructor of Database class that provide connection to our database
        public Database(){
            String url = "jdbc:mysql://localhost:3306/e-commerce";
            try {
                con = DriverManager.getConnection(url, username, password);
                System.out.println("You have connected!");
            } catch (SQLException ex) {
                System.out.println("An error occured");
            }
        }
        //Brings the informations of products table
        public void bringProductDatabase(){
            String query = "Select * From products";
            ArrayList<Product> output = new ArrayList<Product>();
            try {
                statement = con.createStatement();
                rs = statement.executeQuery(query);
                while(rs.next()){
                    String productName = rs.getString("PRODUCT_NAME");
                    String color = rs.getString("COLOR");
                    String category = rs.getString("CATEGORY");
                    int stock = rs.getInt("STOCK");
                    double weight = rs.getDouble("WEIGHT");
                    String description = rs.getString("DESCRIPTION");
                    System.out.println("Product name: " + productName + "\nColor: " + color + "\nCategory: " + category
                    + "\nStock: " + stock + "\nWeight: " + weight + "\nDescrition: " + description + "\n*********");
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Brings the informations of users table
        public void bringUserDatabase(){
            String query = "Select * From users";
            try {
                statement = con.createStatement();
                rs = statement.executeQuery(query);
                while(rs.next()){
                    String username = rs.getString("USERNAME");
                    String name = rs.getString("NAME");
                    String surname = rs.getString("SURNAME");
                    Date birthDate = rs.getDate("BIRTH_DATE");
                    String password = rs.getString("USER_PASSWORD");
                    String email = rs.getString("EMAIL");
                    String homeAddress = rs.getString("HOME_ADDRESS");
                    String workAddress = rs.getString("WORK_ADDRESS");
                    System.out.println("Username: " + username + "\nName: " + name + "\nSurname: " + surname + "\nBirth Date: "
                    + birthDate + "\nPassword: " + password + "\nEmail: " + email + "\nHome Address: " + homeAddress + 
                    "\nWork Address: " + workAddress + "\n**************");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    // The main class that we are gonna test our project
    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        Database database = test.new Database();
        User user1 = test.new User("Toygun34", "Mehmet Toygun", "Tutuk", LocalDate.of(2003, 9, 9), "MTT564", "toygunttk@gmail.com", "Huzur Str/Balikesir/No: 13", "Sakin Str/Ankara/No: 34");
        User user2 = test.new User("Dark Knight", "Muhammed Mustafa", "Koleoglu", LocalDate.of(2004, 11, 23), "123456", "koleoglu04@gmail.com", "Cicek Str/Kahramanmaras/No: 2", "Faruk Str/Kocaeli/No: 85");
        Product product1 = test.new Product("Cup", "Black", "Ceramic", 15, 0.5, "A cup that you can enjoy your drinks");
        Product product2 = test.new Product("Watch", "White", "Electronic Devices", 5, 0.1, "Watch out");
        CreditCard card1 = test.new CreditCard("7484 1375 9004 1264", user1.getUsername(), 803, LocalDate.of(2028, 1, 31));
        CreditCard card2 = test.new CreditCard("5487 1025 9932 1467", user2.getUsername(), 749, LocalDate.of(2030, 5, 19));
        CreditCard card3 = test.new CreditCard("2896 1033 6541 7788", user2.getUsername(), 625, LocalDate.of(2027, 10, 4));
        
        String menu = "************Welcome to our application***************" +//The entry menu
                      "\nPlease press 1 for user transactions" +
                      "\nPlease press 2 for product transactions" +
                      "\nPlease press 3 for credit card transactions" +
                      "\nPress q for the exit";
        System.out.println(menu);
        while(true){
            System.out.println("Choose your option from menu => ");
            Scanner scan = new Scanner(System.in);
            String menuChoice = scan.nextLine();
            if(menuChoice.equals("q")){
                System.out.println("Exiting...");
                Thread.sleep(3000);
                System.exit(0);
            }
            else if(menuChoice.equals("1")){
                String transactions = "You are at the user transactions check your options...\n" +
                               "Press 1 for register or add a new user\n" +
                               "Press 2 for add a credit card\n" +
                               "Press 3 for add a favorite product to your favorite products list\n" +
                               "Press 4 for see user's favorite lists\n" +
                               "Press 5 for order a product\n" +
                               "Press 6 for see user's ordered products\n" + 
                               "Press 7 for show the users informations\n" +
                               "Press 8 for show the user database\n" +
                               "Press q for exit the user transactions";
                System.out.println(transactions);
                while(true){
                    System.out.println("Enter your transaction: ");
                    String userOption = scan.nextLine();
                    if(userOption.equals("q")){
                        System.out.println("Exiting from user transactions...");
                        Thread.sleep(3000);
                        break;
                    }
                    else if(userOption.equals("1")){
                        ArrayList<User> userList = new ArrayList<User>();
                        userList.add(user1);
                        userList.add(user2);
                        System.out.println("Users has been saved");
                    }
                    else if(userOption.equals("2")){
                        user1.addCreditCard(card1);
                        user2.addCreditCard(card2);
                        user2.addCreditCard(card3);
                        System.out.println("Credit cards have been added");
                    }
                    else if(userOption.equals("3")){
                        user1.addAnFavoriteProduct(product1);
                        user2.addAnFavoriteProduct(product2);
                    }
                    else if(userOption.equals("4")){
                        user1.showFavoriteProducts();
                        user2.showFavoriteProducts();
                    }
                    else if(userOption.equals("5")){
                        Order order1 = test.new Order(user1, product1, card1, 7);
                        Order order2 = test.new Order(user2, product2, card3, 2);
                    }
                    else if(userOption.equals("6")){
                        user1.showOrders();
                        user2.showOrders();
                    }
                    else if(userOption.equals("7")){
                        user1.userInfo();
                        user2.userInfo();
                    }
                    else if(userOption.equals("8")){
                        database.bringUserDatabase();
                    }
                    else{
                        System.out.println("Invalid transaction. Please choose from options");
                    }
                }
            }
            else if(menuChoice.equals("2")){
                String transactions = "You are at the product transactions check your options...\n" +
                                      "Press 1 for see product informations\n" +
                                      "Press 2 for change the color\n" +
                                      "Press 3 for show the products database\n" +
                                      "Press q for exit";
                System.out.println(transactions);
                while(true){
                    System.out.println("Enter your transaction");
                    String productOption = scan.nextLine();
                    if(productOption.equals("q")){
                        System.out.println("Exiting from product transactions...");
                        Thread.sleep(3000);
                        break;
                    }
                    else if(productOption.equals("1")){
                        product1.productInfo();
                        product2.productInfo();
                    }
                    else if(productOption.equals("2")){
                        System.out.println("Current color => " + product1.getColor());
                        System.out.println("Which color would you like to change with: ");
                        String newColor = scan.nextLine();
                        product1.setColor(newColor);
                        System.out.println("New color => " + product1.getColor());
                    }
                    else if(productOption.equals("3")){
                        database.bringProductDatabase();
                    }
                    else{
                        System.out.println("Invalid transaction. Please choose from options");
                    }
                }
            }
            else if(menuChoice.equals("3")){
                String transactions = "You are at the credit card transactions check your options...\n" +
                                      "1 - Show card informations\n" +
                                      "Press q for exit";
                System.out.println(transactions);
                while(true){
                    System.out.println("Enter your transaction: ");
                    String cardOptions = scan.nextLine();
                    if(cardOptions.equals("q")){
                        System.out.println("Exiting credit card transactions...");
                        Thread.sleep(3000);
                        break;
                    }
                    else if(cardOptions.equals("1")){
                        System.out.println(card1);
                        System.out.println(card2);
                        System.out.println(card3);
                    }
                    else{
                        System.out.println("Invalid transaction. Please choose from options");
                    }
                }
            }
            else{
                System.out.println("Invalid option. Please choose an option from menu");
            }
        }
        
    }
}
