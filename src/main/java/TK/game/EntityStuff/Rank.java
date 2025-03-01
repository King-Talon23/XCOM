package TK.game.EntityStuff;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
    ROOKIE,
    SQUADDIE,
    CORPORAL,
    LIEUTENANT,
    CAPTAIN,
    MAJOR,
    COLONEL,
    GENERAL,
    GENERAL_COMMANDER; // Only for dev character


    public static final Map<Rank, Rank> rankUpgradePath = Map.ofEntries(
            Map.entry(Rank.ROOKIE, Rank.SQUADDIE),
            Map.entry(Rank.SQUADDIE, Rank.CORPORAL),
            Map.entry(Rank.CORPORAL, Rank.LIEUTENANT),
            Map.entry(Rank.LIEUTENANT, Rank.CAPTAIN),
            Map.entry(Rank.CAPTAIN, Rank.MAJOR),
            Map.entry(Rank.MAJOR, Rank.COLONEL),
            Map.entry(Rank.COLONEL, Rank.GENERAL));
}
