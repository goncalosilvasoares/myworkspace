import avengers.CaptainAmerica;
import avengers.Hulk;
import avengers.IronMan;
import avengers.Thor;
import enemies.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    private JFrame window;
    private Container container;
    private JPanel titleNamePanel;
    private JPanel startButtonPanel;
    private JLabel titleNameLabel;
    private Font titleFont = new Font("Arial", Font.PLAIN, 60);
    private Font normalFont = new Font("Arial", Font.PLAIN, 20);
    private JButton starButton;
    private JPanel mainTextPanel;
    private JTextArea mainTextArea;
    private JPanel choiceButtonPanel;

    private TitleScreenHandler handler = new TitleScreenHandler();
    private ChoiceHandler choiceHandler = new ChoiceHandler();
    private ChoiceFightHandler choiceFightHandler = new ChoiceFightHandler();

    private JButton choice1;
    private JButton choice2;
    private JButton choice3;
    private JButton choice4;

    private JPanel playerPanel;
    private JLabel playerName;
    private JPanel healthBarPlayer;
    private JProgressBar progressBarPlayer;

    private JProgressBar progressBarEnemy;
    private JPanel healthBarEnemy;
    private JLabel enemyName;

    private Player player;

    private Enemy enemy;
    private int fightNumb = 1;
    private int enemyChoiceNumb;

    private EnemyFactory enemyFactory;

    public void init() {

        player = new Player();
        enemyFactory = new EnemyFactory();

        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setVisible(true);

        container = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.BLACK);

        titleNameLabel = new JLabel("Avengers Game");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.BLACK);

        starButton = new JButton("START");
        starButton.setBackground(Color.black);
        starButton.setForeground(Color.white);
        starButton.setFocusPainted(false);
        starButton.setFont(normalFont);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(starButton);
        container.add(titleNamePanel);
        container.add(startButtonPanel);

        starButton.addActionListener(handler);
    }

    public void createGameScreen() {

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 150, 600, 150);
        mainTextPanel.setBackground(Color.BLACK);
        container.add(mainTextPanel);

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(100, 150, 600, 150);
        mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(2, 2));
        container.add(choiceButtonPanel);

        choice1 = new JButton();
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("1");
        choiceButtonPanel.add(choice1);

        choice2 = new JButton();
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("2");
        choiceButtonPanel.add(choice2);

        choice3 = new JButton();
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("3");
        choiceButtonPanel.add(choice3);

        choice4 = new JButton();
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("4");
        choiceButtonPanel.add(choice4);

        playerPanel = new JPanel();
        playerPanel.setBounds(150, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 1));
        container.add(playerPanel);

        playerName = new JLabel();
        playerName.setFont(normalFont);
        playerName.setForeground(Color.white);

        enemyName = new JLabel();
        enemyName.setForeground(Color.white);
        enemyName.setFont(normalFont);


        JLabel nullName = new JLabel();
        JLabel nullname2 = new JLabel();

        playerPanel.add(playerName);
        playerPanel.add(nullName);
        playerPanel.add(enemyName);
        playerPanel.add(nullname2);

        healthBarPlayer = new JPanel();
        healthBarPlayer.setBounds(150,75,200,30);
        healthBarPlayer.setBackground(Color.black);
        container.add(healthBarPlayer);
        progressBarPlayer = new JProgressBar(0,250);
        progressBarPlayer.setPreferredSize(new Dimension(200,30));
        healthBarPlayer.add(progressBarPlayer);

        healthBarEnemy = new JPanel();
        healthBarEnemy.setBounds(450,75,200,30);
        healthBarEnemy.setBackground(Color.black);
        container.add(healthBarEnemy);
        progressBarEnemy = new JProgressBar(0,250);
        progressBarEnemy.setPreferredSize(new Dimension(200,30));
        healthBarEnemy.add(progressBarEnemy);

        playerChooseAvenger();
    }

    public void playerChooseAvenger() {

        mainTextArea.setText("Please choose one Avenger for fight with enemies.");

        choice1.setText("IronMan");
        choice2.setText("Captain America");
        choice3.setText("Thor");
        choice4.setText("Hulk");
    }

    public void fightNumb() {

        switch (fightNumb) {

            case 1:
                mainTextArea.setText("Welcome to your first fight " + player.getAvenger().getName());
                break;
            case 2:
                mainTextArea.setText("Welcome to your second fight " + player.getAvenger().getName());
                break;
            case 3:
                mainTextArea.setText("Welcome to your third fight " + player.getAvenger().getName());
                break;
            case 4:
                mainTextArea.setText("Welcome to your fourth fight " + player.getAvenger().getName());
                break;
        }
        choice1.setText("" + player.getAvenger().getDamage1Name());
        choice2.setText("" + player.getAvenger().getDamage2Name());
        choice3.setText("" + player.getAvenger().getDefence1Name());
        choice4.setText("" + player.getAvenger().getDefence2Name());
    }

    public class TitleScreenHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            createGameScreen();
        }
    }

    public class ChoiceHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String playerChoice = e.getActionCommand();

            switch (playerChoice) {

                case "1":
                    getIronMan();
                    choice1.removeActionListener(choiceHandler);
                    choice2.removeActionListener(choiceHandler);
                    choice3.removeActionListener(choiceHandler);
                    choice4.removeActionListener(choiceHandler);
                    choice1.addActionListener(choiceFightHandler);
                    choice2.addActionListener(choiceFightHandler);
                    choice3.addActionListener(choiceFightHandler);
                    choice4.addActionListener(choiceFightHandler);
                    fightNumb();
                    break;
                case "2":
                    getCaptainAmerica();
                    choice1.removeActionListener(choiceHandler);
                    choice2.removeActionListener(choiceHandler);
                    choice3.removeActionListener(choiceHandler);
                    choice4.removeActionListener(choiceHandler);
                    choice1.addActionListener(choiceFightHandler);
                    choice2.addActionListener(choiceFightHandler);
                    choice3.addActionListener(choiceFightHandler);
                    choice4.addActionListener(choiceFightHandler);
                    fightNumb();
                    break;
                case "3":
                    getThor();
                    choice1.removeActionListener(choiceHandler);
                    choice2.removeActionListener(choiceHandler);
                    choice3.removeActionListener(choiceHandler);
                    choice4.removeActionListener(choiceHandler);
                    choice1.addActionListener(choiceFightHandler);
                    choice2.addActionListener(choiceFightHandler);
                    choice3.addActionListener(choiceFightHandler);
                    choice4.addActionListener(choiceFightHandler);
                    fightNumb();
                    break;
                case "4":
                    getHulk();
                    choice1.removeActionListener(choiceHandler);
                    choice2.removeActionListener(choiceHandler);
                    choice3.removeActionListener(choiceHandler);
                    choice4.removeActionListener(choiceHandler);
                    choice1.addActionListener(choiceFightHandler);
                    choice2.addActionListener(choiceFightHandler);
                    choice3.addActionListener(choiceFightHandler);
                    choice4.addActionListener(choiceFightHandler);
                    fightNumb();
                    break;
            }
        }
    }



    public class ChoiceFightHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String playerChoice = e.getActionCommand();
            int choice = enemyChoice();

            switch (playerChoice) {

                case "1":
                    switch (enemyChoiceNumb) {
                        case 1:
                        case 2:
                            playerAttack(player.getAvenger().getDamage1(), 0);
                            enemyAttack(choice, 0);
                          progressBarPlayer.setValue(player.getAvenger().getHp());
                            progressBarEnemy.setValue(enemy.getHp());
                            mainTextArea.setText("You hit " + enemy.getName() + " with " + player.getAvenger().getDamage1() +
                                    " damage.\nThe enemy hits you with " + choice + " damage.");
                            checkHP();
                            break;
                        case 3:
                        case 4:
                            playerAttack(player.getAvenger().getDamage1(), choice);
                            progressBarEnemy.setValue(enemy.getHp());
                            mainTextArea.setText("You hit " + enemy.getName() + " with " + player.getAvenger().getDamage1() + " damage." +
                                    "\nBut the enemy defends with " + choice + " from your damage.");
                            checkHP();
                            break;
                    }
                    break;
                case "2":
                    switch (enemyChoiceNumb) {
                        case 1:
                        case 2:
                            playerAttack(player.getAvenger().getDamage2(), 0);
                            enemyAttack(choice, 0);
                            progressBarPlayer.setValue(player.getAvenger().getHp());
                            progressBarEnemy.setValue(enemy.getHp());
                            mainTextArea.setText("You hit " + enemy.getName() + " with " + player.getAvenger().getDamage2() +
                                    " damage.\nThe enemy hits you with " + choice + " damage.");
                            checkHP();
                            break;
                        case 3:
                        case 4:
                            playerAttack(player.getAvenger().getDamage2(), choice);
                            progressBarEnemy.setValue(enemy.getHp());
                            mainTextArea.setText("You hit " + enemy.getName() + " with " + player.getAvenger().getDamage2() + " damage." +
                                    "\nBut the enemy defends with " + choice + " from your damage.");
                            checkHP();
                            break;
                    }
                    break;
                case "3":
                    switch (enemyChoiceNumb) {
                        case 1:
                        case 2:
                            enemyAttack(choice, player.getAvenger().getDefence1());
                            progressBarPlayer.setValue(player.getAvenger().getHp());
                            mainTextArea.setText("The enemy hits you with " + choice + " damage. \nBut you defend with " + player.getAvenger().getDefence1() + ".");
                            checkHP();
                            break;
                        case 3:
                        case 4:
                            mainTextArea.setText("You and the enemy chose defend this turn,\nso no damage for anyone.");
                            break;
                    }
                    break;
                case "4":
                    switch (enemyChoiceNumb) {
                        case 1:
                        case 2:
                            enemyAttack(choice, player.getAvenger().getDefence2());
                            progressBarPlayer.setValue(player.getAvenger().getHp());
                            mainTextArea.setText("The enemy hits you with " + choice + " damage. \nBut you defend with " + player.getAvenger().getDefence2() + ".");
                            checkHP();
                            break;
                        case 3:
                        case 4:
                            mainTextArea.setText("You and the enemy chose defend this turn,\nso no damage for anyone.");
                            break;
                    }
                    break;
            }
        }
    }

    public void playerAttack(int attack, int enemyDefend) {

        if (attack > enemyDefend) {
            int totalAttack =  attack - enemyDefend;
            enemy.setHp(enemy.getHp() - totalAttack);
        }
    }

    public void enemyAttack(int attack, int playerDefend) {

        if (attack > playerDefend) {
            int totalAttack = attack - playerDefend;

            player.getAvenger().setHp(player.getAvenger().getHp() - totalAttack);
        }
    }

    public int enemyChoice() {

        int randChoice = (int) (Math.random() * 4);

        switch (randChoice) {

            case 0:
                enemyChoiceNumb = randChoice + 1;
                return enemy.getDamage1();
            case 1:
                enemyChoiceNumb = randChoice + 1;
                return enemy.getDamage2();
            case 2:
                enemyChoiceNumb = randChoice + 1;
                return enemy.getDefence1();
            case 3:
                enemyChoiceNumb = randChoice + 1;
                return enemy.getDefence2();
        }
        return 0;
    }

    public void win() {

        mainTextArea.setText("<You WIN>");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
        Music musicWin = new Music("/src/main/resources/win.wav");
        musicWin.play(true);
    }

    public void lose() {

        mainTextArea.setText("You are dead!\n\n<GAME OVER>");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
        Music musicLose = new Music("/src/main/resources/lose.wav");
        musicLose.play(true);
    }

    public void checkHP() {

        if (player.getAvenger().getHp() < 1) {

            lose();
        } else if (enemy.getHp() < 1 && enemyFactory.getEnemies().size() == 0) {

            win();
        } else if (enemy.getHp() < 1) {

            mainTextArea.setText(mainTextArea.getText() + "\nYou killed the enemy " + enemy.getName() + ". \nBut have more enemies for fight!");
            fightNumb++;
            enemy = enemyFactory.getEnemy();
            enemyName.setText(enemy.getName());
            progressBarEnemy.setValue(enemy.getHp());

            fightNumb();
        }
    }

    public void getHulk() {

        player.setAvenger(Hulk.getHulk());
        enemy = enemyFactory.getEnemy();
        playerName.setText("" + player.getAvenger().getName());
        enemyName.setText("" + enemy.getName());
        progressBarPlayer.setValue(player.getAvenger().getHp());
        progressBarEnemy.setValue(enemy.getHp());
    }

    public void getCaptainAmerica() {

        player.setAvenger(CaptainAmerica.getCaptainAmerica());
        enemy = enemyFactory.getEnemy();
        playerName.setText("" + player.getAvenger().getName());
        enemyName.setText("" + enemy.getName());
        progressBarPlayer.setValue(player.getAvenger().getHp());
        progressBarEnemy.setValue(enemy.getHp());
    }

    public void getIronMan() {

        player.setAvenger(IronMan.getIronMan());
        enemy = enemyFactory.getEnemy();
        playerName.setText("" + player.getAvenger().getName());
        enemyName.setText("" + enemy.getName());
        progressBarPlayer.setValue(player.getAvenger().getHp());
        progressBarEnemy.setValue(enemy.getHp());
    }

    public void getThor() {

        player.setAvenger(Thor.getThor());
        enemy = enemyFactory.getEnemy();
        playerName.setText("" + player.getAvenger().getName());
        enemyName.setText("" + enemy.getName());
        progressBarPlayer.setValue(player.getAvenger().getHp());
        progressBarEnemy.setValue(enemy.getHp());
    }
}


