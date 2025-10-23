package Classes;

import java.util.List;

public class Archer extends GenericClass {

    public Archer(String name) {
        this.characterName = name;
        this.className = "Archer";
        this.description = "A specialist in ranged attacks, agile and precise.";

        // Atributos base
        this.strenghPoints = 8;
        this.agillityPoints = 15;
        this.intelligencePoints = 7;

        // Vida e Mana
        this.healthPoints = 90;
        this.manaPoints = 80;

        // Armas permitidas
        this.allowedWeapons = List.of("Arco", "Adaga");

        // Habilidade passiva
        this.moves = List.of(); // ataques iniciais podem ser adicionados depois
        this.appliedEffects = List.of();
    }

    // Passiva "Esquiva" - 25% de chance de evitar ataque
    public boolean tryDodge() {
        double chance = 0.25; // 25%
        return Math.random() < chance;
    }
}
