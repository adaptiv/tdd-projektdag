package pmlib;

import pmlib.command.Command;
import pmlib.command.CountCommand;
import pmlib.command.ErrorCommand;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"rawtypes","unchecked"})
public class CommandParser {
    private MovieLibrary library;
    private Map commandByName = new HashMap();

    public CommandParser(MovieLibrary library) {
        this.library = library;
        commandByName.put("count", CountCommand.class);
    }

    public Command buildCommand(String[] args) {
        String firstArg = (args.length > 0) ? args[0] : "";
        Class commandClass = (Class) commandByName.get(firstArg);
        if (commandClass != null) {
            try {
                return (Command) commandClass.getConstructor(MovieLibrary.class, String[].class).newInstance(library, args);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException(e);
            }
        }

        return new ErrorCommand(library, args);
    }
}
