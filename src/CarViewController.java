/*
Dylan Sprague
200368636
 */

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class CarViewController implements Initializable {
    @FXML private ComboBox<String> brandComboBox;
    @FXML private TableView<Car> tableView;
    @FXML private TableColumn<Car, Integer> yearColumn;
    @FXML private TableColumn<Car, String> brandColumn;
    @FXML private TableColumn<Car, String> modelColumn;
    @FXML private TableColumn<Car, Integer> kilometersColumn;
    @FXML private TableColumn<Car, Double> priceColumn;
    @FXML private ImageView imageView;
    @FXML private Button sellButton;
    @FXML private Label invValueLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CarLot lot = new CarLot(CarLoader.loadCars());
        brandComboBox.getItems().addAll(lot.getBrands());
        imageView.setImage(new Image("images/default.png"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<Car, Integer>("year"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("brand"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("model"));
        kilometersColumn.setCellValueFactory(new PropertyValueFactory<Car, Integer>("kilometers"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Car, Double>("price"));

        brandComboBox.getSelectionModel().selectedIndexProperty().addListener(
                (observable, oldValue, newValue) -> {
                    tableView.getItems().clear();
                    tableView.getItems().addAll(lot.getCars(brandComboBox.getValue()));
                    imageView.setImage(new Image("images/"+brandComboBox.getValue()+".png"));
                }
        );

        sellButton.onActionProperty().addListener(
                ((observable, oldValue, newValue) -> {
                    lot.sellCar(tableView.getSelectionModel().getSelectedItem());
                    tableView.refresh();
                })
        );
    }
}

