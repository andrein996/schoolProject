package Entities;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by Andrei on 10/9/2016.
 */
public class Sarcina implements HasID<Integer>, Serializable, Comparator<Sarcina> {
    private Integer id;
    private String descriereSarcina;

    public Sarcina(Integer id, String descriereSarcina) {
        this.id = id;
        this.descriereSarcina = descriereSarcina;
    }

    public Sarcina() {
        this(0, "");
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescriereSarcina(String descriereSarcina) {
        this.descriereSarcina = descriereSarcina;
    }

    public Integer getId() {
        return this.id;
    }

    public String getDescriereSarcina() {
        return this.descriereSarcina;
    }

    @Override
    public String toString() {
        return this.descriereSarcina;
    }

    @Override
    public int compare(Sarcina o1, Sarcina o2) {
        return o1.getDescriereSarcina().compareTo(o2.getDescriereSarcina());
    }

    public static Comparator<Sarcina> cmpSarcinaDescriere = (Sarcina s1, Sarcina s2) -> s1.getDescriereSarcina().compareTo(s2.getDescriereSarcina());
}
