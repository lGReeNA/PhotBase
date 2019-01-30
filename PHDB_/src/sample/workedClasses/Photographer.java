package sample.workedClasses;

/**
 * The class for working with information about photographers
 */

public class Photographer {

    private int id;
    private String name;
    private String surname;
    private String stage;
    private String portfolio;
    private String location_;

    public Photographer(String names, String surnames, String stages, String port, String loc)
    {
        name = names;
        surname = surnames;
        stage = stages;
        portfolio = port;
        location_ = loc;
    }
    public Photographer(){}

    public Integer getId() {
        return id;
    }

    public
    void setId(String id) {
        this.id = Integer.parseInt(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String loginl) {
        this.stage = loginl;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getLocation_() {
        return location_;
    }

    public void setLocation_(String location_) {
        this.location_ = location_;
    }
}
