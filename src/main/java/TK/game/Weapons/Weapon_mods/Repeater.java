package TK.game.Weapons.Weapon_mods;

public class Repeater extends WeaponMod{
    public Repeater(ModTier tier) {
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
        return "Repeater";
    }

    @Override
    public String getDescription() {
        return "Chance to instantly kill a target on hit";
    }
}
