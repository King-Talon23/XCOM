package TK.game.Weapons;

import java.util.Random;

public class ShotGun extends Weapon {
    Random random = new Random();

    public ShotGun(Tier tier) {
        super(tier);
    }

    @Override
    public String getSound() {
        return heavyGunSounds.get(random.nextInt(heavyGunSounds.size()));
    }

    @Override
    public String getName() {
        return shotgunNames.get(random.nextInt(shotgunNames.size()));
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
