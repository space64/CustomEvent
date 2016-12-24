package demo;

import java.awt.Color;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Huyen Pham
 *
 */

@SuppressWarnings("serial")
public class ChangeColorEvent extends ActionEvent {
	private Color fillColor;

	public ChangeColorEvent(Object source, int id, String command, Color c) {
		super(source, id, command);
		fillColor = c;
	}

	public Color getNewColor() {
		return fillColor;
	}

	public void setNewColor(Color fillColor) {
		this.fillColor = fillColor;
	}
}
