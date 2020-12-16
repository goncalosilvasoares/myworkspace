package enemies;

public class WinterSoldier extends Enemy {

    private static WinterSoldier winterSoldier;

    private WinterSoldier() {
        setHp(130);
        setName("Winter Soldier");
        setDamage1(20);
        setDamage1Name("");
        setDamage2(20);
        setDamage2Name("");
        setDefence1(20);
        setDefence1Name("");
        setDefence2(20);
        setDefence2Name("");
    }

    public static WinterSoldier getWinterSoldier() {

        if (winterSoldier == null) {
            winterSoldier = new WinterSoldier();
        }
        return winterSoldier;
    }
}
