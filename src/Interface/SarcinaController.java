package Interface;

import Validator.ValidatorException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by Andrei on 11/28/2016.
 */
public class SarcinaController {
    private Controller.SarcinaController controller;
    private SarcinaView sarcinaView;

    public SarcinaController(SarcinaView sarcinaView, Controller.SarcinaController controller) {
        this.controller = controller;
        this.sarcinaView = sarcinaView;
    }

    public EventHandler<ActionEvent> addButtonHandler(){
        return new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    try {
                        Integer a = Integer.parseInt(sarcinaView.idText.getText());
                    }
                    catch (Exception e) {
                        throw new ValidatorException("Id-ul trebuie sa fie un intreg!");
                    }
                    controller.addSarcina(Integer.parseInt(sarcinaView.idText.getText()),
                            sarcinaView.descriereText.getText());
                }
                catch (ValidatorException ex) {
                    ShowMessage.showErrorMessage(ex.getMessage());
                }

            }
        };
    }

    public EventHandler<ActionEvent> changeButtonHandler(){
        return new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    try {
                        Integer a = Integer.parseInt(sarcinaView.idText.getText());
                    }
                    catch (Exception e) {
                        throw new ValidatorException("Id-ul trebuie sa fie un intreg!");
                    }
                    controller.change(Integer.parseInt(sarcinaView.idText.getText()),
                            sarcinaView.descriereText.getText());
                }
                catch (ValidatorException ex) {
                    ShowMessage.showErrorMessage(ex.getMessage());
                }
            }
        };
    }

    public EventHandler<ActionEvent> removeButtonHandler(){
        return new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    try {
                        Integer a = Integer.parseInt(sarcinaView.idText.getText());
                    }
                    catch (Exception e) {
                        throw new ValidatorException("Id-ul trebuie sa fie un intreg!");
                    }
                    controller.remove(Integer.parseInt(sarcinaView.idText.getText()));
                }
                catch (ValidatorException ex) {
                    ShowMessage.showErrorMessage(ex.getMessage());
                }
            }
        };
    }
}
