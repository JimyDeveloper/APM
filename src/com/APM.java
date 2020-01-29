package com;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterAttributes;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import style.Style;

public class APM extends Application {

    BorderPane pane = new BorderPane();
    TabPane tabPane = new TabPane();

    ImageView xBtn1 = new ImageView("images/xButton.png");
    ImageView xBtn2 = new ImageView("images/xButton.png");
    ImageView xBtn3 = new ImageView("images/xButton.png");
    ImageView xBtn4 = new ImageView("images/xButton.png");

    //objects for registration view pane
    Tab btnToSeeRegistration = new Tab("Просмотреть сроки");

    TableView tableRegistrationAll = new TableView();
    TableColumn department = new TableColumn("Цех");
    TableColumn station = new TableColumn("Станция");
    TableColumn object = new TableColumn("Обект");
    TableColumn leftDays = new TableColumn("Количество оставшихся дней");
    TableColumn detail = new TableColumn("Деталь");
    TableColumn lastCheck = new TableColumn("Дата последней проверки");
    TableColumn nextCheck = new TableColumn("Дата новой проверки");
    TableColumn detailName = new TableColumn("Наименование детали");
    TableColumn location = new TableColumn("Расположение");
    TableColumn detailCode = new TableColumn("Код детали");

    TableView tableRegistration30 = new TableView();
    TableColumn department30 = new TableColumn("Цех");
    TableColumn station30 = new TableColumn("Станция");
    TableColumn object30 = new TableColumn("Обект");
    TableColumn leftDays30 = new TableColumn("Количество оставшихся дней");
    TableColumn detail30 = new TableColumn("Деталь");
    TableColumn lastCheck30 = new TableColumn("Дата последней проверки");
    TableColumn nextCheck30 = new TableColumn("Дата новой проверки");
    TableColumn detailName30 = new TableColumn("Наименование детали");
    TableColumn location30 = new TableColumn("Расположение");
    TableColumn detailCode30 = new TableColumn("Код детали");

    TableView tableRegistration8 = new TableView();
    TableColumn department8 = new TableColumn("Цех");
    TableColumn station8 = new TableColumn("Станция");
    TableColumn object8 = new TableColumn("Обект");
    TableColumn leftDays8 = new TableColumn("Количество оставшихся дней");
    TableColumn detail8 = new TableColumn("Деталь");
    TableColumn lastCheck8 = new TableColumn("Дата последней проверки");
    TableColumn nextCheck8 = new TableColumn("Дата новой проверки");
    TableColumn detailName8 = new TableColumn("Наименование детали");
    TableColumn location8 = new TableColumn("Расположение");
    TableColumn detailCode8 = new TableColumn("Код детали");

    TableView tableRegistration1 = new TableView();
    TableColumn department1 = new TableColumn("Цех");
    TableColumn station1 = new TableColumn("Станция");
    TableColumn object1 = new TableColumn("Обект");
    TableColumn leftDays1 = new TableColumn("Количество оставшихся дней");
    TableColumn detail1 = new TableColumn("Деталь");
    TableColumn lastCheck1 = new TableColumn("Дата последней проверки");
    TableColumn nextCheck1 = new TableColumn("Дата новой проверки");
    TableColumn detailName1 = new TableColumn("Наименование детали");
    TableColumn location1 = new TableColumn("Расположение");
    TableColumn detailCode1 = new TableColumn("Код детали");

    //objects for insertion pane
    Tab btnToInsertion = new Tab("Добавить параметры");

    TableView tableDepartment = new TableView();
    TableColumn departmentName = new TableColumn("Название Цеха");
    Label lbInsertDep = new Label("Цех");
    TextField taInsertDep = new TextField();
    Button btnInsertDep = new Button("Вставить запись");
    Button btnInsertDepRst = new Button("Просмотреть результат");
    Button clearDepartmentTF = new Button();

    TableView tableDetail = new TableView();
    TableColumn detName = new TableColumn("Название детали");
    TableColumn yearWrrnty = new TableColumn("Года годности");
    Label lbInsertDetail = new Label("Деталь");
    Label lbInsertYear = new Label("Года годности");
    TextField taInsertDetail = new TextField();
    TextField taInsertYear = new TextField();
    Button btnInsertDetail = new Button("Вставить запись");
    Button btnInsertDetailRst = new Button("Просмотреть результат");
    Button clearDetailTF = new Button();

    TableView tableObject = new TableView();
    TableColumn objName = new TableColumn("Название Обекта");
    Label lbInsertObject = new Label("Обект");
    TextField taInsertObject = new TextField();
    Button btnInsertObject = new Button("Вставить запись");
    Button btnInsertObjectRst = new Button("Просмотреть результат");
    Button clearObjectTF = new Button();

    TableView tableStation = new TableView();
    TableColumn stationName = new TableColumn("Название Станции");
    Label lbInsertStation = new Label("Станция");
    TextField taInsertStation = new TextField();
    Button btnInsertStation = new Button("Вставить запись");
    Button btnInsertStationRst = new Button("Просмотреть результат");
    Button clearStationTF = new Button();

    //objects for pane to insert registration
    Tab btnToInsertReg = new Tab("Добавить информацию");

    Button btnForInsertReg = new Button("Вставкa запись");
    Button btnNotification = new Button("Обновление");
    ComboBox<String> cmbDepartments = new ComboBox<>();
    ArrayList<String> departments;
    ComboBox<String> cmbStations = new ComboBox<>();
    ArrayList<String> stations;
    ComboBox<String> cmbObjects = new ComboBox<>();
    ArrayList<String> objects;
    ComboBox<String> cmbDetails = new ComboBox<>();
    ArrayList<String> details;
    Label labelForDep = new Label("Цех");
    Label labelForStation = new Label("Станция");
    Label labelForObject = new Label("Обект");
    Label labelForDetail = new Label("Деталь");
    Label labelForDetailCode = new Label("Код");
    Label labelForLocation = new Label("Место");
    Label labelForCheckDate = new Label("Дата проверки");
    TextField tfForDetailCode = new TextField();
    TextField tfForLocation = new TextField();
    DatePicker tfForCheckDate = new DatePicker();

    Button btnPrint = new Button("Print");

    final AudioClip ALERT_AUDIOCLIP = new AudioClip(getClass().getClassLoader().getResource("music/demonstrative.mp3").toExternalForm());
    final AudioClip INPUT_AUDIOCLIP = new AudioClip(getClass().getClassLoader().getResource("music/input.mp3").toExternalForm());

    public void print(PrinterJob job, Node node) {
        Printer printer = Printer.getDefaultPrinter();

        boolean success = job.printPage(node);
        if (success) {
            job.endJob();
        }
    }

    public static void printNode(final Node node) {
        Printer printer = Printer.getDefaultPrinter();
        PageLayout pageLayout
                = printer.createPageLayout(Paper.A4, PageOrientation.PORTRAIT, Printer.MarginType.HARDWARE_MINIMUM);
        PrinterJob job = PrinterJob.createPrinterJob();
        double scaleX
                = pageLayout.getPrintableWidth() / node.getBoundsInParent().getWidth();
        double scaleY
                = pageLayout.getPrintableHeight() / node.getBoundsInParent().getHeight();
        Scale scale = new Scale(scaleX, scaleY);
        node.getTransforms().add(scale);

        if (job != null) {
            boolean success = job.printPage(pageLayout, node);
            if (success) {
                job.endJob();

            }
        }
        node.getTransforms().remove(scale);
    }

    public void setup(final Node node, Stage owner) {

        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null) {
            boolean proceed = job.showPrintDialog(owner);
            if (proceed) {
                print(job, node);
            }
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField user = new TextField();
        PasswordField pass = new PasswordField();
        Label lbUser = new Label("Username:");
        Label lbPass = new Label("Password:");
        Button login = new Button("Login");

        GridPane grid = new GridPane();
        grid.add(lbUser, 0, 0);
        grid.add(user, 0, 1);
        grid.add(lbPass, 0, 2);
        grid.add(pass, 0, 3);
        grid.add(login, 1, 3);

        login.setOnAction(e -> {
            if (!user.getText().isEmpty() || !pass.getText().isEmpty()) {
                if (pass.getText().equals(DataProcess.selectPassword(user.getText()))) {
                    APM(primaryStage);
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Login");
                    alert.setHeaderText("Invalid username or password");
                    alert.setContentText("Try again");
                    INPUT_AUDIOCLIP.play();
                    alert.showAndWait();
                }
            } else {
                user.setPromptText("Please, enter username");
                pass.setPromptText("Please, enter password");
            }
        });

        Scene scene = new Scene(grid, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        String bgURL = "/images/gradient.jpg";
        grid.setStyle("-fx-background-image: url('" + bgURL + "');");
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        primaryStage.setTitle("Login");
        lbUser.setFont(new Font("Times", 20));
        lbUser.setTextFill(Color.ANTIQUEWHITE);
        lbPass.setFont(new Font("Times", 20));
        lbPass.setTextFill(Color.ANTIQUEWHITE);
        pass.setFont(new Font("Times", 20));
        user.setFont(new Font("Times", 20));
        login.setFont(new Font("Times", 20));
        pass.setAlignment(Pos.BASELINE_RIGHT);
        pass.setPromptText("Enter password");
        user.setAlignment(Pos.BASELINE_RIGHT);
        user.setPromptText("Enter username");

        Rectangle clip = new Rectangle(300, 200);
        clip.setArcWidth(20);
        clip.setArcHeight(20);
        login.setClip(clip);
        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        WritableImage image = login.snapshot(parameters, null);
        login.setClip(null);
        login.setEffect(new DropShadow(20, Color.BLACK));
    }

    @SuppressWarnings("empty-statement")
    public void APM(Stage primaryStage) {
        //process with registration view pane
        department.setCellValueFactory(new PropertyValueFactory("department"));
        station.setCellValueFactory(new PropertyValueFactory("station"));
        object.setCellValueFactory(new PropertyValueFactory("object"));
        leftDays.setCellValueFactory(new PropertyValueFactory("leftDays"));
        detail.setCellValueFactory(new PropertyValueFactory("detail"));
        lastCheck.setCellValueFactory(new PropertyValueFactory("lastCheck"));
        nextCheck.setCellValueFactory(new PropertyValueFactory("nextCheck"));
        location.setCellValueFactory(new PropertyValueFactory("location"));
        detailCode.setCellValueFactory(new PropertyValueFactory("registrationID"));

        tableRegistrationAll.getColumns().addAll(department, station, object, leftDays,
                detail, lastCheck, nextCheck, location, detailCode);

        department30.setCellValueFactory(new PropertyValueFactory("department"));
        station30.setCellValueFactory(new PropertyValueFactory("station"));
        object30.setCellValueFactory(new PropertyValueFactory("object"));
        leftDays30.setCellValueFactory(new PropertyValueFactory("leftDays"));
        detail30.setCellValueFactory(new PropertyValueFactory("detail"));
        lastCheck30.setCellValueFactory(new PropertyValueFactory("lastCheck"));
        nextCheck30.setCellValueFactory(new PropertyValueFactory("nextCheck"));
        location30.setCellValueFactory(new PropertyValueFactory("location"));
        detailCode30.setCellValueFactory(new PropertyValueFactory("registrationID"));

        tableRegistration30.getColumns().addAll(department30, station30, object30, leftDays30,
                detail30, lastCheck30, nextCheck30, location30, detailCode30);

        department8.setCellValueFactory(new PropertyValueFactory("department"));
        station8.setCellValueFactory(new PropertyValueFactory("station"));
        object8.setCellValueFactory(new PropertyValueFactory("object"));
        leftDays8.setCellValueFactory(new PropertyValueFactory("leftDays"));
        detail8.setCellValueFactory(new PropertyValueFactory("detail"));
        lastCheck8.setCellValueFactory(new PropertyValueFactory("lastCheck"));
        nextCheck8.setCellValueFactory(new PropertyValueFactory("nextCheck"));
        location8.setCellValueFactory(new PropertyValueFactory("location"));
        detailCode8.setCellValueFactory(new PropertyValueFactory("registrationID"));

        tableRegistration8.getColumns().addAll(department8, station8, object8, leftDays8,
                detail8, lastCheck8, nextCheck8, location8, detailCode8);

        department1.setCellValueFactory(new PropertyValueFactory("department"));
        station1.setCellValueFactory(new PropertyValueFactory("station"));
        object1.setCellValueFactory(new PropertyValueFactory("object"));
        leftDays1.setCellValueFactory(new PropertyValueFactory("leftDays"));
        detail1.setCellValueFactory(new PropertyValueFactory("detail"));
        lastCheck1.setCellValueFactory(new PropertyValueFactory("lastCheck"));
        nextCheck1.setCellValueFactory(new PropertyValueFactory("nextCheck"));
        location1.setCellValueFactory(new PropertyValueFactory("location"));
        detailCode1.setCellValueFactory(new PropertyValueFactory("registrationID"));

        tableRegistration1.getColumns().addAll(department1, station1, object1, leftDays1,
                detail1, lastCheck1, nextCheck1, location1, detailCode1);

        RadioButton btnAll = new RadioButton("All");
        RadioButton btn30 = new RadioButton("30 days");
        RadioButton btn8 = new RadioButton("7 days");
        RadioButton btn1 = new RadioButton("1 day");
        ToggleGroup group = new ToggleGroup();
        btnAll.setToggleGroup(group);
        btn30.setToggleGroup(group);
        btn8.setToggleGroup(group);
        btn1.setToggleGroup(group);

        HBox hbRBtns = new HBox();
        BorderPane paneTables = new BorderPane();

        hbRBtns.getChildren().addAll(btn1, btn8, btn30, btnAll);
        paneTables.setTop(hbRBtns);
        btnToSeeRegistration.setContent(paneTables);

        //process with insertion pane       
        detName.setCellValueFactory(new PropertyValueFactory("name"));
        yearWrrnty.setCellValueFactory(new PropertyValueFactory("warranty"));
        tableDetail.setItems(DataProcess.selectDetail());
        tableDetail.getColumns().addAll(detName, yearWrrnty);

        objName.setCellValueFactory(new PropertyValueFactory("name"));
        tableObject.setItems(DataProcess.selectObject());
        tableObject.getColumns().add(objName);

        stationName.setCellValueFactory(new PropertyValueFactory("name"));
        tableStation.setItems(DataProcess.selectStation());
        tableStation.getColumns().add(stationName);

        departmentName.setCellValueFactory(new PropertyValueFactory("name"));
        tableDepartment.setItems(DataProcess.selectDepartment());
        tableDepartment.getColumns().add(departmentName);

        VBox paneForInsertDep = new VBox();
        paneForInsertDep.getChildren().addAll(tableDepartment, lbInsertDep,
                new HBox(taInsertDep, clearDepartmentTF), btnInsertDep, btnInsertDepRst);
        VBox paneForInsertDetail = new VBox();
        GridPane grid = new GridPane();
        grid.add(lbInsertDetail, 0, 0);
        grid.add(lbInsertYear, 1, 0);
        grid.add(taInsertDetail, 0, 1);
        grid.add(taInsertYear, 1, 1);
        grid.add(clearDetailTF, 2, 1);
        paneForInsertDetail.getChildren().addAll(tableDetail, grid,
                btnInsertDetail, btnInsertDetailRst);
        VBox paneForInsertObject = new VBox();
        paneForInsertObject.getChildren().addAll(tableObject, lbInsertObject,
                new HBox(taInsertObject, clearObjectTF), btnInsertObject, btnInsertObjectRst);
        VBox paneForInsertStation = new VBox();
        paneForInsertStation.getChildren().addAll(tableStation, lbInsertStation,
                new HBox(taInsertStation, clearStationTF), btnInsertStation, btnInsertStationRst);

        HBox paneInsertion = new HBox(4);
        paneInsertion.getChildren().addAll(paneForInsertDep, paneForInsertStation,
                paneForInsertObject, paneForInsertDetail);
        paneInsertion.setPadding(new Insets(10, 10, 10, 10));
        btnToInsertion.setContent(paneInsertion);

        DataProcess dp = new DataProcess();

        VBox paneInsertReg = new VBox();
        GridPane gridCodeLocation = new GridPane();
        HBox hbpaneInsertReg = new HBox();
        final Pane spacer = new Pane();
        VBox.setVgrow(spacer, Priority.ALWAYS);
        spacer.setMinSize(10, 100);

        gridCodeLocation.add(labelForDetailCode, 0, 0);
        gridCodeLocation.add(labelForLocation, 1, 0);
        gridCodeLocation.add(tfForDetailCode, 0, 1);
        gridCodeLocation.add(tfForLocation, 1, 1);
        gridCodeLocation.setPrefSize(50, 100);

        paneInsertReg.getChildren().addAll(btnNotification, labelForDep,
                cmbDepartments, labelForStation, cmbStations,
                labelForObject, cmbObjects, labelForDetail, cmbDetails,
                gridCodeLocation, labelForCheckDate, tfForCheckDate,
                btnForInsertReg);
        paneInsertReg.setPadding(new Insets(10, 10, 10, 10));
        VBox printPane = PrintPane.printTable();
//        PrintPane.refresh.setOnMouseClicked(e -> {
//            PrintPane.tableRegistration.setItems(DataProcess.selectDataFromRegistration());
//        });


        hbpaneInsertReg.getChildren().addAll(paneInsertReg);
        btnToInsertReg.setContent(hbpaneInsertReg);

        tabPane.getTabs().addAll(btnToSeeRegistration,
                btnToInsertReg, btnToInsertion);
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        pane.setCenter(tabPane);
        pane.setBottom(btnPrint);
        btnPrint.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(pane, 1000, 600);

        scene.getStylesheets().add("style/tableStyle.css");
        tableRegistrationAll.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableRegistration30.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableRegistration8.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableRegistration1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableDepartment.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableDetail.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableObject.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableStation.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        xBtn1.setFitHeight(20);
        xBtn1.setFitWidth(20);
        xBtn2.setFitHeight(20);
        xBtn2.setFitWidth(20);
        xBtn3.setFitHeight(20);
        xBtn3.setFitWidth(20);
        xBtn4.setFitHeight(20);
        xBtn4.setFitWidth(20);

        clearStationTF.hoverProperty();
        clearStationTF.setGraphic(xBtn1);
        clearStationTF.setStyle(Style.styleButton);
        clearObjectTF.setGraphic(xBtn2);
        clearObjectTF.setStyle(Style.styleButton);
        clearDetailTF.setGraphic(xBtn3);
        clearDetailTF.setStyle(Style.styleButton);
        clearDepartmentTF.setGraphic(xBtn4);
        clearDepartmentTF.setStyle(Style.styleButton);

        //actions here..
        tableRegistrationAll.setRowFactory(tv -> {
            TableRow<Registration> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Registration rowData = row.getItem();
                    UpdateStage.update(rowData).show();
                }
            });
            return row;
        });

        tableRegistration30.setRowFactory(tv -> {
            TableRow<Registration> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Registration rowData = row.getItem();
                    UpdateStage.update(rowData).show();
                }
            });
            return row;
        });

        tableRegistration8.setRowFactory(tv -> {
            TableRow<Registration> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Registration rowData = row.getItem();
                    UpdateStage.update(rowData).show();
                }
            });
            return row;
        });

        tableRegistration1.setRowFactory(tv -> {
            TableRow<Registration> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Registration rowData = row.getItem();
                    UpdateStage.update(rowData).show();
                }
            });
            return row;
        });

        btnAll.setOnAction(e -> {
            if (btnAll.isSelected()) {
                paneTables.setCenter(tableRegistrationAll);
            }
        });
        btn30.setOnAction(e -> {
            if (btn30.isSelected()) {
                paneTables.setCenter(tableRegistration30);
            }
        });
        btn8.setOnAction(e -> {
            if (btn8.isSelected()) {
                paneTables.setCenter(tableRegistration8);
            }
        });
        btn1.setOnAction(e -> {
            if (btn1.isSelected()) {
                paneTables.setCenter(tableRegistration1);
            }
        });

        btnInsertDep.setOnAction(e -> {
            if (!taInsertDep.getText().isEmpty()) {
                Registration dpName = new Registration(taInsertDep.getText());
                try {
                    dp.insertDepartment(dpName);
                } catch (SQLException ex) {
                    System.out.println("I am in btnInsertDep");
                }
            } else {
                taInsertDep.setPromptText("Заполните бланк");
            }

            departmentName.setCellValueFactory(new PropertyValueFactory("name"));
            tableDepartment.setItems(DataProcess.selectDepartment());
        });

        btnInsertDetail.setOnAction(e -> {
            try {
                if (!taInsertDetail.getText().isEmpty() && !taInsertYear.getText().isEmpty()) {
                    Registration det = new Registration(taInsertDetail.getText(),
                            Integer.valueOf(taInsertYear.getText()));
                    try {
                        dp.insertDetail(det);
                    } catch (SQLException ex) {
                        System.out.println("I am in btnInsertDetail");
                    }
                } else {
                    taInsertDetail.setPromptText("Заполните бланк");
                    taInsertYear.setPromptText("Заполните бланк");
                }
            } catch (NumberFormatException ex) {
                taInsertYear.setPromptText("Заполните цифрами");;
            }

            detName.setCellValueFactory(new PropertyValueFactory("name"));
            yearWrrnty.setCellValueFactory(new PropertyValueFactory("warranty"));
            tableDetail.setItems(DataProcess.selectDetail());
        });

        btnInsertObject.setOnAction(e -> {
            if (taInsertObject.getText().isEmpty()) {
                taInsertObject.setPromptText("Заполните бланк");
            } else {
                Registration obj = new Registration(taInsertObject.getText());
                try {
                    dp.insertObject(obj);
                } catch (SQLException ex) {
                    System.out.println("I am in btnInsertObject");
                }
            }

            objName.setCellValueFactory(new PropertyValueFactory("name"));
            tableObject.setItems(DataProcess.selectObject());
        });

        btnInsertStation.setOnAction(e -> {
            if (!taInsertStation.getText().isEmpty()) {
                Registration sttn = new Registration(taInsertStation.getText());
                try {
                    dp.insertStation(sttn);
                } catch (SQLException ex) {
                    System.out.println("I am in btnInsertStation");
                }
            } else {
                taInsertStation.setPromptText("Заполните бланк"); //Ничего не найдено
            }

            stationName.setCellValueFactory(new PropertyValueFactory("name"));
            tableStation.setItems(DataProcess.selectStation());
        });

        clearDepartmentTF.setOnAction(e -> {
            taInsertDep.clear();
        });

        clearDetailTF.setOnAction(e -> {
            taInsertDetail.clear();
            taInsertYear.clear();
        });

        clearObjectTF.setOnAction(e -> {
            taInsertObject.clear();
        });

        clearStationTF.setOnAction(e -> {
            taInsertStation.clear();
        });

        btnInsertDepRst.setOnAction(e -> {
            departmentName.setCellValueFactory(new PropertyValueFactory("name"));
            tableDepartment.setItems(DataProcess.selectDepartment());
        });

        btnInsertDetailRst.setOnAction(e -> {
            detName.setCellValueFactory(new PropertyValueFactory("name"));
            yearWrrnty.setCellValueFactory(new PropertyValueFactory("warranty"));
            tableDetail.setItems(DataProcess.selectDetail());
        });

        btnInsertObjectRst.setOnAction(e -> {
            objName.setCellValueFactory(new PropertyValueFactory("name"));
            tableObject.setItems(DataProcess.selectObject());
        });

        btnInsertStationRst.setOnAction(e -> {
            stationName.setCellValueFactory(new PropertyValueFactory("name"));
            tableStation.setItems(DataProcess.selectStation());
        });

        btnPrint.setOnAction(e -> {
            printNode(printPane);
        });

        btnForInsertReg.setOnAction(e -> {
            try {
                if (!cmbDepartments.getValue().isEmpty()
                        || !cmbStations.getValue().isEmpty()
                        || !cmbObjects.getValue().isEmpty()
                        || !cmbDetails.getValue().isEmpty()
                        || !tfForDetailCode.getText().isEmpty()
                        || !tfForLocation.getText().isEmpty()) {
                    String tempDep = cmbDepartments.getValue();
                    String tempStation = cmbStations.getValue();
                    String tempObject = cmbObjects.getValue();
                    String tempDetail = cmbDetails.getValue();
                    Date tempLastCheck = java.sql.Date.valueOf(tfForCheckDate.getValue());
                    int tempLocation = Integer.parseInt(tfForLocation.getText());
                    int tempDetailCode = Integer.parseInt(tfForDetailCode.getText());

                    long date1 = tfForCheckDate.getValue().toEpochDay();
                    tfForCheckDate.setValue(tfForCheckDate.getValue().plusYears(DataProcess.selectDetailWarranty(tempDetail)));
                    long date2 = tfForCheckDate.getValue().toEpochDay();
                    Date tempNextCheck = java.sql.Date.valueOf(tfForCheckDate.getValue());
                    int days = (int) Math.abs(date1 - date2);

                    Registration tempRegistration = new Registration(tempDep,
                            tempStation, tempObject, days, tempDetail,
                            tempLastCheck, tempNextCheck, tempLocation, tempDetailCode);
                    DataProcess datP = new DataProcess();
                    datP.insertRegistration(tempRegistration);
                    DataProcess.updateLeftDays();
                }
            } catch (NullPointerException | NumberFormatException ex) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Input");
                alert.setHeaderText("Input Error");
                alert.setContentText("Please enter all values in the correct format!");
                INPUT_AUDIOCLIP.play();
                alert.showAndWait();
            }
        });

        btnNotification.setOnAction(e -> {
            ArrayList<Integer> lftDays = DataProcess.selectLeftDays();
            int count = 0;
            for (Integer lftDay : lftDays) {
                if (lftDay > -30) {
                    count++;
                }
            }
            String message = "Sizda " + count + " ta yangi xabar bor!";
            MakeNotification.makeNotification(message);
        });

        tableDepartment.setRowFactory(tv -> {
            TableRow<Registration> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    INPUT_AUDIOCLIP.play();
                    Registration rowData = row.getItem();
                    DeleteStage.delete(rowData.getName(), "department").show();
                }
            });
            return row;
        });

        tableStation.setRowFactory(tv -> {
            TableRow<Registration> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    INPUT_AUDIOCLIP.play();
                    Registration rowData = row.getItem();
                    DeleteStage.delete(rowData.getName(), "station").show();
                }
            });
            return row;
        });

        tableObject.setRowFactory(tv -> {
            TableRow<Registration> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    INPUT_AUDIOCLIP.play();
                    Registration rowData = row.getItem();
                    DeleteStage.delete(rowData.getName(), "object").show();
                }
            });
            return row;
        });

        tableDetail.setRowFactory(tv -> {
            TableRow<Registration> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    INPUT_AUDIOCLIP.play();
                    Registration rowData = row.getItem();
                    DeleteStage.delete(rowData.getName(), "detail").show();
                }
            });
            return row;
        });

        //threads here..
        new Thread(() -> {

            try {
                while (true) {
                    System.out.println("627");
                    Platform.runLater(() -> {
                        tableRegistrationAll.setItems(DataProcess.selectDataFromRegistration());
                        tableRegistration30.setItems(DataProcess.selectDataFromRegistration(-30));
                        tableRegistration8.setItems(DataProcess.selectDataFromRegistration(-7));
                        tableRegistration1.setItems(DataProcess.selectDataFromRegistration(-1));
                    });
                    Thread.sleep(2 * 1000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(APM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();

        new Thread(() -> {

            try {
                while (true) {
                    System.out.println("645");
                    Platform.runLater(() -> {
                        cmbDepartments.setItems(DataProcess.selectDepartmentForCBox());

                        cmbStations.setItems(DataProcess.selectStationForCBox());

                        cmbObjects.setItems(DataProcess.selectObjectForCBox());

                        cmbDetails.setItems(DataProcess.selectDetailForCBox());
                    });
                    Thread.sleep(2 * 1000);
                }
            } catch (InterruptedException ex) {
            }
        }).start();

        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Warning Dialog");
        alert.setContentText("Please warn the specific workers to check the details!");

        new Thread(() -> {
            try {
                while (true) {
                    System.out.println("668");
                    ArrayList<Integer> lftDays = DataProcess.selectLeftDays();
                    int count = 0;
                    for (Integer lftDay : lftDays) {
                        if (lftDay == -30 || lftDay == -7 || lftDay == -1) {
                            count++;
                        }
                    }
                    if (count != 0) {
                        alert.setHeaderText("You have " + count + " unchecked messages  here.");
                        Platform.runLater(() -> {
                            ALERT_AUDIOCLIP.play();
                            alert.show();
                        });
                    }
                    Thread.sleep(2 * 60 * 1000);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();

        new Thread(() -> {

            try {
                while (true) {
                    System.out.println("694");
                    DataProcess.updateLeftDays();
                    Thread.sleep(60 * 60 * 1000);
                }
            } catch (InterruptedException ex) {
            }
        }).start();

        primaryStage.setScene(scene);
        primaryStage.setTitle("APM Registration");
        primaryStage.show();

    }

}
