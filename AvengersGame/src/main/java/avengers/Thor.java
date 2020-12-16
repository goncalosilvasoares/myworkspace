package avengers;

public class Thor extends Avengers {

    private static Thor thor = null;

    public Thor() {

        setName("Thor");
        setHp(150);

        setDamage1(20);
        setDamage1Name("Attack 20");
        setDamage2(15);
        setDamage2Name("Attack 15");
        setDefence1(10);
        setDefence1Name("Defend 10");
        setDefence2(2);
        setDefence2Name("Defend 20");
    }

    public static Thor getThor() {

        if (thor == null) {
            thor = new Thor();
        }
        return thor;
    }
}
