package Validator;

import Entities.Post;

/**
 * Created by Andrei on 10/23/2016.
 */
public class PostValidator implements IValidator<Post> {

    @Override
    public void validate(Post entity) throws ValidatorException {
        String msg="";
        if (entity.getId().isEmpty() ||
                entity.getId()==null) {
                msg += "ID-ul este invalid!\n";

        }
        else {
            if (entity.getTip()==null ||
                    entity.getTip().isEmpty() ||
                    !(entity.getTip().equals("fulltime")) &&
                    !(entity.getTip().equals("parttime"))) {
                    msg += "Tipul post-ului este invalid!\n";
            }
            if (entity.getDescriere()==null ||
                    entity.getDescriere().isEmpty()) {
                    msg += "Descrierea post-ului este invalida!\n";
            }
        }
        if (!msg.equals("")) {
            throw new ValidatorException(msg);
        }
    }
}
