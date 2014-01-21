package pmlib;

import pmlib.command.Command;

public class Main {

    public static void main(String[] args) throws Exception {
        MovieRepository repository = new MovieRepository();
        repository.load();

        Command command = new CommandParser(repository).buildCommand(args);
        System.out.println(command.call());
        repository.save();
    }

}
