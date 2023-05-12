package com.comp301.a09akari.view;

import com.comp301.a09akari.SamplePuzzles;
import com.comp301.a09akari.controller.ClassicMvcController;
import com.comp301.a09akari.controller.ControllerImpl;
import com.comp301.a09akari.model.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class AppLauncher extends Application {
  @Override
  public void start(Stage stage) throws Exception {
    // TODO: Create your Model, View, and Controller instances and launch your GUI
    PuzzleLibrary puzzles = new PuzzleLibraryImpl();
    puzzles.addPuzzle(new PuzzleImpl(SamplePuzzles.PUZZLE_01));
    puzzles.addPuzzle(new PuzzleImpl(SamplePuzzles.PUZZLE_02));
    puzzles.addPuzzle(new PuzzleImpl(SamplePuzzles.PUZZLE_03));
    puzzles.addPuzzle(new PuzzleImpl(SamplePuzzles.PUZZLE_04));
    puzzles.addPuzzle(new PuzzleImpl(SamplePuzzles.PUZZLE_05));
    Model model = new ModelImpl(puzzles);
    ClassicMvcController controller = new ControllerImpl(model);
    View view = new View(controller, stage);

    stage.setTitle("The game of Akari.");

    view.update(model);

    stage.show();
  }
}
