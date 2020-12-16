package enemies;

public class Loki extends Enemy{

    private static Loki loki;

    private Loki() {
        setHp(100);
        setName("Loki");
        setDamage1(20);
        setDamage1Name("");
        setDamage2(25);
        setDamage2Name("");
        setDefence1(15);
        setDefence1Name("");
        setDefence2(20);
        setDefence2Name("");
    }

    public static Loki getLoki() {

        if (loki == null) {
            loki = new Loki();
        }
        return loki;
    }

}
