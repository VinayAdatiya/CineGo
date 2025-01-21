package Theatre;

public class MovieTeam {
    private String name;
    private String chName;
    private String designation;
    private String type;

    public MovieTeam(String name, String chName, String designation, String type) {
        this.name = name;
        this.chName = chName;
        this.designation = designation;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChName() {
        return chName;
    }

    public void setChName(String chName) {
        this.chName = chName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
