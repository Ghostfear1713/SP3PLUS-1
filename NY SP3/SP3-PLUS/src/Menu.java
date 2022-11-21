import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {


    static String fileName = "C:\\Users\\unito\\IdeaProjects\\SP3-PLUS\\Data\\ListOfMovies.txt";
    static String seriesFileName = "C:\\Users\\unito\\IdeaProjects\\SP3-PLUS\\Data\\ListOfSeries.txt";


    static BufferedReader reader;

    static {
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static BufferedReader readSeries;

    static {
        try {
            readSeries = new BufferedReader(new FileReader(seriesFileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static FileIO fio = new FileIO();
    static List<Movie> movies;

    static {
        try {
            movies = fio.getMoviesFromFile(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static List<Series> series;

    static {
        try {
            series = fio.getSeriesFromFile(readSeries);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void login() throws IOException {
        System.out.println("1.Ny bruger: \n2.Eksisterende brugere");
        Scanner loginscan = new Scanner(System.in);


        switch (loginscan.nextLine()) {
            case "1":
                User.UserCreation();
                System.out.println("Log nu ind med din ny-oprettede bruger");
                User.userlogin();
                break;


            case "2":
                User.userlogin();
                break;
            default:
                System.out.println("ugyldigt valg");
                break;

        }

    }


    public static void runProgram() throws IOException {

        while (true) {
            File file1 = new File("C:\\Users\\unito\\IdeaProjects\\SP3-PLUS\\Data\\WatchedMovieList.txt");
            BufferedWriter writeToWatchedMovieFileList = new BufferedWriter(new FileWriter(file1, true));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));



            System.out.println("Hvad kunne du tænke dig?\n 1. Se en liste over alle film.\n 2. Se en liste over alle serier.\n 3. Se din liste over gemte film.\n 4.Søg" +
                    "\n 5. Gem en film. \n 6. Se din liste af sete film");
            Scanner choice = new Scanner(System.in);


            switch (choice.nextLine()) {
                case "1":

                    for (Movie m : movies) {
                        System.out.println(m.toString());
                    }

                    System.out.println("Kunne du tænke dig at se en af de film? Ja / Nej");
                    switch (choice.nextLine()){
                        case "Ja":
                            System.out.println("Hvilken film vil du gerne se?");
                            String chosenMovie = choice.nextLine();
                            boolean found1 = false;
                            for (Movie m : movies) {
                                //checks if the movie the user writes, is in our movieList
                                if(m.getName().equalsIgnoreCase(chosenMovie)){
                                    found1 = true;
                                }
                            }

                            System.out.println("Du har valgt at se: " + chosenMovie);
                            System.out.println("Filmen afspilles nu");

                                    writeToWatchedMovieFileList.write(chosenMovie + "\n");
                                    writeToWatchedMovieFileList.close();




                            if (!found1){
                                System.out.println("Filmen findes ikke");
                            }


                    }
                break;



                case "2":


                    for (Series s : series) {
                        System.out.println(s.toString());
                    }
                    break;

                case "3":
                            SavedMovie savedMovie1 = new SavedMovie();
                            savedMovie1.displaySavedMovies();

                    break;

                case "4":
                    System.out.println("søger du efter film, eller serie?");

                    switch (choice.nextLine()) {
                        case "film":
                            System.out.println("Hvilken film leder du efter?");
                            String movieSearch = choice.nextLine();

                            boolean found = false;

                            for (Movie m : movies) {
                                if (m.getName().toLowerCase().contains(movieSearch.toLowerCase())) {
                                    System.out.println(m.toString());
                                    found = true;
                                }

                            }
                            if (!found) {
                                System.out.println("Denne film findes ikke i vores bibliotek");
                                break;
                            }


                            break;

                        case "serie":
                            System.out.println("Hvilken serie leder du efter");
                            String seriesSearch = choice.nextLine();
                            found = false;

                            for (Series s : series) {
                                if (s.getName().toLowerCase().contains(seriesSearch.toLowerCase())) {
                                    System.out.println(s.toString());
                                    found = true;
                                }
                            }
                            if (!found) {
                                System.out.println("Denne film findes ikke i vores bibliotek");
                                break;
                            }
                    }
                case "5":
                    SavedMovie savedMovies = new SavedMovie();
                    savedMovies.MovieSavedList();
                    break;

                case "6":
                    DisplayWatchedMovies displayWatchedMovies = new DisplayWatchedMovies();
                    displayWatchedMovies.watchedMoviePreview();
            }
        }
    }
}

