import Exceptions.*;
import Theatre.Theatre;
import Theatre.Screen;
import Theatre.Movie;
import Theatre.MovieTeam;
import Theatre.Show;
import Users.Admin;
import Users.Customer;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class CineGo {
    public static void main(String[] args) {
        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";

        // Initializing Theatre.Theatre
        Theatre theatre = new Theatre("theatre001", "Cineplex", "8.5", "Main Street", "Downtown", "City", "State", 123456);

        // Assigning Users.Admin
        Admin admin = new Admin("Vinay", "Adatiya", "admin", "admin@123", "ad001", "admin@gemail.com", "Surat", 395009, theatre);

        // Adding screen
        Screen screen1 = null;
        Screen screen2 = null;
        try{
            screen1 = new Screen("SC001", 1, "IMAX", 10);
            admin.addScreen(screen1);

            screen2 = new Screen("SC002", 2, "2D", 10);
            admin.addScreen(screen2);
        }
        catch (ScreenAlreadyExists e){
            System.out.println(RED+"Error :- "+e.getMessage()+RESET);
        }


        // Adding Theatre.Movie
        Movie interstellarMovie = null;
        Movie pushpa2Movie = null;
        try{
            interstellarMovie = new Movie.Builder()
                    .setMovieID("001")
                    .setTitle("Interstellar")
                    .setGenre(Arrays.asList("Sci-Fi", "Adventure"))
                    .setDuration(LocalTime.of(2, 49))
                    .setLanguage(Arrays.asList("English"))
                    .setReleaseDate(LocalDate.of(2014, 11, 7))
                    .setRating(8.6f)
                    .setDescription("A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.")
                    .setFormat(Arrays.asList("IMAX", "3D"))
                    .setMovieTeam(Arrays.asList(
                            new MovieTeam("Christopher Nolan", "Director", "Director", "Crew"),
                            new MovieTeam("Matthew McConaughey", "Actor", "Lead Actor", "Cast")))
                    .build();
            admin.addMovie(interstellarMovie);

            // Adding Theatre.Movie
            pushpa2Movie = new Movie.Builder()
                    .setMovieID("002")
                    .setTitle("Pushpa 2")
                    .setGenre(Arrays.asList("Action", "Drama"))
                    .setDuration(LocalTime.of(2, 45))
                    .setLanguage(Arrays.asList("Telugu", "Hindi"))
                    .setReleaseDate(LocalDate.of(2023, 12, 17))
                    .setRating(7.8f)
                    .setDescription("The sequel to the blockbuster movie Pushpa, continuing the story of the rise of a red sandalwood smuggler.")
                    .setFormat(Arrays.asList("2D", "4DX"))
                    .setMovieTeam(Arrays.asList(
                            new MovieTeam("Sukumar", "Director", "Director", "Crew"),
                            new MovieTeam("Allu Arjun", "Actor", "Lead Actor", "Cast")))
                    .build();
            admin.addMovie(pushpa2Movie);
        }
        catch(MovieAlreadyExists e){
            System.out.println(RED+"Error :- "+e.getMessage()+RESET);
        }

        // Adding a show
        Show show1 = null;
        Show show2 = null;
        Show show3 = null;
        try{
            show1 = new Show("SH001", LocalDate.now(), LocalTime.of(12, 30), interstellarMovie, screen1);
            admin.addShow(show1);

            show2 = new Show("SH002", LocalDate.now(), LocalTime.of(18, 30), interstellarMovie, screen1);
            admin.addShow(show2);

            show3 = new Show("SH003", LocalDate.of(2025,01,19), LocalTime.of(18, 30), interstellarMovie, screen1);
            admin.addShow(show3);
        }
        catch(ShowAlreadyExists e){
            System.out.println(RED+"Error :- "+e.getMessage()+RESET);
        }


        //New Users.Customer added
        Customer cs = new Customer("Raj", "Shah", "raj", "raj123", "cs001", "raj@gmail.com", "Surat", 395009);
        try{
            theatre.addCustomer(cs);
        }
        catch(CustomerAlreadyRegistred e){
            System.out.println(RED+"Error :- "+e.getMessage()+RESET);
        }

        //Users.Customer Printing Theatre.Show Details
        try{
            cs.getShowDetails(interstellarMovie);
            cs.getShowDetails(pushpa2Movie);
        }
        catch(ShowNotAvailableException e){
            System.out.println(RED+"Error :- "+e.getMessage()+RESET);
        }

        //Theatre.Show Available Seats
        cs.showAvailableSeats(show1);

        //Preview of Theatre.Booking
        try{
            cs.bookingPreview(show1, Arrays.asList( "A1", "A2" , "B3" )); // Afternoon Pricing
            cs.bookingPreview(show2, Arrays.asList( "A1", "A2" , "B3" )); // Evening Pricing
            cs.bookingPreview(show3, Arrays.asList( "A1", "A2" , "B3" )); // Evening Pricing + Weekends
            cs.bookingPreview(show1, Arrays.asList( "A1", "A2" , "B12" )); // Invalid Theatre.Seat
        }
        catch(SeatNotFoundException | SeatAlreadyOccupiedException e){
            System.out.println(RED+"Error :- "+e.getMessage()+RESET);
        }

        //Confirm Theatre.Booking
        try {
            cs.bookTicket(show1, Arrays.asList("A1", "A2" , "B3"));
        }
        catch(SeatNotFoundException | SeatAlreadyOccupiedException e){
            System.out.println(RED+"Error :- "+e.getMessage()+RESET);
        }

        try{
            cs.bookingPreview(show1, Arrays.asList( "A1", "A2" , "B3" )); // Already Booked Theatre.Seat
        }
        catch(SeatNotFoundException | SeatAlreadyOccupiedException e){
            System.out.println(RED+"Error :- "+e.getMessage()+RESET);
        }

        //Ticket Details
        cs.getTicketDetails();

        //Users.Customer Printing Theatre.Show Details
        try {
            cs.getShowDetails(interstellarMovie);
        }
        catch(ShowNotAvailableException e){
            e.getMessage();
        }

        //After Theatre.Booking Theatre.Show Available Seats
        cs.showAvailableSeats(show1);
        cs.showAvailableSeats(show2);
        cs.showAvailableSeats(show3);
    }
}