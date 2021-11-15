package lk.ijse.POS.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class DashBoardFormController {

    
    public void openSaveCustomerOnAction(ActionEvent actionEvent) throws IOException {
/*Scene scene =
        new Scene (FXMLLoader.load(getClass()
        .getResource("../view/CustomerSaveForm.fxml")));
            Stage PrimaryStage = new Stage();
            PrimaryStage.setScene(scene);
            PrimaryStage.show();*/

            setUi("CustomerSaveForm");
    }

    public void openSearchCustomerOnAction(ActionEvent actionEvent) throws IOException {
        /*Scene scene =
                new Scene (FXMLLoader.load(getClass()
                        .getResource("../view/CustomerSearchForm.fxml")));
        Stage PrimaryStage = new Stage();
        PrimaryStage.setScene(scene);
        PrimaryStage.show();*/

        setUi("CustomerSearchForm");
    }

    public void openGetAllCustomersOnAction(ActionEvent actionEvent) throws IOException {
        setUi("CustomerListForm");
    }

    public void openUpdateCustomerOnAction(ActionEvent actionEvent) throws IOException {
           setUi("CustomerUpdateForm");

    }

    public void openDeleteCustomerOnAction(ActionEvent actionEvent) throws IOException {
          setUi("CustomerDeleteForm");
    }

    public void openPlaceOrderOnAction(ActionEvent actionEvent) throws IOException {
        setUi("PlaceOrderForm");

    }

void setUi(String location) throws IOException {

    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml")));
    Stage PrimaryStage = new Stage();
    PrimaryStage.setScene(scene);
    PrimaryStage.show();
}

}
