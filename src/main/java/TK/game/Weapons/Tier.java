package TK.game.Weapons;

import java.util.HashMap;
import java.util.Map;

public enum Tier {
    CONVENTIONAL, BEAM, PLASMA;
    public static final Map<Tier, Tier> tierMap = new HashMap<>();
    static {
        tierMap.put(CONVENTIONAL, BEAM);
        tierMap.put(BEAM, PLASMA);
    }
}
