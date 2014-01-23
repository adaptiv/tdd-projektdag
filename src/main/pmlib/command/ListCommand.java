package pmlib.command;

import pmlib.Movie;
import pmlib.MovieLibrary;
import pmlib.MovieRepository;

import java.util.Iterator;

public class ListCommand extends Command {

    public ListCommand(MovieLibrary library, String[] args) {
        super(library, args);
    }

    @Override
    public String call() {
        String result = "";
        for (Iterator<Movie> i = library.getMovies().iterator(); i.hasNext(); ) {
            Movie movie = i.next();
            result += movie.getTitle() + " (" + movie.getYear() + ")";
            if (i.hasNext()) {
                result += "\n";
            }
        }
        return result;
    }
}
