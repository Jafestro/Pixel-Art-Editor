package org.example.pixelarteditor;

class GenerateCodeCommand implements Command {
  private final GenerateCodeSystem generateCodeSystem;

  GenerateCodeCommand(GenerateCodeSystem generateCodeSystem) {
    this.generateCodeSystem = generateCodeSystem;
  }

  @Override
  public boolean execute() {
    generateCodeSystem.generateCode();
    return true;
  }
}