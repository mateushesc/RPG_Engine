package Weapons;

import java.util.List;
import Attacks.RainOfArrows;

public class ElvenBow extends GenericWeapon {

    public ElvenBow() {
        this.dmgMultiplier = 1.2f;
        this.Name = "Arco Élfico";
        this.description = "Um arco gracioso forjado por elfos, conhecido por sua precisão e poder em ataques em área.";
        
        // Adiciona o ataque especial
        this.weaponMoves = List.of(new RainOfArrows());
    }
}
