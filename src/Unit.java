public class Unit {
     String name;
     int weaponSkill;
     int ballisticSkill;
     int strength;
     int toughness;
     int wound;
     int attack;
     int armorSave;

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
