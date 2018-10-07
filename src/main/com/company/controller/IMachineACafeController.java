package main.com.company.controller;

import main.com.company.model.Boisson;
import main.com.company.model.BoissonType;

public interface IMachineACafeController {

    Boisson processDrinkType(Boisson boisson, int drink, String money);

    Boisson processSugar(Boisson boisson);

    String processExtraHotAndFinish(Boisson boisson);

    String processStick(Boisson boisson);

    String processMessageUtilisateur(BoissonType boissonType, Boisson boisson);
}
