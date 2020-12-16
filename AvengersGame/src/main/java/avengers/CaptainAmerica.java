package avengers;

public class CaptainAmerica extends Avengers {

    private static CaptainAmerica captainAmerica = null;

    private CaptainAmerica() {

        setHp(130);
        setName("Captain America");

        setDamage1(20);
        setDamage1Name("Attack 20");
        setDamage2(25);
        setDamage2Name("Attack 25");
        setDefence1(15);
        setDefence1Name("Defend 15");
        setDefence2(20);
        setDefence2Name("Defend 20");
    }


    public static CaptainAmerica getCaptainAmerica() {

        if (captainAmerica == null) {
            captainAmerica = new CaptainAmerica();
        }
        return captainAmerica;
    }
}
