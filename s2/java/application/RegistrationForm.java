import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
 
public class RegistrationForm extends Application {
 
    Stage primaryStage;
    Scene registrationScene, confirmationScene;
    Label welcomeLabel;
    TextArea confirmationDetails;
 
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Registration Form");
 
        // Registration Form
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        Label phoneLabel = new Label("Phone No:");
        TextField phoneField = new TextField();
 
        Label genderLabel = new Label("Gender:");
        RadioButton maleRadioButton = new RadioButton("Male");
        RadioButton femaleRadioButton = new RadioButton("Female");
        ToggleGroup genderToggleGroup = new ToggleGroup();
        maleRadioButton.setToggleGroup(genderToggleGroup);
        femaleRadioButton.setToggleGroup(genderToggleGroup);
        HBox genderBox = new HBox(maleRadioButton, femaleRadioButton);
        genderBox.setSpacing(10);
 
        Label courseLabel = new Label("Course:");
        ComboBox<String> courseComboBox = new ComboBox<>();
        courseComboBox.getItems().addAll("B.Tech", "M.Tech", "MBA");
 
        Label electivesLabel = new Label("Electives:");
        CheckBox mathCheckBox = new CheckBox("Math");
        CheckBox physicsCheckBox = new CheckBox("Physics");
        CheckBox chemistryCheckBox = new CheckBox("Chemistry");
        VBox electivesBox = new VBox(mathCheckBox, physicsCheckBox, chemistryCheckBox);
        electivesBox.setSpacing(5);
 
 
        Button cancelButton = new Button("Cancel");
        Button submitButton = new Button("Submit");
 
        HBox buttonBox = new HBox(cancelButton, submitButton);
        buttonBox.setSpacing(10);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
 
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(emailLabel, 0, 1);
        grid.add(emailField, 1, 1);
        grid.add(phoneLabel, 0, 2);
        grid.add(phoneField, 1, 2);
        grid.add(genderLabel, 0, 3);
        grid.add(genderBox, 1, 3);
        grid.add(courseLabel, 0, 4);
        grid.add(courseComboBox, 1, 4);
        grid.add(electivesLabel, 0, 5);
        grid.add(electivesBox, 1, 5);
        grid.add(buttonBox, 1, 6);
 
        registrationScene = new Scene(grid, 400, 350);
 
 
        // Confirmation Page
        welcomeLabel = new Label("Welcome!");
        welcomeLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        confirmationDetails = new TextArea();
        confirmationDetails.setEditable(false);
        VBox confirmationLayout = new VBox(welcomeLabel, confirmationDetails);
        confirmationLayout.setPadding(new Insets(20));
        confirmationLayout.setSpacing(10);
        confirmationScene = new Scene(confirmationLayout, 400, 300);
 
 
        // Button Actions
        submitButton.setOnAction(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String gender = maleRadioButton.isSelected() ? "Male" : "Female";
            String course = courseComboBox.getValue();
            StringBuilder electives = new StringBuilder();
            if (mathCheckBox.isSelected()) electives.append("Math, ");
            if (physicsCheckBox.isSelected()) electives.append("Physics, ");
            if (chemistryCheckBox.isSelected()) electives.append("Chemistry, ");
            if (electives.length() > 0) electives.delete(electives.length() - 2, electives.length());
 
            String details = String.format("Name: %s\nEmail: %s\nPhone: %s\nGender: %s\nCourse: %s\nElectives: %s",
                    name, email, phone, gender, course, electives.toString());
 
            confirmationDetails.setText(details);
            primaryStage.setScene(confirmationScene);
        });
 
        cancelButton.setOnAction(e -> primaryStage.close());
 
        primaryStage.setScene(registrationScene);
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}