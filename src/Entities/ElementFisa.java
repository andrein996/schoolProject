package Entities;

import java.io.Serializable;

/**
 * Created by Andrei on 12/4/2016.
 */
public class ElementFisa implements HasID<Integer>, Serializable{
    private Integer id;
    /*
    private String idPost;
    private Integer idSarcina;
    private String descrierePost;
    private String descriereSarcina;
    */
    private Post post;
    private Sarcina sarcina;

    public ElementFisa(Integer id, Post post, Sarcina sarcina) {
        this.id = id;
        this.post = post;
        this.sarcina = sarcina;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Sarcina getSarcina() {
        return sarcina;
    }

    public void setSarcina(Sarcina sarcina) {
        this.sarcina = sarcina;
    }
}
