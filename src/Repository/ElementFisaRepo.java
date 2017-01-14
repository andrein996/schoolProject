package Repository;

import Entities.ElementFisa;
import Validator.ElementFisaValidator;

/**
 * Created by Andrei on 12/4/2016.
 */
public class ElementFisaRepo extends AbstractRepo<ElementFisa, Integer> {
    public ElementFisaRepo() {
        validator = new ElementFisaValidator();
    }
}
