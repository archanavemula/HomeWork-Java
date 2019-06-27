

import javafx.scene.shape.Polyline;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;


public class DrawLines extends Application {
	
	@Override 
	public void start(Stage primaryStage) {

		//line drawing object
		Polyline line = new Polyline(new Double(100.0), new Double(100.0));
		line.setFill(Color.WHITE);
		line.setStroke(Color.BLACK);
		
		//set the line to pane
		Pane pane = new Pane();
		pane.getChildren().add(line);
		
		ObservableList<Double> list = line.getPoints();
	
		Scene scene = new Scene(pane, 500, 300);
		primaryStage.setTitle("DrawLines");
		
		pane.setOnKeyPressed(e -> {
			
			double x = 0, y = 0;
			double len = 8;
			
			switch (e.getCode()) {						
				case RIGHT:
				{
				x = list.get(list.size() - 2) + len;
				y = list.get(list.size() - 1); 
				 break;
				}
				case UP: 
				{
				x = list.get(list.size() - 2);
				y = list.get(list.size() - 1) - len; 
				break;
				}
				case LEFT:
				{
				x = list.get(list.size() - 2) - len;
				y = list.get(list.size() - 1); 
				break;
				}
				case DOWN:
				{
				x = list.get(list.size() - 2);		  
				y = list.get(list.size() - 1) + len; 
				break;
				}
			
			}
			list.add(x);
			list.add(y); 
		});

		primaryStage.setScene(scene); 
		primaryStage.show(); 

		pane.requestFocus(); 
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}