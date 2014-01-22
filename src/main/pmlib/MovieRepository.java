package pmlib;

import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@SuppressWarnings({"rawtypes", "unchecked"})
public class MovieRepository {
    private List<Movie> movies = new ArrayList<Movie>();

    public MovieRepository() {
    }

    public MovieRepository(Movie[] movies) {
        this.movies = new ArrayList<Movie>(Arrays.asList(movies));
    }

    @SuppressWarnings("serial")
    void save() throws IOException {
        new Yaml().dump(new HashMap() {{
            put("movies", movies);
        }}, new FileWriter("movies.yml"));
    }

    public void load() throws FileNotFoundException {
        movies = (List<Movie>) ((Map) new Yaml().load(new FileReader("movies.yml"))).get("movies");
    }

    public void add(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
