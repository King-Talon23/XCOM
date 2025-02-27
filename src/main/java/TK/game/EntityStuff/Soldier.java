package TK.game.EntityStuff;

import TK.game.Weapons.DevPistol;
import TK.game.Weapons.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static TK.game.EntityStuff.Rank.*;
import static TK.game.Weapons.Tier.FOUR;
import static TK.game.Weapons.Tier.ONE;
import static TK.game.Weapons.Weapon.createWeaponList;
import static TK.game.Weapons.WeaponType.ALL;
import static TK.game.game.getRandomIntInRange;
import static TK.game.game.getRandomListItem;
import static TK.game.Weapons.Weapon.c;

public class Soldier extends Entity {
    Integer ap;
    Integer soldierID;
    Integer xp;
    String nickname;
    List<String> bodyMods;
    Integer hunkerBonus;

    public Soldier(Integer soldierID, Integer hp, Integer aim, Integer mobility, Rank rank, Integer armour, Weapon weapon, List items, Integer bodyModifiers) {
        super(hp, aim, rank, armour, weapon, items);

        this.ap = mobility;
        this.soldierID = soldierID;
        this.xp = 0;
        this.nickname = null;
        this.bodyMods = new ArrayList<>();
        this.hunkerBonus = 0;
    }

    @Override
    public String getFirstname() {
        int gender = getRandomIntInRange(1, 2);
        return switch (gender) {
            case 1 -> getRandomListItem(maleOperativeFirstNames);
            case 2 -> getRandomListItem(femaleOperativeFirstNames);
            default -> throw new IllegalStateException("Unexpected value: " + gender);
        };
    }

    @Override
    public String getLastname() {
        return getRandomListItem(lastnames);
    }

    @Override
    public void handleDeath() {
        System.out.println("\n                                    _ ._  _ , ._ _");
        System.out.println("                                  (_  ' ( `  )_ .__)");
        System.out.println("                                ( (  (    )   `)  ) _)");
        System.out.println("                               (__ (_   (_ . _) _) ,__)");
        System.out.println("                                   `--`\\  ' . /`--`");
        System.out.println("                                   ,::: ;    ; :::,");
        System.out.println("                                   '::::::::::::::'");
        System.out.println("╭──────────────────────────────────────/ ─ ── \\────────────────────────────────────╮");
        System.out.println("│                                     lol you died                                 │");
        System.out.println("│                                       (loser)                                    │");
        System.out.println("│                                (didn't even do good)                             │");
        System.out.println("╰──────────────────────────────────────────────────────────────────────────────────╯");

        System.exit(0);
    }

    public void shootOverwatch(Entity target) {
        if (!this.handleOverwatch(target)) { // if overwatch misses
            System.out.printf("%s: %s", this.firstname, getRandomListItem(overwatchMissRetort));
        }
    }

    public void levelUp() {
        Rank oldRank = this.rank;
        this.rank = rankUpgradePath.get(this.rank);
        int hpIncrease = (this.rank.ordinal() + 1) * getRandomIntInRange(1, 3);
        int aimIncrease = (this.rank.ordinal() + 1) * getRandomIntInRange(1, 2);
        this.hp += hpIncrease;
        this.aim += aimIncrease;
        System.out.println("LEVEL UP");
        System.out.println("--------------------");
        System.out.printf("\n%s -> %s", oldRank, this.rank);
        System.out.printf("\nHP + %s", hpIncrease);
        System.out.printf("\nAim + %s", aimIncrease);
    }

    public void printSummary() {
        String middle = " ";
        if (this.nickname != null) {
            middle = " '" + this.nickname + "' ";
        }
        System.out.print(this.rank + " " + this.firstname + middle + this.lastname + " - " + this.hp + " HP" + " - " + this.aim + " Aim" + " - " + this.ap + " AP");
        System.out.print("Weapon: " + this.weapon.name);

        // Items still have to be created
        System.out.print("Items: " + this.items[0].name + ", " + this.items[1].name);
    }

    private static final List<String> maleOperativeFirstNames = new ArrayList<>(Arrays.asList("Nomad", "Jin", "Richard", "David", // Solid snake (MGS5)
            "Clark", "Talon", "Luc"));

    private static final List<String> maleNickNames = new ArrayList<>(Arrays.asList("The King", "The Rook", "The Knight", "Mr. President", "Solid Snake"));

    private static final List<String> femaleOperativeFirstNames = new ArrayList<>(Arrays.asList("Eivor", "Lauren"));

    private static final List<String> femaleNickNames = new ArrayList<>(Arrays.asList("The Queen", "The Bishop"));

    private static final List<String> lastnames = new ArrayList<>(Arrays.asList("Sakai", "Nixon", "Bond", "King", "[Classified]", "Kent"));

    private static final List<String> overwatchMissRetort = new ArrayList<>(Arrays.asList("Damn it, missed the target!", "Shot wide!", "Need to work on my aim.", "Target still active.", "Missed the mark!", "No joy here.", "I've got to do better.", "They're getting away!", "Next time, I'll get 'em.", "Gotta concentrate.", "Enemy still standing.", "Close! But not good enough."));

    public Soldier createSoldier(Integer soldierID) {
        // items still to be added
        // items = [rd.choice([item_grenade, item_serum, item_scope]),
        // rd.choice([item_grenade, item_serum, item_uav, item_emp])]
        ap = getRandomIntInRange(10, 15);
        body_modifiers = []

        if (getRandomIntInRange(1, 100) <= 5) {
            // Nomad is a dev character used to beat the game easily for bug finding and test playing if
            return Soldier(soldierID, 999, 100, 100, GENERAL_COMMANDER, armour, new DevPistol(FOUR), items, body_modifiers);
        }

        // Create regular soldier, 10 % to start with a tier 3 - 4 weapon
        ArrayList<Weapon> weaponList = createWeaponList(ONE, FOUR, ALL);
        weapon = weaponList.get(rd.nextInt(weaponList.size()));

        return Soldier(soldierID, rd.randint(90, 110), rd.randint(50, 75), ap, ROOKIE, armour, weapon, items, body_modifiers);
    }
}
