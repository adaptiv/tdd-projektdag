package pmlib.command;

public class ErrorCommand implements Command {
    private String[] args;

    public ErrorCommand(String[] args) {
        this.args = args;
    }

    @Override
    public String call() {
        return "Unknown command: '" + stringifyArgs() + "'";
    }

    private String stringifyArgs() {
        String result = "";
        for (String arg : args) {
            result += arg + " ";
        }
        if (result.endsWith(" ")) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }
}
