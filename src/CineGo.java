import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class CineGo {
    static Admin admin;
    static Customer customer;

    public static void main(String[] args) {
        // Admin login
        if (Admin.adminLogin("Admin01", "ad@001") != null) {
            admin = Admin.adminLogin("Admin01", "ad@001");
            System.out.println(admin.getUserName() + " is Logged in Successfully");
        } else {
            System.out.println("Admin login Failed !!!");
        }

        // Admin adding a movie
        if (admin.addMovie("Interstellar",
                Arrays.asList("Adventure", "Drama", "Sci-Fi"),
                LocalTime.of(2, 49),
                Arrays.asList("English", "Hindi"),
                LocalDate.of(2014, 11, 7),
                8.6f,
                "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
                Arrays.asList("2D", "IMAX"),
                Arrays.asList(
                        new MovieTeam("Christopher Nolan", "Director", "Director", "Crew"),
                        new MovieTeam("Matthew McConaughey", "Cooper", "Actor", "Cast"),
                        new MovieTeam("Anne Hathaway", "Brand", "Actor", "Cast"),
                        new MovieTeam("Jessica Chastain", "Murph", "Actor", "Cast"),
                        new MovieTeam("Hans Zimmer", "Composer", "Music", "Crew")
                ),
                "mv001")) {
            System.out.println("Movie Added Successfully");
        } else {
            System.out.println("Failed to add movie");
        }

        // Admin printing all movie details
        admin.getAllMovies();

        // Create Theatre, Screen, and Shows
        Theatre theatre = new Theatre("theatre001","Rajhans Multiplex","7.8","Adajan Hazira Road","Adajan","Surat","Gujarat",395009);
        Screen screen1 = new Screen("SC001", 1,"IMAX" ,10);
        Screen screen2 = new Screen("SC002", 2,"2D" ,10);
        Screen screen3 = new Screen("SC004", 3,"4DX" ,10);


        // Admin removing a movie
        System.out.println("\nAdmin removing a movie:");
        admin.removeMovie("mv001");
        admin.getAllMovies();
    }
}
