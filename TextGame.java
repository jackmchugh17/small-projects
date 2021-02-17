/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jackmchugh
 */


import java.util.Random;
import java.util.Scanner;


public class TextGame {
    public static void main(String[] args)  {
        
       // System objects
       Scanner in = new Scanner(System.in);
       Random rand = new Random();
       
       //Game Variables
       String[] enemies = {"Skeleton", "Goblin", "Troll", "Assassin" };
       int maxEnemyHealth = 75;
       int enemyAttackDamage = 25;
       int killCount = 0;
       
       //Player Variables
       int health = 100;
       int attackDamage = 50;
       int numHealthPotions = 3;
       int healthPotionHealAmount = 30;
       int healthPotionDropChance = 50; //Chance in percentage 
       int playerLevel = 0;
       
       boolean running = true;
       
       System.out.println("Welcome to the Dungeon!");
       
       System.out.println("What will you name your character?");
           String name = in.nextLine();
           
           System.out.println("Well " + name + ", what class will you choose?");
           System.out.println("\t1. Mage");
           System.out.println("\t2. Warrior");
           System.out.println("\t3. Rogue");
           String build = in.nextLine();
           
           if(build.equals("1")){
               System.out.println("A mystic Mage! A master of the magical and mystic arts!");
               
           }
           else if(build.equals("2")){
               System.out.println("A brave Warrior I see! A master of battle and strategy!");
           }
          else if(build.equals("3")){
               System.out.println("A cunning Rogue! A master of stealth and guile!");
           }
           else{
               System.out.println("Invalid command!");
           }
       
      
       GAME:
       while(running) {
           System.out.println("-------------------------------------");
           
           
           
           int enemyHealth = rand.nextInt(maxEnemyHealth);
           String enemy = enemies[rand.nextInt(enemies.length)];
           System.out.println("\t# " + enemy + " has appeared! #\n");
           
           while(enemyHealth > 0) {
               System.out.println("\tYour HP: " + health);
               System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
               System.out.println("\n\tWhat would you like to do " + name + "?");
               System.out.println("\t1. Attack");
               System.out.println("\t2. Drink health potion");
               System.out.println("\t3. Run!");
               
               String input = in.nextLine();
               if(input.equals("1")) {
                   int damageDealt = rand.nextInt(attackDamage);
                   int damageTaken = rand.nextInt(enemyAttackDamage);
                   
                   enemyHealth -= damageDealt;
                   health -= damageTaken;
                   
                   
                   System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
                   System.out.println("\t> You receive " + damageTaken + " in retaliation!");
                   
                   if(health <1) {
                       System.out.println("\t> You have taken too much damage, you are too weak to carry on! ");
                       break;
                       
                   }
                   
               }
               else if(input.equals("2")) {
                   if(numHealthPotions > 0) {
                       health += healthPotionHealAmount;
                       numHealthPotions--;
                       System.out.println("\t> You drink a health potion, healing yourself for " + healthPotionHealAmount + "."
                                              + "\n\t> You now have " + health + " HP."
                                              + "\n\t> You have " + numHealthPotions + " health potions left.\n")  ;
                   }
                   else {
                       System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get some!");
                   }
                   
               }
               else if(input.equals("3")) {
                   System.out.println("\tYou run away from  the " + enemy + "!");
                   continue GAME;
               }
               else {
                   System.out.println("\tInvalid command!");
               }
           }
           
           if(health < 1) {
               System.out.println("You limp out of the dungeon, weak from battle.");
               System.out.println("Though " + name + " was defeated they killed " + killCount + " enemies. A valiant effort from our hero");
               break;
           }
           
            System.out.println("-------------------------------------");
            System.out.println(" # " + enemy + " was defeated! #");
            System.out.println(" # You have " + health + " HP left. #");
            System.out.println(" # Your level is " + playerLevel);
            if(rand.nextInt(100) < healthPotionDropChance) {
                numHealthPotions++;
                System.out.println(" # The " + enemy + " dropped a health potion! #");
                System.out.println(" # You now have " + numHealthPotions + " health potion(s). # ");
                
            }
            if(enemyHealth < 0)
            {
                killCount++;
                System.out.println(" # You have defeated " + killCount + " enemies");
            }
            if(killCount % 2 == 0){               
                playerLevel++;
                System.out.println(" # LEVEL UP! Congrats you are now level " + playerLevel);
            }
           
           System.out.println("-------------------------------------");
           System.out.println("What you like to do now " + name + "?");
           System.out.println("1. Continue fighting");
           System.out.println("2. Exit dungeon");
           
           String input = in.nextLine();
           
           while(!input.equals("1") && !input.equals("2")) {
               System.out.println("Invalid command!");
               input = in.nextLine();
           } 
           
           if(input.equals("1")) {
               System.out.println("You continue on your adventure!");
           }
           else if(input.equals("2")) {
               System.out.println("You exit the dungeon, successful from your adventures!");
               System.out.println(name + " successfully defeated " + killCount +  " enemies. Good hunting!!");
               break;
           }
                   
                   
       }
       
       System.out.println("#######################");
       System.out.println("# THANKS FOR PLAYING! #");
       System.out.println("#######################");
        
    }
    
}
