package TK.game.Weapons;

import java.util.Random;

public class ShotGun extends Weapon{
    Random random = new Random();

    public ShotGun() {
        super(tier, damage, maxShotsFired, clipSize, critChance);
    }

    @Override
    public String getSound() {
        return heavyGunSounds.get(random.nextInt(heavyGunSounds.size()));
    }

    @Override
    public String getName() {
        return shotgunNames.get(random.nextInt(shotgunNames.size()));
    }
}
