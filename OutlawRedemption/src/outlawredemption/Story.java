/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlawredemption;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Norco College
 */
public class Story {

    ChapterOne ch1 = new ChapterOne();
    ChapterTwo ch2 = new ChapterTwo();
    ChapterThree ch3 = new ChapterThree();
    ChapterFour ch4 = new ChapterFour();
    ChapterFive ch5 = new ChapterFive();

    public void mainStory(Player player) {
        displayMenu("You wake up at the shore of a river, all of your clothes are wet and your only belongings are: a gold revolver with engravings, $50, and a gold pocket watch.\n");
        displayMenu("You stare at your relfection in the water. You don't recognize yourself. You can't remember anything, not even your own name.\n");
        displayMenu("You start walking the main road and find a sign post pointing to the closest town, Paradise. It will take 1 hour to get there.\n");
        displayMenu("You arrive at Paradise, you see there's a lot of common people, and with your current looks you will fit in properly. You check your watch. It's 1:00 PM\n");
        displayMenu("You enter the saloon and pay $3.00 for the special. You hear people talking about a recent event.\n");
        player.subtractMoney(3.00);
        displayMenu("Stranger 1: \"Did you see today's newspaper? The " + player.getGangName() + " got involved in the train robbery of the Blackwall Oil company, they say they got away with $50,000!!\"\n");
        displayMenu("Stranger 2: \"Well, I heard it wasn't that pretty, the bridge going to New Bordeaux was blown up and the train fell into the river. Pinkertons were all over the place and got two of them.\"\n");
        displayMenu("Stranger 1: \"I heard, they don't know where the rest of the gang is, their leader, yeah, " + player.getCharacterName() + " it is.\"\n"
                + "\"He is the most wanted man in the country, have you seen the wanted posters in town? He is wanted dead or alive.\"");
        displayMenu("After hearing this conversation you head outside the saloon and check one of the wanted posters. There's 5 of them, all from the infamous " + player.getGangName() + ".\n");
        ImageIcon icon = new ImageIcon("wanted_poster.jpg");
        displayMenuIcon("One of them caught your attention, it has a picture of yourself.\n"
                + player.getCharacterName() + " Wanted DEAD or ALIVE\n"
                + "He is extremely dangerous. He is armed. He is wanted for the murder of Vinicius Blackwall, the violent murders of the Grayson family, train robbery, bank robbery, extorsion, avoiding the law.\n"
                + "He is the leader of the most wanted gang, " + player.getGangName() + ". If captured or seen, report to the closest Sheriff immediately.\n", icon);
        displayMenu("Your story begins here. Based on your choices you will get different outcomes and will shape the story the way you want it.\n"
                + "Depending on your choices you will get Honorable or Dishonorable points, this will affect your story and your ending.\n"
                + "From now on you will decide how the story will continue.\n");
        ch1.startChapter(player);
    }

    public void resume(Player player) {
        if (player.getChapter() == 2) {
            displayMenu("Last you left off:\n\nYou recently found \"Red Hawk\" in the prison and he wants you to get some dynamite in order to break him out.");
            ch2.startChapter(player);
        } else if (player.getChapter() == 3) {
            displayMenu("Last you left off:\n\nYou have acquired the dynamite and a horse and now it is time to break \"Red Hawk\" out of prison.");
            ch3.startChapter(player);
        } else if (player.getChapter() == 4) {
            displayMenu("Last you left off:\n\nYou arrived at Big Mammoth and are getting ready to confront Samantha Bell.");
            ch4.startChapter(player);
        } else if (player.getChapter() == 5) {
            displayMenu("Last you left off:\n\nYou found out where Cross is, while also killing Samantha Bell and Marcus \"Bullet\" Williams.");
            ch5.startChapter(player);
        } else if (player.getChapter() == 6) {
            ch5.ending(player);
        } else {
            displayMenu("Save did not load correctly. Returning to main menu.");
        }
    }

    public void displayMenu(String menu) {
        JOptionPane.showMessageDialog(null, menu);
    }

    private void displayMenuIcon(String menu, ImageIcon icon) {
        JOptionPane.showMessageDialog(null, menu, "Wanted Poster", JOptionPane.INFORMATION_MESSAGE, icon);
    }
}
