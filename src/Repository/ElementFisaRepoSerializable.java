package Repository;

import Entities.ElementFisa;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Andrei on 12/4/2016.
 */
public class ElementFisaRepoSerializable extends ElementFisaRepo{
    protected String fname;
    public ElementFisaRepoSerializable(String fname){
        super();
        this.fname=fname;
        try {
            loadData();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void loadData() throws FileNotFoundException {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fname));
            lista = (ArrayList<ElementFisa>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveData() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fname));
            objectOutputStream.writeObject(lista);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
