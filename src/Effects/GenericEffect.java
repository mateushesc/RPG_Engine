package Effects;

import Classes.GenericClass;

public class GenericEffect {
    public String effectName = "Effect";
    public String description = "Generic effect, does nothing";

    public int quantity;

    public void applyTo(GenericClass target) { // For when there is a simple apllication (is not said how many of effect)
        boolean alreadyApplied = target.appliedEffects.stream()
        .anyMatch(effect -> effect.effectName.equals(this.effectName)); //Checks if effect is already applied in the character

        if (alreadyApplied) {
            this.quantity += 1;
            System.out.println(target.getCharacterName() + " now has " + effectName + " (" + this.quantity + ")");
            return;
        }
        this.quantity = 1;
        target.appliedEffects.add(this);
        System.out.println(effectName + " (" + this.quantity + ") was applied to " + target.getCharacterName());
        return;
    }

    public void applyTo(GenericClass target, int quantityOfEffect) { // For when there is a multiple apllication (is said how many of effect)
        boolean alreadyApplied = target.appliedEffects.stream()
        .anyMatch(effect -> effect.effectName.equals(this.effectName)); //Checks if effect is already applied in the character

        if (alreadyApplied) {
            this.quantity += quantityOfEffect;
            System.out.println(target.getCharacterName() + " now has " + effectName + " (" + this.quantity + ")");
            return;
        }
        this.quantity = quantityOfEffect;
        target.appliedEffects.add(this);
        System.out.println(effectName + " (" + this.quantity + ") was applied to " + target.getCharacterName());
        return;
    }
    
    public void effect(GenericClass target){
        this.quantity -= 1;

        if (this.quantity <= 0) {
            target.appliedEffects.remove(this);
        }
        System.out.println(target.getCharacterName() + " has suffered nothing");
        return;
    }
}
