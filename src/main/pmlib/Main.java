package pmlib;

import pmlib.command.Command;

public class Main {

    public static void main(String[] args) throws Exception {
        MovieRepository repository = new MovieRepository();
        MovieLibrary library = repository.load();

        Command command = new CommandParser(library).buildCommand(args);
        System.out.println(command.call());
        repository.save(library);
    }

}
