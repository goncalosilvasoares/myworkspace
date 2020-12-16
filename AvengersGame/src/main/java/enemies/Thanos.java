package enemies;

public class Thanos extends Enemy {

    private static Thanos thanos = null;

    private Thanos() {

        setName("Thanos");
        setHp(250);
        setDamage1(30);
        setDamage1Name("");
        setDamage2(30);
        setDamage2Name("");
        setDefence1(30);
        setDefence1Name("");
        setDefence2(35);
        setDefence2Name("");
    }

    public static Thanos getThanos() {

        if (thanos == null) {
            thanos = new Thanos();
        }
        return thanos;
    }
}
