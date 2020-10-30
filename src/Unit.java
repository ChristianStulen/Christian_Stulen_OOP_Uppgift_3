public class Unit {
    private  String name;
    private  int weaponSkill;
    private  int ballisticSkill;
    private  int strength;
    private  int toughness;
    private  int wound;
    private  int attack;
    private int armorSave;

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
    /*
    public String toString() {
        String out = "";

        out = "[" + name + " WS:" + weaponSkill + " BS:" + ballisticSkill + " S:" + strength + " T:" + toughness + " W:" + wound + " A:" + attack + " AS:" + armorSave +"]";

        return out;
    }

     */

}
