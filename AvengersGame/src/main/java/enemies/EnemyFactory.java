package enemies;

import java.util.ArrayList;
import java.util.List;

public class EnemyFactory {

    private List<Enemy> enemies = new ArrayList<>();

    public EnemyFactory() {
        Thanos thanos = Thanos.getThanos();
        Loki loki = Loki.getLoki();
        Ultron ultron = Ultron.getUltron();
        WinterSoldier winterSoldier = WinterSoldier.getWinterSoldier();
        enemies.add(thanos);
        enemies.add(loki);
        enemies.add(ultron);
        enemies.add(winterSoldier);
    }

    public Enemy getEnemy() {

        int enemyRand = (int) (Math.random() * enemies.size());
        Enemy enemy = enemies.get(enemyRand);
        enemies.remove(enemyRand);

        return enemy;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }
}
