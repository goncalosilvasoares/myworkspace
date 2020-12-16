package enemies;

public abstract class Enemy {

    private String name;
    private int hp;

    private int damage1;
    private String damage1Name;
    private int damage2;
    private String damage2Name;
    private int defence1;
    private String defence1Name;
    private int defence2;
    private String defence2Name;
    private boolean shield;

    public boolean isShield() {
        return shield;
    }

    public void setShield(boolean shield) {
        this.shield = shield;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }


    public void setDamage1(int damage1) {
        this.damage1 = damage1;
    }

    public void setDamage1Name(String damage1Name) {
        this.damage1Name = damage1Name;
    }

    public void setDamage2(int damage2) {
        this.damage2 = damage2;
    }

    public void setDamage2Name(String damage2Name) {
        this.damage2Name = damage2Name;
    }

    public void setDefence1(int defence1) {
        this.defence1 = defence1;
    }

    public void setDefence1Name(String defence1Name) {
        this.defence1Name = defence1Name;
    }

    public void setDefence2(int defence2) {
        this.defence2 = defence2;
    }

    public void setDefence2Name(String defence2Name) {
        this.defence2Name = defence2Name;
    }

    public int getDefence2() {
        return defence2;
    }

    public String getDamage1Name() {
        return damage1Name;
    }

    public String getDamage2Name() {
        return damage2Name;
    }

    public String getDefence1Name() {
        return defence1Name;
    }

    public String getDefence2Name() {
        return defence2Name;
    }

    public int getDefence1() {
        return defence1;
    }


    public int getDamage1() {
        return damage1;
    }

    public int getDamage2() {
        return damage2;
    }
}
