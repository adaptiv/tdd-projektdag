package pmlib.spec;

import org.junit.Test;
import pmlib.CommandParser;
import pmlib.MovieLibrary;
import pmlib.MovieRepository;
import pmlib.command.*;

import static org.junit.Assert.assertEquals;


public class CommandParserSpec {

    @Test
    public void parseUnknownCommand() throws ReflectiveOperationException {
        Command command = new CommandParser(new MovieLibrary()).buildCommand(new String[] {"unknown", "arguments"});
        assertEquals(ErrorCommand.class, command.getClass());
    }

    @Test
    public void parseCountCommand() throws ReflectiveOperationException {
        Command command = new CommandParser(new MovieLibrary()).buildCommand(new String[] {"count"});
        assertEquals(CountCommand.class, command.getClass());
    }

    @Test
    public void parseAddCommand() throws ReflectiveOperationException {
        Command command = new CommandParser(new MovieRepository()).buildCommand(new String[] {"add", "Alien", "1979"});
        assertEquals(AddCommand.class, command.getClass());
    }

    @Test
    public void parseListCommand() throws ReflectiveOperationException {
        Command command = new CommandParser(new MovieRepository()).buildCommand(new String[] {"list"});
        assertEquals(ListCommand.class, command.getClass());
    }
}
