package TK.game.Weapons;

import java.util.Random;

public class SubMachineGun extends Weapon {
    Random random = new Random();

    public SubMachineGun() {
        super(tier, damage, maxShotsFired, clipSize, critChance);
    }

    private void tierOne() {

    }

    @Override
    public String getSound() {
        return lightGunSounds.get(random.nextInt(lightGunSounds.size()));
    }

    @Override
    public String getName() {
        return SMGNames.get(random.nextInt(SMGNames.size()));
    }
}
