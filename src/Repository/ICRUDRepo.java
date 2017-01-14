package Repository;

import Utils.Observable;
import Validator.ValidatorException;

import java.util.List;

/**
 * Created by Andrei on 10/23/2016.
 */
public interface ICRUDRepo<E,Id> extends Observable<E> {
    long size();
    void save(E entity) throws ValidatorException;
    void delete(Id id) throws ValidatorException;
    E findOne(Id id);
    List<E> findAll();
}
