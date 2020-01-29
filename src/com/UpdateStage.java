
package com;

import java.sql.Date;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UpdateStage {
    
    static Stage stage = new Stage();
    private static Registration reg = new Registration();
    private static final Label department = new Label();
    private static final Label station = new Label();
    private static final Label object = new Label();
    private static final Label leftDays = new Label();
    private static final Label detail = new Label();
    private static final DatePicker lastCheck = new DatePicker();
    private static final Label location = new Label();
    private static final Label checkDay = new Label();
    private static final Button update = new Button("Обновить");
    private static final Button delete = new Button(" Удалить");
  //  static AudioClip ALERT_AUDIOCLIP = new AudioClip("music/update.mp3");
    
    public static Stage update(Registration reg) {
        department.setText("Цех:\t" + reg.getDepartment());
        station.setText("Станция:\t" + reg.getStation());
        object.setText("Обект:\t" + reg.getObject());
        leftDays.setText("Кол. дней:\t" + reg.getLeftDays());
        detail.setText("Деталь:\t" + reg.getDetail());
        location.setText("Расположение:\t" + reg.getLocation());
        checkDay.setText("Дата новой проверки:");
        lastCheck.setValue(reg.getLastCheck().toLocalDate());
        
        update.setOnAction(e -> {
            Date newDate = java.sql.Date.valueOf(lastCheck.getValue());
            Date nextDate = java.sql.Date.valueOf(
                    lastCheck.getValue().plusYears(
                            DataProcess.selectDetailWarranty(reg.getDetail())));
            DataProcess.updateDate(reg.getRegistrationID(), newDate, nextDate);
            DataProcess.updateLeftDays();
//            ALERT_AUDIOCLIP.play();
            stage.close();
        });
        
        delete.setOnAction(e -> {
            DataProcess.deleteRegistraion(reg.getRegistrationID());
//            ALERT_AUDIOCLIP.play();
            stage.close();
        });
        
        HBox hb = new HBox();
        hb.getChildren().addAll(update, delete);
        VBox vb = new VBox();
        vb.getChildren().addAll(department, station, object, leftDays, 
                detail, location, checkDay, lastCheck, hb);
        stage.setScene(new Scene(vb, 200, 270));
        //stage.initModality(Modality.APPLICATION_MODAL);
        
        department.setFont(new Font("Times", 15));
        station.setFont(new Font("Times", 15));
        object.setFont(new Font("Times", 15));
        leftDays.setFont(new Font("Times", 15));
        detail.setFont(new Font("Times", 15));
        location.setFont(new Font("Times", 15));
        checkDay.setFont(new Font("Times", 15));
        lastCheck.setStyle("-fx-background-color: #ff4444;");
        
        vb.setAlignment(Pos.BASELINE_LEFT);
        vb.setPadding(new Insets(5,5,5,5));
        vb.setSpacing(5);
        hb.setAlignment(Pos.BASELINE_CENTER);
        hb.setPadding(new Insets(5,5,5,5));
        hb.setSpacing(5);
        
        return stage;
    }
}
