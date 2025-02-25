package TK.game.Weapons;

import java.util.Random;

import static TK.game.Weapons.Weapon.heavyGunSounds;
import static TK.game.Weapons.Weapon.sniperNames;

public class SniperRifle extends Weapon {
    Random random = new Random();

    public SniperRifle(Tier tier) {
        super(tier);
    }

    @Override
    public String getSound() {
        return heavyGunSounds.get(random.nextInt(heavyGunSounds.size()));
    }

    @Override
    public String getName() {
        return sniperNames.get(random.nextInt(sniperNames.size()));
    }

    @Override
    public Integer getBaseDamage() {
        // damage per bullet
        return switch (this.tier) {
            case ONE -> getRandomIntInRange(6, 8);

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
            case ONE, TWO, THREE -> 5;

            case FOUR -> 7;
        };
    }

    @Override
    public Integer getCritChance() {
        return switch (this.tier) {
            case ONE -> getRandomIntInRange(12, 15);

            case TWO -> getRandomIntInRange(15, 18);

            case THREE -> getRandomIntInRange(18, 21);

            case FOUR -> getRandomIntInRange(21, 27);
        };
    }
}
