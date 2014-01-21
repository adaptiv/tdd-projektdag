package pmlib.command;

import pmlib.MovieRepository;

public class CountCommand implements Command {
    private MovieRepository library;

    public CountCommand(MovieRepository library, String[] args) {
        this.library = library;
    }

    @Override
    public String call() {
        return String.valueOf(library.size());
    }
}
