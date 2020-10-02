/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlawredemption;

import java.io.IOException;
import texasholdem.Poker;

/**
 *
 * @author cbran
 */
public class ChapterFive extends Chapter {

    @Override
    public void startChapter(Player player) {
        displayMenu("James: \"We should head to New Bourdeaux and check how we can get in that boat.\"");
        displayMenu("Red Hawk: \"Cross is an evil man, he put us in this situation. After the train robbery we were going to dismantle the gang, but his acts led us to where we are now.\"\n"
                + "\"We don’t have anywhere to go, we don’t have anything… We are wanted men, nobody likes us.\"\n"
                + "\"" + player.getCharacterName() + " deserves to know the truth and the key is Cross.\"");
        displayMenu("\"I don’t know my past, but what I know is that I want to live without the ghosts of my past haunting me.\"");
        setDone(false);
        while (!isDone()) {
            String choice = getUserInput("1. \"I want to talk face to face to Cross. It’s the only way to know the truth of it all. I still believe we all can get what we want without spilling more blood.\"\n"
                    + "2. \"I’m going to turn him into the police, it can be the only way to clean my name and start again.\"\n"
                    + "3. \"Cross is a dead man, when I see him I won’t hesitate to put him out of his miserable life. I’m going to take that boat with all the money and disappear.\"");
            if (choice.equals("1") || choice.equals("2") || choice.equals("3")) {
                setDone(true);
            } else {
                displayMenu("Dew it.");
            }
        }
        displayMenu("James: \"Fair enough, you can count on me.\"");
        displayMenu("Red Hawk: \"We should go now.\"");
        displayMenu("The three of you packed the weapons and equipment and headed to the last objective, New Bourdeaux.");
        displayMenu("Red Hawk: \"Remember that we are wanted men, except for you James. When we get close to the city you should go ahead and check for safe passages for us.\"\n"
                + "\"It’s only been a few days since the robbery and police are going to be patrolling everywhere.\"");
        displayMenu("It took a day to get to New Bourdeaux.");
        displayMenu("\"Alright James, you go ahead, we’ll wait for you in that old building next to the rails.\"");
        displayMenu("\"James left, and you and \"Red Hawk\" head to the old building to wait for him.\"");
        displayMenu("Red Hawk: \"It looks abandoned, let’s check inside, we might find something.\"");
        displayMenu("You two enter the building, there’s nothing inside. It was an old sugar factory.\n"
                + "Suddenly, you hear the noise of someone stepping onto cracked glass.");
        part1(player);
    }

    @Override
    public void part1(Player player) {
        setDone(false);
        while (!isDone()) {
            String choice = getUserInput("1. You signal Red Hawk to go check the noise.\n"
                    + "2. You head to check the noise.\n"
                    + "3. \"Come on out!! We are armed, you don’t want to mess with us.\"");
            if (choice.equals("1")) {
                displayMenu("\"Red Hawk\" moves silently and checks every corner, nobody is there.");
                setDone(true);
            } else if (choice.equals("2")) {
                displayMenu("You move silently and check every corner, nobody is there.");
                setDone(true);
            } else if (choice.equals("3")) {
                displayMenu("Nobody responds.");
                setDone(true);
            } else {
                displayMenu("Dew it.");
            }
        }
        displayMenu("You two look at each other, wondering who else is in the building.");
        displayMenu("Stranger: \"Hey boss!!\"");
        displayMenu("You turn your head to the voice and someone hits you in the back of the head, leaving you unconscious.");
        displayMenu("A few minutes pass and you wake up tied up at the center of the building. At your side, \"Red Hawk\" is tied up too.");
        displayMenu("Stranger: \"Well well, so the stories are right. The man that came back from the dead. It’s a pleasure to see you again boss.\"");
        displayMenu("You look at him, you recognize him from the posters. It’s Andrew \"The Kid\" Evans.\n"
                + "The man behind him is other " + player.getGangName() + " member, Gustavo Correa.");
        displayMenu("Gustavo Correa: \"Look at you boss, I can’t believe how easy it was to get you. Too bad Cross can’t be here to see this.\"");
        setDone(false);
        while (!isDone()) {
            String choice = getUserInput("1. \"Tell Cross to come here, I just want to speak with him.\"\n"
                    + "2. \"You tell Cross that he is a coward, and I’m gonna finish him when I see him.\"");
            if (choice.equals("1")) {
                displayMenu("Correa: \"Not gonna happen, he’s already on the boat.\"");
                setDone(true);
            } else if (choice.equals("2")) {
                displayMenu("Correa: \"I don’t think that’s gonna happen, we are planning to blow this whole building up with you two inside.\"");
                setDone(true);
            } else {
                displayMenu("Dew it.");
            }
        }
        displayMenu("Correa: \"Everything would’ve been perfect if you hadn’t softened up. Ever since you laid eyes on that damn Blackwall’s sister you got weaker.\"\n"
                + "\"You weren’t the same anymore. We tried to help you but you wouldn't listen.\"\n"
                + "\"When we went to their manor, you wanted to apologize and go our separate ways. That’s when Cross pulled the trigger and killed that son of a bitch.\"\n"
                + "\"You know there’s no way out of this life. We convinced you to stay with us, and you did, we were surprised you accepted to rob the train of your brother in law.\"\n"
                + "\"When we got our hands on our prize you knew you would find the bonds that belonged to Blackwall’s, and you wanted to give those bonds to your beloved and escape with her.\"\n"
                + "\"We didn’t want to do what we did but we pushed you off the train and you fell to the river. We were a gang, and your selfish acts led us to make the decisions you should’ve made for our common good.\"");
        setDone(false);
        while (!isDone()) {
            String choice = getUserInput("1. \"I’m sorry for everything. I’m a different man now, there’s no need to do this.\"\n"
                    + "2. \"There was a way out for all of us, we can still make it. Help me against Cross and we will win this time for sure.\"\n"
                    + "3. \"You guys are dumb as hell. I can’t believe how fortunate I am of not riding with you anymore.\"");
            if (choice.equals("1")) {
                displayMenu("Correa: \"There’s no need to keep you alive.\"");
                setDone(true);
            } else if (choice.equals("2")) {
                displayMenu("Correa: \"We don’t trust you anymore boss, Cross is our leader now.\"");
                setDone(true);
            } else if (choice.equals("3")) {
                displayMenu("The Kid: \"Shut up fool! You should be more careful with what you say! Remember who is tied up.\"");
                setDone(true);
            } else {
                displayMenu("Dew it.");
            }
        }
        displayMenu("Red Hawk: \"How did you know we were coming?\"");
        displayMenu("The Kid: \"I was at the saloon on Big Mammoth when you guys made a scene. Cross told me to follow Bell and spy on her and Williams.\"\n"
                + "\"Our boss didn’t trust them, they weren’t happy when Cross pushed you off the train and we suspected that they wanted to take over the gang.\"");
        displayMenu("Red Hawk: \"I should’ve thought about it, you were good by being undetected.\"");
        part2(player);
    }

    @Override
    public void part2(Player player) {
        displayMenu("Correa: \"Ready Kid? Let’s burn this place.\"");
        displayMenu("Both Correa and \"The Kid\" light moonshine bottles and start throwing them all over the place.\n"
                + "In a matter of seconds the whole building was on fire.");
        displayMenu("The Kid: \"This will distract the police and dispose of these scum. Let’s go now!\"");
        displayMenu("Correa and \"The Kid\" leave while you and \"Red Hawk\" are trying to get untied to get out of there.");
        setDone(false);
        while (!isDone()) {
            String choice = getUserInput("1. Move side to side to untie the ropes.\n"
                    + "2. Try to get a piece of broken glass to cut the ropes.\n"
                    + "3. \"This is all your fault Red Hawk! We shouldn’t have entered here in the first place! HEEEELP!!\"");
            if (choice.equals("1")) {
                displayMenu("Nothing happens.");
                setDone(true);
            } else if (choice.equals("2")) {
                displayMenu("You are not tall enough.");
                setDone(true);
            } else if (choice.equals("3")) {
                displayMenu("Red Hawk: \"There’s nothing I can do now! HEEELP!\"");
                setDone(true);
            } else {
                displayMenu("Dew it.");
            }
        }
        displayMenu("Suddenly you hear the ropes cut, and your hands are free. You stand up quickly and see James cutting \"Red Hawk’s\" ropes.");
        setDone(false);
        while (!isDone()) {
            String choice = getUserInput("1. \"Perfect timing James! I thought we were dead already.\"\n"
                    + "2. \"Hurry up James! There’s no time to waste!\"\n"
                    + "3. Sprint to the exit!");
            if (choice.equals("1") || choice.equals("2") || choice.equals("3")) {
                setDone(true);
            } else {
                displayMenu("Dew it.");
            }
        }
        displayMenu("The three of you got out of the building safely.\n"
                + "James takes the two of you through an alley and remain unseen while civilians and lawmen reach the building on fire.");
        displayMenu("Red Hawk: \"Get us to the port James! We need to get there before they do.\"");
        displayMenu("You reach the port of New Bourdeaux, security has lowered since some of the patrols went to check the old building on fire.");
        displayMenu("The boat is a cruise with a casino inside.\n"
                + "It has a lot of money but it’s going to be hard to rob the boat and escape from the boat in the middle of the ocean.");
        displayMenu("James: \"Whatever you want to do, we should come up with a plan quick. There’s no going back now.\"");
        displayMenu("Red Hawk: \"We should separate, the three of us together will draw too much attention.\"\n"
                + "\"I’m gonna hide beneath the pier and climb through the anchor. Let’s meet at the casino.\"");
        displayMenu("James: \"Take my weapons with you, I’m going to pay for a ticket and enter the boat as a regular civilian.\"");
        setDone(false);
        while (!isDone()) {
            String choice = getUserInput("1. \"I’ll subdue a guard and take his clothes.\"\n"
                    + "2. \"I'll hide in one of the crates.\"\n"
                    + "3. \"I think I’ll wait.\"");
            if (choice.equals("1")) {
                displayMenu("You are now with the guard’s clothes and sneak into the ship without problems.");
                setDone(true);
            } else if (choice.equals("2")) {
                displayMenu("You hide in the crate and do not get detected by the guards.");
                setDone(true);
            } else if (choice.equals("3")) {
                displayMenu("James and Red Hawk: \"Quit playing around!!\"");
            } else {
                displayMenu("Dew it.");
            }
        }
        displayMenu("Once in, you go to the casino. \"Red Hawk\" and James are already there.");
        displayMenu("Red Hawk: \"There’s no sign of Cross yet.\"");
        displayMenu("James: \"I’m gonna check the bar to see if there’s something suspicious and I’ll get back with you.\"");
        displayMenu("Red Hawk: \"Good idea, I’ll go look for a way out.\"");
        setDone(false);
        while (!isDone()) {
            int amountOfBeer = 0;
            String choice = getUserInput("1. Go to the bar.\n2. Go look for the safe.");
            if (choice.equals("1")) {
                boolean done2 = false;
                while (!done2) {
                    if (amountOfBeer > 4) {
                        amountOfBeer = 0;
                        displayMenu("Dealer: \"You can't sleep on the card table sir.\"");
                    } else {
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
                            if (player.getMoney() > 1.0) {
                                Poker.start(player);
                            } else {
                                displayMenu("You do not have enough money to play dice.");
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
                }
            } else if (choice.equals("2")) {
                displayMenu("\"I'll look for the safe, there's a high chance of finding it here.\"");
                setDone(true);
            }
        }
        displayMenu("You start looking for the captain’s cabin. The safe should be over there.\n"
                + "You see the cabin’s door slightly ajar, when you peer in you immediately see the safe.");
        if (player.getHonorPoints() > -15 && player.getHonorPoints() < 15) {
            displayMenu("You get in the room. Nobody is around.\n"
                    + "You take the money and put it in a bag\n"
                    +"You head outside the captain's cabin");
            displayMenu("Cross:\"Well, well, look what we've got here. The man that is trying to ruin my plans. None other than my former partner" + player.getCharacterName() +"\"");
            displayMenu("Cross and his men got Red Hawk and James");
            displayMenu("Cross:\"Hand us the money and we won't hurt your friends.");
            displayMenu("Cross and his men are pointing their guns at you. \n"
                    +"You look at Red Hawk and James.\n"
                    +"They know what you are about to do.");
            displayMenu("You: \"Fine, you can have the money Cross.\"");
            displayMenu("You throw the bag with the money.\n"
                    +"While you throw the bag, you draw your weapon and shoot at Cross and his crew.\n"
                    +"While The Kid and Correa go for the bag, Cross shoots at you.\n"
                    +"The only ones that didn't get in the crossfrire were Red Hawk and James.");
            displayMenu("Red Hawk and James go to aid you)");
            displayMenu("Red Hawk: \"" + player.getCharacterName() + ", why did you do this?\"");
            displayMenu("You got shot several times, you are now laying on the floor with enough strength to tell your companions your last words.");
            displayMenu("You:\"Take the money and find somewhere else to start... Our story ends here... tonight.");
            displayMenu("Red Hawk and James were saved by your act, they left with the money and started a new gang with your name as a tribute.");
            player.addDeath();
        } else if (player.getHonorPoints() >= 15) {
            displayMenu("You get in the room. The captain is inside looking at you. Suddenly a gun is pointing at your head.");
            displayMenu("Stranger: \"Not so far,\"" + player.getCharacterName() + "\". Looking for Cross? He's at the casino right now.\n"
                    + "Before you two have your little reunion, I have an offer for you.\n"
                    + "Bring us Cross, and you current companions and you won't face any charges. Either that or we take you right here, right now.");
            displayMenu("You: \"Who are you?\"");
            displayMenu("Stranger:\"I'm agent Roberts, head agent of the Pinkerton agency. We don't have to be enemies Mr." + player.getCharacterName() + "\"\n"
                    + "\"Let's skip the formalities and bring me Cross would you?\"");
            displayMenu("You:\"Fine, I don't have much of a choice.");
            displayMenu("Agent Roberts:\"You are smart Mr." + player.getCharacterName() + ". I like you, that's why I'm giving you a chance to do the right thing.\"\n"
                    + "This opportunity won't come twice.");
            displayMenu("You head to the casino, Red Hawk gets next to you.");
            displayMenu("Red Hawk: Pinkerton agents are over the place, they offered us a deal...");
            displayMenu("You:\" I know, I'm gonnna take the deal Red Hawk... We won't be wanted anymore and Cross will be executed.");
            displayMenu("Red Hawk: \"Whatever happens, James and I will follow you. The man that's sitting in the poker's table is Cross, he has a scar in his face.");
            displayMenu("You: \"I'll meet you at the captain's cabin.\"");
            displayMenu("You sit by Cross, and start playing poker.\n"
                    +"He recognizes you. He whispers to you.");
            displayMenu("Cross: \"It seems my men can't dispose of a cockroach like you.\n"
                    + "Soon we will find the safe and be gone, but before that, I'm gonna make sure you won't follow us anymore");
            displayMenu("You:\"Your men got caught by the Pinkertons, this whole ship is crowded by them. The only way to get out is if we join forces together.\"\n"
                    + "\"After that, you won't hear about me anymore.\"");
            displayMenu("Cross: \"How do I know you are not lying");
            displayMenu("You: \"I know you've seen them already, that guy at the bar. He is a Pinkerton, the guy wandering around the other table, is another one.");
            displayMenu("Cross looks around, you notice he is sweating.");
            displayMenu("You: \"I know where the safe is");
            displayMenu("Cross: \"Fine,if you try to do something. I'll shoot you dead.\"");
            displayMenu("You left the game with Cross. You two head to the captain's cabin.");
            displayMenu("Once in, the Pinkertons show up and get Cross.");
            displayMenu("Cross: \"Unbelievable, you are a rat. I could never imagined that you were working with these rats.");
            displayMenu("Agent Roberts: \"It's over Cross, he made a wise choice, you didn't. You caused us a lot of trouble these past weeks.\"\n"
                    + " The people will be happy to see you hanged.");
            displayMenu("The Pinkertons take Cross and leave the room.");
            displayMenu("Agent Roberts: \"Thank you Mr." + player.getCharacterName() + "\"\n"
                    + "\"You and your crew are now free men. We will take care of our friend Cross.");
            displayMenu("You: \"James, Red Hawk... Let's go");
            displayMenu("Once the ship got back to the port. You and ypour crew head to the West, where the three of you start working as bounty hunters.");
        } else if (player.getHonorPoints() <= -15) {
            displayMenu("When you get in the room, the captain's body is laying on the floor and Cross is waiting for you inside.");
            displayMenu("Cross:\"Finally, we meet again \"" + player.getCharacterName() + "\"\n"
                    + "\"I know it was you the one that escaped from Paradise, and I know it was you the one that killed Samantha and Williams.\"\n"
                    + "\"I'm impressed you made it this far, but your luck ends here...\"\n"
                    + "\"We got your friends and you have nowhere to run...\"\n");
            displayMenu("Cross draws his weapon and points it at you.\n"
                    + "The Kid brings James inside");
            displayMenu("Cross:\"Where's Correa?\"");
            displayMenu("The Kid: \"\"Red Hawk\" put in a fight... they both fell to the sea");
            displayMenu("Cross: \"Better, one person less to share our cut. Now... let's get rid of these scum\"");
            displayMenu("The Kid shoots James right in front of you, while Cross stands up and get closer to you.\n"
                    + "He gets his gun on your forehead.");
            displayMenu("Cross: \"I win\"");
            displayMenu("You see a figure standing up in the back, it's the captain\n"
                    + "He takes his gun a shoots The Kid in the head.");
            displayMenu("Captain:\"Get away from my ship!\"");
            displayMenu("Cross quickly reacts and shoots at the captain.\n"
                    + "Now is your moment, you grab Cross and make him drop his gun. You two start fighting and fall on the floor.\n"
                    + "You pull your knife and stab Cross in his chest.\n"
                    + "The battle is over. You stand up and spit on him.");
            displayMenu("You:\"I win.\"");
            displayMenu("You go to the safe and put all the money in a bag. It is a matter of time for the guards to show up so you get out of the room quickly and hide in one of the lifeboats.\n"
                    + "You cut the rope and drop the safeboat with you inside on the water. You can see the sunrise in the horizon.\n"
                    + "You don't know what your next step is, but you feel your goal is fullfilled and can't help but smile while thinking that you got your revenge and escaped with all the money.");

        } else {
            displayMenu("I don't know how you are seeing this.");
        }
        displayMenu("THE END");
        ending(player);
        saveGame(player, 6);
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

    public void saveGame(Player player, Integer ch) {
        boolean quit = false;
        while (!quit) {
            String selection = getUserInput("Would you like to save your game? (Y or N)");
            if (selection.equalsIgnoreCase("y")) {
                player.setChapter(ch);
                try {
                    File.saveGame(player);
                } catch (IOException ex) {
                    displayMenu("IOException thrown.");
                }
                quit = true;
            } else if (selection.equalsIgnoreCase("n")) {
                quit = true;
            } else {
                displayOptionError();
            }
        }
    }
}
