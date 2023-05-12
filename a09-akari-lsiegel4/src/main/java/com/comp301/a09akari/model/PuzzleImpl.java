package com.comp301.a09akari.model;

public class PuzzleImpl implements Puzzle {
  private int[][] board;

  public PuzzleImpl(int[][] board) {
    this.board = board;
  }

  @Override
  public int getWidth() {
    return this.board[0].length;
  }

  @Override
  public int getHeight() {
    return this.board.length;
  }

  @Override
  public CellType getCellType(int r, int c) {
    if (r >= this.getHeight() || c >= this.getWidth() || r < 0 || c < 0) {
      throw new IndexOutOfBoundsException("r and c must be in bounds of board!");
    }
    int cell = this.board[r][c];
    if (cell < 5) {
      return CellType.CLUE;
    } else if (cell == 5) {
      return CellType.WALL;
    } else {
      return CellType.CORRIDOR;
    }
  }

  @Override
  public int getClue(int r, int c) {
    if (r >= this.getHeight() || c >= this.getWidth() || r < 0 || c < 0) {
      throw new IndexOutOfBoundsException("r and c must be in bounds of board!");
    }
    if (this.getCellType(r, c) != CellType.CLUE) {
      throw new IllegalArgumentException("Cell must be a clue!");
    }
    return this.board[r][c];
  }
}
