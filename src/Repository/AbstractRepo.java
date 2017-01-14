package Repository;

import Entities.HasID;
import Utils.Observer;
import Validator.IValidator;
import Validator.ValidatorException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Andrei on 10/23/2016.
 */
public class AbstractRepo<E extends HasID<Id>,Id> implements ICRUDRepo<E,Id> {
    public List<E> lista = new ArrayList<E>();
    public IValidator<E> validator;

    public long size() {
        return lista.size();
    }

    public void save(E obj) throws ValidatorException
    {
        validator.validate(obj);
        if (findOne(obj.getId()) != null) {
            throw new ValidatorException("Exista deja id-ul!");
        }
        lista.add(obj);
        notifyObservers();
    }

    public void delete(Id id) {
        Iterator<E> it=lista.iterator();
        while(it.hasNext()){
            E e=it.next();
            if(e.getId().equals(id)){
                it.remove();}
        }
        notifyObservers();
    }
    public void update(E ol,E ne) throws ValidatorException{
        validator.validate(ne);
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getId().equals(ol.getId())){
                lista.set(i,ne);
            }
        }
        notifyObservers();
    }

    public E findOne(Id id) {
        for (E e : lista) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    public List<E> findAll(){
        return lista;
    }

    private List<Observer<E>> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer<E> o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer<E> o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers){
            o.update(this);
        }
    }
}
