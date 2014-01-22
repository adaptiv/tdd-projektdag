package pmlib;

public class Movie {

    private String title;
    private Integer year;

    public Movie() {
    }

    public Movie(String title, Integer year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }
}
