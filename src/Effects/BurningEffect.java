package Effects;

import Classes.GenericClass;

public class BurningEffect extends GenericEffect {

    public BurningEffect() {
        this.effectName = "Queimadura";
        this.description = "Sofre 10 de dano por turno devido a queimaduras.";
    }

    @Override
    public void effect(GenericClass target) {
        this.quantity -= 1;

        target.setHealthPoints(target.getHealthPoints() - 10);
        System.out.println(target.getCharacterName() + " sofre 10 de dano por queimadura. Restam " + this.quantity + " turnos.");

        if (this.quantity <= 0) {
            target.appliedEffects.remove(this);
            System.out.println("🔥 A queimadura em " + target.getCharacterName() + " cessou.");
        }
    }
}
