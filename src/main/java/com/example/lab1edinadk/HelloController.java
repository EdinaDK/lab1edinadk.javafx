// Лабораторная работа №1
// Едина Дарья, 007са1

package com.example.lab1edinadk;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {
//инициаплизация элементов
    @FXML
    Label welcomeText;
    @FXML
    Button ButFill;
    @FXML
    Button ButClear;
    @FXML
    TableView Table;
    @FXML
    private TableColumn<Table, String> NumberOfRaw;
    @FXML
    private TableColumn<Table, String> TextRaw;
    @FXML
    TextField TextFieldFileRead;
    private ObservableList<Table> tableText;

    @FXML
    // Инициализация модуля
    public void initialize()
    {
        NumberOfRaw.setCellValueFactory(new PropertyValueFactory<>("NumberRow"));
        TextRaw.setCellValueFactory(new PropertyValueFactory<>("Text"));
        tableText = FXCollections.observableArrayList(); //выделение памяти под список
    }

    @FXML
    private void FillTable(ActionEvent ae)
    {
        Table table;

        try(FileReader reader = new FileReader(TextFieldFileRead.getText())) //считывать файл с инпута
        {
            int numberRow = 1; //начать с единички
            BufferedReader bufReader = new BufferedReader(reader); //считывать строки
            String line = ""; //опустошение строчки
            tableText.clear();

            while (line != null) { //пока строка не пустая
                line = bufReader.readLine(); // считываем строчки
                table = new Table(Integer.toString(numberRow), line); //создаю строчку
                tableText.add(table); // добавляю строчку в табличку
                numberRow++; // продолжаю нумеровать))
            }

            Table.setItems(tableText); //вывод в таблицу
        }
        catch(IOException ex){
            System.out.println(ex.getMessage()); //тут понятно кэтчим эксепшны
        }
    }
}