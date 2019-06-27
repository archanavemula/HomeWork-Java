

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;

public class GUIProgram extends Application {
	
	protected Text text = new Text(70, 50, "Programming is fun");

	@Override 
	public void start(Stage primaryStage) {
		
		BorderPane pane = new BorderPane();
		Scene scene = new Scene(pane, 500, 100);
		primaryStage.setTitle("GUIProgram"); 
		
		//create radio buttons with colors mentioned.
		RadioButton red = new RadioButton("Red");
		RadioButton yellow = new RadioButton("Yellow");
		RadioButton black = new RadioButton("Black");
		RadioButton orange = new RadioButton("Orange");
		RadioButton green = new RadioButton("Green");
			
		Button left = new Button("<=");
		Button right = new Button("=>");
		
		
		ToggleGroup group = new ToggleGroup();
		
		HBox buttons = new HBox(20);
		buttons.getChildren().addAll(left, right);
		buttons.setAlignment(Pos.CENTER);
		

		HBox radioB = new HBox(20);
		radioB.getChildren().addAll(red, yellow, black, orange, green);

		
		red.setToggleGroup(group);
		yellow.setToggleGroup(group);
		black.setToggleGroup(group);
		orange.setToggleGroup(group);
		green.setToggleGroup(group);

		Pane paneForText = new Pane();
		paneForText.setStyle("-fx-border-color: black");
		paneForText.getChildren().add(text);
		pane.setCenter(paneForText);
		pane.setTop(radioB);

		left.setOnAction(e -> text.setX(text.getX() - 7));
		right.setOnAction(e -> text.setX(text.getX() + 7));

		red.setOnAction(e -> {if (red.isSelected()) { text.setFill(Color.RED);} });
		yellow.setOnAction(e -> {if (yellow.isSelected()) {text.setFill(Color.YELLOW);}});
		black.setOnAction(e -> {if (black.isSelected()) {text.setFill(Color.BLACK);}});
		orange.setOnAction(e -> {if (orange.isSelected()) {text.setFill(Color.ORANGE);}});
		green.setOnAction(e -> {if (green.isSelected()) {text.setFill(Color.GREEN);}});
	
		pane.setBottom(buttons);
		primaryStage.setScene(scene); 
		primaryStage.show(); 
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

