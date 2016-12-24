package demo;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

/**
 * 
 * @author Huyen
 *
 */

@SuppressWarnings("serial")
public class MainUI extends JFrame{
	Canvas canvas;
	Palette palette;
	Color fillColor;
	String title = "Custom Event - Huyen";
	
	public MainUI(){
		setTitle(title);
		setResizable(false);

		//Canvas
		canvas = new Canvas();
		canvas.setBackground(Color.WHITE);
		//Palette
		palette = new Palette();
		palette.setBackground(Color.LIGHT_GRAY);
		palette.addChangeColorListener(new ChangeColorListener() {
			
			@Override
			public void onChangeColor(ChangeColorEvent e) {
				canvas.setFillColor(e.getNewColor());
				MainUI.this.setTitle(title+" - New fill color is selected "+e.getNewColor().getRGB());
			}
		});
		//Layout & add components
		setLayout(new BorderLayout());
		getContentPane().add(canvas, BorderLayout.CENTER);
		getContentPane().add(palette, BorderLayout.WEST);
		
		pack();
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		MainUI f= new MainUI();
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);

	}
}
