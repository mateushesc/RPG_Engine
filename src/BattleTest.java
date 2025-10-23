import Classes.*;
import Groups.*;
import Weapons.*;
import Battle.*;

public class BattleTest {

    public static void main(String[] args) {

        System.out.println("=== RPG Turn-Based Battle Test ===");

        // --- Criando heróis ---
        Warrior conan = new Warrior("Conan");
        Archer legolas = new Archer("Legolas");
        Mage gandalf = new Mage("Gandalf");

        // Equipando armas
        Longsword sword = new Longsword();
        conan.getOwnedWeapons().add(sword);
        conan.setEquipedWeapon(0);

        ElvenBow bow = new ElvenBow();
        legolas.getOwnedWeapons().add(bow);
        legolas.setEquipedWeapon(0);

        ArcaneStaff staff = new ArcaneStaff();
        gandalf.getOwnedWeapons().add(staff);
        gandalf.setEquipedWeapon(0);

        // --- Criando grupo de heróis ---
        GenericGroup heroes = new GenericGroup();
        heroes.groupMembers.add(conan);
        heroes.groupMembers.add(legolas);
        heroes.groupMembers.add(gandalf);

        // --- Criando inimigos ---
        GenericClass orc1 = new GenericClass();
        orc1.setCharacterName("Orc 1");
        orc1.setHealthPoints(60);

        GenericClass orc2 = new GenericClass();
        orc2.setCharacterName("Orc 2");
        orc2.setHealthPoints(50);

        GenericGroup enemies = new GenericGroup();
        enemies.groupMembers.add(orc1);
        enemies.groupMembers.add(orc2);

        // --- Executando batalha ---
        TurnBasedBattle battle = new TurnBasedBattle(heroes, enemies);
        battle.startBattle();

        // --- Testando passivas e efeitos após a batalha ---
        System.out.println("\n=== Testando efeitos e passivas ===");
        System.out.println("Conan tenta usar 'Pele Dura' em 50 de dano:");
        float danoReduzido = conan.applyPassiveDamageReduction(50);
        System.out.println("Dano recebido com 'Pele Dura': " + danoReduzido);

        System.out.println("\nLegolas tenta esquivar de ataque:");
        boolean dodge = legolas.tryDodge();
        System.out.println("Esquivou? " + dodge);

        System.out.println("\nGandalf regenera mana:");
        gandalf.regenerateMana();

        // --- Listando efeitos aplicados ---
        System.out.println("\nEfeitos aplicados em personagens:");
        conan.getAppliedEffects();
        legolas.getAppliedEffects();
        gandalf.getAppliedEffects();
        orc1.getAppliedEffects();
        orc2.getAppliedEffects();

        System.out.println("\n=== Test Completed ===");
    }
}
