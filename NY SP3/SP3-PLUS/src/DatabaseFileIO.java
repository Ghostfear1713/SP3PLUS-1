import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class DatabaseFileIO {
    private ArrayList<Movie> movieListDatabase = new ArrayList<>();
    public ArrayList<Series> seriesArrayList = new ArrayList<>();

    public void getMoviesFromDatabase() {
        try {
            //Firstly we want to create a connection to our new database with our connection class. It will need our url, username and password to that database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sp3test", "root", "root123");
            //Now that our database connection is made, we want to be able to write our statements. In order to do so, we needed to make a connection object (done above) to create a statement object.
            //We make our statement object through the statement class and put it equal to the connection that we made
            Statement statement = connection.createStatement();
            // We also execute statement objects which then will return our result objects (resultSet). A resultSet is a table of data representing the results returned from the database. We want our query to
            //Select all from our user
            ResultSet resultSet = statement.executeQuery("select * from movielist");
            //Finally we want to loop through the return results to display our data to the console. To do that, we use the next method to resultSet
            while (resultSet.next()) {

                String MovieName = resultSet.getString("MovieName");
                String MovieYear = resultSet.getString("MovieYear");
                String MovieGenre = resultSet.getString("MovieGenre");
                String MovieRating = resultSet.getString("MovieRating");

                Movie movies = new Movie(MovieName, MovieYear, MovieGenre, MovieRating);
                this.movieListDatabase.add(movies);
            }

            for (Movie s : movieListDatabase) {
                System.out.println(s);
            }

        }
        //Next is a boolean and it returns true if there is still data to be shown. We make a sout to print it out. Inside the parameter of getString, is the colum variable we're interested in.
        // In our case, we want to get our username.
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void seriesListDB() {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sp3test", "root", "root123");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT* FROM SeriesList");

            while (resultSet.next()) {

                String sName = resultSet.getString("sName");
                String sYear = resultSet.getString("sYear");
                String sGenre = resultSet.getString("sGenre");
                String sRating = resultSet.getString("sRating");
                String sSeasonAndEpisodes = resultSet.getString("sSeasonAndEpisodes");

                Series series = new Series(sName, sYear, sGenre, sRating, sSeasonAndEpisodes);
                this.seriesArrayList.add(series);
            }
            for (Series s : seriesArrayList) {
                System.out.println(s);
            }
        } catch (Exception e) {
            System.out.println("Database not found");
        }


    }
}



