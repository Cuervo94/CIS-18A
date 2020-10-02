/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlawredemption;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author cbran
 */
public class ChapterTwo extends Chapter {

    ChapterThree ch3 = new ChapterThree();

    @Override
    public void startChapter(Player player) {
        setDone(false);
        while (!isDone()) {
            String choice = getUserInput("1. Head to the post office. \"I'll be back, get ready.\"\n2. Head to the post office. \"Nope. I don't think I'm going.\" [LIE]");
            if (choice.equals("1")) {
                player.addHonor(2);
                setDone(true);
            } else if (choice.equals("2")) {
                player.addDishonor(2);
                displayMenu("Red Hawk: \"There's no time for this!\"");
                setDone(true);
            } else {
                displayMenu("There is literally nothing else to do except go to the post office.");
            }
        }
        part1(player);
    }

    @Override
    public void part1(Player player) {
        displayMenu("You go to the post office, no one is around at this time of the day.\nYou search the bushes around the area until you find the stash.\n\n"
                + "\"He was right, there's enough explosives to blow up the entire town\".  [+5 dynamite]");
        player.addDynamite(5);
        displayMenu("A stranger approaches you.");
        setDone(false);
        while (!isDone()) {
            String choice = getUserInput("Stranger: \"What are you doing here. I know who you are " + player.getCharacterName() + ", if you want to keep my mouth shut you better pay me up.\"\n\n"
                    + "1. \"Ok. Fine, here.\"  [$10.00]\n"
                    + "2. \"I ain't paying shit!\"  [START DRAW]\n"
                    + "3. \"Here's a stash of gold, we can split it.\"  [LIE]\n");
            if (choice.equals("1")) {
                pay(player, "Stranger: \"Smart move mister. Now move along.\"", 10.00, 5);
            } else if (choice.equals("2")) {
                draw(player);
            } else if (choice.equals("3")) {
                player.addDishonor(5);
                displayMenu("Stranger: \"I don't believe you, let me see it.\"");
                boolean quit = false;
                while (!quit) {
                    String choice1 = getUserInput("1. Choke him and kill him");
                    if (choice1.equals("1")) {
                        displayMenu("You took advantage of the stranger.");
                        quit = true;
                    } else {
                        displayMenu("Dew it.");
                    }
                }
                setDone(true);
            } else {
                displayMenu("You should kill him.");
            }
        }
        part2(player);
    }

    @Override
    public void part2(Player player) {
        displayMenu("Before returning to the prison, you are going to need a horse to runaway.\n"
                + "There should be some in the stables across the town.\n");
        setDone(false);
        while (!isDone()) {
            String choice = getUserInput("You reach the stables. Someone is sleeping, \"guarding\" the horses.\n\n"
                    + "1. Sneak in and get a horse.\n"
                    + "2. \"Wake up! I want a horse, here's $20.\" You leave without any problems.  [$20.00]\n"
                    + "3. Choke him out and leave him unconscious.");
            if (choice.equals("1")) {
                player.addDishonor(4);
                displayMenu("You make a noise and the owner wakes up to you racing off with his horse.");
                setDone(true);
            } else if (choice.equals("2")) {
                pay(player, "You successfully bought the horse.", 20.00, 4);
            } else if (choice.equals("3")) {
                player.addDishonor(4);
                choke();
                displayMenu("You leave with the best horse you could find.");
                setDone(true);
            } else {
                displayMenu("Why is it so hard for you to pick something?");
            }
        }
        displayMenu("You come back to the prison with a horse and the dynamite.");
        saveGame(player, ch3, 3);
    }

    private void pay(Player player, String menu, Double amount, Integer honor) {
        if (player.getMoney() >= amount) {
            player.addHonor(honor);
            player.subtractMoney(amount);
            displayMenu(menu);
            displayMenu(player.getTotalMoney());
            setDone(true);
        } else {
            displayMenu("You must choose another option since you wasted your money drinking or gambling.");
            setDone(false);
        }
    }

    private void draw(Player player) {
        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.getRootFrame().dispose();
            }
        });
        timer.start();
        String input = JOptionPane.showInputDialog("Enter \"shoot\"");
        timer.stop();
        if (input == null) {
            input = "";
        }
        if (input.equalsIgnoreCase("shoot")) {
            player.addDishonor(5);
            displayMenu("You killed the stranger.");
            setDone(true);
        } else {
            displayDead(player);
        }
    }

    private void choke() {
        final JOptionPane optionPane = new JOptionPane("Choking...", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        final JDialog dialog = new JDialog();
        dialog.setTitle("Message");
        dialog.setModal(true);
        dialog.setContentPane(optionPane);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        Timer timer = new Timer(5000, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.getRootFrame().dispose();
            }
        });
        timer.start();
        dialog.setVisible(true);
        timer.stop();
        displayMenu("Choke complete.");
    }
}
