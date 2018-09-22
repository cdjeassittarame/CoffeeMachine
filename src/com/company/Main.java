package com.company;

import jdk.jfr.Unsigned;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static final int NO_SUGAR = 0;
    private static final int ONE_SUGAR = 1;
    private static final int TWO_SUGAR = 2;
    private static String machineProtocolMessage;
    private static String drinkName;
    private static double minimumMoney = 0.40;
    private static double remainingMoney = 0;
    private static String money = null;
    private static String drinkType = null;


    public static void main(String[] args) {
        String extraHotOrNot = null;

        try {
            do {
                System.out.println("Insert your money");
                Scanner scannerMoney = new Scanner(System.in);
                money = scannerMoney.nextLine();
                remainingMoney = Double.parseDouble(money) - minimumMoney;
                if (remainingMoney < 0) {
                    System.out.println("There is " + remainingMoney + " left for your drink");
                }
            }
            while (remainingMoney < 0);
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e);
            return;
        }
        try {
            System.out.println("Could you chose your type of drink");
            Scanner scannerDrink = new Scanner(System.in);
            System.out.println(" 1.Tea\n 2.Coffee\n 3.Chocolate\n 4.Orange juice");
            String drink = scannerDrink.nextLine();
            int drinkChoice = Integer.parseInt(drink);
            drinkType = processDrinkType(drinkChoice);
            if (drinkType == null || drinkType.equals("O")) {
                return;
            }
        }catch (NumberFormatException e){
            System.out.println("Error: " + e);
            return;
        }
        try {
            System.out.println("How many sugar do you want?");
            Scanner scannerNumberOfSugar = new Scanner(System.in);
            System.out.println(" 0\n 1\n 2");

            String numberOfSugar = scannerNumberOfSugar.nextLine();
            int numberOfSugarChoice = Integer.parseInt(numberOfSugar);
            int sugarNumber = processSugarNumber(numberOfSugarChoice);
            if (sugarNumber == 404) {
                return;
            }
            String stickPresence = processStick(numberOfSugarChoice);

            do {
                System.out.println("ExtraHot Or not?");
                Scanner scannerHot = new Scanner(System.in);
                System.out.println("y or n");
                extraHotOrNot = scannerHot.nextLine();

                if (extraHotOrNot.equals("y")) {
                    drinkType = drinkType + "h";
                }

            } while((!extraHotOrNot.contains("y") || !extraHotOrNot.contains("n")) && extraHotOrNot.isEmpty());

            machineProtocolMessage = "PROTOCOL_MESSAGE: " + drinkType + ":" + sugarNumber + ":" + stickPresence;
            System.out.println(machineProtocolMessage);
            String message = infomessage(drinkName, sugarNumber);

            System.out.println(message);
        }catch(NumberFormatException e){
            System.out.println("Error: " + e);
            return;
        }
    }

    public static String processDrinkType(int drink) {
        String resultDrink = null;
        if (Objects.nonNull(drink)) {
            switch (drink) {
                case 1:
                    resultDrink = "T";
                    drinkName = "Tea";
                    System.out.println("M:You chose Tea");
                    return resultDrink;
                case 2:
                    if (Double.parseDouble(money) >= 0.60) {
                        resultDrink = "C";
                        drinkName = "Coffee";
                        System.out.println("M:You chose Coffee");
                        return resultDrink;
                    } else {
                        System.out.println("Not enough money");
                        break;
                    }
                case 3:
                    if (Double.parseDouble(money) >= 0.50) {
                        resultDrink = "H";
                        drinkName = "Chocolate";
                        System.out.println("M:You chose Chocolate");
                        return resultDrink;
                    } else {
                        System.out.println("Not enough money");
                        break;
                    }
                case 4:
                    if (Double.parseDouble(money) >= 0.60) {
                        resultDrink = "O";
                        drinkName = "Orange juice";
                        System.out.println("M:You chose Orange juice");
                        machineProtocolMessage = "PROTOCOL_MESSAGE: " + resultDrink + ":" + ":";
                        System.out.println(machineProtocolMessage);
                        return resultDrink;
                    } else {
                        System.out.println("Not enough money");
                        break;
                    }
                default:
                    System.out.println("Bad choice");
                    return null;
            }
        }
        return resultDrink;
    }


    public static int processSugarNumber(int sugarNumber) {
        int resultSugar = 0;
        if (Objects.nonNull(sugarNumber)) {
            switch (sugarNumber) {
                case 0:
                    resultSugar = NO_SUGAR;
                    System.out.println("M:You chose 0 sugar");
                    return resultSugar;
                case 1:
                    resultSugar = ONE_SUGAR;
                    System.out.println("M:You chose 1 sugar");
                    return resultSugar;
                case 2:
                    resultSugar = TWO_SUGAR;
                    System.out.println("M:You chose 2 sugar");
                    return resultSugar;
                default:
                    System.out.println("Bad choice");
                    return 404;
            }
        }
        return resultSugar;
    }

    public static String processStick(int sugarNumber) {
        String resultStick = null;
        String numberStick = null;
        if (Objects.nonNull(sugarNumber)) {
            if (sugarNumber == 0) {
                resultStick = "M:No Stick";
                numberStick = "0";
            } else {
                resultStick = "M:You will have one Stick";
                numberStick = "1";
            }
        }
        System.out.println(resultStick);
        return numberStick;
    }

    public static String infomessage(String drinkName, int sugarNumber) {
        String message = "Drink maker makes 1 " + drinkName + " with";

        switch (sugarNumber) {
            case 0:
                message = message + " no sugar - and therefore no stick";
                return message;
            case 1:
                message = message + " 1 sugar and a stick";
                return message;
            case 2:
                message = message + " 2 sugars and a stick";
                return message;
            default:
                System.out.println("Bad choice");
                return null;
        }
    }

}
