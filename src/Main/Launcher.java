package Main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Choser.ColorCase;
import Choser.ColorChoser;
import Choser.ResetButton;
import Filler.AnswerSet;
import Filler.ColorFiller;
import Filler.Set;
import javafx.scene.layout.Border;

public class Launcher {
	
	private static List<ColorCase> cases = new ArrayList<ColorCase>();
	static AnswerSet as;
	static ColorFiller filler;
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		JFrame fenetre = new JFrame();
		fenetre.setTitle("Diamantaire");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
		fenetre.setVisible(true);
		fenetre.setLocation(new Point(400,25));
		fenetre.setLayout(new BorderLayout());
		//fenetre.setPreferredSize(new Dimension(600,400));
		fenetre.setResizable(false);

		JPanel pane = new JPanel();
		//pane.setBackground(Color.RED);
		pane.setVisible(true);
		fenetre.add(pane);

		JPanel right = new JPanel();
		right.setLayout(new BorderLayout());
		
		
		ColorChoser choser = new ColorChoser();
		fillCases();
		choser.init(cases);
		//choser.setBackground(Color.CYAN);
		choser.setVisible(true);
		
		right.add(choser, BorderLayout.CENTER);
		ResetButton reset = new ResetButton();
		right.add(reset, BorderLayout.SOUTH);
		
		pane.setLayout(new BorderLayout());
		pane.add(right, BorderLayout.EAST);
		
		//choser.repaint();
		
		JPanel left = new JPanel();
		left.setLayout(new BorderLayout());
		pane.add(left, BorderLayout.CENTER);
		
		
		filler = new ColorFiller();
		filler.setVisible(true);
		left.add(filler);
		
		as = new AnswerSet();
		left.add(as,BorderLayout.SOUTH);
		
		
		fenetre.pack();
	}

	private static void fillCases() {
		// TODO Auto-generated method stub
		ColorCase c1 = new ColorCase(Couleurs.ROUGE);
		ColorCase c2 = new ColorCase(Couleurs.JAUNE);
		ColorCase c3 = new ColorCase(Couleurs.VERT);
		ColorCase c4 = new ColorCase(Couleurs.CYAN);
		ColorCase c5 = new ColorCase(Couleurs.GRIS);
		ColorCase c6 = new ColorCase(Couleurs.VIOLET);
		ColorCase c7 = new ColorCase(Couleurs.MAGENTA);
		ColorCase c8 = new ColorCase(Couleurs.ORANGE);
		ColorCase c9 = new ColorCase(Couleurs.ROSE);
		
		cases.add(c1);
		cases.add(c2);
		cases.add(c3);
		cases.add(c4);
		cases.add(c5);
		cases.add(c6);
		cases.add(c7);
		cases.add(c8);
		cases.add(c9);
	}

	public static void calcul(){
		for(Set s : filler.getSets()){
			s.calcul(as);
		}
		as.calcul(filler);
		checkScores();
	}
	
	public static void clear() {
		// TODO Auto-generated method stub
		for(ColorCase cc : cases){
			cc.clear();
		}
	}

	public static void checkScores() {
		// TODO Auto-generated method stub
		for(int i=1;i<Constantes.nb_sets;i++){
			if(filler.getSets().get(i).getScore()<filler.getSets().get(i-1).getScore()){
				filler.getSets().get(i).setRight(false);
			}
			else{
				filler.getSets().get(i).setRight(true);
			}
		}
	}

	public static void reset() {
		// TODO Auto-generated method stub
		as.reset();
		calcul();
	}
}
