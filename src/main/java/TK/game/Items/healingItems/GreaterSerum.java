package TK.game.Items.healingItems;


public class GreaterSerum extends HealingItem {
    public GreaterSerum(String name, Integer apCost, String key) {
        super(name, apCost, key,11,15);
    }

    @Override
    public String getDescription() {
        return "Best source of healing\n(heals between 11 and 15 hp)";
    }
}
