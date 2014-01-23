package pmlib.command;

import pmlib.MovieLibrary;

public class ErrorCommand extends Command {

    public ErrorCommand(MovieLibrary library, String[] args) {
        super(library, args);
    }

    @Override
    public String call() {
        return String.format("Unknown command: '%s'", stringifyArgs());
    }

    private String stringifyArgs() {
        String result = "";
        for (String arg : args) {
            result += arg + " ";
        }

        return result.trim();
    }
}
