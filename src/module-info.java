module MariaLobatoGenteJovem {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
	opens telas to javafx.graphics, javafx.fxml;
}
