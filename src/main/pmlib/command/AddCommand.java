package pmlib.command;

import pmlib.Movie;
import pmlib.MovieRepository;

public class AddCommand implements Command {
    private final MovieRepository repository;
    private final String[] args;

    public AddCommand(MovieRepository repository, String[] args) {
        this.repository = repository;
        this.args = args;
    }

    @Override
    public String call() {
        Movie movie = new Movie(args[1], Integer.valueOf(args[2]));
        repository.add(movie);
        return null;
    }
}
