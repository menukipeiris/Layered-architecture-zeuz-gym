package lk.ijse.gym.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.gym.dao.Custom.UserDao;
import lk.ijse.gym.dao.Custom.Impl.UserDaoImpl;
import lk.ijse.gym.entity.User;

import java.io.IOException;
import java.sql.SQLException;

public class SignUpFormController {

    @FXML
    private AnchorPane root1;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextArea txtName;

    @FXML
    private TextField txtPassword;

    private UserDao userDao=new UserDaoImpl();

    @FXML
    void btnRegisterOnAction(ActionEvent event) {
        try {
            boolean userCheck = txtEmail.getText().equals(userDao.getEmail(txtEmail.getText()));
            if (!userCheck) {

                User userDto = new User();
                userDto.setEmail(txtEmail.getText());
                userDto.setName(txtName.getText());
                userDto.setPassword(txtPassword.getText());

                boolean saved = userDao.save(userDto);
                if (saved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Registration successful").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Registration Unsuccessful").show();
                }
            } else {
                new Alert(Alert.AlertType.WARNING, "Already exist ").show();
            }
        } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
    }

    @FXML
    void hyperLoginHereOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/Login_form.fxml"));

        Scene scene = new Scene(rootNode);

        root1.getChildren().clear();
        Stage stage = (Stage) root1.getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle("Login Form");
    }

}

