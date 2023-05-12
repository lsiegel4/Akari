package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.ClassicMvcController;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ControlView implements FXComponent {
  private ClassicMvcController controller;

  public ControlView(ClassicMvcController controller) {
    this.controller = controller;
  }

  public Parent render() {
    HBox layout = new HBox();
    layout.getStyleClass().add("controls-layout");

    Button prevPuzzle = new Button("\u2190");
    prevPuzzle.setOnAction(
        (ActionEvent event) -> {
          controller.clickPrevPuzzle();
        });
    layout.getChildren().add(prevPuzzle);

    Label title = new Label("Akari!");
    title.getStyleClass().add("title");
    layout.getChildren().add(title);

    Button nextPuzzle = new Button("\u2192");
    nextPuzzle.setOnAction(
        (ActionEvent event) -> {
          controller.clickNextPuzzle();
        });
    layout.getChildren().add(nextPuzzle);

    VBox header = new VBox();
    header.getStyleClass().add("header");
    header.getChildren().add(layout);

    Label author = new Label("By Lucas Siegel");
    author.getStyleClass().add("author");

    HBox middle = new HBox();
    middle.getStyleClass().add("middle");
    middle.getChildren().add(author);

    header.getChildren().add(middle);

    Button clear = new Button("Reset");
    clear.getStyleClass().add("clear");
    clear.setOnAction(
        (ActionEvent event) -> {
          controller.clear();
        });

    Button random = new Button("Random");
    random.getStyleClass().add("random");
    random.setOnAction(
        (ActionEvent event) -> {
          controller.clickRandPuzzle();
        });

    HBox bottom = new HBox();
    bottom.getStyleClass().add("bottom");
    bottom.getChildren().add(clear);
    bottom.getChildren().add(random);

    header.getChildren().add(bottom);

    return header;
  }
}
