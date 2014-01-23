package pmlib.command;

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
        library.add(movie);
        return null;
    }
}
