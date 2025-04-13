import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Insets; 
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
 
public class LoginForm extends Application {
 
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login Form");
 
        // Create GridPane layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER); 
        grid.setHgap(10);                                              
        grid.setVgap(10);                                               
        grid.setPadding(new Insets(25, 25, 25, 25));  
 
        // Create labels and text fields
        Label userNameLabel = new Label("User Name:");
        TextField userNameTextField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
 
        // Add labels and text fields to the grid
        grid.add(userNameLabel, 0, 0);
        grid.add(userNameTextField, 1, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1, 1);
 
 
        // Create buttons
        Button loginButton = new Button("Login");
        Button cancelButton = new Button("Cancel");
 
 
        loginButton.setOnAction(e -> {
            String username = userNameTextField.getText();
            String password = passwordField.getText();
 
            if (username.equals("test") && password.equals("password")) {  
                System.out.println("Login Successful!");
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Login Successful!");
                alert.showAndWait();
            } else {
                System.out.println("Login Failed!");
                Alert alert = new Alert(Alert.AlertType.ERROR, "Login Failed. Incorrect username or password.");
                alert.showAndWait();
            }
        });
 
        cancelButton.setOnAction(e -> {
            System.out.println("Login Cancelled.");
            primaryStage.close(); // Close the login window
        });
 
 
        // Create HBox for buttons
        HBox buttonBox = new HBox(10); 
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        buttonBox.getChildren().addAll(cancelButton, loginButton);
 
        grid.add(buttonBox, 1, 2);  // Add buttons to the grid
 
        // Create Scene and set it to the stage
        Scene scene = new Scene(grid, 300, 200); // Adjust size as needed
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch();
    }
}