public class Player {

    private integer id;
    private String name;
    private String strength;

    public Player(integer id, String name, String strength) {
        this.id = id;
        this.name = name;
        this.strength = strength;
    }

    public integer getId() {
        return id;
    }

    public void setId(integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }
}
