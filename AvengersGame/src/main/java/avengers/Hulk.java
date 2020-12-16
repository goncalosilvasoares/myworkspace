package avengers;

public class Hulk extends Avengers {

    private static Hulk hulk = null;

    private Hulk() {

        setHp(250);
        setName("Hulk");

        setDamage1(40);
        setDamage1Name("Attack 40");
        setDamage2(35);
        setDamage2Name("Attack 35");
        setDefence1(30);
        setDefence1Name("Defend 30");
        setDefence2(50);
        setDefence2Name("Defend 50");
    }

    public static Hulk getHulk() {

        if (hulk == null) {
            hulk = new Hulk();
        }
        return hulk;
    }
}
