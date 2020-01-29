package com;

import javafx.animation.Animation;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
import style.Style;

public class PrintPane {

    static Label status = new Label();
    static ImageView refresh = new ImageView("images/refresh.png");
    static TableView tableRegistration = new TableView();
    static TableColumn department = new TableColumn("Цех");
    static TableColumn station = new TableColumn("Станция");
    static TableColumn object = new TableColumn("Обект");
    static TableColumn leftDays = new TableColumn("Количество оставшихся дней");
    static TableColumn detail = new TableColumn("Деталь");
    static TableColumn lastCheck = new TableColumn("Дата последней проверки");
    static TableColumn nextCheck = new TableColumn("Дата новой проверки");
    static TableColumn detailName = new TableColumn("Наименование детали");
    static TableColumn location = new TableColumn("Расположение");
    static TableColumn detailCode = new TableColumn("Код детали");

    public static VBox printTable() {

        department.setCellValueFactory(new PropertyValueFactory("department"));
        station.setCellValueFactory(new PropertyValueFactory("station"));
        object.setCellValueFactory(new PropertyValueFactory("object"));
        leftDays.setCellValueFactory(new PropertyValueFactory("leftDays"));
        detail.setCellValueFactory(new PropertyValueFactory("detail"));
        lastCheck.setCellValueFactory(new PropertyValueFactory("lastCheck"));
        nextCheck.setCellValueFactory(new PropertyValueFactory("nextCheck"));
        location.setCellValueFactory(new PropertyValueFactory("location"));
        detailCode.setCellValueFactory(new PropertyValueFactory("registrationID"));

        tableRegistration.getColumns().addAll(department, station, object, leftDays,
                detail, lastCheck, nextCheck, location, detailCode);
        tableRegistration.setItems(DataProcess.selectDataFromRegistration());
        tableRegistration.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        status.setText("There should be written something about tables below. Report");
        status.setStyle(Style.styleLabel);
        refresh.setFitHeight(60);
        refresh.setFitWidth(60);
        tableRegistration.setStyle(Style.styleTable);

        department.setCellFactory(new Callback<TableColumn<Animation.Status, String>, TableCell<Animation.Status, String>>() {
            @Override
            public TableCell<Animation.Status, String> call(TableColumn<Animation.Status, String> arg0) {
                return new TableCell<Animation.Status, String>() {
                    private Text text;

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!isEmpty()) {
                            text = new Text(item);
                            text.setWrappingWidth(department.getWidth());
                            this.setWrapText(true);
                            setGraphic(text);
                        }
                    }
                };
            }
        });

        station.setCellFactory(new Callback<TableColumn<Animation.Status, String>, TableCell<Animation.Status, String>>() {
            @Override
            public TableCell<Animation.Status, String> call(TableColumn<Animation.Status, String> arg0) {
                return new TableCell<Animation.Status, String>() {
                    private Text text;

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!isEmpty()) {
                            text = new Text(item);
                            text.setWrappingWidth(department.getWidth());
                            this.setWrapText(true);
                            setGraphic(text);
                        }
                    }
                };
            }
        });

        object.setCellFactory(new Callback<TableColumn<Animation.Status, String>, TableCell<Animation.Status, String>>() {
            @Override
            public TableCell<Animation.Status, String> call(TableColumn<Animation.Status, String> arg0) {
                return new TableCell<Animation.Status, String>() {
                    private Text text;

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!isEmpty()) {
                            text = new Text(item);
                            text.setWrappingWidth(department.getWidth());
                            this.setWrapText(true);
                            setGraphic(text);
                        }
                    }
                };
            }
        });

        HBox hb = new HBox();
        hb.getChildren().addAll(status, refresh);
        hb.setPadding(new Insets(0, 0, 0, 0));
        hb.setSpacing(5);
        hb.setAlignment(Pos.CENTER);
        VBox vb = new VBox();
        vb.getChildren().addAll(hb, tableRegistration);
        vb.setSpacing(5);
        vb.setPadding(new Insets(0, 0, 0, 0));

        return vb;
    }
}
