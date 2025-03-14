package TK.game.EntityStuff;


import TK.game.Weapons.Primary.AssaultRifle;
import TK.game.Weapons.WeaponTier;

import static TK.game.EntityStuff.SoliderAttributes.*;
import static TK.game.game.getRandomIntInRange;

public class Soldier extends Entity {

    String nickname;
    String firstName;
    String lastname;
    Rank rank;
    ClassType classType;

    public Soldier() { // always creates a rookie
        super(6, 65, 12, 0, 40, 0, 5, 0, new AssaultRifle(WeaponTier.CONVENTIONAL), null);
        this.rank = Rank.ROOKIE;
        this.classType = getRandomClass();
    }

    @Override
    public void handleDeath() {
        System.out.println("\n                                    _ ._  _ , ._ _");
        System.out.println("                                  (_  ' ( `  )_ .__)");
        System.out.println("                                ( (  (    )   `)  ) _)");
        System.out.println("                               (__ (_   (_ . _) _) ,__)");
        System.out.println("                                   `--`\\  ' . /`--`");
        System.out.println("                                   ,::: ;    ; :::,");
        System.out.println("                                   '::::::::::::::'");
        System.out.println("╭──────────────────────────────────────/ ─ ── \\────────────────────────────────────╮");
        System.out.println("│                                     lol you died                                 │");
        System.out.println("│                                       (loser)                                    │");
        System.out.println("│                                (didn't even do good)                             │");
        System.out.println("╰──────────────────────────────────────────────────────────────────────────────────╯");

        System.exit(0);
    }

    public void levelUp() {
        this.hp = setHealth(this.rank, this.classType);
        this.aim = setAim(this.rank, this.classType);
        this.hack = setHack(this.rank, this.classType);
        this.will = Math.min((this.will + getRandomIntInRange(4, 12)), 100);

    }

    private ClassType getRandomClass(){
        return switch (getRandomIntInRange(1,4)) {
            case 1 -> ClassType.SPECIALIST;
            case 2 -> ClassType.GRENADIER;
            case 3 -> ClassType.RANGER;
            case 4 -> ClassType.SHARPSHOOTER;
            default -> throw new IllegalArgumentException("Int out of bounds, Class does not exist");
        };
    }


}
