package TK.game.EntityStuff.AlienStuff;

import TK.game.EntityStuff.Entity;
import TK.game.EntityStuff.Rank;
import TK.game.Weapons.Weapon;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static TK.game.game.getRandomIntInRange;
import static TK.game.game.getRandomListItem;
public class Alien extends Entity {
    Integer enemyID;
    AlienType type;

    public Alien(Integer enemyID, AlienType type, Integer hp, Integer aim, Integer mobility, Rank rank, Integer armour, Weapon weapon, List items) {
        super(hp, aim, mobility, rank, armour, weapon, items);

        this.enemyID = enemyID;
        this.type = type;
        this.hp = (this.rank.ordinal() + 1) * getRandomIntInRange(0, 3);
        this.aim = (this.rank.ordinal() + 1) * getRandomIntInRange(0, 3);
    }

    public PrintStream printFullName() {
        return System.out.printf("(%s) %s %s %s",this.type, this.rank, this.firstname, this.lastname);
    }


    @Override
    public String getFirstname() {
        return getRandomListItem(alienFirstNames);
    }

    @Override
    public String getLastname() {
        return getRandomListItem(alienLastNames);
    }

    @Override
    public void handleDeath() {
        //future methods needed
        System.out.print(this.firstname + "died");
        // get_loot(this);
        // drop();
        // check_xp();

        // room[room_number].remove(this);
    }

    private static final List<String> alienFirstNames = new ArrayList<>(Arrays.asList(
            "Zeebler",
            "Glorp",
            "Goober",
            "Zebop",
            "Allen",
            "Thrax",
            "Torvax",
            "Xyphor",
            "Veltrax",
            "Ulthor",
            "Nexor",
            "Krylox",
            "Zarkon",
            "John F."
    ));
    private static final List<String> alienLastNames = new ArrayList<>(Arrays.asList(
            "The Alien",
            "Kennedy"
    ));
}
