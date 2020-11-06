public class Unit {
    private final String name;
    private final int weaponSkill;
    private final int ballisticSkill;
    private final int strength;
    private final int toughness;
    private final int wound;
    private final int attack;
    private final int armorSave;

    public String getName() {
        return name;
    }

    public int getWeaponSkill() {
        return weaponSkill;
    }

    public int getBallisticSkill() {
        return ballisticSkill;
    }

    public int getStrength() {
        return strength;
    }

    public int getToughness() {
        return toughness;
    }

    public int getWound() {
        return wound;
    }

    public int getAttack() {
        return attack;
    }

    public int getArmorSave() {
        return armorSave;
    }

    public Unit(String n, int ws, int bs, int s, int t, int w, int a, int as){
        name=n;
        weaponSkill=ws;
        ballisticSkill=bs;
        strength=s;
        toughness=t;
        wound=w;
        attack=a;
        armorSave=as;

    }

    public String toString() {

        return "[" + name + " WS:" + weaponSkill + " BS:" + ballisticSkill + " S:" + strength + " T:" + toughness + " W:" + wound + " A:" + attack + " AS:" + armorSave +"]";

    }



}
