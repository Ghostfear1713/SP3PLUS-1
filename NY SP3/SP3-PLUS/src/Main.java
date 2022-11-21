import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Menu menu = new Menu();
        SavedMoviesDB savedMovie = new SavedMoviesDB();
        SearchDB searchDB = new SearchDB();
        WatchedMoviesDB watchedMoviesDB = new WatchedMoviesDB();




        //MenuDB.login();
        //Menu.login();
        //Menu.runProgram();
        //savedMovie.createSavedMoviesTable();
        //savedMovie.getSavedMoviesFromDatabase();
        watchedMoviesDB.addMovieToWatchedMoviesList();
        //watchedMoviesDB.getWatchedMoviesFromDatabase();
    }
}




