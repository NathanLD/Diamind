package Filler;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Main.Constantes;
import Main.Couleurs;

public class Set extends JPanel{
	
	private List<FillerCase> cases = new ArrayList<FillerCase>();
	private int score=0;
	private JLabel Jscore = new JLabel(String.valueOf(score));

	public Set(){
		this.setBackground(new Color(200,200,200));
		this.setLayout(new GridLayout(1, 6, 3, 0));
		for(int i=0;i<5;i++){
			FillerCase fc = new FillerCase(Couleurs.NONE);
			cases.add(fc);
			this.add(fc);
		}
		this.add(Jscore);
		
		this.setPreferredSize(new Dimension(Constantes.longueur_case*7+Jscore.getWidth(),Constantes.hauteur_case*2));
	}

	public void calcul(AnswerSet as) {
		// TODO Auto-generated method stub
		int points = 0;
		
		for(int i=0;i<5;i++){				// Premier tour pour trouver les bonnes places et les éliminer du compte
			FillerCase fc = as.getCase(i);
			if(isEqual(fc,i)){
				points+=3;
				this.cases.get(i).setUsed(true);
				fc.setUsed(true);
			}
		}
		
		for(int i=0;i<5;i++){				// 2e tour pour trouver les mauvaises places. Attention à pas compter 2 fois une case pour une couleur
			FillerCase fc = as.getCase(i);
			points+=isIn(fc,i);
		}
		
		score=points;
		Jscore.setText(String.valueOf(score));
		//System.out.println(points);
		repaint();
		
		for(FillerCase fc : cases){
			fc.setUsed(false);
		}
		as.unuse();	// Remettre les cases du AS à usef(false)
		
	}

	private int isIn(FillerCase fc, int i) {
		int score=0;
		for(int j=0;j<5;j++){
			if(fc.getUsed() == false && this.cases.get(j).getUsed()==false && fc.getColor()==this.cases.get(j).getColor() && fc.getColor()!=this.cases.get(i).getColor()){
				score++;
				fc.setUsed(true);
				this.cases.get(j).setUsed(true);
			}
		}
		return score;
	}

	private boolean isEqual(FillerCase fc, int i) {
		return(fc.getColor()==this.cases.get(i).getColor());
	}

	public int getScore() {
		// TODO Auto-generated method stub
		return this.score;
	}

	public void setRight(boolean b) {
		// TODO Auto-generated method stub
		if(b){
			this.Jscore.setForeground(Color.BLACK);
		}
		else{
			this.Jscore.setForeground(Color.RED);
		}
	}

	/*private boolean isIn(FillerCase fc, int i) {
		boolean test = false;
		for(int j=0;j<5;j++){
			if(fc.getColor()==this.cases.get(j).getColor() && fc.getColor()!=this.cases.get(i).getColor())	test=true;
		}
		System.out.println(test);
		
		
		int nb_same = 0;
		if(fc.getColor()!=this.cases.get(i).getColor()){
			for(int j=0;j<5;j++){
				if(fc.getColor()==this.cases.get(j).getColor())	nb_same++;
			}
		}
		return test;
	}

	private boolean isEqual(FillerCase fc, int i) {
		//System.out.println(fc.getColor()==this.cases.get(i).getColor());
		return(fc.getColor()==this.cases.get(i).getColor());
	}*/
	
	/*public void paint(Graphics g)
	{
		super.getRootPane().updateUI();
		super.paint(g);
	}*/

	/*public void paint(Graphics g){
		g.setColor(Color.ORANGE);
		g.fillRect((int) (Math.random()*100), (int) (Math.random()*100), 100, 10);
	}*/

	/*@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(100,50);
	}*/
}
