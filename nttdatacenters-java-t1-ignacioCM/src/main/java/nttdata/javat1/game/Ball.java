package nttdata.javat1.game;

public class Ball {
	private int posX;
	private int posY;
	
	/**
	 * Constructor de la clase Ball que empieza en centro de la parte inferior
	 */
	public Ball() {
		super();
		this.posX = 0;
		this.posY = 250;
	}

	//Getters y Setters
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	
}
