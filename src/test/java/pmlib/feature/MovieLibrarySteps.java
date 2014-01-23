package pmlib.feature;

import cucumber.api.PendingException;
import cucumber.api.java.sv.Givet;
import cucumber.api.java.sv.När;
import cucumber.api.java.sv.Så;
import pmlib.CommandParser;
import pmlib.Movie;
import pmlib.MovieLibrary;
import pmlib.MovieRepository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.junit.internal.matchers.StringContains.containsString;

public class MovieLibrarySteps {

    private CommandParser parser;
    private String result;
    private MovieLibrary library;

    @Givet("att filmbiblioteket är tomt")
    public void createEmptyLibrary() {
        library = new MovieLibrary();
        parser = new CommandParser(library);
    }

    @Givet("^att filmbiblioteket innehåller (\\d+) filmer$")
    public void createPopulatedLibrary(int numberOfMovies) {
        Movie[] movies = new Movie[numberOfMovies];
        for (int i = 0; i < numberOfMovies; i++) {
            movies[i] = new Movie();

        }
        library = new MovieLibrary(movies);
        parser = new CommandParser(library);
    }

    @Givet("^att jag har en filmsamling$")
    public void createdPopulatedLibraryWithTheBatmanTrilogy() throws Throwable {
        Movie[] movies = {new Movie("Batman Begins", 2005), new Movie("The Dark Knight", 2008), new Movie("The Dark Knight Rises", 2012)};
        library = new MovieLibrary(movies);
        parser = new CommandParser(library);
    }

    @Givet("^att filmbiblioteket innehåller \"([^\"]*)\" från (\\d+)$")
    public void createLibraryWith(String title, int year) throws Throwable {
        library = new MovieLibrary(new Movie[] {new Movie(title, year)});
        parser = new CommandParser(library);
    }

    @När("^jag räknar antalet filmer$")
    public void countMovies() throws Exception {
        result = parser.buildCommand(new String[] {"count"}).call();
        assertThat(result, not(startsWith("Unknown command:")));
    }

    @När("^jag lägger till filmen \"([^\"]*)\" från (\\d+)$")
    public void addMovie(String title, String year) throws Throwable {
        result = parser.buildCommand(new String[] {"add", title, year}).call();
        assertThat(result, not(startsWith("Unknown command:")));
    }

    @När("^jag listar innehåller i filmbilioteket$")
    public void listMovies() throws Throwable {
        result = parser.buildCommand(new String[] {"list"}).call();
        assertThat(result, not(startsWith("Unknown command:")));
    }

    @Så("^kommer resultatet vara: \"([^\"]*)\"$")
    public void compareResult(String listing) {
        assertThat(result, equalTo(listing));
    }

    @Så("^kommer den innehålla samtliga filmer$")
    public void resultIncludeMoviesInLibrary() throws Throwable {
        for (Movie movie : library.getMovies()) {
            assertThat(result, containsString(movie.getTitle()));
        }
    }
}
