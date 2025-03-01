package TK.game.Weapons;

import static TK.game.game.getRandomIntInRange;
import static TK.game.game.getRandomListItem;


public class SubMachineGun extends Weapon {
    public SubMachineGun(Tier tier) {
        super(tier);
    }

    @Override
    public String getSound() {
        return getRandomListItem(lightGunSounds);
    }

    @Override
    public String getName() {
        return getRandomListItem(SMGNames);
    }

    @Override
    public Integer getBaseDamage() {
        // damage per bullet
        return switch (this.tier) {
            case ONE -> 1;

            case TWO, THREE -> 2;

            case FOUR -> 3;
        };
    }

    @Override
    public Integer getMaxShots() {
        return switch (this.tier) {
            case ONE -> 10;

            case TWO -> 12;

            case THREE -> 14;

            case FOUR -> 18;

        };
    }

    @Override
    public Integer getzClipSize() {
        return switch (this.tier) {
            case ONE -> 30;

            case TWO -> 35;

            case THREE -> 40;

            case FOUR -> 50;
        };
    }

    @Override
    public Integer getCritChance() {
        return switch (this.tier) {
            case ONE -> getRandomIntInRange(1, 2);

            case TWO -> getRandomIntInRange(2, 3);

            case THREE -> getRandomIntInRange(3, 4);

            case FOUR -> getRandomIntInRange(5, 7);
        };
    }
}
