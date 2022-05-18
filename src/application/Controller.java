package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {

	// * //
	Image buttonPressed = new Image("C:/Users/AHSAN/Desktop/Fiverr/2)" + "Fiverr Projects/3)Very 3 rd/1)"
			+ "Data by Buyer/" + "Picture Picker/src/application/START.jpg");

	@FXML
	public ImageView ImageTopLeft;

	@FXML
	public void onMousePress() {

		System.out.println("Top Left Corner");
	}

	public void tryAgain(ActionEvent e) {

		System.out.println("BYE");
	}

	public void isCorrectImage(ActionEvent e) {

		System.out.println("BYE1");
	}

}
