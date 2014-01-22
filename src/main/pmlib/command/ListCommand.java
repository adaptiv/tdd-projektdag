package pmlib.command;

import pmlib.Movie;
import pmlib.MovieRepository;

import java.util.Iterator;

public class ListCommand implements Command {
    private final MovieRepository repository;
    private final String[] args;

    public ListCommand(MovieRepository repository, String[] args) {
        this.repository = repository;
        this.args = args;
    }

    @Override
    public String call() {
        String result = "";
        for (Iterator<Movie> i = repository.getMovies().iterator(); i.hasNext(); ) {
            Movie movie = i.next();
            result += movie.getTitle() + " (" + movie.getYear() + ")";
            if (i.hasNext()) {
                result += "\n";
            }
        }
        return result;
    }
}
