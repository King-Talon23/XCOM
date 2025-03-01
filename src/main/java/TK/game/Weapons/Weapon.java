package TK.game.Weapons;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import static TK.game.Weapons.Tier.*;
import static TK.game.Weapons.WeaponType.ALL;
import static TK.game.game.getRandomIntInRange;

public abstract class Weapon {
    Random rd = new Random();
    public String name;
    public Tier tier;
    public Integer damage;
    public Integer ammo;
    public Integer clipSize;
    public Integer critChance;
    public String sound;

    public Weapon(Tier tier) {
        this.name = getName();
        this.tier = tier;
        this.damage = getBaseDamage();
        this.clipSize = getzClipSize();
        this.ammo = getCritChance();
        this.critChance = getCritChance();
        this.sound = getSound();
        this.critDamage = getCritDamage();
        this.

    }

    public void reload() {
        this.ammo = this.clipSize;
    }


    public int shoot() {
        int totalDamage = getRandomIntInRange(getBaseDamage(), (getBaseDamage() + getDamageSpread()));
        if (getRandomIntInRange(1, 100) < getPlusOneChance()) {
            totalDamage += 1;
        }
        System.out.print(this.sound);

        return totalDamage;

    }

    public abstract String getSound();

    public abstract String getName();

    public abstract Integer getBaseDamage();

    public abstract Integer getzClipSize();

    public abstract Integer getCritChance();

    public abstract Integer getCritDamage();

    public abstract Integer getDamageSpread();

    public abstract Integer getPlusOneChance();

    public abstract Integer getAimBonus();

    public static java.util.List<String> lightGunSounds = new ArrayList<>();

    // SMGs and ARs
    static {
        lightGunSounds.add("*BRRRRRRR*");
        lightGunSounds.add("*Pew-Pew-Pew*");
        lightGunSounds.add("*Bang-Bang*");
        lightGunSounds.add("*BRRAP!*");
    }

    public static java.util.List<String> heavyGunSounds = new ArrayList<>();

    // Snipers and Shotguns
    static {
        heavyGunSounds.add("*BANG*");
        heavyGunSounds.add("*CRACK");
        heavyGunSounds.add("*POP!*");
        heavyGunSounds.add("*SNAP*");
        heavyGunSounds.add("*POW*");
        heavyGunSounds.add("*CHK CHK BOOM!*");
    }
}
