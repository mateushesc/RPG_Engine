package Weapons;

import java.util.List;
import Attacks.CrushingBlow;

public class WarAxe extends GenericWeapon {

    public WarAxe() {
        this.dmgMultiplier = 1.8f;
        this.Name = "Machado de Guerra";
        this.description = "Um pesado machado capaz de esmagar armaduras e atordoar inimigos.";

        this.weaponMoves = List.of(new CrushingBlow());
    }
}
