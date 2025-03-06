package TK.game.Weapons.Weapon_mods;

public class ExtendedMagazine extends WeaponMod{
    public ExtendedMagazine(ModTier tier){
        super(tier);
    }

    @Override
    public Integer applyEffect() {
        return this.tier.ordinal() + 1; // 1- 3
    }

    @Override
    public String getName() {
        return "Extended Magazine";
    }

    @Override
    public String getDescription() {
        return "Increases magazine/clip size";
    }


}
