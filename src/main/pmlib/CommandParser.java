package pmlib;

import pmlib.command.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"rawtypes","unchecked"})
public class CommandParser {
    private MovieLibrary library;
    private Map commandByName = new HashMap();

    public CommandParser(MovieLibrary library) {
        this.library = library;
        commandByName.put("count", CountCommand.class);
        commandByName.put("add", AddCommand.class);
        commandByName.put("list", ListCommand.class);
        commandByName.put("lend", LendCommand.class);
    }

    public Command buildCommand(String[] args) {
        Class commandClass = (Class) commandByName.get(args[0]);
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
