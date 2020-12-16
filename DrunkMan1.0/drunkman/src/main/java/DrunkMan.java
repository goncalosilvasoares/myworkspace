public class DrunkMan {
    public DrunkMan() {
    }

    public static void main(String[] args) throws InterruptedException {
        Game g = new Game(50, 25, 200);
        g.init();
        g.start();
    }
}
