package TK.game.Weapons.Weapon_mods;

public class Scope extends WeaponMod{
    public Scope(ModTier tier) {
        super(tier);
    }

    @Override
    public Integer applyEffect() {
        return switch(this.tier){
            case BASIC -> 5;
            case ADVANCED -> 10;
            case SUPERIOR -> 15;
        };
    }

    @Override
    public String getName() {
        return "Scope";
    }

    @Override
    public String getDescription() {
        return "Increases Aim";
    }
}
