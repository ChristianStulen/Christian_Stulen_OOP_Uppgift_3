public class Weapon {
     String name;
     String meleeOrRanged;
     int strength;
     int damage;
     int attack;
     int armorPenetration;

    public Weapon(String n, String mr, int s, int d, int a, int ap) {
         name = n;
         meleeOrRanged = mr;
         strength = s;
         damage = d;
         attack = a;
         armorPenetration = ap;
    }

    public String toString() {
       return "[" + name + " Type:" + meleeOrRanged + " S:" + strength + " D:" + damage + " A:" + attack + " AP:-" + armorPenetration + "]";

    }
}


