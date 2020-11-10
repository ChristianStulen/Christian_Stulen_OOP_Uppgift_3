/**
 * Unit represents an unit in the game Warhammer 40k. They have several different stats
 * that's used together with dice to get results.
 * When a Unit has been created it becomes immutable and cannot be changed.
 * @author Christian Stulen
 */

public class Unit {
    private final String name;
    private final int weaponSkill;
    private final int ballisticSkill;
    private final int strength;
    private final int toughness;
    private final int wound;
    private final int attack;
    private final int armorSave;

    /**
     * Constructor for Unit.
     * @param n -Name
     * @param ws -Weapon skill
     * @param bs -Ballistic skill
     * @param s -Strength
     * @param t -Toughness
     * @param w -Wound
     * @param a -Attack
     * @param as -Armor Save
     */
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

    /**
     * toString that lay out the different values in a understandable way.
     */

    public String toString() {

        return "[" + name + " WS:" + weaponSkill + " BS:" + ballisticSkill + " S:" + strength + " T:" + toughness + " W:" + wound + " A:" + attack + " AS:" + armorSave +"]";

    }



}
