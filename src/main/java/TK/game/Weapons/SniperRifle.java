package TK.game.Weapons;

import java.util.Random;

import static TK.game.Weapons.Weapon.heavyGunSounds;
import static TK.game.Weapons.Weapon.sniperNames;

public class SniperRifle extends Weapon{
    Random random = new Random();

    public SniperRifle() {
        super(tier, damage, maxShotsFired, clipSize, critChance);
    }

    @Override
    public String getSound() {
        return heavyGunSounds.get(random.nextInt(heavyGunSounds.size()));
    }

    @Override
    public String getName() {
        return sniperNames.get(random.nextInt(sniperNames.size()));
    }
}
