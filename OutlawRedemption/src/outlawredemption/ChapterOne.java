/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlawredemption;

import texasholdem.Poker;

/**
 *
 * @author Norco College
 */
public class ChapterOne extends Chapter {

    ChapterTwo ch2 = new ChapterTwo();

    @Override
    public void startChapter(Player player) {
        setDone(false);
        while (!isDone()) {
            String choice = getUserInput("1. Check Wanted Posters\n2. Buy newspaper from the kid at the corner  [$0.30]\n");
            if (choice.equals("1")) {
                checkPosters(player);
                setDone(false);
                while (!isDone()) {
                    choice = getUserInput("1. Buy newspaper from kid in the corner  [$0.30]\n");
                    if (choice.equals("1")) {
                        buyNewspaper(player);
                    } else {
                        displayMenu("Just get the damn newspaper.");
                    }
                }
            } else if (choice.equals("2")) {
                buyNewspaper(player);
                setDone(false);
                while (!isDone()) {
                    choice = getUserInput("1. Check Wanted posters\n");
                    if (choice.equals("1")) {
                        checkPosters(player);
                    } else {
                        displayMenu("You may want to check the wanted posters.");
                    }
                }
            } else {
                displayMenu("Pick one of them.");
            }
        }
        part1(player);
    }

    @Override
    public void part1(Player player) {
        setDone(false);
        while (!isDone()) {
            String choice = getUserInput("1. Go to the saloon.\n2. Go to the prison.\n");
            if (choice.equals("1")) {
                int amountOfBeer = 0;
                boolean done2 = false;
                while (!done2) {
                    if (amountOfBeer > 4) {
                        displayMenu("A pig wakes you up in the stables.");
                        break;
                    }
                    choice = getUserInput("1. Buy beer  [$0.50]\n2. Buy whiskey  [$0.75]\n3. Play Blackjack\n4. Play Poker\n5. Play Dice\n6. Play Rock, Paper, Scissors\n7. Leave");
                    if (choice.equals("1")) {
                        amountOfBeer++;
                        buyItem(player, "You feel a little buzz.", 0.50, "beer");
                    } else if (choice.equals("2")) {
                        amountOfBeer++;
                        buyItem(player, "You feel a little burn in your throat.", 0.75, "whiskey");
                    } else if (choice.equals("3")) {
                        if (player.getMoney() > 0.0) {
                            BlackJack.run(player);
                        } else {
                            displayMenu("You do not have enough money to play blackjack.");
                        }
                    } else if (choice.equals("4")) {
                        if (player.getMoney() > 0.0) {
                            Poker.start(player);
                        } else {
                            displayMenu("You do not have enough money to play poker.");
                        }
                    } else if (choice.equals("5")) {
                        if (player.getMoney() > 1.0) {
                            DiceGame.run(player);
                        } else {
                            displayMenu("You do not have enough money to play dice.");
                        }
                    } else if (choice.equals("6")) {
                        RockPaper.run(player);
                    } else if (choice.equals("7")) {
                        done2 = true;
                    } else {
                        displayMenu("You should buy 5 beers or whiskey.");
                    }
                }
            } else if (choice.equals("2")) {
                boolean done2 = false;
                while (!done2) {
                    choice = getUserInput("You go to the back of the prison and check who they have behind the bars. You see a Native American resting on the floor, beaten up.\n\n"
                            + "1. \"Hey you \"Red Hawk\"\".\n"
                            + "2. \"Psssst.\"\n"
                            + "3. Throw a rock at him.\n");
                    if (choice.equals("1")) {
                        displayMenu("Red Hawk: \"" + player.getCharacterName() + "? I thought you were dead. What are you doing here?\"");
                        done2 = true;
                        setDone(true);
                    } else if (choice.equals("2")) {
                        displayMenu("He didn't listen to you.");
                    } else if (choice.equals("3")) {
                        displayMenu("You hit im in the head.\n"
                                + "Red Hawk: \"Aaahg, what the hell? " + player.getCharacterName() + "? I thought you were dead. What are you doing here?\"");
                        done2 = true;
                        setDone(true);
                    } else {
                        displayMenu("You have to get his attention.");
                    }
                }
            } else {
                displayMenu("Check out the prison.");
            }
        }
        part2(player);
    }

    @Override
    public void part2(Player player) {
        setDone(false);
        while (!isDone()) {
            String choice = getUserInput("1. \"I'm gonna get you out of here.\"\n"
                    + "2. \"I don't remember anything. The train robbery from yesterday? What happened?\"\n"
                    + "3. \"I don't know who you are, but if you want to get out of here I want some explanations. NOW!\"\n");
            if (choice.equals("1")) {
                displayMenu("Red Hawk: \"There's no way out of here unless you blow up a hole in the wall.\"\n"
                        + "\"There's a stash of dynamite we hide in the bushes before the train robbery.\"\n"
                        + "\"It's near the post office of the city, maybe you could steal some and come back.\"");
                player.addHonor(2);
                setDone(true);
            } else if (choice.equals("2")) {
                displayMenu("Red Hawk: \"There's a lot to explain, we don't have time for this, that damned Cross, he played us all.\"\n"
                        + "\"There's a stash of dynamite we hid in the bushes before the train robbery.\"\n"
                        + "\"It's near the post office of the city, maybe you could steal some and come back.\"");
                setDone(true);
            } else if (choice.equals("3")) {
                displayMenu("Red Hawk: \"There's no time for this! Look, there's a stash of dynamite near the post office of this town.\"\n"
                        + "\"Get some and get me out of here and I'll explain everything.\"");
                player.addDishonor(2);
                setDone(true);
            } else {
                displayMenu("Just talk to him.");
            }
        }
        saveGame(player, ch2, 2);
    }

    private void checkPosters(Player player) {
        displayMenu("Wanted posters:\n"
                + "William \"Claw\" Cross, right hand of " + player.getCharacterName() + ", involved in the train robbery to New Bourdeaux, numerous bank robberies in the West of the US.\n"
                + "Wanted for the murder of the Grayson family. He has a big scar in his face. If seen, contact the local sheriff immediately.\n"
                + "Wanted DEAD or ALIVE.\n\n"
                + "Gustavo Correa, involved in the train robbery to New Bourdeaux, kidnapping and killing of his wife. Wanted because of his atrocious killings.\n"
                + "Wanted DEAD or ALIVE.\n\n"
                + "Marcus \"Bullet\" Williams was a former slave, involved in the train robbery to New Bourdeaux.\n"
                + "Dangerous gunslinger, he has been involved in more than 10 deaths the past year.\n"
                + "Wanted DEAD or ALIVE\n\n"
                + "Andrew \"The Kid\" Evans, youngest one of the " + player.getGangName() + ", he is the only one that has never been caught.\n"
                + "Persuasive and smart, was also involved in the train robbery to New Bourdeaux.\n"
                + "REWARD $500\n\n"
                + "Samantha Bell, the most dangerous woman of the gang, former bounty hunter. She was present in the train robbery to New Bourdeaux. She is armed.\n"
                + "REWARD $500");
        setDone(true);
    }

    private void buyNewspaper(Player player) {
        player.subtractMoney(0.30);
        displayMenu("You buy the recent newspaper from the kid.\n\n"
                + "\"The " + player.getGangName() + " Hits Another Train\". This incident that happened around 3:00 PM in the day of yesterday left 10 civilians wounded, including the driver, and 4 lawman dead.\n"
                + "The gang took possession of $50,000 from the train that belong to Vinicius Blackwall, who was found dead at his residence in Cloverdale three days ago.\n"
                + "The capture of one of the men of the " + player.getGangName() + " may provide more information to the sheriff on the whereabouts of the gang.\n"
                + "For further questioning, \"Red Hawk\" will be transferred from the town of Paradise to New Bourdeaux State Prison.\n"
                + "There are no charges against \"Red Hawk\" yet, this information will be provided tomorrow by the New Bourdeaux Chief Police Officer tomorrow at 10:00 AM.\n\n"
                + "\"I need to know what happened. Red Hawk is my only chance to understand what's going on\".");
        displayMenu(player.getTotalMoney());
        setDone(true);
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
