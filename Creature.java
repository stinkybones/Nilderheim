public class Creature{

    public String name;
    public String role;
    public int maxHp;
    public int maxAtt;
    public int minAtt;
    public int level;
    public int curHp;

    public Creature(String name, String role){
        this.name = name;
        this.role = role;
    }

    public int attack(Creature other){
        int att = (int)(Math.random() * (this.maxAtt - this.minAtt + 1) + this.minAtt);
        other.curHp -= att;
        return att;
    }

    public boolean isDead(){
        if(this.curHp <= 0){
            return true;
        }else{
            return false;
        }
    }
    public int getCurHp(){
        return curHp;
    }
    public void setCurHp(int hp){
        if(hp >= maxHp - curHp){
            curHp = maxHp;
        }else{
            curHp = hp;
        }
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name; 
    }
    public String getRole(){
        return role;
    }
    public void setRole(String role){
        this.role = role;
    }
    public int getMaxHp(){
        return maxHp;
    }
    public int getLevel(){
        return level;
    }
    public String status(){
        return name + " has " + curHp + "/" + maxHp + " health.";
    }

    public String toString(){
        return name +  " the " + role + " is level " + level + " with " + curHp + "/" + maxHp + " HP and an attack of " + maxAtt + "-" + minAtt;
    }

}
