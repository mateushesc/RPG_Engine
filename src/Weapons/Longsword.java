package Weapons;

import java.util.List;
import Attacks.DeepCut;

public class Longsword extends GenericWeapon {

    public Longsword() {
        this.dmgMultiplier = 1.5f;
        this.Name = "Espada Longa";
        this.description = "Uma lâmina bem balanceada. Pode causar um corte profundo.";
        
        this.weaponMoves = List.of(new DeepCut());
    }
}
