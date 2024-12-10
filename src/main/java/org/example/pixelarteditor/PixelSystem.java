package org.example.pixelarteditor;

class PixelSystem {
  private final StatusWindow statusWindow;

  PixelSystem(StatusWindow statusWindow) {
    this.statusWindow = statusWindow;
  }

  public boolean togglePixel() {
    return statusWindow.togglePixel();
  }
}

