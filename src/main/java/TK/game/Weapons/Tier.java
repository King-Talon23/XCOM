package TK.game.Weapons;

import java.util.HashMap;
import java.util.Map;

public enum Tier {
    ONE, TWO, THREE, FOUR;
    public static final Map<Tier, Tier> tierMap = new HashMap<>();
    // used to cycle through tiers when creating weapon lists
    static {
        tierMap.put(ONE, TWO);
        tierMap.put(TWO, THREE);
        tierMap.put(THREE, FOUR);
    }
}
