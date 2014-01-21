package pmlib.feature;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.sv.Givet;
import cucumber.api.java.sv.När;
import cucumber.api.java.sv.Så;
import pmlib.CommandParser;
import pmlib.Movie;
import pmlib.MovieRepository;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

public class MovieLibrarySteps {

    private CommandParser parser;
    private String result;
    private MovieRepository library;
    private Movie movie;

    @Givet("att filmbiblioteket är tomt")
    public void createEmptyLibrary() {
        library = new MovieRepository();
        parser = new CommandParser(library);
    }

    @Givet("^att filmbiblioteket innehåller (\\d+) filmer$")
    public void createPopulatedLibrary(int numberOfMovies) {
        Movie[] movies = new Movie[numberOfMovies];
        for (int i = 0; i < numberOfMovies; i++) {
            movies[i] = new Movie();

        }
        library = new MovieRepository(movies);
        parser = new CommandParser(library);
    }

    @När("^jag räknar antalet filmer$")
    public void countMovies() throws Exception {
        result = parser.buildCommand(new String[] {"count"}).call();
        assertThat(result, not(startsWith("Unknown command:")));
    }

    @Så("^kommer resultatet vara: \"([^\"]*)\"$")
    public void compareResult(String listing) {
        assertThat(result, equalTo(listing));
    }
}
