import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Movie {

    private String movieID;
    private String title;
    private List<String> genre;
    private LocalTime duration;
    private List<String> language;
    private LocalDate releaseDate;
    private float rating;
    private String description;
    private List<String> format;
    private List<MovieTeam> movieTeam;
    private List<Show> showList = new ArrayList<>();

    private Movie(Builder builder) {
        this.movieID = builder.movieID;
        this.title = builder.title;
        this.genre = builder.genre;
        this.duration = builder.duration;
        this.language = builder.language;
        this.releaseDate = builder.releaseDate;
        this.rating = builder.rating;
        this.description = builder.description;
        this.format = builder.format;
        this.movieTeam = builder.movieTeam;
    }

    public void addShow(Show show) {
        showList.add(show);
    }

    //Getter methods
    public String getMovieID() {
        return movieID;
    }

    public String getTitle() {
        return title;
    }

    public List<Show> getShowList() {
        return showList;
    }

    public static class Builder {
        private String movieID;
        private String title;
        private List<String> genre;
        private LocalTime duration;
        private List<String> language;
        private LocalDate releaseDate;
        private float rating;
        private String description;
        private List<String> format;
        private List<MovieTeam> movieTeam;

        public Builder setMovieID(String movieID) {
            this.movieID = movieID;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setGenre(List<String> genre) {
            this.genre = genre;
            return this;
        }

        public Builder setDuration(LocalTime duration) {
            this.duration = duration;
            return this;
        }

        public Builder setLanguage(List<String> language) {
            this.language = language;
            return this;
        }

        public Builder setReleaseDate(LocalDate releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public Builder setRating(float rating) {
            this.rating = rating;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setFormat(List<String> format) {
            this.format = format;
            return this;
        }

        public Builder setMovieTeam(List<MovieTeam> movieTeam) {
            this.movieTeam = movieTeam;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }
}
