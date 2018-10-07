package main.com.company.controller;

import main.com.company.model.Boisson;
import main.com.company.model.BoissonType;

import java.util.Objects;
import java.util.Scanner;

public class MachineACafeController implements IMachineACafeController {

    public MachineACafeController() {
    }

    @Override
    public Boisson processDrinkType(Boisson boisson, int drink, String money) {
        String machineProtocolMessage = null;
        if (Objects.nonNull(drink)) {
            switch (drink) {
                case 1:
                    boisson.setType(BoissonType.TEA);
                    System.out.println("M:You chose Tea");
                    break;
                case 2:
                    if (Double.parseDouble(money) >= 0.60) {
                        boisson.setType(BoissonType.COFFEE);
                        System.out.println("M:You chose Coffee");
                    } else {
                        System.out.println("Not enough money");
                        break;
                    }
                    break;
                case 3:
                    if (Double.parseDouble(money) >= 0.50) {
                        boisson.setType(BoissonType.CHOCOLATE);
                        System.out.println("M:You chose Chocolate");
                    } else {
                        System.out.println("Not enough money");
                        break;
                    }
                    break;
                case 4:
                    if (Double.parseDouble(money) >= 0.60) {
                        boisson.setType(BoissonType.ORANGE);
                        System.out.println("M:You chose Orange juice");
                        machineProtocolMessage = "PROTOCOL_MESSAGE: " + boisson.getType() + ":" + ":";
                        System.out.println(machineProtocolMessage);
                    } else {
                        System.out.println("Not enough money");
                        break;
                    }
                    break;
                default:
                    System.out.println("Bad choice");
                    return null;
            }
        }

        return boisson;
    }

    @Override
    public Boisson processSugar(Boisson boisson) {
        if (boisson.getType() != BoissonType.ORANGE){
            System.out.println("How many sugar do you want?");
            Scanner scannerNumberOfSugar = new Scanner(System.in);
            System.out.println(" 0\n 1\n 2");
            String scannerSugar = scannerNumberOfSugar.nextLine();
            int sugarNumber = Integer.parseInt(scannerSugar);
            boisson.setNbSucre(sugarNumber);

            if (Objects.nonNull(boisson.getNbSucre()) && (sugarNumber>= 0 && sugarNumber <= 2)) {

                System.out.println("M:You chose" + sugarNumber + "sugar");

            }else{
                System.out.println("Bad choice");

            }
        } else {
            return boisson;
        }
        return boisson;
    }

    @Override
    public String processExtraHotAndFinish(Boisson boisson) {
        String machineProtocolMessage;
        String extraHotOrNot = null;
        if (boisson.getType() != BoissonType.ORANGE) {
            System.out.println("ExtraHot Or not?");
            Scanner scannerHot = new Scanner(System.in);
            System.out.println("y or n");
            extraHotOrNot = scannerHot.nextLine();
        }
        if (Objects.nonNull(extraHotOrNot) && extraHotOrNot.toLowerCase().equals("y")) {
            boisson.setExtraHot(true);
            machineProtocolMessage = "PROTOCOL_MESSAGE: " + boisson.getType().getBoissonTypeProtocol() + "h" + ":" + boisson.getNbSucre() + ":" + boisson.getTouillette();
        } else {
            boisson.setExtraHot(false);
            machineProtocolMessage = "PROTOCOL_MESSAGE: " + boisson.getType().getBoissonTypeProtocol() + ":" + boisson.getNbSucre() + ":" + boisson.getTouillette();
        }
        return machineProtocolMessage;

    }

    @Override
    public String processStick(Boisson boisson) {
        String resultStick = null;
        if (Objects.nonNull(boisson.getNbSucre())) {
            if (boisson.getNbSucre() == 0) {
                resultStick = "M:No Stick";
                boisson.setTouillette(false);
            } else {
                resultStick = "M:You will have one Stick";
                boisson.setTouillette(true);
            }
        }
        System.out.println(resultStick);
        return resultStick;
    }


    public String processMessageUtilisateur(BoissonType boissonType, Boisson boisson) {
        String message = null;
        if(Objects.nonNull(boissonType)){
            message = "Drink maker makes 1 " + boissonType.getBoissonNameFrench() + " with ";
        }

        switch (boisson.getNbSucre()) {
            case 0:
                message = message + " no sugar - and therefore no stick";
                return message;

            case 1:
            case 2:
                message = message + boisson.getNbSucre() +" sugar and a stick";
                return message;

            default:
                System.out.println("Bad choice");
                return null;
        }
    }
}
