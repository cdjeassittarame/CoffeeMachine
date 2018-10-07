package main.com.company.view;

import main.com.company.controller.MachineACafeController;
import main.com.company.model.Boisson;
import main.com.company.model.BoissonType;

import java.util.Scanner;

public class MachineACafe {

    private static double minimumMoney = 0.40;
    private static double remainingMoney = 0;
    private static Boisson boissonGlobale = new Boisson();

    public static void main(String[] args) {
        boolean isRestarted = false;
        String money= null;
        MachineACafeController machineACafeController = new MachineACafeController();
        do {
            try {
                money = processMoney();
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e);
                return;
            }

            try {
                processChoiceDrink(boissonGlobale, money, machineACafeController);
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e);
                return;
            }

            try {
                boissonGlobale = machineACafeController.processSugar(boissonGlobale);
                machineACafeController.processStick(boissonGlobale);
                System.out.println(machineACafeController.processExtraHotAndFinish(boissonGlobale));
                System.out.println(machineACafeController.processMessageUtilisateur(boissonGlobale.getType(), boissonGlobale));;

                isRestarted = isRestarted();

            } catch (NumberFormatException e) {
                System.out.println("Error: " + e);
                return;
            }
        }while(isRestarted);
    }

    public static boolean isRestarted() {
        boolean isRestarted;
        Scanner scannerQuestionResponse = new Scanner(System.in);
        System.out.println("Want another drink ? Y or N");

        String questionResponse = scannerQuestionResponse.nextLine();

        if (questionResponse.equals("Y") || questionResponse.equals("y")){
            isRestarted = true;
        }else if (questionResponse.equals("N") || questionResponse.equals("n")){
            isRestarted = false;
        } else {
            isRestarted = false;
        }
        return isRestarted;
    }

    public static boolean processChoiceDrink(Boisson boisson, String money, MachineACafeController machineACafeController) {
        int drinkChoice;
        do {
            System.out.println("Could you chose your type of drink");
            Scanner scannerDrink = new Scanner(System.in);
            System.out.println(" 1.Tea\n 2.Coffee\n 3.Chocolate\n 4.Orange juice");
            String drink = scannerDrink.nextLine();

            drinkChoice = Integer.parseInt(drink);
        }while (drinkChoice != 1 &&  drinkChoice != 2 &&  drinkChoice != 3 &&  drinkChoice != 4);

        boissonGlobale = machineACafeController.processDrinkType(boissonGlobale, drinkChoice, money);
        return boisson.getType() == BoissonType.ORANGE;
    }

    public static String processMoney() {

        String money = null;
        do {
            System.out.println("Insert your money");
            Scanner scannerMoney = new Scanner(System.in);
            money = scannerMoney.nextLine();
            remainingMoney = Double.parseDouble(money) - minimumMoney;
            if (remainingMoney < 0) {
                System.out.println("There is " + remainingMoney + " left for your drink");
            }
        }while (remainingMoney < 0);

        return money;
    }

}
