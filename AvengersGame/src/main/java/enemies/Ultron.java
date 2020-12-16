package enemies;

public class Ultron extends Enemy {

    private static Ultron ultron;

    private Ultron() {
        setHp(180);
        setName("Ultron");
        setDamage1(30);
        setDamage1Name("");
        setDamage2(40);
        setDamage2Name("");
        setDefence1(20);
        setDefence1Name("");
        setDefence2(30);
        setDefence2Name("");
    }

    public static Ultron getUltron() {

        if (ultron == null) {
            ultron = new Ultron();
        }
        return ultron;
    }
}
