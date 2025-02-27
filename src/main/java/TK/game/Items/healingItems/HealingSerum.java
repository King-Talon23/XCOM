package TK.game.Items.healingItems;


public abstract class HealingSerum extends HealingItem {
    public HealingSerum(String name, Integer apCost, String key) {
        super(name, apCost, key, 6, 10);
    }

    @Override
    public String getDescription(){
        return "Mediocre Healing (Heals between 6 and 10 HP)";
    }
}
