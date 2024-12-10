package org.example.pixelarteditor;

// Concrete Command Classes
class MoveCursorUpCommand implements Command {
  private final CursorSystem cursorSystem;

  MoveCursorUpCommand(CursorSystem cursorSystem) {
    this.cursorSystem = cursorSystem;
  }

  @Override
  public boolean execute() {
    return cursorSystem.moveCursor(-1, 0);
  }
}

