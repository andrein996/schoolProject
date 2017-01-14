package Controller;

import Entities.Post;
import Repository.PostRepoSerializable;
import Validator.ValidatorException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Andrei on 10/23/2016.
 */
public class PostController {
    private PostRepoSerializable mPostRepo;

    public PostController(PostRepoSerializable repo) { mPostRepo = repo; }

    public void addPost(String id, String descriere, String tip ) throws ValidatorException {
        Post p = new Post(id, descriere, tip);
        mPostRepo.save(p);
        mPostRepo.saveData();
    }

    public List<Post> getAllPosts() {
        List<Post> all = mPostRepo.findAll();
        return all;
    }

    public Post findPost(String id) {
        if (existsId(id)) {
            return mPostRepo.findOne(id);
        }
        return null;
    }

    public boolean existsId(String id) {
        if (mPostRepo.findOne(id) != null) {
            return true;
        }
        return false;
    }

    public void change(String id, String descriere, String tip) throws ValidatorException{
        Post p = mPostRepo.findOne(id);
        if (p != null) {
            Post pnew = new Post(id, descriere, tip);
            mPostRepo.update(p, pnew);
        }
        mPostRepo.saveData();
    }

    public void remove(String id) {
        mPostRepo.delete(id);
        mPostRepo.saveData();
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

    public List<Post> filterPostByTip(String tip) {
        Predicate<Post> pred = (Post p) -> { return p.getTip().compareTo(tip) == 0; };
        List<Post> lista = filterGeneric(mPostRepo.findAll(), pred);
        return lista;
    }

    public List<Post> filterPostByDenumire(String den) {
        Predicate<Post> pred = (Post p) -> { return p.getDescriere().compareTo(den) == 0; };
        List<Post> lista = filterGeneric(mPostRepo.findAll(), pred);
        return lista;
    }


}
