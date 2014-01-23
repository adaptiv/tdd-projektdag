package pmlib.command;

import pmlib.DuplicateMovieException;
import pmlib.Movie;
import pmlib.MovieLibrary;
import pmlib.MovieRepository;

public class AddCommand extends Command {

    public AddCommand(MovieLibrary library, String[] args) {
        super(library, args);
    }

    @Override
    public String call() {
        Movie movie = new Movie(args[1], Integer.valueOf(args[2]));
        try {
            library.add(movie);
        } catch (DuplicateMovieException e) {
            return String.format("Already exists: %s", movie);
        }
        return null;
    }
}
