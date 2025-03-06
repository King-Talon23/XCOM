package TK.game.Weapons.Weapon_mods;

public class LaserSight extends WeaponMod {
    public LaserSight(ModTier tier) {
        super(tier);
    }

    @Override
    public Integer applyEffect() {
        return switch(this.tier) {
            case BASIC -> 5;
            case ADVANCED -> 10;
            case SUPERIOR -> 15;
        };
    }

    @Override
    public String getName() {
        return "Laser Sight";
    }

    @Override
    public String getDescription() {
        return "Increases critical chance";
    }
}
