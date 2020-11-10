/**
 * Weapon represents an item that Units can wield to improve their damage potential.
 * When a Weapon has been created it becomes immutable and cannot be changed.
 * @author Christian Stulen
 */
public class Weapon {
    private final String name;
    private final String meleeOrRanged;
    private final int strength;
    private final int damage;
    private final int attack;
    private final int armorPenetration;

    /**
     * Constructor for Weapon
     * @param n -Name
     * @param mr -Melee or Ranged
     * @param s -Strength
     * @param d -Damage
     * @param a -Attacks
     * @param ap -Armor Penetration
     */
    public Weapon(String n, String mr, int s, int d, int a, int ap) {
         name = n;
         meleeOrRanged = mr;
         strength = s;
         damage = d;
         attack = a;
         armorPenetration = ap;
    }

    public String getName() {
        return name;
    }

    public String getMeleeOrRanged() {
        return meleeOrRanged;
    }

    public int getStrength() {
        return strength;
    }

    public int getDamage() {
        return damage;
    }

    public int getAttack() {
        return attack;
    }

    public int getArmorPenetration() {
        return armorPenetration;
    }

    /**
     * toString that lay out the different values in a understandable way.
     */
    public String toString() {
       return "[" + name + " Type:" + meleeOrRanged + " S:" + strength + " D:" + damage + " A:" + attack + " AP:-" + armorPenetration + "]";

    }
}


