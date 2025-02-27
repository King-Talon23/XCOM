package TK.game.Weapons;

public class DevPistol extends Weapon{
    public DevPistol(Tier tier) {
        super(tier);
        this.tier = Tier.FOUR;
    }

    @Override
    public String getSound() {
        return "pew";
    }

    @Override
    public String getName() {
        return "Dev Gun";
    }

    @Override
    public Integer getBaseDamage() {
        return 999;
    }

    @Override
    public Integer getMaxShots() {
        return 99;
    }

    @Override
    public Integer getzClipSize() {
        return 999;
    }

    @Override
    public Integer getCritChance() {
        return 101;
    }
}
