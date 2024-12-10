package org.example.pixelarteditor;

class MoveCursorRightCommand implements Command {
  private final CursorSystem cursorSystem;

  MoveCursorRightCommand(CursorSystem cursorSystem) {
    this.cursorSystem = cursorSystem;
  }

  @Override
  public boolean execute() {
    return cursorSystem.moveCursor(0, 1);
  }
}
