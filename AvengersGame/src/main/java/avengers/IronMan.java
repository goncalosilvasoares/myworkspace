package avengers;

public class IronMan extends Avengers {

    private static IronMan ironMan = null;

    private IronMan() {

        setName("Iron Man");
        setHp(200);

        setDamage1(30);
        setDamage1Name("Attack 30");
        setDamage2(100);
        setDamage2Name("Attack 50");
        setDefence1(15);
        setDefence1Name("Defend 15");
        setDefence2(20);
        setDefence2Name("Defend 20");
    }

    public static IronMan getIronMan() {

        if (ironMan == null) {
            ironMan = new IronMan();
        }
        return ironMan;
    }
}
