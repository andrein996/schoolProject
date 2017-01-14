package Validator;

import Entities.Sarcina;

/**
 * Created by Andrei on 10/23/2016.
 */
public class SarcinaValidator implements IValidator<Sarcina> {
    @Override
    public void validate(Sarcina entity) throws ValidatorException {
        String msg="";
        if (entity.getId()<0 ||
                entity.getId()==null) {
            msg += "ID-ul este invalid!\n";
        }
        else if (entity.getDescriereSarcina() == null ||
                entity.getDescriereSarcina().isEmpty()) {
            msg += "Descrierea este invalida!\n";
        }
        if (!msg.equals("")) {
            throw new ValidatorException(msg);
        }
    }
}
