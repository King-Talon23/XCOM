package TK.game.Weapons;

import java.util.ArrayList;
import java.util.Random;

public abstract class Weapon {
    Random rd = new Random();
    String name;
    Tier tier;
    Integer damage;
    Integer maxShotsFired;
    Integer ammo;
    Integer clipSize;
    Integer critChance;
    String sound;

    public Weapon(Tier tier) {
        this.name = getName();
        this.tier = tier;
        this.damage = getBaseDamage();
        this.clipSize = getzClipSize();
        this.ammo = getCritChance();
        this.critChance = getCritChance();
        this.sound = getSound();
        this.maxShotsFired = getMaxShots();
    }

    public void reload() {
        this.ammo = this.clipSize;
    }


    public int shoot() {
        int totalDamage = 0;
        int shotsFired = rd.nextInt(maxShotsFired);
        if (shotsFired == 0) {
            shotsFired = 1;
        }
        if (shotsFired > this.ammo) {
            shotsFired = this.ammo;
        }
        System.out.print(this.sound);
        String plural;
        switch (shotsFired) {
            case 1 -> plural = "shot";
            default -> plural = "shots";
        }
        System.out.printf("%s %s fired!", shotsFired, plural);

        while (shotsFired > 0) {
            this.ammo -= 1;
            totalDamage += (this.damage + (rd.nextInt(4) - 1));
            // damage variation between -1 and +2
            shotsFired--;
            if (this.ammo == 0) {
                System.out.print("Out of ammo");
                return totalDamage;
            }
        }
        if (totalDamage <= 0) {
            totalDamage = 1;
            return totalDamage;
        }
        return totalDamage;

    }

    public abstract String getSound();
    public abstract String getName();
    public abstract Integer getBaseDamage();
    public abstract Integer getMaxShots();
    public abstract Integer getzClipSize();
    public abstract Integer getCritChance();
    public int getRandomIntInRange(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Minimum cannot be higher than maximum");
        }
        return rd.nextInt((max - min) + 1) + min;
    }

    public static java.util.List<String> sniperNames = new ArrayList<>();
    static {
        sniperNames.add("M82");
        sniperNames.add("Barret .50Cal");
        sniperNames.add("Remington 700");
        sniperNames.add("M40");
        sniperNames.add("Tac50");
    }

    public static java.util.List<String> shotgunNames = new ArrayList<>();
    static {
        shotgunNames.add("Spas-12");
        shotgunNames.add("KSG");
    }

    public static java.util.List<String> ARNames = new ArrayList<>();
    static {
        ARNames.add("AK-47");
        ARNames.add("M16");
        ARNames.add("AUG");
        ARNames.add("AR-15");
        ARNames.add("Scar");
        ARNames.add("M4A1");
    }
    public static java.util.List<String> SMGNames = new ArrayList<>();
    static {
        SMGNames.add("MP5");
        SMGNames.add("Uzi");
        SMGNames.add("MP7");
        SMGNames.add("P90");
        SMGNames.add("Mac-10");
        SMGNames.add("Vector");
    }
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
