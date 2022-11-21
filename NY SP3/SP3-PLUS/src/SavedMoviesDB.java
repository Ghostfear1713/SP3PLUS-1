import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SavedMoviesDB {
    private ArrayList<Movie> savedMovieList = new ArrayList<>();
    private boolean found;
    Scanner search = new Scanner(System.in);


    public void createSavedMoviesTable() {
        try {
            //Creating our connection to our Database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sp3test", "root", "root123");
            //Making a preparedStatement that we want to execute
            PreparedStatement createUserTable = connection.prepareStatement("CREATE TABLE IF NOT EXISTS SavedMovieList(iD int NOT NULL AUTO_INCREMENT, MovieName varchar(255), MovieYear varchar(255), MovieGenre varchar(255), MovieRating varchar(255), PRIMARY KEY (iD))");
            //Updating our Database, so that our new table (SavedMovieList) gets added
            createUserTable.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Your table has been created");
        }
    }

    public void addMovieToSavedMoviesList() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sp3test", "root", "root123");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT* FROM movielist");


            while (resultSet.next()) {
                //Selecting all the fields we want data from
                String MovieName = resultSet.getString("MovieName");
                String MovieYear = resultSet.getString("MovieYear");
                String MovieGenre = resultSet.getString("MovieGenre");
                String MovieRating = resultSet.getString("MovieRating");
                //creating a Movie object in order to add movie object into an Arraylist
                Movie movie = new Movie(MovieName, MovieYear, MovieGenre, MovieRating);
                System.out.println(movie.toString());
                savedMovieList.add(movie);
            }

            System.out.println("Hvilken film vil du gemme?");
            String savedMovie = search.nextLine();

            for (Movie s : savedMovieList) {
                //input from user, gets checked in our Arraylist - If the input is equal a name in the Arraylist, it will add this input
                //to our database through our PreparedStatement
                if (s.getName().toLowerCase().contains(savedMovie.toLowerCase())) {
                    //savedMovieList.add(savedMovie);
                    System.out.println(s.toString());

                    PreparedStatement addUsernameAndPasswordToDB = connection.prepareStatement("INSERT INTO savedmovielist (MovieName, MovieYear, MovieGenre, MovieRating) VALUES ('"+s.getName()+"', '"+s.getYear()+"', '"+s.getGenre()+"', '"+s.getRating()+"')");
                    addUsernameAndPasswordToDB.executeUpdate();
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Denne film findes ikke i vores bibliotek");

            }
        } catch (SQLException e) {
            System.out.println("Datafejl");
        }
    }

//VIRKER!
    public void getSavedMoviesFromDatabase() {

        try {
            //Creating our connection to our Database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sp3test", "root", "root123");
            //Making a preparedStatement that we want to execute
            Statement statement = connection.createStatement();
            //Getting the results we want to execute
            ResultSet resultSet = statement.executeQuery("select * from savedMovieList");
            //Finally we want to loop through the return results to display our data to the console. To do that, we use the next method to resultSet
            while (resultSet.next()) {
                String MovieName = resultSet.getString("MovieName");
                String MovieYear = resultSet.getString("MovieYear");
                String MovieGenre = resultSet.getString("MovieGenre");
                String MovieRating = resultSet.getString("MovieRating");

                Movie movies = new Movie(MovieName, MovieYear, MovieGenre, MovieRating);
                this.savedMovieList.add(movies);
            }
            for (Movie s : savedMovieList) {
                System.out.println(s.toString());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }



}
