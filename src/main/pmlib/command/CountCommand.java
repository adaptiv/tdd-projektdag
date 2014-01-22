package pmlib.command;

import pmlib.MovieRepository;

public class CountCommand implements Command {
    private MovieRepository repository;

    public CountCommand(MovieRepository repository, String[] args) {
        this.repository = repository;
    }

    @Override
    public String call() {
        return String.valueOf(repository.getMovies().size());
    }
}
