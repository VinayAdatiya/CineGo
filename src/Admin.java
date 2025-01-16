import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Admin extends Users{

    private Theatre theatre = null;

    // Admin Constructor
    public Admin(String firstName, String lastName, String userName, String password, String customerID, String emailID, String city, int pinCode, Theatre theatre) {
        super(firstName, lastName, userName, password, customerID, emailID, city, pinCode);
        this.theatre = theatre;
    }


    // Add Movie
     public void addMovie(Movie movie){
       theatre.addMovie(movie);
    }

    // Add Screen
    public void addScreen(Screen screen) {
        theatre.addScreen(screen);
    }

    // Add Show
    public void addShow(Show show){
        theatre.addShow(show);
    }

    // Printing all movies title and id for admin
    public void getAllMovies(){
        List<Movie> movies = theatre.getMovieList();
        System.out.println("----------------");
        System.out.println("Movie ID | Title");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println("----------------");
            System.out.println("  "+movies.get(i).getMovieID()+"  | "+movies.get(i).getTitle());
        }
        System.out.println("----------------");
    }

    //removeMovie
    public void removeMovie(String movieID){
        for (int i = 0; i < theatre.getMovieList().size(); i++) {
            if(theatre.getMovieList().get(i).getMovieID() == movieID){
                System.out.println(movieID+" Removed Successfully");
                theatre.getMovieList().remove(i);
            }
        }
    }

}
