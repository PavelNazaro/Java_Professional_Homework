package Lesson2;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.sql.SQLException;

public class PrimaryController {

    @FXML public MenuBar menuBar;

    @FXML public TextField loginField;
    @FXML public PasswordField passField;

    @FXML public Button btnAuth;
    @FXML public BorderPane authBorderPane;
    @FXML public BorderPane defaultBorderPane;
    @FXML public Label labelLogin;
    @FXML public Button btnStartReplaceLogin;
    @FXML public Button btnReplaceLogin;
    @FXML public TextField newLoginField;
    @FXML public Group groupReplaceLogin;
    @FXML public Label labelInfo;
    @FXML public VBox globalVBox;

    private String login;
    private String password;
    private boolean enable = false;
    private boolean authSuccess = false;
    private String authStatus;

    public boolean isAuthSuccess() {
        return authSuccess;
    }

    public void setAuthSuccessTrue() {
        this.authSuccess = true;
    }

    public void setFalseEnable() {
        this.enable = false;
    }

    public void setAuthStatus(String s) {
        this.authStatus = s;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnable() {
        return enable;
    }

    @FXML private void handleAboutAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Create by PavelNazaro");
        alert.setHeaderText("About");
        alert.show();
    }

    @FXML private void handleExitAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML public void signIn(ActionEvent event) throws InterruptedException {
        login = loginField.getText();
        password = passField.getText();
        if (!login.equals("") && !password.equals("")){
            loginField.clear();
            passField.clear();
            enable = true;

            while (enable) {
                Thread.sleep(100);
            }

            if (authStatus.equals("Password correct")){
                authBorderPane.setVisible(false);
                globalVBox.setMinWidth(400);
                defaultBorderPane.setVisible(true);
                labelLogin.setText("You login: " + login);
            }
            else if (authStatus.equals("Password incorrect")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Неверный пароль!");
                alert.setHeaderText("Неверный пароль!");
                alert.showAndWait();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Логин не найден!");
                alert.setHeaderText("Логин не найден!");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Пустое поле!");
            alert.setHeaderText("Заполните оба поля!");
            alert.showAndWait();
        }
    }

    @FXML public void startReplaceLogin(ActionEvent event) {
        btnStartReplaceLogin.setVisible(false);
        groupReplaceLogin.setVisible(true);
    }

    @FXML public void replaceLogin(ActionEvent event) throws SQLException {
        String newLogin = newLoginField.getText();
        if (!newLogin.equals("")){
            Main.replaceLogin(login, newLogin);
            labelInfo.setText("Replace login successful!");
            labelLogin.setText("You new login: " + newLogin + ". Restart application!");
            groupReplaceLogin.setVisible(false);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Пустое поле!");
            alert.setHeaderText("Заполните поле!");
            alert.showAndWait();
        }
    }
}