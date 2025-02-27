package TK.game.Items.healingItems;


public class LesserSerum extends HealingItem {
    public LesserSerum(String name, Integer apCost, String key) {
        super(name, apCost, key, 1, 5);
    }


    @Override
    public String getDescription() {
        return "Worst healing (may give aids)\n(heals between 1 and 5 hp)";
    }
}
