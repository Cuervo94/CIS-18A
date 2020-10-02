/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlawredemption;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author cbran
 */
public class ChapterFour extends Chapter {

    ChapterFive ch5 = new ChapterFive();

    @Override
    public void startChapter(Player player) {
        displayMenu("Before entering the saloon James hands you an eyepatch.");
        displayMenu("James: \"Here, you'll be less recognizable with this.\"");
        displayMenu("You put on the eyepatch and enter the saloon. There's a lot of people but you can distinguish the hired guns from the crowd.\n"
                + "There is a total of 4, and 1 is right next to your target. You know there's also a couple more on the second floor.\n"
                + "You can count on \"Red Hawk\" to deal with the ones on the second floor.");
        displayMenu("Samantha Bell: \"Get us another round! On me!\"");
        part1(player);
    }

    @Override
    public void part1(Player player) {
        setDone(false);
        while (!isDone()) {
            String choice = getUserInput("1. \"Forget about it, next round is on me!\"  [$4.00]\n"
                    + "2. \"Samantha Bell? I want to ask you some questions.\"\n"
                    + "3. Shoot her bodyguard and slam her face on the counter. \"Where are your friends Bell?\"");
            String choice1 = "";
            if (choice.equals("1")) {
                if (player.getMoney() >= 4.00) {
                    player.addHonor(3);
                    player.subtractMoney(4.00);
                    displayMenu(player.getTotalMoney());
                    displayMenu("Samantha Bell: \"Trying to show off? Did we meet before? You look familiar.\"");
                    displayMenu("\"I'm new in town. I thought I could make some friends.\"");
                    displayMenu("Both of you drink.\n\n\"Bring us another round! I heard about that train hit, that must've been a hell of a score!\"");
                    displayMenu("Samantha Bell: \"It was, but its none of your business. Bartender! Bring us another round!\"");
                    boolean quit = false;
                    while (!quit) {
                        choice1 = getUserInput("1. \"I'm a good shot, you'll need someone like me on your journey. You are a wanted woman after all. Bring another round!\"  [$4.00]\n"
                                + "2. \"I think you are pretty.\"  [Kiss her]\n"
                                + "3. Shoot her bodyguard and slam her face on the counter. \"Where are your friends Bell?\"");
                        if (choice1.equals("1")) {
                            if (player.getMoney() >= 4.00) {
                                player.subtractMoney(4.00);
                                displayMenu(player.getTotalMoney());
                                displayMenu("Samantha Bell: \"I'm actually looking for people that can stand for themselves.\"\n"
                                        + "\"The gang wants new faces so we can take an even bigger score.\"");
                                displayMenu("\"I'm in, I need the money, you need an extra gun. I think we would make great partners. Another round bartender!\"");
                                displayMenu("Samntha Bell: \"It's not gonna be that easy. First, you need to kill someone for me.\"");
                                displayMenu("\"Who is it?\"");
                                displayMenu("Samantha Bell: \"My partner, Marcus \"Bullet\" Williams. He's a pain in the ass. Our boss Cross wants him dead, he's dangerous.\"\n"
                                        + "\"There's no chance you can take him out up front. He should be back any minute.\"\n"
                                        + "\"If you get this done, meet me at the New Bourdeaux port. We are going to rob a ship and flee to South America.\"");
                                displayMenu("The bodyguards pass out drunk.");
                                setDone(true);
                                quit = true;
                            } else {
                                displayMenu("Samantha Bell: \"Looks like you have no money little guy.\"");
                            }
                        } else if (choice1.equals("2")) {
                            displayMenu("Samantha Bell: \"Get your hands off me!\"\n\nShe draws her gun and shoots you in the face.");
                            displayDead(player);
                        } else if (choice1.equals("3")) {
                            quit = true;
                        } else {
                            displayMenu("You should kiss her.");
                        }
                    }
                } else {
                    displayMenu("Samantha Bell: \"Looks like you have no money little guy.\"");
                }
            } else if (choice.equals("2")) {
                displayMenu("She points a gun at you.\n\nSamantha Bell: \"Are you another one of those sheriff pigs? I thought I bought you all...");
                displayMenu("She shoots you.");
                displayDead(player);
            } else if (choice.equals("3") || choice1.equals("3")) {
                player.addDishonor(3);
                displayMenu("The other bodyguards draw their guns.\n\nBodyguard: \"Let her go or I'm going to put a bullet in your head.\"");
                displayMenu("Samantha Bell: \"I cannot believe I'm seeing a ghost. Cross said he was sure you were dead.\"\n"
                        + "\"What are you going to do now? Kill me? Go ahead I won't tell you anything!\"");
                displayMenu("The bodyguards point their guns at you.\n\n"
                        + "Bodyguard: \"Let her go, there are three of us and only one of you. we have people on top of you as well.\"");
                displayMenu("Red Hawk: \"Not anymore! Drop your weapons!\"");
                displayMenu("James: \"Drop them on the floor!\"");
                displayMenu("\"We only want her, you guys should leave before we shoot you dead.\"");
                displayMenu("Samantha Bell: \"If you kill Williams I'll tell you where Cross is. I don't trust neither of them.\"\n"
                        + "\"I'll help you recover the money, but you need to kill Williams first.\"");
                setDone(true);
            } else {
                displayMenu("Don't be shy.");
            }
        }
        part2(player);
    }

    @Override
    public void part2(Player player) {
        displayMenu("The doors open and someone walks in.\n\n"
                + "Stranger: \"He's here! " + player.getCharacterName() + " is here!\"\n"
                + "\"He fled from Paradise with \"Red Hawk\" and James is not in the gun shop. We must go now!\"");
        displayMenu("Samantha Bell: \"That's impossible Williams!\"");
        displayMenu("She looks at you.");
        displayMenu("Samantha Bell: \"You! You are alive!\"");
        displayMenu("You draw weapons and point it at Samantha and Williams.");
        setDone(false);
        while (!isDone()) {
            String choice = getUserInput("1. \"Drop your gun Williams, your friend wanted to hire me to kill you.\"\n"
                    + "2. \"Tell him what you just told me! She wanted to kill you Williams, join me against Cross! He will betray you as he betrayed me!\"\n"
                    + "3. \"You don't scare me Williams, only one of us is going to come out of here alive, and its gonna be me.\"  [Shoot Samantha and Williams]");
            if (choice.equals("1")) {
                player.addHonor(2);
                displayMenu("Samantha Bell: \"That's not true!\"");
                displayMenu("Marcus Williams: \"I knew your intentions Bell, I was going to kill you on the way to New Bourdeaux.\"");
                displayMenu("Williams starts shooting and you cover yourself with Samantha. She dies.");
                setDone(true);
            } else if (choice.equals("2")) {
                player.addHonor(2);
                displayMenu("Marcus Williams: \"I knew her intentions, but I tell you what. Both of you won't make it to New Bourdeaux.\"");
                displayMenu("Williams starts shooting and you cover yourself with Samantha. She dies.");
                setDone(true);
            } else if (choice.equals("3")) {
                player.addDishonor(2);
                displayMenu("Samantha dies. Williams takes cover behind a table and starts shooting at you.");
                setDone(true);
            } else {
                displayMenu("Kill them.");
            }
        }
        displayMenu("\"Red Hawk\" and you shoot at Williams who is under cover.");
        setDone(false);
        while (!isDone()) {
            String choice = getUserInput("1. \"Surrender Williams, we got you cornered. New Bourdeaux is your next stop? After that what? Cross is gonna set you up like he did me!\"\n"
                    + "2. \"Your plans at New Bourdeaux are gonna end tonight, because I’m gonna kill you and I’m sure as hell gonna kill Cross!\"");
            if (choice.equals("1")) {
                displayMenu("Marcus Williams: \"Cross said you wanted to flee with all the money! I didn’t have much of a choice so we throw you off the train! I will make sure you are dead this time!\"");
                setDone(true);
            } else if (choice.equals("2")) {
                displayMenu("Marcus Williams: \"Ha! You think you can kill me that easy? You people are dead!\"");
                setDone(true);
            } else {
                displayMenu("Dew it.");
            }
        }
        displayMenu("James comes into the saloon and spots Williams. They both shoot.\n"
                + "While they are at it, you rush on Williams. James drops to the ground.\n"
                + "You start a hand combat with Williams. He punches you hard enough to drop you on the ground and starts beating you.");
        displayMenu("Williams: \"Time to die " + player.getCharacterName() + ". I'm surprised you made it this far, but Cross and I have a boat to rob. I'll send him your regards.\"");
        setDone(false);
        while (!isDone()) {
            String choice = getUserInput("1. \"I'm not gonna die here!\" You headbutt him and kick him off of you.\n"
                    + "2. You bite his ear off and push him off of you.");
            if (choice.equals("1")) {
                setDone(true);
            } else if (choice.equals("2")) {
                displayMenu("Williams: \"Aahg, my ear!! You bastard! You are dead!\"");
                setDone(true);
            } else {
                displayMenu("You're gonna have to get him off somehow.");
            }
        }
        displayMenu("Williams reaches for his gun. James, on the floor, passes you his shotgun.");
        setDone(false);
        while (!isDone()) {
            String choice = getUserInput("1. Grab James' shotgun and shoot Williams.\n"
                    + "2. \"HELP!\" Williams points his gun at you.\n"
                    + "3. Grab your knife.");
            if (choice.equals("1")) {
                draw(player);
            } else if (choice.equals("2")) {
                player.addHonor(3);
                displayMenu("A tomahawk hits him in the head. You have \"Red Hawk\" to thank for that.");
                setDone(true);
            } else if (choice.equals("3")) {
                displayMenu("You try to throw your knife at Williams, but you are too slow and he shoots you.");
                displayDead(player);
            }
        }
        displayMenu("All of you take a moment to catch your breath.");
        displayMenu("\"James, are you alright?\"");
        displayMenu("James: \"I'm fine, he just got my shoulder.\"");
        setDone(false);
        while (!isDone()) {
            String choice = getUserInput("1. \"Thank you James, you did good.\"\n"
                    + "2. \"It’s all over now, they are both dead.\"\n"
                    + "3. \"You are just dead weight, you should’ve stayed home!\"");
            if (choice.equals("1") || choice.equals("2")) {
                player.addHonor(1);
                setDone(true);
            } else if (choice.equals("3")) {
                player.addDishonor(1);
                setDone(true);
            } else {
                displayMenu("Dew it.");
            }
        }
        displayMenu("\"Red Hawk\" and you get James up and head to the hideout.");
        displayMenu("Red Hawk: \"So our next stop is New Bourdeaux, we are getting close to our goal. We should move fast before word gets out there.\"");
        displayMenu("While \"Red Hawk\" puts the bandages on James. You start to strategize your next move.");
        saveGame(player, ch5, 5);
    }

    private void draw(Player player) {
        Timer timer = new Timer(1500, new ActionListener() {
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
            player.addDishonor(3);
            displayMenu("You killed Williams.");
            setDone(true);
        } else {
            displayDead(player);
        }
    }
}
