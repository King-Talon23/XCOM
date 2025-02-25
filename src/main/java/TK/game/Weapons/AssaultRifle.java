package TK.game.Weapons;

import java.util.Random;

public class AssaultRifle extends Weapon {
    Random random = new Random();

    public AssaultRifle(Tier tier) {
        super(tier);
    }


    @Override
    public String getSound() {
        return lightGunSounds.get(random.nextInt(lightGunSounds.size()));
    }

    @Override
    public String getName() {
        return ARNames.get(random.nextInt(ARNames.size()));
    }

    @Override
    public Integer getBaseDamage() {
        // damage per bullet
        return switch (this.tier) {
            case ONE -> getRandomIntInRange(2, 3);

            case TWO -> getRandomIntInRange(3, 4);

            case THREE -> getRandomIntInRange(4, 5);

            case FOUR -> getRandomIntInRange(6, 7);

        };
    }

    @Override
    public Integer getMaxShots() {
        return switch (this.tier) {
            case ONE -> 3;

            case TWO -> 4;

            case THREE -> 5;

            case FOUR -> 7;

        };
    }

    @Override
    public Integer getzClipSize() {
        return switch (this.tier) {
            case ONE -> 6;

            case TWO -> 9;

            case THREE -> 12;

            case FOUR -> 15;
        };
    }


    @Override
    public Integer getCritChance() {
        return switch (this.tier) {
            case ONE -> getRandomIntInRange(3,5);

            case TWO -> getRandomIntInRange(5,7);

            case THREE -> getRandomIntInRange(7,9);

            case FOUR -> getRandomIntInRange(10,12);
        };
    }
}
