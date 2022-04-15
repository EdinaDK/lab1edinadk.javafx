// Лабораторная работа №1
// Едина Дарья, 007са1

package com.example.lab1edinadk;

import javafx.beans.property.SimpleStringProperty;

public class Table {
    SimpleStringProperty NumberRow; //номер строки
    SimpleStringProperty Text; //столбец строчки

    public Table (String InputNumberRow, String InputText)
    {
        NumberRow = new SimpleStringProperty(InputNumberRow); //строковые свойства
        Text = new SimpleStringProperty(InputText);
    }
    public String getNumberRow() {return NumberRow.get();} //геттер (возвращает значения)
    public void setNumberRow(String InputNumberRow)
    {
        NumberRow.set(InputNumberRow);//сеттер (устанавливает значения)
    }

    public String getText() {return Text.get();}//геттер (возвращает значения)
    public void setText(String InputText)
    {
        Text.set(InputText);//сеттер (устанавливает значения)
    }
}
