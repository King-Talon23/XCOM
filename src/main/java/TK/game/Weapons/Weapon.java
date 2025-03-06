package TK.game.Weapons;

import TK.game.Weapons.Weapon_mods.*;

import java.util.List;

import static TK.game.game.getRandomIntInRange;

public abstract class Weapon {
    public String name;
    public WeaponTier weaponTier;
    public Integer damage;
    public Integer ammo;
    public Integer clipSize;
    public Integer critChance;
    public String sound;
    public Range range;
    public Integer armourShredding;
    public Integer aimBonus;
    public Integer freeReloads;

    public List<WeaponMod> weaponMods;

    public Weapon(WeaponTier weaponTier) {
        this.weaponTier = weaponTier;
        this.name = getName();
        this.damage = getBaseDamage();
        this.ammo = getTrueClipSize();
        this.clipSize = getTrueClipSize();
        this.range = getEffectiveRange();
        this.armourShredding = getArmourShredding();
        this.aimBonus = getTrueAimBonus();
        this.sound = getSound();
        this.freeReloads = getFreeReloads();
    }

    public void reload() {
        this.ammo = this.clipSize;
    }


    public Integer shoot() {
        // damage range is between base damage and the damage spread added to the base
        int totalDamage = getRandomIntInRange(getBaseDamage(), (getBaseDamage() + getDamageSpread()));

        if (getTrueCritChance() >= getRandomIntInRange(1, 100)) {
            totalDamage += getDamageOnCrit();
        }
        if (getRandomIntInRange(1, 100) <= getInstantKillChance()) {
            totalDamage += 999;
            System.out.print("Repeater Activated");
        }
        return totalDamage;
    }


    public Integer getTrueAimBonus() {
        return (getAimBonus() + cycleThroughMods(Scope.class));
    }

    public Integer getTrueCritChance() {
        return getCritChance() + cycleThroughMods(LaserSight.class);
    }

    public Integer getMissedShotDamage() {
        return cycleThroughMods(Stock.class);
    }

    public Integer getTrueClipSize() {
        return cycleThroughMods(ExtendedMagazine.class);
    }

    public Integer getInstantKillChance() {
        return cycleThroughMods(Repeater.class);
    }

    public Integer getFreeReloads() {
        return cycleThroughMods(AutoLoader.class);
    }

    private Integer cycleThroughMods(Class<? extends WeaponMod> modClass) {
        // returns 0 if the player doesnt have the required mod
        for (WeaponMod mod : weaponMods) {
            if (modClass.isInstance(mod)) {
                return mod.applyEffect();
            }
        }
        return 0;
    }


    public Integer getAllowedMods() {
        // returns the amount of mods that can be added to a weapon based off tier
        return switch (this.weaponTier) {
            case CONVENTIONAL -> 1;
            case MAGNETIC, PLASMA -> 2;
        };
    }

    public abstract String getSound();

    public abstract String getName();

    public abstract Integer getBaseDamage();

    public abstract Integer getClipSize();

    public abstract Integer getCritChance();

    public abstract Integer getDamageOnCrit();

    public abstract Integer getDamageSpread();

    public abstract Integer getPlusOneChance();

    public abstract Integer getAimBonus();

    public abstract Range getEffectiveRange();

    public abstract Integer getArmourShredding();

}
