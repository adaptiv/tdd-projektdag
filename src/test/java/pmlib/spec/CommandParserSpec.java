package pmlib.spec;

import org.junit.Test;
import pmlib.CommandParser;
import pmlib.MovieLibrary;
import pmlib.command.Command;
import pmlib.command.CountCommand;
import pmlib.command.ErrorCommand;

import static org.junit.Assert.assertEquals;


public class CommandParserSpec {

    @Test
    public void parseMissingCommand() throws ReflectiveOperationException {
        Command command = new CommandParser(new MovieLibrary()).buildCommand(new String[] {});
        assertEquals(ErrorCommand.class, command.getClass());
    }

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
}
