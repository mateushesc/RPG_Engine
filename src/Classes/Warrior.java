package Classes;

import java.util.List;

public class Warrior extends GenericClass {

    public Warrior(String name) {
        this.characterName = name;
        this.className = "Warrior";
        this.description = "A strong and resilient fighter, specialized in heavy weapons.";

        // Atributos base
        this.strenghPoints = 15;
        this.agillityPoints = 8;
        this.intelligencePoints = 5;

        // Vida e Mana
        this.healthPoints = 120;
        this.manaPoints = 50;

        // Armas permitidas
        this.allowedWeapons = List.of("Espada", "Machado");

        // Habilidade passiva
        this.moves = List.of(); // ataques iniciais podem ser adicionados depois
        this.appliedEffects = List.of();
    }

    // Passiva "Pele Dura" - reduz dano recebido em 20%
    public float applyPassiveDamageReduction(float incomingDamage) {
        return incomingDamage * 0.8f; // reduz 20%
    }
}
