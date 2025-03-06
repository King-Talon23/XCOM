package TK.game.Weapons.Weapon_mods;

public class HairTrigger extends WeaponMod{
    public HairTrigger(ModTier tier) {
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
        return "Hair Trigger";
    }

    @Override
    public String getDescription() {
        return "Chance to gain a free action on hit";
    }
}
