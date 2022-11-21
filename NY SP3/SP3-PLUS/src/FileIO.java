import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {


    public List<Movie> getMoviesFromFile(BufferedReader reader) throws IOException {
        List<Movie> movies = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null) {
            String[] movieDetails = line.trim().split(";");
            Movie movie = new Movie();
            for (int i = 0; i < movieDetails.length; i++) {

                setMovieName(movieDetails, movie, i);
                setMovieYear(movieDetails, movie, i);
                setMovieGenre(movieDetails, movie, i);
                setMovieRating(movieDetails, movie, i);


            }

            movies.add(movie);
        }
        return movies;
    }


    private void setMovieName(String[] movieDetails, Movie movie, int i) {
        if (i < movieDetails.length & i == 0) {
            movie.setName(String.valueOf(movieDetails[i]));
        }
    }

    private void setMovieYear(String[] movieDetails, Movie movie, int i) {
        if (i < movieDetails.length && i == 1) {
            movie.setYear(String.valueOf(movieDetails[1]));
        }
    }

    private void setMovieGenre(String[] movieDetails, Movie movie, int i) {
        if (i < movieDetails.length & i == 2) {
            movie.setGenre(String.valueOf(movieDetails[2]));
        }
    }

    private void setMovieRating(String[] movieDetails, Movie movie, int i) {
        if (i < movieDetails.length && i == 3) {
            movie.setRating(String.valueOf(movieDetails[3]));
        }
    }


    public List<Series> getSeriesFromFile(BufferedReader seriesReader) throws IOException {

        List<Series> series = new ArrayList<Series>();

        String line;
        while ((line = seriesReader.readLine()) != null) {
            String[] seriesDetails = line.trim().split(";");

            Series serie = new Series();
            for (int i = 0; i < seriesDetails.length; i++) {


                setSeriesName(seriesDetails, serie, i);
                setSeriesYear(seriesDetails, serie, i);
                setSeriesGenre(seriesDetails, serie, i);
                setSeriesRating(seriesDetails, serie, i);
                setSeriesSeasonAndEpisode(seriesDetails, serie, i);


            }

            series.add(serie);
        }
        return series;
    }


    private void setSeriesName(String[] seriesDetails, Series serie, int i) {
        if (i < seriesDetails.length & i == 0) {
            serie.setName(String.valueOf(seriesDetails[i]));
        }
    }

    private void setSeriesYear(String[] seriesDetails, Series serie, int i) {
        if (i < seriesDetails.length && i == 1) {
            serie.setYear(String.valueOf(seriesDetails[1]));
        }
    }

    private void setSeriesGenre(String[] seriesDetails, Series serie, int i) {
        if (i < seriesDetails.length & i == 2) {
            serie.setGenre(String.valueOf(seriesDetails[2]));
        }
    }

    private void setSeriesRating(String[] seriesDetails, Series serie, int i) {
        if (i < seriesDetails.length && i == 3) {
            serie.setRating(String.valueOf(seriesDetails[3]));
        }
    }

    private void setSeriesSeasonAndEpisode(String[] seriesDetails, Series serie, int i) {
        if (i < seriesDetails.length && i == 4) {
            serie.setSeasonAndEpisode(String.valueOf(seriesDetails[4]));
        }
    }


}






















