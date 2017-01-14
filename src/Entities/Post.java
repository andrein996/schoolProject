package Entities;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by Andrei on 10/9/2016.
 */
public class Post implements HasID<String>, Serializable, Comparator<Post> {
    private String id;
    private String descriere;
    private String tip;

    public Post(String id, String descriere, String tip){
        this.id = id;
        this.descriere = descriere;
        this.tip = tip;
    }

    public Post() {
        this("", "", "");
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getId() {
        return this.id;
    }

    public String getDescriere() {
        return this.descriere;
    }

    public String getTip() {
        return this.tip;
    }

    @Override
    public String toString() {
        return descriere + " " + tip;
    }

    @Override
    public int compare(Post o1, Post o2) {
        return o1.getDescriere().compareTo(o2.getDescriere());
    }

    public static Comparator<Post> cmpPostDescriere = (Post p1, Post p2) -> p1.getDescriere().compareTo(p2.getDescriere());

    public static Comparator<Post> cmpPostId = (Post p1, Post p2) -> p1.getId().compareTo(p2.getId());

}
