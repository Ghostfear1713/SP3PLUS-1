import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchDB {
    private ArrayList<Movie> movielist = new ArrayList<>();
    private Scanner choice = new Scanner(System.in);
    private boolean found;


    public void searchMovies() {


        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sp3test", "root", "root123");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT* FROM movielist");


            while (resultSet.next()) {

                String MovieName = resultSet.getString("MovieName");
                String MovieYear = resultSet.getString("MovieYear");
                String MovieGenre = resultSet.getString("MovieGenre");
                String MovieRating = resultSet.getString("MovieRating");

                Movie movie = new Movie(MovieName, MovieYear, MovieGenre, MovieRating);
                movielist.add(movie);

            }

            System.out.println("Hvilken film leder du efter");
            String movieSearch = choice.nextLine();

            for (Movie s : movielist) {
                if (s.getName().toLowerCase().contains(movieSearch.toLowerCase())) {
                    System.out.println(s.toString());
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

    private ArrayList<Series> serieslist = new ArrayList<>();
    private Scanner choice1 = new Scanner(System.in);
    private boolean found1;
    public void searchSeries() {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/SP3test", "root", "root123");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT* FROM SeriesList");

            while (resultSet.next()) {

                String sName = resultSet.getString("sName");
                String sYear = resultSet.getString("sYear");
                String sGenre = resultSet.getString("sGenre");
                String sRating = resultSet.getString("sRating");
                String sSeasonAndEpisodes = resultSet.getString("sSeasonAndEpisodes");

                Series series = new Series(sName, sYear, sGenre, sRating, sSeasonAndEpisodes);
                serieslist.add(series);

            }

            System.out.println("Hvilken serie leder du efter");
            String seriesSearch = choice1.nextLine();

            for (Series s : serieslist) {
                if (s.getName().toLowerCase().contains(seriesSearch.toLowerCase())) {
                    System.out.println(s.toString());
                    found1 = true;
                    break;
                }
            }
            if (!found1) {
                System.out.println("Denne film findes ikke i vores bibliotek");

            }
        } catch (SQLException e) {
            System.out.println("Datafejl");
        }


    }


}