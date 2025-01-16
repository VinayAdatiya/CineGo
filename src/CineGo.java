import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class CineGo {

    public static void main(String[] args) {

        // Initializing Theatre
        Theatre theatre = new Theatre("theatre001", "Cineplex", "8.5", "Main Street", "Downtown", "City", "State", 123456);

        // Assigning Admin to theatre
        Admin admin = new Admin("Vinay", "Adatiya", "admin", "admin@123", "ad001", "admin@gemail.com", "Surat", 395009, theatre);

        // Adding screen
        Screen screen1 = new Screen("SC001", 1, "IMAX", 10);
        admin.addScreen(screen1);

        // Adding screen
        Screen screen2 = new Screen("SC002", 2, "2D", 10);
        admin.addScreen(screen2);

        // Adding Movie
        Movie interstellarMovie = new Movie.Builder()
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

        // Adding Movie
        Movie pushpa2Movie = new Movie.Builder()
                .setMovieID("002")
                .setTitle("Pushpa 2")
                .setGenre(Arrays.asList("Action", "Drama"))
                .setDuration(LocalTime.of(2, 45))
                .setLanguage(Arrays.asList("Telugu", "Hindi"))
                .setReleaseDate(LocalDate.of(2023, 12, 17))
                .setRating(7.8f).setDescription("The sequel to the blockbuster movie Pushpa, continuing the story of the rise of a red sandalwood smuggler.")
                .setFormat(Arrays.asList("2D", "4DX"))
                .setMovieTeam(Arrays.asList(
                        new MovieTeam("Sukumar", "Director", "Director", "Crew"),
                        new MovieTeam("Allu Arjun", "Actor", "Lead Actor", "Cast")))
                .build();
        admin.addMovie(pushpa2Movie);

        // Adding a show
        Show show1 = new Show("SH001", LocalDate.now(), LocalTime.of(12, 30), interstellarMovie, screen1);
        admin.addShow(show1);

        // Adding a show
        Show show2 = new Show("SH002", LocalDate.now(), LocalTime.of(18, 30), interstellarMovie, screen1);
        admin.addShow(show2);

        // Adding a show in weekends
        Show show3 = new Show("SH003", LocalDate.of(2025,01,19), LocalTime.of(18, 30), interstellarMovie, screen1);
        admin.addShow(show3);

        //New Customer added
        Customer cs = new Customer("Raj", "Shah", "raj", "raj123", "cs001", "raj@gmail.com", "Surat", 395009);

        //Customer Printing Show Details
        cs.getShowDetails(interstellarMovie);

        //Show Available Seats
        cs.showAvailableSeats(show1);

        //Preview of Booking
        cs.bookingPreview(show1, Arrays.asList( "A1", "A2" , "B3" )); // Afternoon Pricing
        cs.bookingPreview(show2, Arrays.asList( "A1", "A2" , "B3" )); // Evening Pricing
        cs.bookingPreview(show3, Arrays.asList( "A1", "A2" , "B3" )); // Evening Pricing + Weekends

        //Confirm Booking
        cs.bookTicket(show1, Arrays.asList("A1", "A2" , "B3"));

        //Ticket Details
        cs.getTicketDetails();

        //Customer Printing Show Details
        cs.getShowDetails(interstellarMovie);

        //After Booking Show Available Seats
        cs.showAvailableSeats(show1);
        cs.showAvailableSeats(show2);
        cs.showAvailableSeats(show3);
    }
}