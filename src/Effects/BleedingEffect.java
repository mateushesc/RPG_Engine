package Effects;

import Classes.GenericClass;

public class BleedingEffect extends GenericEffect {

    public BleedingEffect() {
        this.effectName = "Sangramento";
        this.description = "Perde 5 de vida por turno devido a um corte profundo.";
    }

    @Override
    public void effect(GenericClass target) {
        this.quantity -= 1;

        target.setHealthPoints(target.getHealthPoints() - 5);
        System.out.println(target.getCharacterName() + " sofre 5 de dano por sangramento. Restam " + this.quantity + " turnos.");

        if (this.quantity <= 0) {
            target.appliedEffects.remove(this);
            System.out.println("🩸 O sangramento de " + target.getCharacterName() + " cessou.");
        }
    }
}
