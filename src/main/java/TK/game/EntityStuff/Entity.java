package TK.game.EntityStuff;

import TK.game.Items.Item;
import TK.game.Weapons.Weapon;


import java.util.*;


import static TK.game.EntityStuff.Cover.*;
import static TK.game.EntityStuff.Cover.coverValue;
import static TK.game.game.getRandomIntInRange;


public abstract class Entity {
    public Integer hp;
    public Integer aim;
    public Integer mobility;
    public Integer hack;
    public Integer dodge;
    public Integer will;
    public Integer defense;

    public Integer cover;
    public Integer armour;
    public Weapon weapon;
    public List<Item> items;
    public Cover coverType;

    //numbers from 1-100 spread accross 3 lists to represent the result of shot
    List<Integer> missed = new ArrayList<>();
    List<Integer> grazed = new ArrayList<>();
    List<Integer> hit = new ArrayList<>();
    Integer result;

    Integer GRAZE_CHANCE = 20;


    public Entity(Integer hp, Integer aim, Integer mobility, Integer dodge, Integer will,
                  Integer defense, Integer hack, Integer armour, Weapon weapon, List<Item> items) {
        this.hp = hp;
        this.aim = aim;
        this.mobility = mobility;
        this.dodge = dodge;
        this.hack = hack;
        this.will = will;
        this.defense = defense;
        this.armour = armour;
        this.weapon = weapon;
        this.items = items;
        this.coverType = NONE;
        this.cover = coverValue.get(this.coverType);
    }

    public void isDead() {
        if (this.hp <= 0) {
            this.handleDeath();
        }
    }

    public void reload() {
        this.weapon.reload();
    }

    public void shootAtTarget(Entity target) {
        // doesDodge decreases the shot type from crit->hit->graze->miss
        boolean doesDodge = false;
        if (result < 100) {  // always false if entity has a 100% chanceToHit
            doesDodge = doesTargetDodge(target.dodge);
        }

        // doesCrit increases the shot type from miss->graze->hit->crit
        boolean doesCrit = doesShotCrit();

        result = getRandomIntInRange(1, 100);
        Weapon.ShotBehaviour shotType = getShotType(doesCrit, doesDodge);
        if (shotType != Weapon.ShotBehaviour.MISS) { // in case of shots being downgraded from graze to miss
            int damage = Weapon.shotTypeMap.get(shotType);

            if (target.armour > 0) {
                target.armour -= this.weapon.armourShredding;
                target.armour = Math.max(0, target.armour);
            }

            target.hp -= damage - target.armour;
            target.isDead();
        } else {
            System.out.print("missed! loser");
        }
        this.weapon.ammo--;
    }


    public int aimAtTarget(Entity target) {
        int hitChance = (this.aim + this.weapon.aimBonus) - (target.cover + target.defense);
        hitChance = Math.max(0, Math.min(hitChance, 100));
        hitChance -= 10; // half of graze chance is represented by the 10 lowest values of the hitChance

        int missChance = 100 - (GRAZE_CHANCE + hitChance);

        missed.clear();
        grazed.clear();
        hit.clear();
        for (int i = 0; i < 100; i++) {
            if (i <= missChance) {
                missed.add(i);
            } else if (i <= missChance + GRAZE_CHANCE) {
                grazed.add(i);
            } else {
                hit.add(i);
            }
        }

        return hitChance;
    }

    public abstract void handleDeath();

    private Weapon.ShotBehaviour getShotType(Boolean doesUpgrade, Boolean doesDowngrade) {
        Weapon.ShotBehaviour currentType;
        if (grazed.contains(result)) {
            currentType = Weapon.ShotBehaviour.GRAZE;
        } else if (hit.contains(result)) {
            currentType = Weapon.ShotBehaviour.HIT;
        } else {
            currentType = Weapon.ShotBehaviour.MISS;
        }

        if (doesUpgrade && !doesDowngrade) {
            return Weapon.shotUpgradeMap.get(currentType);
        } else if (!doesUpgrade && doesDowngrade) {
            return Weapon.shotDowngradeMap.get(currentType);
        }
        return currentType;
    }

    private Boolean doesShotCrit() {
        return getRandomIntInRange(1, 100) <= this.weapon.getTrueCritChance();
    }

    private Boolean doesTargetDodge(Integer dodge) {
        return getRandomIntInRange(1, 100) <= dodge;
    }
}
