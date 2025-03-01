package TK.game.Weapons;

import java.util.Random;

import static TK.game.game.getRandomIntInRange;
import static TK.game.game.getRandomListItem;

public class ShotGun extends Weapon {

    public ShotGun(Tier tier) {
        super(tier);
    }

    @Override
    public String getSound() {
        return getRandomListItem(heavyGunSounds);
    }

    @Override
    public String getName() {
        return getRandomListItem(shotgunNames);
    }

    @Override
    public Integer getBaseDamage() {
        // damage per bullet
        return switch (this.tier) {
            case ONE -> getRandomIntInRange(7, 8);

            case TWO -> getRandomIntInRange(9, 10);

            case THREE -> getRandomIntInRange(11, 12);

            case FOUR -> getRandomIntInRange(14, 16);
        };
    }

    @Override
    public Integer getMaxShots() {
        return switch (this.tier) {
            case ONE, TWO, THREE -> 1;

            case FOUR -> 2;
        };
    }

    @Override
    public Integer getzClipSize() {
        return switch (this.tier) {
            case ONE -> 2;

            case TWO -> 4;

            case THREE -> 6;

            case FOUR -> 8;

        };
    }

    @Override
    public Integer getCritChance() {
        // shotguns have a higher chance to crit because of their low chance to hit
        return switch (this.tier) {
            case ONE -> getRandomIntInRange(15, 20);

            case TWO -> getRandomIntInRange(20, 25);

            case THREE -> getRandomIntInRange(25, 30);

            case FOUR -> getRandomIntInRange(33, 40);
        };
    }
}
