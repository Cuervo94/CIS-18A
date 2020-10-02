/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlawredemption;

import texasholdem.Poker;

/**
 *
 * @author cbran
 */
public class ChapterThree extends Chapter {

    ChapterFour ch4 = new ChapterFour();

    @Override
    public void startChapter(Player player) {
        displayMenu("\"\"Red Hawk!\" I'm here, step back this is gonna get messy.\" [-1 dynamite]\n");
        player.subtractDynamite(1);
        displayMenu("A big explosion opens a hole in the wall and all the prisoners are escaping, including \"Red Hawk\" who follows you.\n"
                + "Locals and lawmen are now alerted.\n"
                + "You and \"Red Hawk\" get on the horse and run away.\n");
        displayMenu("\"Where should we go now?\"\n");
        displayMenu("Red Hawk: \"Let's go north, it will give us some time so we can prepare for what is coming, there's a town called Big Mammoth.\"\n"
                + "\"One of our gang members was supposed to finish a job over there.\"\n");
        displayMenu("You are pursued by 3 lawmen of Paradise.\n"
                + "Red Hawk: \"Give me a gun, I can help!\"");
        setDone(false);
        while (!isDone()) {
            String choice = getUserInput("1. \"Here's my revolver, we need to take them out fast!\"\n"
                    + "2. \"I ain't giving you my gun! Here's some dynamite.\"  [-3 dynamite]");
            if (choice.equals("1")) {
                displayMenu("You hand your gun to \"Red Hawk.\"");
                setDone(true);
            } else if (choice.equals("2")) {
                displayMenu("You give \"Red Hawk\" some dynamite.");
                player.subtractDynamite(3);
                setDone(true);
            } else {
                displayMenu("You gotta give him something man.");
            }
        }
        displayMenu("Red Hawk manages to dispose of the three lawmen.\n");
        part1(player);
    }

    @Override
    public void part1(Player player) {
        displayMenu("Red Hawk: \"You seem a little bit off.\"");
        setDone(false);
        while (!isDone()) {
            String choice = getUserInput("1. \"I can't remember anything, not even my own name. Mind if I ask what happened? Seems everybody is talking about that train robbery.\"\n"
                    + "2. \"I woke up at the shore of a river and I still don't know how I ended up there. What happened?\"\n"
                    + "3. \"I don't need to give you explanations, I demand some answers!\"");
            if (choice.equals("1") || choice.equals("2")) {
                player.addHonor(2);
                setDone(true);
            } else if (choice.equals("3")) {
                player.addDishonor(2);
                setDone(true);
            } else {
                displayMenu("I swear if you don't pick something.");
            }
        }
        displayMenu("Red Hawk: \"Well, it's kind of a long story. You had a quarry with Vinicius Blackwall, a powerful man that owns the oil company of the West of the US.\"\n"
                + "\"We've been hitting Blackwall trains the past year, everything was going as planned until the Pinkertons showed up.\"");
        displayMenu("Hours later you enter the mountains on your way to Big Mammoth.\n"
                + "It starts snowing and Red Hawk guides you to an old gang hideout.");
        displayMenu("The hideout is under a gun shop of the town.\nThe guy awaiting your arrival hugs “Red Hawk” and you both.");
        displayMenu("\"" + player.getCharacterName() + ", the man of the hour, I cannot believe what I see.\"\n"
                + "\"Everybody is saying that you died back in New Bourdeaux. When you guys left this hideout, I could never imagine I would see you again.\"\n"
                + "\"What drives you to come back to this freezing hell?\"");
        displayMenu("Red Hawk: \"He lost his memory in the incident. Look James, there’s no time.\"\n"
                + "\"The rest of the gang played us. You think we could stay here for a couple days?\"\n"
                + "\"After all this… you won’t owe us anything anymore. In fact, we need your help with something.\"");
        setDone(false);
        while (!isDone()) {
            String choice = getUserInput("\"Red Hawk\" explains the whole situation to the gun owner named James.\n\n"
                    + "1. \"It seems the gang thought about this since the beginning. Cross has all of our money; we need some guns.\"\n"
                    + "2. \"If you were part of the gang. All of this is mine, give me the guns! I'm gonna get my gaddamn money!\"");
            if (choice.equals("1")) {
                player.addHonor(1);
                displayMenu("James: \"You guys can take anything you want.\"");
                setDone(true);
            } else if (choice.equals("2")) {
                player.addDishonor(1);
                displayMenu("James: \"No need to fight. After all, you bought this place.\"");
                setDone(true);
            } else {
                displayMenu("Pick one of the options.");
            }
        }
        part2(player);
    }

    @Override
    public void part2(Player player) {
        displayMenu("Red Hawk: \"I know you were close with Samantha, she's a wanted woman now.\"\n"
                + "\"She is the key to get to Cross. Any idea where she might be?\"");
        displayMenu("James: \"You might actually be lucky; I saw her at the saloon last night.\"\n"
                + "\"She was spending money like crazy. I thought after the train hit she would come to her hometown and I was right.\"\n"
                + "\"She was accompanied by a local family, a crazy bunch I must say, and \"Bullet\" Williams was there too.\"\n"
                + "\"I'd be careful if I was you. I wouldn't want that gunslinger as an enemy.\"");
        setDone(false);
        while (!isDone()) {
            String choice = getUserInput("1. \"Let's go to the saloon. I'm gonna ask a few questions. \"Red Hawk\", you know where to meet me. James, can you get us some guns and ammo?\"\n"
                    + "2. \"I'm heading to the saloon. James, get some guns and wait for us outside the saloon. \"Red Hawk\", meet me over there, I need to do something first.\"\n"
                    + "3. \"Enough of this chit chat. Let's go talk to that bitch. James, get me the biggest gun you have and let's shoot the place up. I will meet both of you at the saloon.\"\n");
            if (choice.equals("1") || choice.equals("2")) {
                player.addHonor(2);
                setDone(true);
            } else if (choice.equals("3")) {
                player.addDishonor(2);
                setDone(true);
            } else {
                displayMenu("How hard is it to enter 1, 2, or 3?");
            }
        }
        int amountOfBeer = 0;
        setDone(false);
        while (!isDone()) {
            String choice = getUserInput("1. Confront Samantha Bell.\n2. Buy beer  [$0.50]\n3. Buy whiskey  [$0.75]\n4. Play Blackjack\n5. Play Poker\n6. Play Dice\n7. Play Rock, Paper, Scissors");
            if (amountOfBeer > 4) {
                amountOfBeer = 0;
                displayMenu("Bartender: \"Excuse me sir, you can't sleep on the counter.\"");
            } else {
                if (choice.equals("1")) {
                    setDone(true);
                } else if (choice.equals("2")) {
                    amountOfBeer++;
                    buyItem(player, "You feel a little buzz.", 0.50, "beer");
                } else if (choice.equals("3")) {
                    amountOfBeer++;
                    buyItem(player, "You feel a little burn in your throat.", 0.75, "whiskey");
                } else if (choice.equals("4")) {
                    if (player.getMoney() > 0.0) {
                        BlackJack.run(player);
                    } else {
                        displayMenu("You do not have enough money to play blackjack.");
                    }
                } else if (choice.equals("5")) {
                    if (player.getMoney() > 1.0) {
                        Poker.start(player);
                    } else {
                        displayMenu("You do not have enough money to play poker.");
                    }
                } else if (choice.equals("6")) {
                    if (player.getMoney() > 1.0) {
                        DiceGame.run(player);
                    } else {
                        displayMenu("You do not have enough money to play dice.");
                    }
                } else if (choice.equals("7")) {
                    RockPaper.run(player);
                } else {
                    displayMenu("You should buy 5 beers or whiskey.");
                }
            }
        }
        saveGame(player, ch4, 4);
    }

    public void buyItem(Player player, String menu, Double amount, String item) {
        if (player.getMoney() >= amount) {
            player.addDrink();
            player.subtractMoney(amount);
            displayMenu(menu);
            displayMenu(player.getTotalMoney());
        } else {
            displayMenu("Bartender: \"We do not serve free " + item + ".\"");
        }
    }
}
