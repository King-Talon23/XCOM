package TK.game.EntityStuff;

import java.util.HashMap;
import java.util.Map;

public enum Cover {
    FLANKED, NONE, HALF, FULL;

    public static final Map<Cover, Integer> coverValue = new HashMap<>();
    static {
        coverValue.put(FLANKED, -10);
        coverValue.put(NONE, 0);
        coverValue.put(HALF, 20);
        coverValue.put(FULL, 40);
    }

}
