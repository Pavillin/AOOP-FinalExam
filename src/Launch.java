import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.security.Timestamp;

/*
Dylan Sprague
200368636
 */

public class Launch extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("CarView.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Store");
        primaryStage.show();

        Runnable r1 = () -> {
            int i = 1;
            while(i == 1){
                System.out.println("Schevene & Rodrigo don't get bored... go to Jaret's class! ");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t1 = new Thread(r1, "Go to class!");
        t1.start();
    }
}
