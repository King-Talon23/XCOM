package TK.game.Weapons.Weapon_mods;

import static TK.game.Weapons.Weapon_mods.ModTier.modTierNameMap;

public abstract class WeaponMod {
    ModTier tier;

    public WeaponMod(ModTier tier) {
        this.tier = tier;
    }

    public String modName(){
      return modTierNameMap.get(this.tier) + " " +  getName();
    };

    public abstract Integer applyEffect();


    public abstract String getName();

    public abstract String getDescription();



}
