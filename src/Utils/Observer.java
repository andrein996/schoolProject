package Utils;

/**
 * Created by Andrei on 11/27/2016.
 */
public interface Observer<E> {
    void update(Observable<E> e);
}
