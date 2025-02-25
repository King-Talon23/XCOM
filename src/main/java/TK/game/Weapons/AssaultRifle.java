package TK.game.Weapons;

import java.util.Random;

public class AssaultRifle extends Weapon{
    Random random = new Random();

    public AssaultRifle(Integer tier) {
        super(tier, damage, maxShotsFired, clipSize, critChance);

    }

    @Override
    public String getSound() {
        return lightGunSounds.get(random.nextInt(lightGunSounds.size()));
    }

    @Override
    public String getName() {
        return ARNames.get(random.nextInt(ARNames.size()));
    }
}
