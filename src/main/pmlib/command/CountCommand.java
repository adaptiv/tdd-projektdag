package pmlib.command;

import pmlib.MovieLibrary;

public class CountCommand extends Command {

    public CountCommand(MovieLibrary library, String[] args) {
        super(library, args);
    }

    @Override
    public String call() {
        return String.valueOf(library.getMovies().size());
    }
}
