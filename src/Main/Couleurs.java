package Main;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public enum Couleurs {
	CYAN ("cyan.png"),
	VIOLET ("violet.png"),
	GRIS ("gris.png"),
	MAGENTA ("magenta.png"),
	ROSE("rose.png"),
	ROUGE("rouge.png"),
	ORANGE("orange.png"),
	JAUNE("jaune.png"),
	VERT("vert.png"),
	NONE("none.png"),
	ANSWER_NONE("none.png");

	private Image image;
	
	public Image getImage(){
		return this.image;
	}

	//Constructeur
	Couleurs(String image){
		try {
			//this.image=ImageIO.read(new File(image));
			this.image=ImageIO.read(Utils.getResourceAsStream(image));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
