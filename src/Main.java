
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Character player1 = null;
        Character player2 = null;
        String characterClassP1 = null;
        String characterClassP2 = null;

        int characterCode;
        int characterType;

        System.out.println("Hello! And welcome to *NAME OF THE GAME*!");
        System.out.println("First, we need to create the characters. Let's start with player 1, shall we?");

//        CREACION DE PLAYERS
        characterCode = characterSelector();
        if (characterCode == 1) {
            player1 = warriorCreator();

            characterClassP1 = "warrior";

        } else if (characterCode == 2) {
            player1 = wizardCreator();
            characterClassP1 = "wizard";
        }
        System.out.println("Done! Player 1 is the " + characterClassP1 + player1.getName());
        System.out.println("Now, let's create player 2");

        characterCode = characterSelector();
        if (characterCode == 1) {
            player2 = warriorCreator();

            characterClassP2 = "warrior";

        } else if (characterCode == 2) {
            player2 = wizardCreator();
            characterClassP2 = "wizard";
        }


        System.out.println("ALL RIGHT! We're all set!");

        System.out.println("Player 1: the " + characterClassP1 + " " + player1.getName() + ", with " + player1.getHp() + " health points.");
        System.out.println("Player 2: the " + characterClassP2 + " " + player2.getName() + ", with " + player2.getHp() + " health points.");

//        ATAQUES
        System.out.println(player1.getName() + " Select your attack: press 1 for HEAVY ATTACK or press 2 for WEAK ATTACK");
        int attackHeavy = 1;
        int attackWeak = 2;
        characterType = attackSelector();
        if (characterType == 1) {
          ((IAttacker) player1).attack(attackHeavy, player2);

            System.out.println("Player 1 selected heavy attack");

        } else if (characterType == 2) {
            ((IAttacker) player1).attack(attackWeak, player2);
            System.out.println("player 1 selected weak attack");
        }

//        ((IAttacker) player1).attack(1, player2);
//        ((IAttacker) player2).attack(1, player1);

    }

    public static int attackSelector(){
        Scanner scanner = new Scanner(System.in);

        int characterType = 0;
        boolean isCodeinvalid = true;

        while (isCodeinvalid) {
            characterType = introduceInt("That's not a valid character code. Please, introduce 1 if you want a HEAVY ATTACK or 2 if you want WEAK ATTACK.");
            if ((characterType == 1) || (characterType == 2)) {
                isCodeinvalid = false;
            } else {
                System.out.println("That's not a valid character code. Please, introduce 1 if you want a HEAVY ATTACK or 2 if you want WEAK ATTACK.");
            }
        }

        return characterType;


    }





    public static int characterSelector() {

        String green = "\033[32m";
        String reset = "\u001B[0m";
        String purple = "\033[35m";
        String blue = "\033[34m";
        System.out.println(green + "What kind of character would you like to create?" + reset);
        System.out.println(green + "Press 1 for " + blue + "Warrior" + green + " or pres 2 for " + purple + "Wizard" + reset);
        Scanner scanner = new Scanner(System.in);

        int characterCode = 0;
        boolean isCodeinvalid = true;

        while (isCodeinvalid) {
            characterCode = introduceInt("That's not a valid character code. Please, introduce 1 if you want a warrior or 2 if you want a wizard.");
            if ((characterCode == 1) || (characterCode == 2)) {
                isCodeinvalid = false;
            } else {
                System.out.println("That's not a valid character code. Please, introduce 1 if you want a warrior or 2 if you want a wizard.");
            }
        }

        return characterCode;

    }

    public static Warrior warriorCreator() {
        int stamina;
        int strength;
        String name;
        int hp;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please introduce the name of your warrior:");
        name = scanner.nextLine();
        System.out.println("Please, introduce the stamina of your warrior between 10-50:");
        stamina = scanner.nextInt();
        if ((stamina < 10) || (stamina > 50)) {
            System.out.println("That is not correct please, introduce the stamina of your warrior between 10-50:");
            stamina = scanner.nextInt();
        }
        System.out.println("Please, introduce the strength of your warrior between 1-10:");
        strength = scanner.nextInt();
        if ((strength < 1) || (strength > 10)) {
            System.out.println("That is not correct, please, introduce the strength of your warrior between 1-10:");
        }
        System.out.println("Please, introduce the health points of your warrior between 100-200:");
        hp = scanner.nextInt();
        if ((hp < 100) || (hp > 200)) {
            System.out.println("That is not correct, please, introduce the health points of your warrior between 100-200:");
        }

        Warrior player = new Warrior(name, hp, stamina, strength);
        return player;

    }

    public static Wizard wizardCreator() {
        int mana;
        int intelligence;
        String name;
        int hp;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please introduce the name of your wizard:");
        name = scanner.nextLine();

        System.out.println("Please, introduce the mana between 10 - 50:");
        mana = scanner.nextInt();
        if ((mana < 10) || (mana > 50)) {
            System.out.println("Please, introduce the mana of your warrior between 10 - 50:");
        }

        System.out.println("Please, introduce the intelligence of your wizard between 10 - 50:");
        intelligence = scanner.nextInt();
        if ((intelligence < 10) || (intelligence > 50)) {
            System.out.println("Please, introduce the intelligence of your warrior between 10 - 50:");
        }

        System.out.println("Please, introduce the health points of your wizard between 100 - 200:");
        hp = scanner.nextInt();
        if ((hp < 100) || (hp > 200)) {
            System.out.println("Please, introduce the health points of your warrior between 100 - 200:");
        }

        Wizard player = new Wizard(name, hp, mana, intelligence);
        return player;

    }

    public static int introduceInt(String errorMessage) {
        int characterCode;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            characterCode = scanner.nextInt();
            return characterCode;
        } else {
            System.out.println(errorMessage);
            introduceInt(errorMessage);
            return 9000;
        }
    }

}