package Weapons;

import java.util.List;
import Attacks.SneakAttack;

public class ShadowDagger extends GenericWeapon {

    public ShadowDagger() {
        this.dmgMultiplier = 1.3f;
        this.Name = "Adaga Sombria";
        this.description = "Uma adaga silenciosa que inflige grande dano quando o inimigo está desprevenido.";

        this.weaponMoves = List.of(new SneakAttack());
    }
}
