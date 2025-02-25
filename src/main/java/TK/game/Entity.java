package TK.game;

public abstract class Entity {
    private Integer hp;
    private Integer aim;
    private Integer mobility;
    private String firstname;
    private String lastname;
    private Rank rank;
    private Integer armour;
    private Weapon weapom;
    
    public Entity(Integer hp, Integer aim, Integer mobility, Rank rank, ) {

        this.hp = hp;
        this.aim = aim;
        this.mobility = mobility;
        this.rank = rank;
        this.firstname = firstname;
        this.lastname = lastname;
        this.armour = armour;
        this.weapon = weapon;
        this.items = items;
        this.body_mods = body_modifiers;
        this.cover = 0;
        this.onOverwatch = False;
        this.alive = True;
        
    }
}
