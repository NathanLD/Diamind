package Filler;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import Main.Constantes;

public class ColorFiller extends JPanel{
	
	private List<Set> sets = new ArrayList<Set>();
	
	public ColorFiller(){
		/*
		//this.setLayout(new BoxLayout());
		 //On crée un conteneur avec gestion horizontale
	    Box b1 = Box.createHorizontalBox();
	    b1.add(new Set());
	    //Idem
	    Box b2 = Box.createHorizontalBox();
	    b2.add(new JButton("Bouton 2"));
	    b2.add(new JButton("Bouton 3"));
	    //Idem
	    Box b3 = Box.createHorizontalBox();
	    b3.add(new JButton("Bouton 4"));
	    b3.add(new JButton("Bouton 5"));
	    b3.add(new JButton("Bouton 6"));
	    //On crée un conteneur avec gestion verticale
	    Box b4 = Box.createVerticalBox();
	    b4.add(b1);
	    b4.add(b2);
	    b4.add(b3);

	    this.add(b4);
	    this.setVisible(true);*/
		
		
		this.setLayout(new GridLayout(Constantes.nb_sets, 1, 0, 5));
		for(int i=0;i<Constantes.nb_sets;i++){
			Set s = new Set();
			sets.add(s);
		    this.add(s);
		}
		
		/*Box b4 = Box.createVerticalBox();
		
		for(int i=0;i<Constantes.nb_sets;i++){
			Set s = new Set();
			sets.add(s);
		    b4.add(s);
		}
		
		this.add(b4);*/
	}

	

	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(400,400);
	}



	public List<Set> getSets() {
		// TODO Auto-generated method stub
		return this.sets;
	}
}
