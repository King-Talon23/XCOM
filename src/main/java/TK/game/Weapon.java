package TK.game;

import java.util.Random;

public abstract class Weapon {
    Random rd = new Random();
    String name;
    Integer tier;
    Integer damage;
    Integer maxShotsFired;
    Integer ammo;
    Integer clipSize;
    Integer critChance;
    String sound;

    public Weapon(String name, Integer tier, Integer damage, Integer maxShotsFired, Integer clipSize, Integer critChance, String sound) {
        this.name = name;
        this.tier = tier;
        this.damage = damage;
        this.clipSize = clipSize;
        this.ammo = clipSize;
        this.critChance = critChance;
        this.sound = sound;
        this.maxShotsFired = maxShotsFired;
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
}
