package Controller;

import Entities.Sarcina;
import Repository.SarcinaRepoFile;
import Validator.ValidatorException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Andrei on 10/24/2016.
 */
public class SarcinaController {
    private SarcinaRepoFile mSarcinaRepo;

    public SarcinaController() throws ValidatorException{
        mSarcinaRepo = new SarcinaRepoFile("C:/Users/Andrei/IdeaProjects/proiectLab/src/Repository/sarcini.txt");
    }

    public SarcinaController(SarcinaRepoFile sarcinaRepo) {
        this.mSarcinaRepo = sarcinaRepo;
    }

    public void addSarcina(Integer id, String descriere) throws ValidatorException{
        Sarcina s = new Sarcina(id, descriere);
        mSarcinaRepo.save(s);
        mSarcinaRepo.saveToFile();
        mSarcinaRepo.notifyObservers();
    }

    public List<Sarcina> getAllSarcine() {
        List<Sarcina> all = mSarcinaRepo.findAll();
        return all;
    }

    public void change(Integer id, String descriere) throws ValidatorException{
        Sarcina s = mSarcinaRepo.findOne(id);
        if (s != null) {
            Sarcina snew = new Sarcina(id, descriere);
            mSarcinaRepo.update(s, snew);
        }
        mSarcinaRepo.saveToFile();
        mSarcinaRepo.notifyObservers();
    }

    public void remove(Integer id) {
        mSarcinaRepo.delete(id);
        mSarcinaRepo.saveToFile();
        mSarcinaRepo.notifyObservers();
    }

    public boolean existsId(Integer id) {
        if (mSarcinaRepo.findOne(id) != null) {
            return true;
        }
        return false;
    }

    public <E> List<E> filterGeneric(List<E> lista, Predicate<E> p) {
        List<E> results = new ArrayList<E>();
        for (E obj : lista) {
            if (p.test(obj)) {
                results.add(obj);
            }
        }

        return results;
    }

    public List<Sarcina> filterSarcinaByDenumire(String den) {
        Predicate<Sarcina> pred = (Sarcina s) -> { return s.getDescriereSarcina().compareTo(den) == 0; };
        List<Sarcina> lista = filterGeneric(mSarcinaRepo.findAll(), pred);
        return lista;
    }

    public List<Sarcina> filterSarcinaById(Integer fId, Integer sId) {
        Predicate<Sarcina> pred = (Sarcina s) -> { return s.getId() >= fId && s.getId() <= sId; };
        List<Sarcina> lista = filterGeneric(mSarcinaRepo.findAll(), pred);
        return lista;
    }

    public Sarcina findSarcina(Integer id) {
        if (existsId(id)) {
            return mSarcinaRepo.findOne(id);
        }
        return null;
    }
}
