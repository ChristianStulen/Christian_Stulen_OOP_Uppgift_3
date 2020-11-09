import javax.swing.*;
/**
 * This program will help players of Warhammer 40k to make decisions who to attack and what result
 * they should expect.
 * The program itself is quit simple with a few units and weapons hard coded and probability calculation depending
 * on how many attacks who with what weapons.
 * @author Christian Stulen
 */
public class HowMuchDamage {
    /**
     * A menu loop is used so that the user can run the calculations any number of times.
     * In the menu the user can add weapons and units so that calculations can be run.
     */
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
                    /*
                    for (Unit unit : unitsArray) {  diagnose tool
                        System.out.println(unit.toString());
                    }
                    */
                    JOptionPane.showMessageDialog(null,"Units added.");

                }
                case 2 -> {
                    /*
                     * Adds Weapons. At the moment only 4 pre-added weapons exist, 3 ranged and 1 melee, and the option
                     * for the user to add their own has not been implemented.
                     * It's only possible to use this option once. After that an if-method will break and give an error.
                     */
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
                    /*
                    for (Weapon weapon : weaponsArray) {    //diagnose tool
                        System.out.println(weapon.toString());
                    }
                     */
                        JOptionPane.showMessageDialog(null,"Weapons added.");

                }
                case 3 -> {
                    /*
                     * Runs the calculation. The user will be asked how many attacks, against who,
                     * if it's melee or ranged and with which weapon.
                     * An if-method prevents the method to run if no weapons and/or units has been added.
                     * All inputs field has been protected from wrong kind of input.
                     * After all input has been given the result will be presented.
                     */
                    if (weaponsArray.length==0 || unitsArray.length==0){
                        errorMessage("No Unit and/or weapon has been added. " +
                                "\nPlease make sure that both Units and Weapons has been added.");
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
                        //System.out.println(choice);  diagnose tool

                        /*
                         * If the attack is not ranged the default weapon will be send, the power sword.
                         */
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

                    Calculate.ranged(nrOfAttackers, unitsArray[attacker], weaponsArray[weaponChoice], unitsArray[defender],isRanged);
                    }
                    catch (Exception e3){
                        errorMessage("Please type an integer.");
                    }

                }
                case 4 -> isRunning = false;

            }
        }

    }

    /**
     * A bare bone error message.
     * @param message - Shows the message in a JOptionPane
     */
    static void errorMessage(String message){
        JOptionPane.showMessageDialog(null,message);

    }
}
