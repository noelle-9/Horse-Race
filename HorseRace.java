// Name: Noelle Dacayo
// Date: March 15, 2023
// App Name: Horse Race
// Description: App that allows the user to bet on a horse and uses an rng to make the horses run at random speeds.

import java.util.Scanner;

public class HorseRace
{
    // CONSTANTS
    static final String SET_TITLE = "\033];%s\007";
    static final String CLEAR_TERMINAL = "\033c";
    static int HALF_SECOND = 500;
    static final int MAX_DISTANCE = 20;

    // Stops code execution for half a second (in milliseconds)
    public static void waitHalfSecond()
        {
            try{
                Thread.sleep(HALF_SECOND);
            }catch (InterruptedException exception){}
        }

        /**
         * Draws dotted lines to move the horses
         * @param horse horse object(name)
         */
        public static void drawDistanceLine(Horse horse) 
        {
            String distanceCoveredString = horse.getDistanceCoveredString();
            System.out.println(distanceCoveredString + horse.getName());
        }

    public static void main(String[] args) {
         // Only use this fix if your title doesn't work
         try {
            new ProcessBuilder("cmd", "/c").inheritIO().start().waitFor();
        } catch (Exception exception) {}   
        
        Scanner scanner = new Scanner(System.in);
        
        // Creates an array for the horse objects
        Horse[] horses = new Horse[5];
        horses[0] = new Horse("Bagel");
        horses[1] = new Horse("Oatmeal Raisin");
        horses[2] = new Horse("Strawberries n Cream");
        horses[3] = new Horse("Apple Pie");
        horses[4] = new Horse("Churro");


         //Set Title
         System.out.printf(SET_TITLE, "Horse Race - Noelle Dacayo");

        // Sets noWinner to be true to be able to stop the while loop later
        boolean noWinner = true;
        while (noWinner) {
            // Clears the terminal
            System.out.println(CLEAR_TERMINAL);

            // Print the banner
            System.out.printf("%s" + Aesthetics.INTRO_BANNER + "%s", Aesthetics.LIGHT_BLUE, Aesthetics.RESET);

            // Calls run and drawDistanceLine for program to run
            for(Horse horse : horses)
            {
                horse.run();
                drawDistanceLine(horse);
                // Once the DistanceCovered is over the MAX_DISTANCE(20), while loop ends
                if (horse.getDistanceCovered() >= MAX_DISTANCE) 
                {
                    noWinner = false;
                }
            }
            waitHalfSecond();
            
        }
        // Prints winner banner
        System.out.printf("\n\n%s" + Aesthetics.OUTRO_BANNER + "%s", Aesthetics.LIGHT_PINK, Aesthetics.RESET);
        for (Horse horse : horses) {
            // Finds the horse name's winner and displays it
            if (horse.getDistanceCovered() == MAX_DISTANCE) 
            {
                System.out.println();
                System.out.printf("%s" + horse.getName() + " is a winner!%s", Aesthetics.LIGHT_PINK, Aesthetics.RESET);
            }
        }
        System.out.println("\n\nPress Enter to exit: ");
        scanner.nextLine();
        scanner.close();
        
    }
}

// I had such a hard time with this Lab, I had no idea what I was doing for the most part
// A friend managed to run me through where I was convuluting things and it makes a little more sense now??
// It was such a cute Lab too, I wish this didn't stress me out so much so I could've worked on making it pretty a little more
// I loved it though, this was fun despite the tears shed!