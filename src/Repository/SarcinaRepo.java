package Repository;

import Entities.Sarcina;
import Validator.SarcinaValidator;

/**
 * Created by Andrei on 10/23/2016.
 */
public class SarcinaRepo extends AbstractRepo<Sarcina, Integer> {
    public SarcinaRepo(){
        validator=new SarcinaValidator();
    }
}
