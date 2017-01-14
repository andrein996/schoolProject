package Repository;

import Entities.Post;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Andrei on 11/3/2016.
 */
public class PostRepoSerializable extends PostRepo {
    protected String fname;
    public PostRepoSerializable(String fname){
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
            lista = (ArrayList<Post>) objectInputStream.readObject();
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
