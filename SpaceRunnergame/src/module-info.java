module SpaceRunnergame {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.media;
	requires javafx.swing;
	
	opens application to javafx.graphics, javafx.fxml;
}
