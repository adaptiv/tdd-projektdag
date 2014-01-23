package pmlib.command;

import pmlib.MovieLibrary;

public abstract class Command {
    final MovieLibrary library;
    final String[] args;

    public Command(MovieLibrary library, String[] args) {
        this.library = library;
        this.args = args;
    }

    public abstract String call();

    ;
}
