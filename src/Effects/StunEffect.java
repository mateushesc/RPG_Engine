package Effects;

import Classes.GenericClass;

public class StunEffect extends GenericEffect {

    public StunEffect() {
        this.effectName = "Atordoado";
        this.description = "O inimigo perde 1 turno devido a um golpe esmagador.";
    }

    @Override
    public void effect(GenericClass target) {
        this.quantity -= 1;

        System.out.println(target.getCharacterName() + " está atordoado e perde o turno. Restam " + this.quantity + " turnos.");

        if (this.quantity <= 0) {
            target.appliedEffects.remove(this);
            System.out.println("💫 " + target.getCharacterName() + " recuperou-se do atordoamento.");
        }
    }
}
