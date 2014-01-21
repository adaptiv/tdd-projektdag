package pmlib.spec;

import org.junit.Test;
import pmlib.CommandParser;
import pmlib.MovieRepository;
import pmlib.command.*;

import static org.junit.Assert.assertEquals;


public class CommandParserSpec {

    @Test
    public void parseUnknownCommand() throws ReflectiveOperationException {
        Command command = new CommandParser(new MovieRepository()).buildCommand(new String[] {"unknown", "arguments"});
        assertEquals(ErrorCommand.class, command.getClass());
    }

    @Test
    public void parseCountCommand() throws ReflectiveOperationException {
        Command command = new CommandParser(new MovieRepository()).buildCommand(new String[] {"count"});
        assertEquals(CountCommand.class, command.getClass());
    }
}
