package Lesson2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {

    private static Connection conn;
    private static Statement stmt;
    private static PrimaryController controller = new PrimaryController();

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                startDBAuth();
            } catch (InterruptedException | SQLException e) {
                e.printStackTrace();
            }
        }).start();

        launch();
    }

    private static void startDBAuth() throws InterruptedException, SQLException {
        while (!controller.isAuthSuccess()){
            while (!controller.isEnable()) {
                Thread.sleep(100);
            }

            String login = controller.getLogin();
            String pass = controller.getPassword();

            try {
                connection();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            ResultSet rs = stmt.executeQuery("SELECT password FROM auth WHERE login='"+login+"';");

            if (rs.next()){
                String passDB = rs.getString(1);
                if (pass.equals(passDB)){
                    System.out.println("Пароль верный");
                    controller.setAuthStatus("Password correct");
                    controller.setAuthSuccessTrue();
                }
                else{
                    System.out.println("Пароль НЕ верный");
                    controller.setAuthStatus("Password incorrect");
                }
            }
            else {
                System.out.println("Такого пользователя не существует!");
                controller.setAuthStatus("Login not found");
            }

            controller.setFalseEnable();

            disconnect();
        }
    }

    public static void replaceLogin(String login, String newLogin) throws SQLException {
        try {
            connection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        stmt.executeUpdate("UPDATE auth SET login = '" + newLogin + "' WHERE login = '" + login + "';");

        disconnect();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Вход");

        FXMLLoader loader = new FXMLLoader(Main.class.getClassLoader().getResource("Lesson2/scene.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
//        stage.setResizable(false);

        controller = loader.getController();
        controller.globalVBox.setMinWidth(300);
//        stage.setOnHidden(e -> controller.shutdown());
        stage.show();
    }

    private static void connection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:src/Lesson2/mainDB.db");
        stmt = conn.createStatement();
    }

    private static void disconnect() throws SQLException {
        conn.close();
    }
}
