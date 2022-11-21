import javax.imageio.IIOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DisplayWatchedMovies {

    public void watchedMoviePreview() throws IOException {
        File watchedMoviesFile = new File("C:\\Users\\unito\\IdeaProjects\\SP3-PLUS\\Data\\WatchedMovieList.txt");
        //FileInputStream - allows us to read bytes from a file - one byte at a time
        FileInputStream readFile1 = new FileInputStream(watchedMoviesFile);

        int oneByte1;
        //We can write to System.out 'onebyte' at a time using its write() method.
        //FileInputStream returns -1 when it reaches the end of the file.
        while ((oneByte1 = readFile1.read()) != -1) {
            System.out.print((char) oneByte1);
        }
        System.out.flush();

    }



}
