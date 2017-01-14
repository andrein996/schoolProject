package Validator;

/**
 * Created by Andrei on 10/23/2016.
 */
public interface IValidator<E> {
    void validate(E entity) throws ValidatorException;
}
