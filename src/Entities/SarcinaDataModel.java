package Entities;

import Repository.ICRUDRepo;
import Utils.Observable;
import Utils.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Andrei on 11/27/2016.
 */
public class SarcinaDataModel implements Observer<Sarcina> {
    private ObservableList<Sarcina> model;
    private ICRUDRepo repository;

    public SarcinaDataModel(ICRUDRepo<Sarcina, Integer> repository){
        this.repository = repository;
        repository.addObserver(this);
        model = FXCollections.observableArrayList(repository.findAll());
    }

    public ObservableList<Sarcina> getModel(){
        return model;
    }

    @Override
    public void update(Observable<Sarcina> e) {
        model.setAll(repository.findAll());
    }
}
