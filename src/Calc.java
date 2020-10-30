public class Calc {

public static void ranged(int nrOfAttacker, Unit attacker, Weapon weapon, Unit defender) {
    double hits;
    double wounds;
    double damage;

    System.out.println(attacker);
    System.out.println(attacker.toString());

    /*
    hits = nrOfAttacker * attacker * (7-attacker.ws)/6.;
    System.out.println("Hits: "+hits);
    wounds = ((7-strVsTou(attacker,defender)/6.)*hits);
    damage = wounds* (1-defender.armorSave/6.);
    return damage;
}

public static int strVsTou(Unit attacker, Unit defender){
    int chanceToWound;
    if (attacker.strength>= 2* defender.toughness) chanceToWound=2;
    else if(attacker.strength> defender.toughness) chanceToWound=3;
    else if(attacker.strength==defender.toughness) chanceToWound=4;
    else if(attacker.strength< defender.toughness) chanceToWound=5;
    else chanceToWound=6;
    return chanceToWound;
}

     */
}
}
