import javax.swing.*;

public class Calc {

public static void ranged(int nrOfAttacker, Unit attacker, Weapon weapon, Unit defender,boolean isRanged) {
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
    System.out.println("Hits: "+hits);
    wounds = (((7-strVsTou(strength,defender.getToughness()))/6.)*hits);
    System.out.println("Wounds: "+wounds);
    damage = wounds* (1-(totalArmorSave(weapon.getArmorPenetration(), defender.getArmorSave()))/6.);
    System.out.println("Damage: "+damage);
    JOptionPane.showMessageDialog(null,String.format("Total damage: %.2f D",damage*weapon.getDamage()));

}

public static int strVsTou(int attacker, int defender){
    int chanceToWound;
    if (attacker>= 2* defender) chanceToWound=2;
    else if(attacker> defender) chanceToWound=3;
    else if(attacker==defender) chanceToWound=4;
    else if(attacker< defender) chanceToWound=5;
    else chanceToWound=6;

    System.out.println("Chance to wound: "+chanceToWound);
    return chanceToWound;
}
public static int totalArmorSave(int attacker, int defender){
    int chanceForDamage;
    if (attacker>=defender) chanceForDamage=0;
    else chanceForDamage=defender-attacker;
    return chanceForDamage;


}
}
