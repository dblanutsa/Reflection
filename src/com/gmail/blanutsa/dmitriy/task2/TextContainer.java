package com.gmail.blanutsa.dmitriy.task2;

import com.gmail.blanutsa.dmitriy.task2.SaveTo;
import com.gmail.blanutsa.dmitriy.task2.Saver;

import java.io.IOException;
import java.io.PrintWriter;

@SaveTo(path = "D:\\text.txt")
public class TextContainer {

    private String text = "Hello World!!!";

    private String path;

    public TextContainer(String text) {
        this.text = text;
    }

    public TextContainer() {
    }

    @Saver
    public void save(){
        try(PrintWriter pw = new PrintWriter(path)){
            pw.println(text);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
