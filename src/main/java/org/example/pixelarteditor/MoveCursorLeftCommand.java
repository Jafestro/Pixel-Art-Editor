package org.example.pixelarteditor;

class MoveCursorLeftCommand implements Command {
  private final CursorSystem cursorSystem;

  MoveCursorLeftCommand(CursorSystem cursorSystem) {
    this.cursorSystem = cursorSystem;
  }

  @Override
  public boolean execute() {
    return cursorSystem.moveCursor(0, -1);
  }
}
