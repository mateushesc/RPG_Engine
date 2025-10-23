package Weapons;

import java.util.List;
import Attacks.FireballAttack;

public class ArcaneStaff extends GenericWeapon {

    public ArcaneStaff() {
        this.dmgMultiplier = 1.1f;
        this.Name = "Cajado Arcano";
        this.description = "Um cajado místico capaz de lançar bolas de fogo que queimam os inimigos.";
        
        this.weaponMoves = List.of(new FireballAttack());
    }
}
