package TK.game.Weapons;

import java.util.Random;

public class AssaultRifle extends Weapon{
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
        switch (this.tier) {
            case ONE -> {
                return 2;
            }
            case TWO -> {
                return 3;
            }
            case THREE -> {
                return 4;
            }
            case FOUR -> {
                return 6;
            }
        }
       throw new IllegalArgumentException("Unknown Tier");
    }

    @Override
    public Integer getMaxShots() {
        switch (this.tier) {
            case ONE -> {
                return 3;
            }
            case TWO -> {
                return 4;
            }
            case THREE -> {
                return 5;
            }
            case FOUR -> {
                return 7;
            }
        }
        throw new IllegalArgumentException("Unknown Tier");
    }

    @Override
    public Integer getzClipSize() {
        switch (this.tier) {
            case ONE -> {
                return 6;
            }
            case TWO -> {
                return 9;
            }
            case THREE -> {
                return 12;
            }
            case FOUR -> {
                return 15;
            }
        }
        throw new IllegalArgumentException("Unknown Tier");

    }

    @Override
    public Integer getCritChance() {
        switch (this.tier) {
            case ONE -> {
                return 7;
            }
            case TWO -> {
                return 5;
            }
            case THREE -> {
                return 9;
            }
            case FOUR -> {
                return 12;
            }
        }
        throw new IllegalArgumentException("Unknown Tier");

    }
}
