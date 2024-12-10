package org.example.pixelarteditor;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GUI extends Application {
  private final StatusWindow statusWindow = new StatusWindow();
  private final CursorSystem cursorSystem = new CursorSystem(statusWindow);
  private final PixelSystem pixelSystem = new PixelSystem(statusWindow);
  private final GenerateCodeSystem generateCodeSystem = new GenerateCodeSystem(statusWindow);

  private static final int RECT_SIZE = 40;
  private final Rectangle[][] grid = new Rectangle[8][8];

  @Override
  public void start(Stage primaryStage) {
    BorderPane root = new BorderPane();
    GridPane gridPane = new GridPane();

    // Initialize grid
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        Rectangle rect = new Rectangle(RECT_SIZE, RECT_SIZE);
        rect.setFill(Color.LIGHTGRAY);
        rect.setStroke(Color.BLACK);
        grid[i][j] = rect;
        gridPane.add(rect, j, i);
      }
    }

    Button generateCodeButton = new Button("Generate Code");
    generateCodeButton.setOnAction(e -> new GenerateCodeCommand(generateCodeSystem).execute());

    root.setCenter(gridPane);
    root.setBottom(generateCodeButton);

    Scene scene = new Scene(root, 400, 450);

    // Request focus on the scene to capture key events
    root.requestFocus();

    // Key events for commands
    scene.setOnKeyPressed(event -> {
      Command command = null;
      if (event.getCode() == KeyCode.UP) {
        command = new MoveCursorUpCommand(cursorSystem);
      } else if (event.getCode() == KeyCode.DOWN) {
        command = new MoveCursorDownCommand(cursorSystem);
      } else if (event.getCode() == KeyCode.LEFT) {
        command = new MoveCursorLeftCommand(cursorSystem);
      } else if (event.getCode() == KeyCode.RIGHT) {
        command = new MoveCursorRightCommand(cursorSystem);
      } else if (event.getCode() == KeyCode.SPACE) {
        command = new TogglePixelCommand(pixelSystem);
      }

      if (command != null && command.execute()) {
        // Update grid display
        for (int i = 0; i < 8; i++) {
          for (int j = 0; j < 8; j++) {
            if (i == cursorSystem.getCursorY() && j == cursorSystem.getCursorX()) {
              grid[i][j].setFill(Color.BLUE); // Highlight cursor position
            } else {
              grid[i][j].setFill(statusWindow.pixelState[i][j] ? Color.BLACK : Color.LIGHTGRAY);
            }
          }
        }
      }
    });

    primaryStage.setTitle("Pixel Art Editor");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}