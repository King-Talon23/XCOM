package TK.game.Items.Consumable.healingItems;

import TK.Entities.Entity;
import TK.game.Items.Item;

import static TK.game.game.getRandomIntInRange;
import static TK.game.game.println;

public abstract class HealingItem extends Item {
    Integer lowEndHealing;
    Integer highEndHealing;

    public HealingItem(String name, Integer apCost, String key, Integer lowEndHealing, Integer highEndHealing) {
        super(name, apCost, key);
        this.lowEndHealing = lowEndHealing;
        this.highEndHealing = highEndHealing;
    }

    @Override
    public void useItem(Entity user) {
        int increaseHP = getRandomIntInRange(lowEndHealing, highEndHealing);
        user.hp += increaseHP;
        println("HP Restored.");
        println("+" + increaseHP + "HP");
    }

}
