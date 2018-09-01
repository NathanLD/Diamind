package Filler;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Main.Couleurs;

public class AnswerSet extends JPanel {

	private List<FillerCase> cases = new ArrayList<FillerCase>();
	private int scoreTotal=0;
	private boolean used = false;
	private JLabel Jscore=new JLabel(String.valueOf(scoreTotal));

	public AnswerSet(){
		this.setBackground(new Color(150,150,150));
		this.setLayout(new GridLayout(1, 6, 3, 0));
		for(int i=0;i<5;i++){
			FillerCase fc = new FillerCase(Couleurs.ANSWER_NONE);
			cases.add(fc);
			this.add(fc);
		}
		this.add(Jscore);
	}
	
	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(400,50);
	}

	public FillerCase getCase(int i) {
		// TODO Auto-generated method stub
		return this.cases.get(i);
	}

	public void calcul(ColorFiller filler) {
		// TODO Auto-generated method stub
		int score=0;
		for(Set s : filler.getSets()){
			score+=s.getScore();
		}
		this.scoreTotal=score;
		Jscore.setText(String.valueOf(score));
		repaint();
	}

	public void unuse() {
		// TODO Auto-generated method stub
		for(FillerCase fc : cases){
			fc.setUsed(false);
		}
	}
	
	public void reset(){
		for(FillerCase fc : cases){
			fc.reset();
		}
	}
}
