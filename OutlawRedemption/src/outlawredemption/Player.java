/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlawredemption;

/**
 *
 * @author cbran
 */
public class Player {

    private String characterName;
    private String gangName;
    private Double money;
    private Integer chapter;
    private Integer dynamite;
    private Integer honorPoints;
    private Integer totalDeaths;
    private Integer totalBJ;
    private Integer totalBJWon;
    private Integer totalBJLost;
    private Double moneyFromBJ;
    private Integer totalPoker;
    private Integer totalPokerWon;
    private Integer totalPokerLost;
    private Integer totalPokerTie;
    private Double moneyFromPoker;
    private Integer totalDG;
    private Integer totalDGWon;
    private Integer totalDGLost;
    private Integer totalDGTie;
    private Double moneyFromDG;
    private Integer totalRPS;
    private Integer totalRPSWon;
    private Integer totalRPSLost;
    private Integer totalRPSTie;
    private Integer totalDrinks;

    Player(String cName, String gName, Double money) {
        this.characterName = cName;
        this.gangName = gName;
        this.money = money;
        this.dynamite = 0;
        this.honorPoints = 0;
        this.totalDeaths = 0;
        this.totalBJ = 0;
        this.totalBJWon = 0;
        this.totalBJLost = 0;
        this.moneyFromBJ = 0.00;
        this.totalPoker = 0;
        this.totalPokerWon = 0;
        this.totalPokerLost = 0;
        this.totalPokerTie = 0;
        this.moneyFromPoker = 0.00;
        this.totalDG = 0;
        this.totalDGWon = 0;
        this.totalDGLost = 0;
        this.totalDGTie = 0;
        this.moneyFromDG = 0.00;
        this.totalRPS = 0;
        this.totalRPSWon = 0;
        this.totalRPSLost = 0;
        this.totalRPSTie = 0;
        this.totalDrinks = 0;
    }

    public Player(String characterName, String gangName, Double money, Integer chapter, Integer dynamite, Integer honorPoints, Integer totalDeaths, Integer totalBJ, Integer totalBJWon, Integer totalBJLost, Double moneyFromBJ, Integer totalPoker, Integer totalPokerWon, Integer totalPokerLost, Integer totalPokerTie, Double moneyFromPoker, Integer totalDG, Integer totalDGWon, Integer totalDGLost, Integer totalDGTie, Double moneyFromDG, Integer totalRPS, Integer totalRPSWon, Integer totalRPSLost, Integer totalRPSTie, Integer totalDrinks) {
        this.characterName = characterName;
        this.gangName = gangName;
        this.money = money;
        this.chapter = chapter;
        this.dynamite = dynamite;
        this.honorPoints = honorPoints;
        this.totalDeaths = totalDeaths;
        this.totalBJ = totalBJ;
        this.totalBJWon = totalBJWon;
        this.totalBJLost = totalBJLost;
        this.moneyFromBJ = moneyFromBJ;
        this.totalPoker = totalPoker;
        this.totalPokerWon = totalPokerWon;
        this.totalPokerLost = totalPokerLost;
        this.totalPokerTie = totalPokerTie;
        this.moneyFromPoker = moneyFromPoker;
        this.totalDG = totalDG;
        this.totalDGWon = totalDGWon;
        this.totalDGLost = totalDGLost;
        this.totalDGTie = totalDGTie;
        this.moneyFromDG = moneyFromDG;
        this.totalRPS = totalRPS;
        this.totalRPSWon = totalRPSWon;
        this.totalRPSLost = totalRPSLost;
        this.totalRPSTie = totalRPSTie;
        this.totalDrinks = totalDrinks;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getGangName() {
        return gangName;
    }

    public void setGangName(String gangName) {
        this.gangName = gangName;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getChapter() {
        return chapter;
    }

    public void setChapter(Integer chapter) {
        this.chapter = chapter;
    }

    public Integer getDynamite() {
        return dynamite;
    }

    public void setDynamite(Integer dynamite) {
        this.dynamite = dynamite;
    }

    public Integer getHonorPoints() {
        return honorPoints;
    }

    public void setHonorPoints(Integer honorPoints) {
        this.honorPoints = honorPoints;
    }

    public Integer getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(Integer totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public Integer getTotalBJ() {
        return totalBJ;
    }

    public void setTotalBJ(Integer totalBJ) {
        this.totalBJ = totalBJ;
    }

    public Integer getTotalBJWon() {
        return totalBJWon;
    }

    public void setTotalBJWon(Integer totalBJWon) {
        this.totalBJWon = totalBJWon;
    }

    public Integer getTotalBJLost() {
        return totalBJLost;
    }

    public void setTotalBJLost(Integer totalBJLost) {
        this.totalBJLost = totalBJLost;
    }

    public Double getMoneyFromBJ() {
        return moneyFromBJ;
    }

    public void setMoneyFromBJ(Double moneyFromBJ) {
        this.moneyFromBJ = moneyFromBJ;
    }

    public Integer getTotalPoker() {
        return totalPoker;
    }

    public void setTotalPoker(Integer totalPoker) {
        this.totalPoker = totalPoker;
    }

    public Integer getTotalPokerWon() {
        return totalPokerWon;
    }

    public void setTotalPokerWon(Integer totalPokerWon) {
        this.totalPokerWon = totalPokerWon;
    }

    public Integer getTotalPokerLost() {
        return totalPokerLost;
    }

    public void setTotalPokerLost(Integer totalPokerLost) {
        this.totalPokerLost = totalPokerLost;
    }

    public Integer getTotalPokerTie() {
        return totalPokerTie;
    }

    public void setTotalPokerTie(Integer totalPokerTie) {
        this.totalPokerTie = totalPokerTie;
    }

    public Double getMoneyFromPoker() {
        return moneyFromPoker;
    }

    public void setMoneyFromPoker(Double moneyFromPoker) {
        this.moneyFromPoker = moneyFromPoker;
    }

    public Integer getTotalDG() {
        return totalDG;
    }

    public void setTotalDG(Integer totalDG) {
        this.totalDG = totalDG;
    }

    public Integer getTotalDGWon() {
        return totalDGWon;
    }

    public void setTotalDGWon(Integer totalDGWon) {
        this.totalDGWon = totalDGWon;
    }

    public Integer getTotalDGLost() {
        return totalDGLost;
    }

    public void setTotalDGLost(Integer totalDGLost) {
        this.totalDGLost = totalDGLost;
    }

    public Integer getTotalDGTie() {
        return totalDGTie;
    }

    public void setTotalDGTie(Integer totalDGTie) {
        this.totalDGTie = totalDGTie;
    }

    public Double getMoneyFromDG() {
        return moneyFromDG;
    }

    public void setMoneyFromDG(Double moneyFromDG) {
        this.moneyFromDG = moneyFromDG;
    }

    public Integer getTotalRPS() {
        return totalRPS;
    }

    public void setTotalRPS(Integer totalRPS) {
        this.totalRPS = totalRPS;
    }

    public Integer getTotalRPSWon() {
        return totalRPSWon;
    }

    public void setTotalRPSWon(Integer totalRPSWon) {
        this.totalRPSWon = totalRPSWon;
    }

    public Integer getTotalRPSLost() {
        return totalRPSLost;
    }

    public void setTotalRPSLost(Integer totalRPSLost) {
        this.totalRPSLost = totalRPSLost;
    }

    public Integer getTotalRPSTie() {
        return totalRPSTie;
    }

    public void setTotalRPSTie(Integer totalRPSTie) {
        this.totalRPSTie = totalRPSTie;
    }

    public Integer getTotalDrinks() {
        return totalDrinks;
    }

    public void setTotalDrinks(Integer totalDrinks) {
        this.totalDrinks = totalDrinks;
    }

    public void addMoney(Double amount) {
        this.money += amount;
    }

    public void subtractMoney(Double amount) {
        this.money -= amount;
    }

    public String getTotalMoney() {
        return "Your new money total is $" + String.format("%.2f", this.getMoney()) + ".\n";
    }

    public void addDynamite(Integer amount) {
        this.dynamite += amount;
    }

    public void subtractDynamite(Integer amount) {
        this.dynamite -= amount;
    }

    public void addHonor(Integer amount) {
        this.honorPoints += amount;
    }

    public void addDishonor(Integer amount) {
        this.honorPoints -= amount;
    }

    public void addDeath() {
        this.totalDeaths += 1;
    }

    public void addBJ() {
        this.totalBJ += 1;
    }

    public void addBJW() {
        this.totalBJWon += 1;
    }

    public void addBJL() {
        this.totalBJLost += 1;
    }

    public void addBJMoney(Double amt) {
        this.moneyFromBJ += amt;
    }

    public String getBJMoney() {
        if (this.getMoneyFromBJ() > 0) {
            return "Total Money Won From Blackjack: " + moneyFormat(this.getMoneyFromBJ()) + "\n";
        } else if (this.getMoneyFromBJ() < 0) {
            return "Total Money Lost From BlackJack: " + moneyFormat(Math.abs(this.getMoneyFromBJ())) + "\n";
        } else {
            return "Total Money From BlackJack: " + moneyFormat(this.getMoneyFromBJ()) + "\n";
        }
    }

    public void addPoker() {
        this.totalPoker += 1;
    }

    public void addPokerW() {
        this.totalPokerWon += 1;
    }

    public void addPokerL() {
        this.totalPokerLost += 1;
    }

    public void addPokerT() {
        this.totalPokerTie += 1;
    }

    public void addPokerMoney(Double amt) {
        this.moneyFromPoker += amt;
    }

    public String getPokerMoney() {
        if (this.getMoneyFromPoker() > 0) {
            return "Total Money Won From Poker: " + moneyFormat(this.getMoneyFromPoker()) + "\n";
        } else if (this.getMoneyFromPoker() < 0) {
            return "Total Money Lost From Poker: " + moneyFormat(Math.abs(this.getMoneyFromPoker())) + "\n";
        } else {
            return "Total Money From Poker: " + moneyFormat(this.getMoneyFromPoker()) + "\n";
        }
    }

    public void addDG() {
        this.totalDG += 1;
    }

    public void addDGW() {
        this.totalDGWon += 1;
    }

    public void addDGL() {
        this.totalDGLost += 1;
    }

    public void addDGT() {
        this.totalDGTie += 1;
    }

    public void addDGMoney(Double amt) {
        this.moneyFromDG += amt;
    }

    public String getDGMoney() {
        if (this.getMoneyFromDG() > 0) {
            return "Total Money Won From Dice Game: " + moneyFormat(this.getMoneyFromDG()) + "\n";
        } else if (this.getMoneyFromDG() < 0) {
            return "Total Money Lost From Dice Game: " + moneyFormat(Math.abs(this.getMoneyFromDG())) + "\n";
        } else {
            return "Total Money From Dice Game: " + moneyFormat(this.getMoneyFromDG()) + "\n";
        }
    }

    public void addRPS() {
        this.totalRPS += 1;
    }

    public void addRPSW() {
        this.totalRPSWon += 1;
    }

    public void addRPSL() {
        this.totalRPSLost += 1;
    }

    public void addRPST() {
        this.totalRPSTie += 1;
    }

    public void addDrink() {
        this.totalDrinks += 1;
    }

    private String moneyFormat(Double amt) {
        return "$" + String.format("%.2f", amt);
    }
}
