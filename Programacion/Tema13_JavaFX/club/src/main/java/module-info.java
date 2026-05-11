module org.club {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;

	opens org.club to javafx.fxml;
	exports org.club;
}