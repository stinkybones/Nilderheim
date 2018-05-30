import java.util.Scanner;
public class MyProgram
{

    public static void main(String[] args)
    {
        Scanner readName = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String userName = readName.nextLine();

        Scanner readRole = new Scanner(System.in);
        System.out.println("As a warrior you have more hp out of all the other classes but suffer low attack damage");
        System.out.println("As a ranger you are a well balanced class but often suffer low hp and damage late game");
        System.out.println("As a mage you have the highest attack out of all other classes but suffer low hp pool");
        System.out.println("Choose your role (Warrior, Ranger, Mage): ");
        String userRole = readRole.nextLine();
        while(true){
            if(userRole.equalsIgnoreCase("Warrior") || userRole.equalsIgnoreCase("Ranger") || userRole.equalsIgnoreCase("Mage")){
                break;
            }else{
                System.out.println("Choose a valid role");
                readRole = new Scanner(System.in);
                System.out.print("Choose your role (Warrior, Ranger, Mage): ");
                userRole = readRole.nextLine();
            }
        }
        System.out.println("Welcome Adventurer, This basis of the game is to save the king that has been kidnapped which has sent the town of Nilderheim into a deep plunge of chaos. ");
        System.out.println("Will you help us Adventurer?");
        //a demo of all of the systems
        System.out.println("");
        Player player = new Player(userName, userRole); 

        scene(player, "a dark cave");
        if(!player.isDead()){
            scene(player, "a dark room");
        }
        if(!player.isDead()){
            scene(player, "a dark hallway");
        }
        if(!player.isDead()){
            scene(player, "a mossy damp room");
        }
        if(!player.isDead()){
            System.out.println("As you enter through a strange door in the dungeon you start to hear someone yelling for help.");
            System.out.println("You walk towards the sound in the dark damp mossy room.");
            System.out.println("As you come closer you start to realize that the man in chains is the king of Nilderheim");
            System.out.println("You bring the king back to the town of Nilderheim to restore peace and order within the kingdom");
            System.out.println("Well done! The deed is done, you recieve the kings blessing and treasure for your heroic acts");
        }
         if(player.isDead()){
            System.out.println("Try again next time.");
        }
        
        

    }
    public static String attack(Creature one, Creature two){
        int a = one.attack(two);
        return one.getName() + " hit " + two.getName() + " for " + a + " damage.";
    }

    public static void battle(Player one, Creature two){
        System.out.println(one);
        System.out.println(two);

        while(true){
            Scanner readChoice = new Scanner(System.in);
            System.out.print("\nWhat do you want to do (Attack, Run, Status, Use Potion): ");
            String userChoice = readChoice.nextLine();
            while(true){
                if(!userChoice.equalsIgnoreCase("Status") && !userChoice.equalsIgnoreCase("Run") && !userChoice.equalsIgnoreCase("Attack") && !userChoice.equalsIgnoreCase("Use Potion")){
                    System.out.println("Choose a valid choice");
                    readChoice = new Scanner(System.in);
                    System.out.print("\nWhat do you want to do (Attack, Run, Status, Use Potion): ");
                    userChoice = readChoice.nextLine();
                }else{
                    break;
                }
            }
            if(userChoice.equalsIgnoreCase("Status")){
                System.out.println(one.status());

                continue;
            }

            if(userChoice.equalsIgnoreCase("Use Potion")){
                System.out.println(one.useHealthPotion());
                System.out.println(one.status());

                continue;
            }

            if(userChoice.equalsIgnoreCase("Run")){
                int run = (int)(Math.random() * 100 + 1);
                if(run >= 50){
                    System.out.println("You successfully run.");
                    break;
                }else{
                    System.out.println("You fail at running.");

                }

            }else if(userChoice.equalsIgnoreCase("Attack")){
                System.out.println(attack(one, two));
                System.out.println(two.status());

            }
            if(!two.isDead()){
                System.out.println(attack(two, one));
                System.out.println(one.status());

                if(one.isDead()){
                    System.out.println("You died!");
                    break;
                }
            }else{
                System.out.println("You killed " + two.getName() + "\n");
                System.out.println("You gained " + one.gainXp(two) + " exp");
                if(one.checkXp()){
                    System.out.println("You leveled up, your health is restored!");
                    System.out.println("You have " + one.getXp() + " exp");
                }else{
                    System.out.println("You have " + one.getXp() + " exp");
                }
                System.out.println(one + "\n");
                break;
            }
        }
    }
    public static void scene(Player one, String description){
        System.out.println(one.getName() + " arrives at " + description);

        int x = (int)(Math.random() * 3 + 1);

        for(int i = 0; i < x; i++){
            if(one.isDead()){
                break;
            }
            Enemy randEnemy = new Enemy(one.getLevel());
            System.out.println("\nYou encounter " + randEnemy.getName() + " the " + randEnemy.getRole());
            battle(one, randEnemy);
        }

    }
}
