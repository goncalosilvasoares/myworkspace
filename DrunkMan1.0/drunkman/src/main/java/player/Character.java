package player;

public enum Character {
    BENNY("Benny"),
    PAULINHO("Paulinho"),
    ROLO("Rolo-Demon");

    private String name;

    private Character(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}