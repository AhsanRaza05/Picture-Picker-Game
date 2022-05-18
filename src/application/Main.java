package application;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

	// It is to ensure that out of four pictures no one repeat.
	static String animalName = "";

	static DAO dao = new DAO();
	String img;

	public static ArrayList<String> tableLists = new ArrayList(4);

	public static ArrayList<String> images = new ArrayList(4);

	// These set the stage and layout components of the game's four screens.
	public static Stage primaryStage;
	// This is the screen that shows four images that the user must choose from.
	private AnchorPane PicturePicker4Square;
	// This is the screen shown if the correct image is chosen.
	private AnchorPane PicturePickerFact;
	// This is the screen shown if the wrong image is chosen.
	private AnchorPane PicturePickerFailure;
	// The loader loads the FXML documents that dictate screen content and object
	// placement.
	FXMLLoader loader = new FXMLLoader();

	// This global variable corresponds to the button the user presses.
	static int check = 0;
	// This global variable corresponds to the button the user must press for a
	// correct answer.
	// Please configure the random choice code to set this as 1-4, depending on
	// which image is correct.
	static int correct = 0;

	@Override
	public void start(Stage stage) {
		try {
			// This sets the stage.

			primaryStage = stage;
			// This sets the title at the top of the window.
			Main.primaryStage.setTitle("Picture Picker");

			// This loads the title screen.
			Parent root = FXMLLoader.load(getClass().getResource("/application/PicturePickerMain.fxml"));

			Scene mainScene = new Scene(root);
			// And this displays it.
			primaryStage.setScene(mainScene);
			//primaryStage.setMaximized(true);
			//primaryStage.setFullScreen(true);


			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// This is the main game screen. Four images are displayed.
	// To make this work, you have to make the system display four random images
	// from the database instead of the placeholder ones I have included.
	public void init4Square(ActionEvent event) {

		try {
			// This loads the layout.

			tableLists = new ArrayList<String>(4);
			images = new ArrayList<String>(4);
			animalName = "";
			loader.setLocation(Main.class.getResource("/application/PicturePicker4Square.fxml"));
			PicturePicker4Square = (AnchorPane) loader.load();

			// This is the first image. You have to adjust this code so that it loads one of
			// the four randomly selected images as image1.
			// The image loaded is only a placeholder.
			// Image1 refers to the top left corner image.

			img = dao.getRandomImage(randomTableName());
			images.add(img);

			InputStream stream1 = new FileInputStream(img);

			Image image1 = new Image(stream1);

			// This is the wrapper for the first image, and must not be altered, as it sets
			// the layout of the screen.
			ImageView image1View = new ImageView();
			image1View.setImage(image1);
			// This sets the position of the image.
			image1View.setLayoutX(35);
			image1View.setLayoutY(35);
			image1View.setFitHeight(300);
			image1View.setFitWidth(300);
			image1View.setPickOnBounds(true);
			image1View.setPreserveRatio(true);

//			Button b1 = new Button();
//			b1.setLayoutX(35);
//			b1.setLayoutY(35);
//			b1.setPrefHeight(270);
//			b1.setPrefWidth(300);
//			b1.setGraphic(image1View);

//			b1.setOnAction(new EventHandler<ActionEvent>() {
//
//				@Override
//				public void handle(ActionEvent evt) {
//
//					System.out.println("Event Handle B1");
//				}
//
//			});

			// This is the second image. You have to adjust this code so that it loads one
			// of the four randomly selected images as image2.
			// The image loaded is only a placeholder.
			// Image2 refers to the top right corner image.

			img = dao.getRandomImage(randomTableName());
			images.add(img);
			InputStream stream2 = new FileInputStream(img);
			// "C:/Users/Ahsan/Desktop/JAVA/Java/Programs in
			// Eclipse/Fiverr3/images/Placeholders/2.jpg");
			Image image2 = new Image(stream2);

			// This is the wrapper for the first image, and must not be altered, as it sets
			// the layout of the screen.
			ImageView image2View = new ImageView();
			image2View.setImage(image2);
			// This sets the position of the image.
			image2View.setLayoutX(965);
			image2View.setLayoutY(35);
			image2View.setFitHeight(300);
			image2View.setFitWidth(300);
			image2View.setPickOnBounds(true);
			image2View.setPreserveRatio(true);

			// This is the third image. You have to adjust this code so that it loads one of
			// the four randomly selected images as image3.
			// The image loaded is only a placeholder.
			// Image3 refers to the bottom left corner image.

			// ImageView image3View = new ImageView();
			img = dao.getRandomImage(randomTableName());
			images.add(img);
			InputStream stream3 = new FileInputStream(img);
			// "C:/Users/Ahsan/Desktop/JAVA/Java/Programs in
			// Eclipse/Fiverr3/images/Placeholders/3.jpg");
			Image image3 = new Image(stream3);

			// This is the wrapper for the third image, and must not be altered, as it sets
			// the layout of the screen.
			ImageView image3View = new ImageView();
			image3View.setImage(image3);
			// This sets the position of the image.
			image3View.setLayoutX(35);
			image3View.setLayoutY(465);
			image3View.setFitHeight(300);
			image3View.setFitWidth(300);
			image3View.setPickOnBounds(true);
			image3View.setPreserveRatio(true);

			// This is the fourth image. You have to adjust this code so that it loads one
			// of the four randomly selected images as image4.
			// The image loaded is only a placeholder.
			// Image4 refers to the bottom right corner image.

			img = dao.getRandomImage(randomTableName());
			images.add(img);
			// img = dao.getRandomImage(img);

			InputStream stream4;

			// TODO Check either name is null or not.
			//if (img != null)
			stream4 = new FileInputStream(img);

			// "C:/Users/Ahsan/Desktop/JAVA/Java/Programs in
			// Eclipse/Fiverr3/images/Placeholders/4.jpg");
			Image image4 = new Image(stream4);

			// This is the wrapper for the fourth image, and must not be altered, as it sets
			// the layout of the screen.
			ImageView image4View = new ImageView();
			image4View.setImage(image4);
			// This sets the position of the image.
			image4View.setLayoutX(965);
			image4View.setLayoutY(465);
			image4View.setFitHeight(300);
			image4View.setFitWidth(300);
			image4View.setPickOnBounds(true);
			image4View.setPreserveRatio(true);

			System.out.println("Images: " + images);
			// System.out.println(tableLists);

			Label animalLabel = new Label();
			// Replace the text below with a variable string that shows the correct type of
			// animal to be chosen,
			// as decided by the random database access section.
			// animalLabel.setText("ANIMAL");
			animalName = AnimalName();
			// System.out.println("Animal Name: " + animalName);

			animalLabel.setText(animalName);
			animalLabel.setLayoutX(530);
			animalLabel.setLayoutY(335);
			animalLabel.setAlignment(Pos.CENTER_RIGHT);
			animalLabel.setFont(Font.font("Arial Black", 60));
			animalLabel.setTextFill(Color.color(0, 0.475, 0));
			animalLabel.setStyle("-fx-effect: dropshadow( one-pass-box , black , 1 , 10 , 3 , 3 )");

			// SquareRoot refers to the combination of the game screen and the four images
			// that show up.
			// Note that it has nothing to do with math.
			Group squareRoot = new Group(PicturePicker4Square, animalLabel, image1View, image2View, image3View,
					image4View);
			Scene square = new Scene(squareRoot);

			primaryStage.setScene(square);
			primaryStage.show();
			// System.out.println("All " + tableLists);
			// System.out.println(animalName);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// This is the success screen, to be displayed when the user selects the one
	// correct answer.
	public void displayFact() {
		try {
			loader.setLocation(Main.class.getResource("/application/PicturePickerFact.fxml"));
			PicturePickerFact = (AnchorPane) loader.load();

			TextArea factBox = new TextArea();
			// This is placeholder text. You need to have it load a random fact from the
			// database.
			// The fact must correspond to the correct animal choice.
			// If the system prompts the user to pick an image of a dog, this MUST give a
			// dog fact upon success.
			// Format these facts correctly. Ensure you split the lines.
			// Do not resize the box under any circumstances, but feel free to change the
			// font size.
			// System.out.println(animalName + " fact");
			String text = dao.getFact(animalName);
			factBox.setText(text);
			factBox.setEditable(false);
			factBox.setLayoutX(388);
			factBox.setLayoutY(297);
			factBox.setPrefHeight(230);
			factBox.setPrefWidth(521);
			factBox.setStyle("-fx-background-color: #3d2814;");
			// If you must change the font size, change the numerical value below this line.
			factBox.setFont(Font.font("Arial Black", 24));

			// This replaces the placeholder text with the text box, combining the core
			// layout with the displayed fact.
			Group factRoot = new Group(PicturePickerFact, factBox);
			Scene fact = new Scene(factRoot);
			primaryStage.setScene(fact);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// This function will display the failure page if the wrong answer is chosen.
	// Three of four selections should always result in this.
	public void displayFailure() {
		try {

			System.out.println("Failure");
			System.out.println(animalName + " m");
			loader.setLocation(Main.class.getResource("/application/PicturePickerFailure.fxml"));
			System.out.println("Failure");
			PicturePickerFailure = (AnchorPane) loader.load();

			// This is the failure screen. You have to replace this code so that it displays
			// the correct image, that the player should have chosen.
			// This will be whatever image is picked randomly by the system to lead to the
			// success screen.
			// The image loaded is only a placeholder.
			// img = ;
			// System.out.println(animalName + " m");
			InputStream stream5 = new FileInputStream(getSelectedImage());
			// "C:/Users/Ahsan/Desktop/JAVA/Java/Programs in
			// Eclipse/Fiverr3/images/Placeholders/5.jpg"); // This
			// link
			// must
			// instead
			// point to an already
			// loaded image - there is
			// to be no image five, or a
			// fifth input stream.
			Image image5 = new Image(stream5); // This is to be replaced.

			// This is the wrapper for the image, and must not be altered, as it sets the
			// layout of the screen.
			ImageView failureView = new ImageView();
			failureView.setImage(image5);
			// This sets the position of the image.
			failureView.setLayoutX(483);
			failureView.setLayoutY(245);
			failureView.setFitHeight(330);
			failureView.setFitWidth(347);
			failureView.setPickOnBounds(true);
			failureView.setPreserveRatio(true);

			// The group element combines the imageview and FXML elements, and parameters
			// must be in the correct order.
			// As in other instances, the purpose of this is to load an image from the
			// database
			Group failureRoot = new Group(PicturePickerFailure, failureView);
			Scene DisplayFailure = new Scene(failureRoot);

			primaryStage.setScene(DisplayFailure);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void intSet1() {
		// This function sets the global variable "check" to 1. This means button 1 has
		// been pressed.
		check = 1;
		// System.out.println(tableLists);
		// System.out.println(animalName);

		// Moving on to check the answer.
		answerCheck();
	}

	public void intSet2() {
		// This function sets the global variable "check" to 2. This means button 2 has
		// been pressed.
		check = 2;

		// Moving on to check the answer.
		answerCheck();
	}

	public void intSet3() {
		// This function sets the global variable "check" to 3. This means button 3 has
		// been pressed.
		check = 3;
		// Moving on to check the answer.
		answerCheck();
	}

	public void intSet4() {
		// This function sets the global variable "check" to 4. This means button 4 has
		// been pressed.
		check = 4;
		// Moving on to check the answer.
		answerCheck();
	}

	// This is where you code the function to check if the correct answer has been
	// selected.
	// You must include a way to save the number of the button pressed and compare
	// it against the correct number.
	public void answerCheck() {
		// This println is a debug line, please remove it upon program completion.
		// System.out.println("The user has pressed button " + check);

		// This checks to see if the user has chosen the correct image.
		// You need to add the code that will set the variable "correct" to whatever the
		// randomizer chooses as the right image.

		// correct = AnimalName;

		// System.out.println(tableLists);
		// System.out.println(animalName);
		correct = isCorrect(check);

		if (check == correct)
			displayFact();
		else
			displayFailure();
	}

	// Do not delete this.
	public static void main(String[] args) {
		launch(args);
	}

	String randomTableName() {

		// String tableName = dao.getFact(animalName);
		// System.out.println(tableLists);
		String tableName;
		int x;
		do {

			x = (int) Math.floor(Math.random() * 8);

			System.out.println(tableLists);

			System.out.println("HI + randomTableName");

			if (x == 0)
				tableName = "Alpaca";

			else if (x == 1)
				tableName = "Bird";

			else if (x == 2)
				tableName = "Cat";

			else if (x == 3)
				tableName = "Dog";

			else if (x == 4)
				tableName = "Elephant";

			else if (x == 5)
				tableName = "Fish";

			else if (x == 6)
				tableName = "Lizard";

			else
				tableName = "Monkey";

		} while (tableLists.contains(tableName));

		tableLists.add(tableName);
		return (tableName);

	}

	String AnimalName() {

		int x = (int) Math.floor(Math.random() * 4);
		String animalName = "";
		// System.out.println(tableLists);

		System.out.println("HI Animal Name");

		if (x == 0)
			animalName = tableLists.get(0);

		else if (x == 1)
			animalName = tableLists.get(1);

		else if (x == 2)
			animalName = tableLists.get(2);

		else
			animalName = tableLists.get(3);

		return (animalName);
	}

	int isCorrect(int buttonNo) {

		int correct = 0;

		// System.out.println("Button No: " + buttonNo);
		System.out.println(animalName + " isCorrect()");
		if (animalName.equalsIgnoreCase(tableLists.get(buttonNo - 1)))
			correct = buttonNo;

		else
			correct = 0;

		System.out.println("Correct Vlaue: " + correct);
		// System.out.println(tableLaests.get() + " is correct table Name");

		return (correct);
	}

	String getSelectedImage() {

		String image;
		System.out.println("Animal Name for Selected Image:" + animalName);
		System.out.println("Index of Selected Image: " + tableLists.indexOf(animalName));
		image = images.get(tableLists.indexOf(animalName));
		return image;

	}
}