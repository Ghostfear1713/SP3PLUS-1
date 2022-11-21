import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class UserDB {
    private Connection connection;
    String url = "jdbc:mysql://localhost:3306/sp3test";
    String user = "root";
    String userPassword = "root123";

    public void creatTable() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sp3test", "root", "root123");
            //PreparedStatement - We're getting a SQL-statement, ready to be used, but not using it just yet - simply 'preparing' it
            //Reasons for PreparedStatement over Statement - PreparedStatements can have parameters and therefor more flexiable to use than an usual Statement
            //Create table if not exist - If our table (tablename) doesn't already exist, create one
            //iD (first field of the table) int NOT NULL AUTO_INCREMENT = Creating a field, iD (has to be an int and cannot be null, will create itself each time whenever a username and password is made)
            //username = second field, capable of having 255 characters (same logic with password)
            //PRIMARY KEY = our iD
            PreparedStatement createUserTable = connection.prepareStatement("CREATE TABLE IF NOT EXISTS UserList(iD int NOT NULL AUTO_INCREMENT, username varchar(255), password varchar(255), PRIMARY KEY (iD))");
            //Updating the table
            createUserTable.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Your table has been created");
        }
    }

    public void createUsersToDB() {
        Scanner scan = new Scanner(System.in);
        User user = new User("Orhani123", "Secilmis123");
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sp3test", "root", "root123");

            System.out.println("Indtast venligst dit ønskede brugernavn");
            String name = scan.nextLine();
            user.setUserName(name);

            System.out.println("Indtast venligst dit ønskede kodeord");
            String password = scan.nextLine();
            user.setPassword(password);
            //Adds our userinput name and password to our database - INSERT INTO = adds to our userlist table - VALUES = adding the values the user gave us when creating his username and password
            //Important that they are under a single ' ' since this illustrates that it's a String input
            PreparedStatement addUsernameAndPasswordToDB = connection.prepareStatement("INSERT INTO userlist (username, password) VALUES ('"+name+"', '"+password+"')");
            addUsernameAndPasswordToDB.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("New user has been created");
        }
    }

    public void userLogin(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sp3test", "root", "root123");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM userlist");

            ArrayList<User> loginListOfUsers = new ArrayList<>();

            while(resultSet.next()){
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                User user = new User(username, password);

                loginListOfUsers.add(user);

            }

            Scanner scan = new Scanner(System.in);

            System.out.println("Username:");
            String brugernavn = scan.nextLine();
            System.out.println("Password");
            String adgangskode = scan.nextLine();
            User user1 = new User(brugernavn, adgangskode);

            boolean found = false;
            for (User s: loginListOfUsers) {
                if(s.getUserName().equals(brugernavn) && s.getPassword().equals(adgangskode)){
                    System.out.println("Login Sucessfull");
                    found = true;
                }
            }
            if(found == false){
                System.out.println("Login wasnt succesful");
            }

        } catch (Exception e){
            e.printStackTrace();
        }




    }




}




