package org.example.pixelarteditor;

class GenerateCodeSystem {
  private final StatusWindow statusWindow;

  GenerateCodeSystem(StatusWindow statusWindow) {
    this.statusWindow = statusWindow;
  }

  public void generateCode() {
    statusWindow.printCode();
  }
}
