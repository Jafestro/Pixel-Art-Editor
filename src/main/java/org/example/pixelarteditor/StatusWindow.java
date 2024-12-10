package org.example.pixelarteditor;

class StatusWindow {
  private final int gridSize = 8;
  final boolean[][] pixelState;
  private int cursorX = 0;
  private int cursorY = 0;

  public StatusWindow() {
    pixelState = new boolean[gridSize][gridSize];
  }

  public int getGridSize() {
    return gridSize;
  }

  public void updateCursor(int cursorY, int cursorX) {
    this.cursorY = cursorY;
    this.cursorX = cursorX;
    System.out.println("Cursor moved to: (" + cursorY + ", " + cursorX + ")");
  }

  public boolean togglePixel() {
    pixelState[cursorY][cursorX] = !pixelState[cursorY][cursorX];
    System.out.println("Toggled pixel at (" + cursorY + ", " + cursorX + ") to " + (pixelState[cursorY][cursorX] ? "ON" : "OFF"));
    return pixelState[cursorY][cursorX];
  }

  public void printCode() {
    System.out.println("int[][] pixelArt = {");
    for (int i = 0; i < gridSize; i++) {
      System.out.print("    {");
      for (int j = 0; j < gridSize; j++) {
        System.out.print((pixelState[i][j] ? 1 : 0) + (j < gridSize - 1 ? ", " : ""));
      }
      System.out.println("}" + (i < gridSize - 1 ? "," : ""));
    }
    System.out.println("};");
  }
}
