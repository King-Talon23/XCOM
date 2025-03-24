package TK.game.StatusEffects;
import static TK.game.game.getRandomIntInRange;

public class AcidBurn extends StatusEffect implements StatusEffect.DamageEffect {
    public AcidBurn() {
        super(2);
    }

    @Override
    public int getDamage() {
        return getRandomIntInRange(1,3);
    }

    @Override
    public String getName() {
        return "Acid Burn";
    }

}
