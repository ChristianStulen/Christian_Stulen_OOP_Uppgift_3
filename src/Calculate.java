import javax.swing.*;
/**
 * Calculate does exactly that, it calculates the probability of the data send to it.
 * It works by first checking how many of the attacks will hit. Then it checks if the hits would cause a wound or
 * just glance of. Lastly it check if the defenders armor would protect them from the wound.
 * Afterward the program displays the result.
 * @author Christian Stulen
 */
public class Calculate {
    /**
     * Runs the calculations according to the type of attack
     * and then display the result.
     * Several temporary variables are used:
     * @param nrOfAttacker - How many attackers are there
     * @param attacker - Stats of the attackers
     * @param weapon - Weapon stats of the attacker
     * @param defender - Defenders stats
     * @param isRanged - If it's a ranged attack or melee. Different values are used in melee.
     */
    public static void calculation(int nrOfAttacker, Unit attacker, Weapon weapon, Unit defender, boolean isRanged) {
    double hits;
    double wounds;
    double damage;
    int toHit;
    int attacks;
    int strength;


    Unit[] calcArray = new Unit[2];
    calcArray[0]=attacker;
    calcArray[1]=defender;
    if (isRanged) {
        toHit = calcArray[0].getBallisticSkill();
        attacks=weapon.getAttack();
        strength = weapon.getStrength();
    }
    else {
        toHit = calcArray[0].getWeaponSkill();
        attacks=calcArray[0].getAttack();
        strength = calcArray[0].getStrength() +weapon.getStrength();
    }

    hits = nrOfAttacker * attacks * (7-toHit)/6.;
    //System.out.println("Hits: "+hits); //diagnose tool

    wounds = (((7-strVsTou(strength,defender.getToughness()))/6.)*hits);
    //System.out.println("Wounds: "+wounds); //diagnose tool

    damage = wounds* (1-(totalArmorSave(weapon.getArmorPenetration(), defender.getArmorSave()))/6.);
    //System.out.println("Damage: "+damage); //diagnose tool

    JOptionPane.showMessageDialog(null,String.format("Total damage: %.2f D",damage*weapon.getDamage()));

}

    /**
     * Method to see how easy the hits wounds the defender.
     * If the attacker has double or more strength then the defenders toughness the hit wounds on 2 or more on the dice.
     * If the strength is lower the chance to wound degrees in steps down to 6+
     * @param attacker -Attackers strength
     * @param defender - Defenders toughness
     * @return - returns the value of how easy/hard it is to wound.
     */
    public static int strVsTou(int attacker, int defender){
    int chanceToWound;
    if (attacker>= 2* defender) chanceToWound=2;
    else if(attacker> defender) chanceToWound=3;
    else if(attacker==defender) chanceToWound=4;
    else if(attacker< defender) chanceToWound=5;
    else chanceToWound=6;

    //System.out.println("Chance to wound: "+chanceToWound +"+"); //diagnose tool
    return chanceToWound;
}

    /**
     * How good the armor protects it's wielder depends on the armor penetration of the weapon.
     * If the AP is greater then the armor then the armor will not help at all.
     * @param attacker - Attackers Armor-Penetration
     * @param defender - Defenders
     *                armor
     * @return -Returns how much of the armor is still functional.
     */
    public static int totalArmorSave(int attacker, int defender){
    int chanceForDamage;
    if (attacker>=defender) chanceForDamage=0;
    else chanceForDamage=defender-attacker;
    return chanceForDamage;


}
}
