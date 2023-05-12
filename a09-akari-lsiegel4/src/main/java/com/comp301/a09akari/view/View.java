package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.ClassicMvcController;
import com.comp301.a09akari.model.Model;
import com.comp301.a09akari.model.ModelObserver;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View implements ModelObserver {

  private ClassicMvcController controller;
  private Stage stage;

  public View(ClassicMvcController controller, Stage stage) {
    this.controller = controller;
    this.stage = stage;
    this.controller.addModelObserver(this);
  }

  public Parent render() {
    VBox layout = new VBox();

    ControlView cv = new ControlView(controller);
    PuzzleView pv = new PuzzleView(controller);
    MessageView mv = new MessageView(controller);

    layout.getChildren().add(cv.render());
    layout.getChildren().add(pv.render());
    layout.getChildren().add(mv.render());

    return layout;
  }

  @Override
  public void update(Model model) {
    Scene scene = new Scene(this.render());
    scene.getStylesheets().add("main.css");
    this.stage.setScene(scene);
  }
}
