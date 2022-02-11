package main;



import model.*;
import utils.JDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.timeConverter;

import java.io.*;
import java.sql.*;
import java.util.*;


public class main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/view/LoginPanel.fxml"));
        primaryStage.setTitle("First View");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public static void main(String[] args) throws SQLException, IOException {

        JDBC.openConnection();
        Appointments.setAllAppointments();
        Customers.setAllCustomers();
        Divisions.setAllDivisions();
        Countries.setAllCountries();
        Users.setAllUsers();
        Contacts.setAllContacts();


        int test = timeConverter.setEndHours();
        System.out.println(test);




        launch(args);
        JDBC.closeConnection();


    }
}
