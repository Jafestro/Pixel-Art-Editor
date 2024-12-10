package org.example.pixelarteditor;

class CursorSystem {
  private final StatusWindow statusWindow;
  private int cursorX = 0;
  private int cursorY = 0;

  CursorSystem(StatusWindow statusWindow) {
    this.statusWindow = statusWindow;
  }

  public boolean moveCursor(int deltaY, int deltaX) {
    int newCursorY = cursorY + deltaY;
    int newCursorX = cursorX + deltaX;

    if (newCursorY >= 0 && newCursorY < statusWindow.getGridSize() &&
            newCursorX >= 0 && newCursorX < statusWindow.getGridSize()) {
      cursorY = newCursorY;
      cursorX = newCursorX;
      statusWindow.updateCursor(cursorY, cursorX);
      return true;
    }
    return false;
  }

  public int getCursorX() {
    return cursorX;
  }

  public int getCursorY() {
    return cursorY;
  }
}
