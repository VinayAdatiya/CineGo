package Theatre;

import Exceptions.CustomerAlreadyRegistred;
import Exceptions.MovieAlreadyExists;
import Exceptions.ScreenAlreadyExists;
import Exceptions.ShowAlreadyExists;
import Users.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Theatre {

    private List<Movie> movieList = new ArrayList<>();
    private List<Show> showList = new ArrayList<>();
    private List<Screen> screenList = new ArrayList<>();
    private List<Customer> customerList = new ArrayList<>();

    private String theatreID;
    private String theatreName;
    private String theatreRating;
    private String location;
    private String area;
    private String city;
    private String state;
    private int pinCode;

    public Theatre(String theatreID, String theatreName, String theatreRating, String location, String area, String city, String state, int pinCode) {
        this.theatreID = theatreID;
        this.theatreName = theatreName;
        this.theatreRating = theatreRating;
        this.location = location;
        this.area = area;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }



    public List<Movie> getMovieList() {
        return movieList;
    }

    public void addCustomer(Customer customer) throws CustomerAlreadyRegistred {
        if (customerList.contains(customer)){
            throw new CustomerAlreadyRegistred("Customer Details Already Exsists");
        }
        else{
            this.customerList.add(customer);
        }
    }

    public void addMovie(Movie movie) throws MovieAlreadyExists {
        if (movieList.contains(movie)){
            throw new MovieAlreadyExists("Movie Already Exists !!!");
        }
        else {
            movieList.add(movie);
        }
    }

    public void addScreen(Screen screen) throws ScreenAlreadyExists {
        if (screenList.contains(screen)){
            throw new ScreenAlreadyExists("Screen Already Exists !!!");
        }
        else{
            screenList.add(screen);
        }
    }

    public void addShow(Show show) throws ShowAlreadyExists {
        if(showList.contains(show)){
            throw new ShowAlreadyExists("Show Already Exists !!!");
        }
        else{
            showList.add(show);
            Movie movie = show.getMovie();
            movie.addShow(show);
        }
    }
}
