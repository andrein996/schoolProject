package Utils;

/**
 * Created by Andrei on 11/27/2016.
 */
public interface Observable<E> {
    void addObserver(Observer<E> o);
    void removeObserver(Observer<E> o);
    void notifyObservers();
}
