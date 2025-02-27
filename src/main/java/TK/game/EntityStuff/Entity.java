package TK.game.EntityStuff;

import TK.game.Weapons.ShotGun;
import TK.game.Weapons.SniperRifle;
import TK.game.Weapons.Weapon;

import java.util.List;
import java.util.Random;

import static TK.game.game.getRandomIntInRange;
import static TK.game.game.getRandomListItem;

public abstract class Entity {
    Random rd = new Random();
    public Integer hp;
    public Integer aim;
    public String firstname;
    public String lastname;
    public Rank rank;
    public Integer armour;
    public Weapon weapon;
    public List<String> items;
    public Integer cover;
    public Boolean onOverwatch;

    public Entity(Integer hp, Integer aim,Rank rank, Integer armour, Weapon weapon, List items) {
        this.hp = hp;
        this.aim = aim;
        this.rank = rank;
        this.firstname = getFirstname();
        this.lastname = getLastname();
        this.armour = armour;
        this.weapon = weapon;
        this.items = items;
        this.cover = 0;
        this.onOverwatch = false;
    }

    public void isDead() {
        if (this.hp <= 0) {
            this.handleDeath();
        }
    }
    public void reload() {
        this.weapon.reload();
    }

    public abstract String getFirstname();
    public abstract String getLastname();

    private int isCrit(Entity target) {
        return this.weapon.critChance - target.cover / 4;
    }

    private Boolean doesWeaponHit(Integer chanceToHit){
        return getRandomIntInRange(1,100) < chanceToHit;
    }

    public boolean shootAtTarget(Entity target, Integer chanceToHit) {

        int crit = this.isCrit(target);
        this.onOverwatch = false; // shooting turns off overwatch
        if (doesWeaponHit(chanceToHit)) {
            int damage = this.weapon.shoot();
            System.out.print(this.weapon.sound);
            if (getRandomIntInRange(1,100) < crit) {
                System.out.print("CRITICAL!");
                damage += damage / 2; // 50% crit bonus
            }
            System.out.print(damage + " damage!");
            target.hp -= damage;
            target.isDead();
            return true;
        } else {
            this.weapon.ammo -= 1;
            System.out.print(this.weapon.sound);
            System.out.print("Missed!");
            return false;
        }
    }

    public int aimAtTarget(Entity target) {
        int hitChance = this.aim - target.cover;

        if (this.items.contains("scope")){
            hitChance += 10;
        }
        if (this.weapon instanceof SniperRifle) {
            hitChance += 10;
        }
        if (this.weapon instanceof ShotGun) {
            hitChance -= 10;
        }
        hitChance = Math.max(0, Math.min(hitChance, 100));
        return hitChance;
    }


    public boolean handleOverwatch(Entity target) {
        int chance = this.aimAtTarget(target);
        return this.shootAtTarget(target, chance);
    }

    public abstract void handleDeath();
}
