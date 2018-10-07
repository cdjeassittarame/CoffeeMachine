package test.com.company.controller;

import main.com.company.controller.MachineACafeController;
import main.com.company.model.Boisson;
import main.com.company.model.BoissonType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MachineACafeControllerTest {

    public MachineACafeControllerTest() {
    }

    private MachineACafeController machineACafeController;

    @Before
    public void setUp() {
        this.machineACafeController = new MachineACafeController();
    }

    @Test
    public void processDrinkType() {
        Boisson boissonThe = new Boisson(BoissonType.TEA, 1, "1", 0.4, "T:1:1" );
//        Boisson boissonTheExtraHot = new Boisson(BoissonType.TEA, 1, "1", true, 0.4, "T:1:1" );
        Boisson boissonCafe = new Boisson(BoissonType.COFFEE, 1, "1", 0.6, "C:1:1" );
        Boisson boissonChocolat = new Boisson(BoissonType.CHOCOLATE, 1, "1", 0.8, "H:1:1" );
        Boisson boissonOrange = new Boisson(BoissonType.ORANGE, 0, "0", 0.5, "O::" );

        Boisson boisson = this.machineACafeController.processDrinkType(boissonThe, 1, "0.4");
        Boisson boisson1 = this.machineACafeController.processDrinkType(boissonCafe, 2, "0.6");
        Boisson boisson2 = this.machineACafeController.processDrinkType(boissonChocolat, 3, "0.8");
        Boisson boisson3 = this.machineACafeController.processDrinkType(boissonOrange, 4, "0.5");

        Assert.assertEquals(boissonThe,boisson);
        Assert.assertEquals(boissonCafe,boisson1);
        Assert.assertEquals(boissonChocolat,boisson2);
        Assert.assertEquals(boissonOrange,boisson3);
    }

    @Test
    public void processStick() {
        Boisson boissonThe = new Boisson(BoissonType.TEA, 1, "1", 0.4, "T:1:1" );
        Boisson boissonCafe = new Boisson(BoissonType.COFFEE, 1, "1", 0.6, "C:1:1" );
        Boisson boissonChocolat = new Boisson(BoissonType.CHOCOLATE, 1, "1", 0.8, "H:1:1" );
        Boisson boissonOrange = new Boisson(BoissonType.ORANGE, 0, "0", 0.5, "O::" );

        String boisson = this.machineACafeController.processStick(boissonThe);
        String boisson1 = this.machineACafeController.processStick(boissonCafe);
        String boisson2 = this.machineACafeController.processStick(boissonChocolat);
        String boisson3 = this.machineACafeController.processStick(boissonOrange);

        Assert.assertEquals("M:You will have one Stick",boisson);
        Assert.assertEquals("M:You will have one Stick",boisson1);
        Assert.assertEquals("M:You will have one Stick",boisson2);
        Assert.assertEquals("M:No Stick",boisson3);
    }

    @Test
    public void processMessageUtilisateur() {
        Boisson boissonThe = new Boisson(BoissonType.TEA, 1, "1", 0.4, "T:1:1" );
        Boisson boissonCafe = new Boisson(BoissonType.COFFEE, 1, "1", 0.6, "C:1:1" );
        Boisson boissonChocolat = new Boisson(BoissonType.CHOCOLATE, 1, "1", 0.8, "H:1:1" );
        Boisson boissonOrange = new Boisson(BoissonType.ORANGE, 0, "0", 0.5, "O::" );

        String boisson = this.machineACafeController.processMessageUtilisateur(BoissonType.TEA,boissonThe);
        String boisson1 = this.machineACafeController.processMessageUtilisateur(BoissonType.COFFEE,boissonCafe);
        String boisson2 = this.machineACafeController.processMessageUtilisateur(BoissonType.CHOCOLATE,boissonChocolat);
        String boisson3 = this.machineACafeController.processMessageUtilisateur(BoissonType.ORANGE, boissonOrange);

        Assert.assertEquals("Drink maker makes 1 Thé with 1 sugar and a stick",boisson);
        Assert.assertEquals("Drink maker makes 1 Café with 1 sugar and a stick",boisson1);
        Assert.assertEquals("Drink maker makes 1 Chocolat with 1 sugar and a stick",boisson2);
        Assert.assertEquals("Drink maker makes 1 Orange with  no sugar - and therefore no stick",boisson3);
    }
}