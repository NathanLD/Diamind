package Filler;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import Choser.ColorController;
import Main.Constantes;
import Main.Couleurs;
import Main.Launcher;

public class FillerCase extends JPanel{
	private FillerController controller;
	private Couleurs c;
	private boolean used;	// Variable de test pour compter les points

	public FillerCase(Couleurs none){
		this.c=none;
		this.repaint();

		this.controller=new FillerController(this);
		this.addMouseListener(controller);
		this.addKeyListener(controller);
		this.setFocusable(true);
	}

	public void processClic(MouseEvent e) {
		// TODO Auto-generated method stub
		if(Constantes.chosenColor!=null){
			this.c = Constantes.chosenColor.getColor();
			repaint();	
		}
		System.out.println("Clic case");
		Launcher.calcul();
		//Launcher.checkScores();
	}

	public void paint(Graphics g){
		//g.setColor(c);
		g.drawImage(c.getImage(), (int) (g.getClipBounds().getCenterX()-0.5*Constantes.longueur_case), (int) (g.getClipBounds().getCenterY()-0.5*Constantes.hauteur_case), null);
		//g.fillRect(0, 0, g.getClipBounds().width, g.getClipBounds().height);
		//g.fillRect((int) (g.getClipBounds().getCenterX()-0.5*Constantes.longueur_case), (int) (g.getClipBounds().getCenterY()-0.5*Constantes.hauteur_case), Constantes.longueur_case+1, Constantes.hauteur_case+1);
		//g.fillRect(0, 0, Constantes.longueur_case, Constantes.hauteur_case);
	}

	public Couleurs getColor() {
		// TODO Auto-generated method stub
		return this.c;
	}
	
	public boolean getUsed(){
		return this.used;
	}
	
	public void setUsed(boolean b){
		this.used=b;
	}

	public void reset() {
		// TODO Auto-generated method stub
		this.c=Couleurs.ANSWER_NONE;
		//super.getRootPane().updateUI();
		repaint();
	}

	/*@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(50,50);
	}*/
}
