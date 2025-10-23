package Classes;

import java.util.List;

public class Mage extends GenericClass {

    public Mage(String name) {
        this.characterName = name;
        this.className = "Mage";
        this.description = "A master of arcane arts, specializing in powerful spells.";

        // Atributos base
        this.strenghPoints = 5;
        this.agillityPoints = 7;
        this.intelligencePoints = 18;

        // Vida e Mana
        this.healthPoints = 70;
        this.manaPoints = 150;

        // Armas permitidas
        this.allowedWeapons = List.of("Cajado", "Adaga");

        // Habilidade passiva
        this.moves = List.of(); // ataques iniciais podem ser adicionados depois
        this.appliedEffects = List.of();
    }

    // Passiva "Regeneração de Mana" - +10 mana por turno
    public void regenerateMana() {
        this.manaPoints += 10;
        System.out.println(this.characterName + " regenerou 10 de mana. Mana atual: " + this.manaPoints);
    }
}
