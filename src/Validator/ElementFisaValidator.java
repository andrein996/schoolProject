package Validator;

import Entities.ElementFisa;

/**
 * Created by Andrei on 12/4/2016.
 */
public class ElementFisaValidator implements IValidator<ElementFisa> {
    @Override
    public void validate(ElementFisa entity) throws ValidatorException {
        String msg = "";

        if (entity.getId() < 0 ||
                entity.getId() == null) {
            msg += "ID-ul este invalid!\n";
        }
        if (entity.getPost().getId().isEmpty() ||
                entity.getPost().getId() == null) {
            msg += "ID-ul postului este invalid!\n";
        }
        if (entity.getSarcina().getId() < 0 ||
                entity.getSarcina().getId() == null) {
            msg += "ID-ul sarcinei este invalid!\n";
        }
        if (!msg.equals("")) {
            throw new ValidatorException(msg);
        }
    }
}
