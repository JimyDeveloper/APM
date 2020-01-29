
package com;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DeleteStage {
    
    static Stage stage = new Stage();
    private static final Button delete = new Button(" Удалить");
    private static final Button cancel = new Button("Отмена");
//    static AudioClip ALERT_AUDIOCLIP = new AudioClip("music/input.mp3");
    
    public static Stage delete(String id, String description) {
        
        cancel.setOnAction(e -> {
            stage.close();
        });
        
        delete.setOnAction(e -> {
            switch (description) {
                case "station":
                    DataProcess.deleteStation(id);
                    break;
                case "department":
                    DataProcess.deleteDepartment(id);
                    break;
                case "object":
                    DataProcess.deleteObject(id);
                    break;
                case "detail":
                    DataProcess.deleteDetail(id);
                    break;
            }
//            ALERT_AUDIOCLIP.play();
            stage.close();
        });
        
        HBox hb = new HBox();
        hb.getChildren().addAll(delete, cancel);
        VBox vb = new VBox();
        vb.getChildren().addAll(new Label("Are you sure to delete this value?"), hb);
        stage.setScene(new Scene(vb, 200, 70));
//        stage.initModality(Modality.APPLICATION_MODAL);
        
        vb.setAlignment(Pos.BASELINE_LEFT);
        vb.setPadding(new Insets(5,5,5,5));
        vb.setSpacing(5);
        hb.setAlignment(Pos.BOTTOM_RIGHT);
        hb.setPadding(new Insets(5,5,5,5));
        hb.setSpacing(5);
        
        return stage;
    }
}
