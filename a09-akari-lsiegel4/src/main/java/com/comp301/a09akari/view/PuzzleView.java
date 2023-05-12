package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.ClassicMvcController;
import com.comp301.a09akari.model.CellType;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class PuzzleView implements FXComponent {
  private ClassicMvcController controller;

  public PuzzleView(ClassicMvcController controller) {
    this.controller = controller;
  }

  public Parent render() {
    GridPane gridPane = new GridPane();
    gridPane.getStyleClass().add("game-board");

    for (int i = 0; i < this.controller.getPuzzle().getWidth(); i++) {
      for (int j = 0; j < this.controller.getPuzzle().getHeight(); j++) {
        if (this.controller.getPuzzle().getCellType(j, i) == CellType.CORRIDOR) {
          Button button = new Button();
          button.setPrefSize(50, 50);
          button.getStyleClass().add("cell");
          int finalJ = j;
          int finalI = i;
          button.setOnAction(
              (ActionEvent event) -> {
                controller.clickCell(finalJ, finalI);
              });
          if (controller.getModel().isLamp(j, i)) {
            button = new Button("\u2600");
            button.setPrefSize(50, 50);
            button.setOnAction(
                (ActionEvent event) -> {
                  controller.clickCell(finalJ, finalI);
                });
            if (controller.getModel().isLampIllegal(j, i)) {
              button.getStyleClass().add("illegal");
            } else {
              button.getStyleClass().add("lamp");
            }
          } else if (controller.getModel().isLit(j, i)) {
            button.getStyleClass().add("lit");
          }
          gridPane.add(button, j, i);
        } else if (this.controller.getPuzzle().getCellType(j, i) == CellType.WALL) {
          Button button = new Button();
          button.setPrefSize(50, 50);
          button.getStyleClass().add("wall");
          gridPane.add(button, j, i);
        } else {
          Button button = new Button("" + this.controller.getPuzzle().getClue(j, i));
          button.setPrefSize(50, 50);
          if (this.controller.getModel().isClueSatisfied(j, i)) {
            button.getStyleClass().add("clue-solved");
          } else {
            button.getStyleClass().add("clue");
          }
          gridPane.add(button, j, i);
        }
      }
    }
    return gridPane;
  }
}
