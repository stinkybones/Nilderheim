public class Player extends Creature{
    public int xp;
    private int hpPotions = 5;

    public Player(String name, String role){
        super(name, role);
        this.level = 1;
        rollStats();
        this.curHp = maxHp;
    }    

    public String useHealthPotion(){
        if(hpPotions >= 1 ){
            this.setCurHp(this.getCurHp() + 25);
            hpPotions--;
            return hpPotions + " potions left.";
        }else{
            return "No potions to use.";
        }
    }
    public int getHealthPotion(){
        return hpPotions;
    }
    public void setHealthPotions(int newHpPotions){
        hpPotions = newHpPotions;
    }
    public int gainXp(Creature other){
        int x = other.getLevel();
        int gainedXp = x * (int)(Math.random() * (60 - 21) + 20);
        xp += gainedXp;
        return gainedXp;
    }

    public boolean checkXp(){
        if(xp >= level * 40){
            xp = xp - (level  * 40);
            levelUp();

            return true;
        }else{
            return false;
        }
    }
    public String status(){
        return name + " has " + curHp + "/" + maxHp + " health.";
    }
    public String getXp(){
        return xp + "/" + (level * 40);
    }

    //Starting stats
    public void rollStats(){
        int hp = 0;
        int att = 0;
        switch(roleToNumber()){
            case 1: hp = 16; att = 10; break;
            case 2: hp = 14; att = 13; break;
            case 3: hp = 12; att = 14; break;
        }
        maxHp = (roll(6) + hp);
        maxAtt = (roll(6) + att); 
        minAtt = (maxAtt - 3); 

    }

    private int roll(int sides){
        int aRoll = (int)(Math.random() * sides + 1);
        return aRoll;
    }
    //Role to a number
    private int roleToNumber(){
        if(role.equalsIgnoreCase("Warrior")){
            return 1;
        }else if(role.equalsIgnoreCase("Ranger")){
            return 2;
        }else if(role.equalsIgnoreCase("Mage")){
            return 3;
        }else{
            return 0;
        }
    }
    //coding for level up with modifiers based on role
    public void levelUp(){
        level++;
        int hp = 0;
        int att = 0;
        switch(roleToNumber()){
            case 1: hp = 24; att = 14; break;
            case 2: hp = 21; att = 19; break;
            case 3: hp = 16; att = 22; break;

        }
        maxHp += (hp * Math.random()/2 + .7);
        maxAtt += (att * Math.random()/2 + .5);
        minAtt = maxAtt - 3;
        this.curHp = maxHp;

    }
}
