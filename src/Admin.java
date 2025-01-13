import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Admin extends Users{

    // admin object list
    static List<Admin> adminList = new ArrayList<>();

    // static block for initializing first object in the list
    static {
        Admin a1 = new Admin("Vinay","Adatiya","Admin01","ad@001","ad001","admin.CineGo@gmail.com","Surat",395009);
        adminList.add(a1);
    }

    // Admin Constructor with super()
    public Admin(String firstName, String lastName, String userName, String password, String customerID, String emailID, String city, int pinCode) {
        super(firstName, lastName, userName, password, customerID, emailID, city, pinCode);
    }

    // static adminLogin method so that we can call it from the main CineGo Class
    static Admin adminLogin(String userName,String password){
        for (int i = 0; i < adminList.size(); i++) {
            if(adminList.get(i).getUserName() == userName  &&  adminList.get(i).getPassword() == password){
                return adminList.get(i);
            }
        }
        return null;
    }

    // addMovie using any one of the admin object
     public boolean addMovie(String title, List<String> genre, LocalTime duration, List<String> language, LocalDate releaseDate, float rating, String description, List<String> format, List<MovieTeam> mt, String movieID){
        Movie movie = new Movie(title,genre,duration,language,releaseDate,rating,description,format,mt,movieID);
        if(movie != null){
            return true;
        }
        else{
            return false;
        }
    }

    // Printing all movies title and id for admin
    @Override
    public void getAllMovies(){
        List<Movie> movies = Theatre.getMovieList();
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
        for (int i = 0; i < Theatre.getMovieList().size(); i++) {
            if(Theatre.getMovieList().get(i).getMovieID() == movieID){
                System.out.println(movieID+" Removed Successfully");
                Theatre.getMovieList().remove(i);
            }
        }
    }

    public void addShow(){

    }
}
