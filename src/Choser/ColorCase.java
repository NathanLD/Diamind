package Choser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JPanel;

import Main.Constantes;
import Main.Couleurs;
import Main.Launcher;

public class ColorCase extends JPanel{
	private ColorController controller;
	private boolean chosen;
	private Couleurs c;

	public ColorCase(Couleurs c){
		this.c=c;
		//this.setBackground(c);
		this.repaint();
		
		this.controller=new ColorController(this);
		this.addMouseListener(controller);
		this.addKeyListener(controller);
		this.setFocusable(true);
	}
	
	public void processClic(MouseEvent e) {
		// TODO Auto-generated method stub
		Launcher.clear();
		this.chosen=true;
		Constantes.chosenColor=this;
		repaint();
		System.out.println("Clic couleur");
	}
	
	public void clear(){
		this.chosen=false;
		repaint();
	}
	
	public void paint(Graphics g){
		//g.setColor(c);
		//g.fillRect(0, 0, g.getClipBounds().width, g.getClipBounds().height);
		g.drawImage(c.getImage(), (int) (g.getClipBounds().getCenterX()-0.5*Constantes.longueur_case), (int) (g.getClipBounds().getCenterY()-0.5*Constantes.hauteur_case), null);
		//g.fillRect((int) (g.getClipBounds().getCenterX()-0.5*Constantes.longueur_case), (int) (g.getClipBounds().getCenterY()-0.5*Constantes.hauteur_case), Constantes.longueur_case+1, Constantes.hauteur_case+1);
		if(chosen){
			g.setColor(Color.BLACK);
			g.drawRect((int) (g.getClipBounds().getCenterX()-0.5*Constantes.longueur_case), (int) (g.getClipBounds().getCenterY()-0.5*Constantes.hauteur_case), Constantes.longueur_case, Constantes.hauteur_case);
		}
	}

	public Couleurs getColor() {
		// TODO Auto-generated method stub
		return this.c;
	}
	
	/*@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(50,50);
	}*/
}
