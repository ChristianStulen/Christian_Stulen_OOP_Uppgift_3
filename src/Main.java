import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Unit[] unitsArray= new Unit[0];
        Weapon[] weaponsArray= new Weapon[0];

        int input;
        int nextUnit=0;
        int nextWeapon=0;
        int choice;
        int nrOfAttackers;
        int attacker;
        int defender;
        int weaponChoice=0;
        boolean isRanged;
        boolean isRunning=true;
        while (isRunning){
            try {
                input = Integer.parseInt(JOptionPane.showInputDialog("Choose an option:" +
                        "\n1: Add Units " +
                        "\n2: Add weapons" +
                        "\n3: Calculate probability" +
                        "\n4: Exit"));
                if (input>4 || input<=0) errorMessage("Please typ an integer, 1-4");
            }catch (Exception e1) {
                input=0;
                errorMessage("Please typ an integer, 1-4");
            }
            switch (input) {
                case 1 -> {
                    if (unitsArray.length>0){
                        errorMessage("Units already added.");
                        break;
                    }
                    unitsArray = new Unit[2];
                    unitsArray[nextUnit] = new Unit("Guard",4,4,3,3,1,1,5);
                    nextUnit++;
                    unitsArray[nextUnit] = new Unit("Space Marine",3,3,4,4,2,2,3);
                    for (Unit unit : unitsArray) {
                        System.out.println(unit.toString());
                    }

                }
                case 2 -> {
                    if (weaponsArray.length>0){
                        errorMessage("Weapons already added.");
                        break;
                    }
                    weaponsArray = new Weapon[4];
                    weaponsArray[nextWeapon] = new Weapon("Powersword","melee",1,2,1,3);
                    nextWeapon++;
                    weaponsArray[nextWeapon] = new Weapon("Lasgun","ranged",3,1,1,0);
                    nextWeapon++;
                    weaponsArray[nextWeapon] = new Weapon("Bolter","ranged",4,1,2,1);
                    nextWeapon++;
                    weaponsArray[nextWeapon] = new Weapon("Plasma gun","ranged",8,2,2,3);
                    for (Weapon weapon : weaponsArray) {
                        System.out.println(weapon.toString());
                    }
                }
                case 3 -> {
                    if (weaponsArray.length==0 || unitsArray.length==0){
                        errorMessage("No Unit and/or weapon has been added.");
                        break;
                    }
                    try{
                    nrOfAttackers = Integer.parseInt(JOptionPane.showInputDialog("How many attackers? 1-100: "));
                    if (nrOfAttackers>100 || nrOfAttackers<1) {
                        errorMessage("Please type an integer, 1-100");
                        break;}

                    attacker= Integer.parseInt(JOptionPane.showInputDialog("Who are attacking? \n0:Guard\n1:Space Marine"));
                    if (attacker>unitsArray.length || attacker<0) {
                        errorMessage("Please choose 0 or 1");
                        break;
                    }
                    defender= Integer.parseInt(JOptionPane.showInputDialog("Who are defending? " +
                            "\n0:Guard" +
                            "\n1:Space Marine"));
                    if (defender>unitsArray.length || defender<0) {
                            errorMessage("Please choose 0 or 1");
                            break;
                    }

                    choice = JOptionPane.showConfirmDialog(null,"Is it a ranged attack?");
                        //System.out.println(choice);
                    if (choice==0) {
                        isRanged=true;
                        weaponChoice = Integer.parseInt(JOptionPane.showInputDialog("Which weapon are they wielding? " +
                                "\n1:Lasgun" +
                                "\n2:Bolter" +
                                "\n3:Plasmagun"));
                        if (weaponChoice>weaponsArray.length || weaponChoice<0) {
                            errorMessage("Please choose 1,2 or 3");
                            break;
                        }
                    }
                    else if (choice==1) isRanged=false;
                    else break;


                    Calc.ranged(nrOfAttackers, unitsArray[attacker], weaponsArray[weaponChoice], unitsArray[defender],isRanged);
                    }
                    catch (Exception e3){
                        errorMessage("Please type an integer.");
                    }

                }
                case 4 -> isRunning = false;

            }
        }

    }
    static void errorMessage(String message){
        JOptionPane.showMessageDialog(null,message);

    }
}
