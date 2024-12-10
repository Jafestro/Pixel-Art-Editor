package org.example.pixelarteditor;

class MoveCursorDownCommand implements Command {
  private final CursorSystem cursorSystem;

  MoveCursorDownCommand(CursorSystem cursorSystem) {
    this.cursorSystem = cursorSystem;
  }

  @Override
  public boolean execute() {
    return cursorSystem.moveCursor(1, 0);
  }
}
