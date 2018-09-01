package Choser;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;

import Main.Constantes;

public class ColorChoser extends JPanel {

	public ColorChoser(){
		this.setLayout(new GridLayout(9, 1, 5, 5));
	}
	
	public void init(List<ColorCase> cases){
		for(ColorCase c : cases){
			 this.add(c);
		}
		//repaint();
	}

	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(2*Constantes.longueur_case,400);
	}
	
	public void paint(Graphics g)
	{
		super.getRootPane().updateUI();
		super.paint(g);
	}
	
}
