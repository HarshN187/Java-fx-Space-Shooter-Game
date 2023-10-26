package model;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class infoLabel extends Label {

public final static String FONT_PATH = "/resources/kenvector_future.ttf";
	
public infoLabel(String text) {
		setPrefWidth(380);
		setPrefHeight(49);
		setText(text);
		setWrapText(true);
		setLabelFont();
		setAlignment(Pos.CENTER);
	}

private void setLabelFont() {
	setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 23));
	}
	
}
