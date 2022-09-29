package controlcircle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author guillermogallegogonzalez
 * @version 1.0
 * Contacto: guillermojulian.gallegogonzalez@gmail.com
 */

public class ControlCircle extends Application {

    @Override
    //Función Start
    public void start(Stage primaryStage) {
        
        //Uso de Pane
        Pane pane = new Pane();
        //Llamada a la clase
        innerClass innerclass = new innerClass();
        
        //Unos de circulo y ajustes
        Circle circle = new Circle();
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        circle.setRadius(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        
        //Botones y sus respectivos eventos
        Button btn = new Button();
        btn.setText("Enlarge");
        btn.setOnAction((ActionEvent event) -> {
            innerclass.Enlarge(circle);
        });

        Button btn2 = new Button();
        btn2.setText("Shrink");
        btn2.setOnAction((ActionEvent event) -> {
            innerclass.Shrink(circle);
        });

        //Border Pane y sus ajustes
        BorderPane border = new BorderPane();
        HBox hbox=new HBox(12);
        hbox.getChildren().add(btn);
        hbox.getChildren().add(btn2);
        StackPane root = new StackPane();
        root.getChildren().add(circle);
        BorderPane.setAlignment(hbox,Pos.CENTER);
        BorderPane.setMargin(hbox, new Insets(12,12,12,85));
        border.setBottom(hbox);
        border.setCenter(root);
        Scene scene = new Scene(border, 300, 250);        
        primaryStage.setTitle("ControlCircle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class innerClass{
        
        //Funciones encargada de modificar el radio del circulo
        public void Enlarge(Circle circle){
        double valorCirculo = circle.getRadius();
            circle.setRadius(valorCirculo + 10);
    }
    
    public void Shrink(Circle circle){
        double valorCirculo = circle.getRadius();
            circle.setRadius(valorCirculo - 10);
    }
    
    }
    
    /**
     * @param args 
     */
    
    public static void main(String[] args) {
        launch(args);
    }

}
