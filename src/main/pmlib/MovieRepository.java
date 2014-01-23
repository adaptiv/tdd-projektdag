package pmlib;

import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@SuppressWarnings({"rawtypes", "unchecked"})
public class MovieRepository {

    @SuppressWarnings("serial")
    public void save(final MovieLibrary library) throws IOException {
        new Yaml().dump(new HashMap() {{
            put("movies", library);
        }}, new FileWriter("movies.yml"));
    }

    public MovieLibrary load() throws FileNotFoundException {
        return (MovieLibrary) ((Map) new Yaml().load(new FileReader("movies.yml"))).get("movies");
    }
}
