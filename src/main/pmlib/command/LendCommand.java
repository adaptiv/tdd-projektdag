package pmlib.command;

import pmlib.Movie;
import pmlib.MovieLibrary;

public class LendCommand extends Command {
    public LendCommand(MovieLibrary library, String[] args) {
        super(library, args);
    }

    @Override
    public String call() {
        Movie movie = library.getMovieByTitle(args[1]);
        library.lend(movie);
        return null;
    }
}
