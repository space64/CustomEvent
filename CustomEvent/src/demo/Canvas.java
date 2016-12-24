package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 * 
 * @author Huyen Pham
 *
 */

@SuppressWarnings("serial")
public class Canvas extends JPanel {
	private int row = 10;
	private int col = 10;
	private int size = 40;
	private Color fillColor = Color.RED;
	private int fillR = -1;
	private int fillC = -1;
	
	public Canvas(){
		setPreferredSize(new Dimension(col*size, row*size));
		setFocusable(true);
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				fillR = e.getY()/size;
				fillC = e.getX()/size;
				repaint();
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		//Fill clicked Square
		g.setColor(fillColor);
		g.fillRect(fillC*size, fillR*size, size, size);
		
		//Draw grid
		g.setColor(Color.BLACK);
		for (int i = 0; i < row; i++) {
			g.drawLine(0, i*size, col*size, i*size);			
		}
		for (int i = 0; i < col; i++) {
			g.drawLine(i*size, 0, i*size, col*size);			
		}
		
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}
}
