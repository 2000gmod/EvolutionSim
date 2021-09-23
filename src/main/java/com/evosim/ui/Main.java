package com.evosim.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class Main extends Application {

    public static Canvas gameView;

    public static void entry(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        FlowPane flowPane = new FlowPane();
        Scene scene = new Scene(flowPane, 1600, 900);


        initMenu(primaryStage, flowPane);

        TabPane tabPane = new TabPane();
        flowPane.getChildren().add(tabPane);


        initTab(primaryStage, tabPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Evolution Simulator");
        primaryStage.show();
    }

    private static void initTab(Stage primaryStage, TabPane parent) {
        parent.prefWidthProperty().bind(primaryStage.widthProperty());
        parent.getTabs().addAll(initMainTab("Main View"), new Tab("Other things"));
    }


    private static void initMenu(Stage primaryStage, Pane parent) {
        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        parent.getChildren().add(menuBar);

        Menu control = new Menu("Control");
        menuBar.getMenus().addAll(control);

        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(f -> System.exit(0));

        control.getItems().addAll(exit);
    }

    private static Tab initMainTab(String title) {
        Tab tab = new Tab(title);

        VBox vBox = new VBox();
        tab.setContent(vBox);
        vBox.setPadding(new Insets(10, 15, 10, 15));

        Label titleLabel = new Label("Genetic Optimization Software");
        titleLabel.setFont(new Font(40));

        SplitPane splitPane = new SplitPane();

        gameView = new Canvas();
        gameView.setWidth(500);
        gameView.setHeight(500);

        gameView.getGraphicsContext2D().setFill(Color.RED);
        gameView.getGraphicsContext2D().fillRect(20, 20, 20, 20);

        VBox vBox1 = new VBox(gameView);

        HBox hBox = new HBox(new Label("Buttons"));

        splitPane.getItems().addAll(vBox1, hBox);

        vBox.getChildren().addAll(titleLabel, splitPane);

        tab.setClosable(false);
        return tab;
    }
}
