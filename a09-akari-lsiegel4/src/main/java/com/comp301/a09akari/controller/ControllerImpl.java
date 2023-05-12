package com.comp301.a09akari.controller;

import com.comp301.a09akari.model.Model;
import com.comp301.a09akari.model.ModelObserver;
import com.comp301.a09akari.model.Puzzle;

public class ControllerImpl implements ClassicMvcController {
  private Model model;

  public ControllerImpl(Model model) {
    this.model = model;
  }

  @Override
  public void clickNextPuzzle() {
    if (model.getActivePuzzleIndex() != (model.getPuzzleLibrarySize() - 1)) {
      model.setActivePuzzleIndex(model.getActivePuzzleIndex() + 1);
      this.clear();
    }
  }

  @Override
  public void clickPrevPuzzle() {
    if (model.getActivePuzzleIndex() != 0) {
      model.setActivePuzzleIndex(model.getActivePuzzleIndex() - 1);
      this.clear();
    }
  }

  @Override
  public void clickRandPuzzle() {
    int random = model.getActivePuzzleIndex();
    while (random == model.getActivePuzzleIndex()) {
      random = (int) (Math.random() * model.getPuzzleLibrarySize());
    }
    model.setActivePuzzleIndex(random);
    this.clear();
  }

  @Override
  public void clickResetPuzzle() {
    model.resetPuzzle();
  }

  @Override
  public void clickCell(int r, int c) {
    if (r >= model.getActivePuzzle().getHeight()
        || c >= model.getActivePuzzle().getWidth()
        || r < 0
        || c < 0) {
      throw new IndexOutOfBoundsException("r and c must be in bounds of board!");
    }
    if (model.isLamp(r, c)) {
      model.removeLamp(r, c);
    } else {
      model.addLamp(r, c);
    }
  }

  @Override
  public Puzzle getPuzzle() {
    return model.getActivePuzzle();
  }

  @Override
  public Model getModel() {
    return this.model;
  }

  @Override
  public void addModelObserver(ModelObserver o) {
    this.model.addObserver(o);
  }

  @Override
  public void clear() {
    this.model.resetPuzzle();
  }
}
