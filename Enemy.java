public class Enemy extends Creature{

    public Enemy(int leveled){
        super("Filler", "Filler");
        this.level = 1;
        this.setName(randomName());
        this.setRole(randomRole());

        rollStats();
        if(leveled > 1){
            for(int i = 1; i < leveled; i++){
                levelUp();
            }
        }
        this.curHp = maxHp;

    }
    //random names
    public String randomName(){
        String[] names = {"Stonemorph", "Thornmorph", "Rottingtooth", "Delirious", "Smokefiend", "Gallbeast", "Aurabug", "Gutwings", "Vaporsoul", "Vexlich"};
        int index = (int)(Math.random() * names.length);

        return names[index];

    }
    //random roles that are passed into a function
    public String randomRole(){
        String[] roles = {"Orc", "Goblin", "Skeleton", "Troll", "Tyrant"};
        int index = (int)(Math.random() * roles.length);

        return roles[index];
    }
    public void rollStats(){
        int hp = 0;
        int att = 0;
        switch(roleToNumber()){
            case 1: hp = 18; att = 10; break;
            case 2: hp = 13; att = 13; break;
            case 3: hp = 10; att = 15; break;
            case 4: hp = 14; att = 16; break;
            case 5: hp = 10; att = 11; break;
        }
        maxHp = (roll(6) + hp);
        maxAtt = (roll(6) + att); 
        minAtt = (maxAtt - 3);

    }

    private int roll(int sides){
        int aRoll = (int)(Math.random() * sides + 1);
        return aRoll;
    }

    private int roleToNumber(){
        if(role.equalsIgnoreCase("Orc")){
            return 1;
        }else if(role.equalsIgnoreCase("Goblin")){
            return 2;
        }else if(role.equalsIgnoreCase("Skeleton")){
            return 3;
        }else if(role.equalsIgnoreCase("Troll")){
            return 4;
        }else if(role.equalsIgnoreCase("Tyrant")){
            return 5;
        }else{
            return 0;
        }
    }
    //level up of the enemy and stats that scale
    public void levelUp(){
        level++;
        int hp = 0;
        int att = 0;
        switch(roleToNumber()){
            case 1: hp = 24; att = 20; break;
            case 2: hp = 19; att = 19; break;
            case 3: hp = 16; att = 21; break;
            case 4: hp = 20; att = 22; break;
            case 5: hp = 16; att = 17; break;
        }
        maxHp += (hp * Math.random()/2 + .5);
        maxAtt += (att * Math.random()/2 + .7);
        minAtt = maxAtt - 6;
        this.curHp = maxHp;
    }
}
