package Controller;

import Entities.ElementFisa;
import Entities.Post;
import Entities.Sarcina;
import Repository.ElementFisaRepoSerializable;
import Repository.PostRepoSerializable;
import Repository.SarcinaRepoFile;
import Validator.ValidatorException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Andrei on 12/4/2016.
 */
public class ElementFisaController {
    private ElementFisaRepoSerializable mElementFisaRepo;
    private PostController mPostController;
    private SarcinaController mSarcinaController;

    public ElementFisaController(ElementFisaRepoSerializable mElementFisaRepo, PostController mPostController, SarcinaController mSarcinaController) {
        this.mElementFisaRepo = mElementFisaRepo;
        this.mPostController = mPostController;
        this.mSarcinaController = mSarcinaController;
    }

    public void addElementFisa(Integer id, String idPost, Integer idSarcina) throws ValidatorException{
        Post p = mPostController.findPost(idPost);
        Sarcina s = mSarcinaController.findSarcina(idSarcina);
        ElementFisa el = new ElementFisa(id, p, s);
        if (mPostController.existsId(idPost) &&
                mSarcinaController.existsId(idSarcina)) {
            mElementFisaRepo.save(el);
            mElementFisaRepo.saveData();
        }
    }

    public List<ElementFisa> getAll() {
        return mElementFisaRepo.findAll();
    }

    public List<Post> getAllByPost(String id) {
        if (mPostController.existsId(id)) {
            Post p = mPostController.findPost(id);
            return mPostController.filterPostByTip(p.getTip());
        }
        return null;
    }

    public void changeElementFisa(Integer id, String idPost, Integer idSarcina) throws ValidatorException {
        ElementFisa el = mElementFisaRepo.findOne(id);
        Post p = mPostController.findPost(idPost);
        Sarcina s = mSarcinaController.findSarcina(idSarcina);

        if (el != null) {
            ElementFisa newEl = new ElementFisa(id, p, s);
            mElementFisaRepo.update(el, newEl);
        }
        mElementFisaRepo.saveData();
    }

    public void removeElementFisa(Integer id) {
        mElementFisaRepo.delete(id);
        mElementFisaRepo.saveData();
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
}
