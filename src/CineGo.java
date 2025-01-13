// File: src/CineGo.java
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class CineGo {
    static Admin admin;

    public static void main(String[] args) {
        // Admin login
        admin = Admin.adminLogin("Admin01", "ad@001");
        if (admin != null) {
            System.out.println(admin.getUserName() + " logged in successfully.");
        } else {
            System.out.println("Admin login failed!");
            return;
        }

        // Adding a movie
        if (admin.addMovie("Inception",
                Arrays.asList("Action", "Sci-Fi", "Thriller"),
                LocalTime.of(2, 28),
                Arrays.asList("English", "Hindi"),
                LocalDate.of(2010, 7, 16),
                8.8f,
                "A thief who steals corporate secrets through dream-sharing technology is given the inverse task of planting an idea.",
                Arrays.asList("2D", "IMAX"),
                Arrays.asList(
                        new MovieTeam("Christopher Nolan", "Director", "Director", "Crew"),
                        new MovieTeam("Leonardo DiCaprio", "Cobb", "Actor", "Cast"),
                        new MovieTeam("Hans Zimmer", "Composer", "Music", "Crew")
                ),
                "mv002")) {
            System.out.println("Movie added successfully.");
        } else {
            System.out.println("Failed to add movie.");
        }

        // Creating a theatre and screen
        Theatre theatre = new Theatre("theatre001", "Cineplex", "8.5", "Main Street", "Downtown", "City", "State", 123456);
        Screen screen1 = new Screen("SC001", 1, "IMAX", 10);
        Screen screen2 = new Screen("SC002", 2, "2D", 10);

        // Adding a show
        Movie inception = Theatre.getMovieList().get(0);
        Show show1 = new Show("SH001", LocalDate.now(), LocalTime.of(18, 30), inception, screen1);

        //New Customer added
        Customer cs = new Customer("Raj","Shah","raj","raj123","cs001","raj@gmail.com","Surat",395009);

        //Customer Printing Show Details
        cs.getShowDetails();

        //Show Available Seats
        cs.showAvailableSeats(show1);

        //Booking a Ticket
        Booking ticket1 = cs.bookTicket(show1,Arrays.asList("A1","A2"));
        cs.getTicketDetails(ticket1);

        //After Booking Show Available Seats
        cs.showAvailableSeats(show1);
    }
}