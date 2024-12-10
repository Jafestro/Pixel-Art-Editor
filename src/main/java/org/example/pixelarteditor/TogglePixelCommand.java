package org.example.pixelarteditor;

class TogglePixelCommand implements Command {
  private final PixelSystem pixelSystem;

  TogglePixelCommand(PixelSystem pixelSystem) {
    this.pixelSystem = pixelSystem;
  }

  @Override
  public boolean execute() {
    return pixelSystem.togglePixel();
  }
}
