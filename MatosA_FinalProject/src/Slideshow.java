import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

/*
 * Class: CMSC214 
 * Instructor: Cristopher Fallon
 * Description: (Give a brief description for each Program)
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Alex Matos
*/

public class Slideshow extends Application {

	int index = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane pane = new BorderPane();

		Button addPhoto;
		Button goBack;
		Button goForward;

		FileChooser fileChooser = new FileChooser();
		Image firstImage = new Image(new FileInputStream(fileChooser.showOpenDialog(primaryStage)));

		ArrayList<Image> images = new ArrayList<>();
		images.add(firstImage);

		ImageView imageView = new ImageView(images.get(index));
		imageView.setX(10);
		imageView.setY(10);
		imageView.setFitWidth(575);
		imageView.setPreserveRatio(true);

		pane.setTop(addPhoto = new Button("Add Photo to Slideshow"));
		pane.setLeft(goBack = new Button("<"));
		pane.setRight(goForward = new Button(">"));
		pane.setCenter(imageView);

		BorderPane.setAlignment(addPhoto, Pos.TOP_CENTER);
		BorderPane.setAlignment(goBack, Pos.CENTER_LEFT);
		BorderPane.setAlignment(goForward, Pos.CENTER_RIGHT);

		Scene scene = new Scene(pane,1200,1000);
		primaryStage.setTitle("Final Project");
		primaryStage.setScene(scene);
		primaryStage.show();

		// Animation that makes photos auto-change
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), e -> {
			if (index == images.size()-1) {
				index = 0;
				ImageView imageView3 = new ImageView(images.get(index));
				imageView3.setX(10);
				imageView3.setY(10);
				imageView3.setFitWidth(575);
				imageView3.setPreserveRatio(true);
				pane.setCenter(imageView3);
			} else {
				index++;
				ImageView imageView3 = new ImageView(images.get(index));
				imageView3.setX(10);
				imageView3.setY(10);
				imageView3.setFitWidth(575);
				imageView3.setPreserveRatio(true);
				pane.setCenter(imageView3);
			}
		}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		
		// When you click button, you will pick a photo, it will add photo to end of rotation
		addPhoto.setOnAction(e -> {
			FileChooser fileChooser2 = new FileChooser();
			try {
				Image image = new Image(new FileInputStream(fileChooser2.showOpenDialog(primaryStage)));
				images.add(image);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		// Shows previous photo when button is clicked
		goBack.setOnAction(e -> {
			if (index == 0) {index = images.size();}
			index--;
			ImageView imageView2 = new ImageView(images.get(index));
			imageView2.setX(10);
			imageView2.setY(10);
			imageView2.setFitWidth(575);
			imageView2.setPreserveRatio(true);
			pane.setCenter(imageView2);

		});

		// Shows the photo that is coming up
		goForward.setOnAction(e -> {
			if (index == images.size()-1) {
				index = 0;
				ImageView imageView3 = new ImageView(images.get(index));
				imageView3.setX(10);
				imageView3.setY(10);
				imageView3.setFitWidth(575);
				imageView3.setPreserveRatio(true);
				pane.setCenter(imageView3);
			} else {
				index++;
				ImageView imageView3 = new ImageView(images.get(index));
				imageView3.setX(10);
				imageView3.setY(10);
				imageView3.setFitWidth(575);
				imageView3.setPreserveRatio(true);
				pane.setCenter(imageView3);
			}
		});
	}
	public static void main(String[] args) {
		launch(args);
	}
}