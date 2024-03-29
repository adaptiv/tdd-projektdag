package pmlib.spec;

import org.junit.Test;
import pmlib.MovieLibrary;
import pmlib.command.ErrorCommand;

import static org.junit.Assert.assertEquals;

public class ErrorCommandSpec {
    @Test
    public void showErrorMessageWhenIssuingAnUnknownCommand() {
        ErrorCommand command = new ErrorCommand(new MovieLibrary(), new String[]{"unknown", "command"});
        assertEquals("Unknown command: 'unknown command'", command.call());
    }
}
