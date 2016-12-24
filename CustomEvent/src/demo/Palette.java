package demo;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * 
 * @author Huyen
 *
 */

@SuppressWarnings("serial")
public class Palette extends JPanel {
	private int size = 30;
	private int padding = 15;
	private Color fillColor = Color.RED;

	// Store all listeners
	private List<ChangeColorListener> listeners = new ArrayList<ChangeColorListener>();

	public Palette() {
		setPreferredSize(new Dimension(100, 300));
		setFocusable(true);
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.println("X:" + e.getX() + " - Y" + e.getY());
				// Fire event
				Rectangle rctB = new Rectangle(padding, padding, size, size);
				Rectangle rctR = new Rectangle(padding + size, padding, size, size);
				Rectangle rctY = new Rectangle(padding + size, padding + size, size, size);
				Rectangle rctG = new Rectangle(padding, padding + size, size, size);
				
				//Check whether users clicked on any of the 4 rectangulars
				if (rctB.contains(e.getPoint())) {
					fillColor = Color.BLUE;
					fireChangeColorEvent(fillColor);
				} else if (rctR.contains(e.getPoint())) {
					fillColor = Color.RED;
					fireChangeColorEvent(fillColor);
				} else if (rctY.contains(e.getPoint())) {
					fillColor = Color.YELLOW;
					fireChangeColorEvent(fillColor);
				} else if (rctG.contains(e.getPoint())) {
					fillColor = Color.GREEN;
					fireChangeColorEvent(fillColor);
				}
				repaint();
			}
		});
	}

	/**
	 * Add listerner
	 * 
	 * @param toAdd
	 */
	public void addChangeColorListener(ChangeColorListener toAdd) {
		listeners.add(toAdd);
	}

	/**
	 * When event occur, notify all listeners
	 * 
	 * @param newColor : new color
	 */
	public void fireChangeColorEvent(Color newColor) {
		// System.out.println("Fire Event");
		for (ChangeColorListener colorListener : listeners) {
			int id = ThreadLocalRandom.current().nextInt();
			ChangeColorEvent colorEvent = new ChangeColorEvent(this, id, "Color changed", newColor);
			colorListener.onChangeColor(colorEvent);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Color palette
		g.setColor(Color.BLUE);
		g.fillRect(padding, padding, size, size);
		g.setColor(Color.RED);
		g.fillRect(padding + size, padding, size, size);
		g.setColor(Color.YELLOW);
		g.fillRect(padding + size, padding + size, size, size);
		g.setColor(Color.GREEN);
		g.fillRect(padding, padding + size, size, size);

		// Selected color
		g.setColor(fillColor);
		g.fillRect(padding, padding + 80, 60, size);

		// Draw black outline
		g.setColor(Color.BLACK);
		g.drawRect(padding, padding, size, size);
		g.drawRect(padding + size, padding, size, size);
		g.drawRect(padding + size, padding + size, size, size);
		g.drawRect(padding, padding + size, size, size);
		g.drawRect(padding, padding + 80, 60, size);

	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
		repaint();
	}
}
