import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Movie {

    static List<Show> showList = new ArrayList<>();

    private String title;
    private List<String> genre;
    private LocalTime duration;
    private List<String> language;
    private LocalDate releaseDate;
    private float rating;
    private String Description;
    private List<String> format;
    private List<MovieTeam> movieTeam;
    private String movieID;

    public Movie(String title, List<String> genre, LocalTime duration, List<String> language, LocalDate releaseDate, float rating, String description, List<String> format, List<MovieTeam> mt, String movieID) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.language = language;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.Description = description;
        this.format = format;
        this.movieTeam = mt;
        this.movieID = movieID;

        Theatre.movieList.add(this);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public List<String> getLanguage() {
        return language;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<String> getFormat() {
        return format;
    }

    public void setFormat(List<String> format) {
        this.format = format;
    }

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public List<MovieTeam> getMovieTeam() {
        return movieTeam;
    }

    public void setMovieTeam(List<MovieTeam> movieTeam) {
        this.movieTeam = movieTeam;
    }
}
