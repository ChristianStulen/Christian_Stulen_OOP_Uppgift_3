public class Weapon {
    private String name;
    private String meleeOrRanged;
    private int strength;
    private int damage;
    private int attack;
    private int armorPenetration;

    public Weapon(String n, String mr, int s, int d, int a, int ap) {
         name = n;
         meleeOrRanged = mr;
         strength = s;
         damage = d;
         attack = a;
         armorPenetration = ap;
    }

    public String toString() {
        String out = "";

        out = "[" + name + " Type:" + meleeOrRanged + " S:" + strength + " D:" + damage + " A:" + attack + " AP:-" + armorPenetration + "]";

        return out;
    }
}


