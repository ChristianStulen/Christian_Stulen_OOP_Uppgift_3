import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Unit[] unitsArray = new Unit[2];
        Weapon[] weaponsArray = new Weapon[3];

        int nextUnit=0;
        int nextWeapon=0;
        boolean isRunning=true;
        while (isRunning){
            int input = Integer.parseInt(JOptionPane.showInputDialog("Välj meny"+
                    "\n1: Add Units " +
                    "\n2: Add weapons" +
                    "\n3: Calculate probability" +
                    "\n4: Exit"));

            switch (input) {
                case 1 -> {
                    unitsArray[nextUnit] = new Unit("Guard",4,4,3,3,1,1,5);
                    nextUnit++;
                    unitsArray[nextUnit] = new Unit("Space Marine",3,3,4,4,2,2,3);
                    for (int i = 0; i < unitsArray.length; i++) {
                        System.out.println(unitsArray[i].toString());
                    }
                    
                }
                case 2 -> {
                    weaponsArray[nextWeapon] = new Weapon("Lasgun","ranged",3,1,1,0);
                    nextWeapon++;
                    weaponsArray[nextWeapon] = new Weapon("Bolter","ranged",4,1,2,1);
                    nextWeapon++;
                    weaponsArray[nextWeapon] = new Weapon("Plasma gun","ranged",8,2,2,3);
                    for (int i = 0; i < weaponsArray.length; i++) {
                        System.out.println(weaponsArray[i].toString());
                    }
                }
                case 3 -> Calc.ranged(10,unitsArray[0],weaponsArray[0],unitsArray[1]);
                case 4 -> isRunning = false;
                //default -> errorMessage;
            }
        }
    }
}