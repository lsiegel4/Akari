package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.ClassicMvcController;
import com.comp301.a09akari.model.Model;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MessageView implements FXComponent {
  private ClassicMvcController controller;

  public MessageView(ClassicMvcController controller) {
    this.controller = controller;
  }

  public Parent render() {
    Label victory;
    if (controller.getModel().isSolved()) {
      victory = new Label("success");
    } else {
      victory = new Label();
    }
    victory.getStyleClass().add("victory-message");

    Label puzzles = new Label(this.makeLabelString());
    puzzles.getStyleClass().add("puzzle-number");

    HBox topLayout = new HBox();
    topLayout.getStyleClass().add("top-layout");
    topLayout.getChildren().add(puzzles);

    HBox layout = new HBox();
    layout.getStyleClass().add("message-layout");
    layout.getChildren().add(victory);

    VBox elts = new VBox();
    elts.getStyleClass().add("message");
    elts.getChildren().add(topLayout);
    elts.getChildren().add(layout);

    return elts;
  }

  public String makeLabelString() {
    return "Puzzle "
        + (this.controller.getModel().getActivePuzzleIndex() + 1)
        + "/"
        + (this.controller.getModel().getPuzzleLibrarySize());
  }
}
