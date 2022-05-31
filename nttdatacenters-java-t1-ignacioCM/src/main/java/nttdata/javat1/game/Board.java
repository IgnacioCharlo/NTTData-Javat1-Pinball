package nttdata.javat1.game;

public class Board {
	private int width;
	private int height;
	private int bouncersNumber;
	private Bouncers[] bouncers;

	/**
	 * Constructor de un tablero del mismo tamaño siempre con un numero aleatorio entre 10 y 40 bouncers
	 * repartidos aleatoriamente dentro del tablero
	 */
	public Board() {
		this.width = 500;
		this.height = 500;

		int min = 10, max = 40;
		bouncersNumber = (int) Math.floor(Math.random() * (max - min + 1) + min);
		bouncers = new Bouncers[bouncersNumber];

		// Ponermos los Bouncers en el tablero (pueden estar solapados)
		for (int i = 0; i < bouncers.length; i++) {
			int minB = 10, maxB = 480;
			int posX = (int) Math.floor(Math.random() * (maxB - minB + 1) + minB);
			int posY = (int) Math.floor(Math.random() * (maxB - minB + 1) + minB);
			bouncers[i] = new Bouncers(posX, posY);
		}

	}

	// Getters y Setters
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getBouncersNumber() {
		return bouncersNumber;
	}

	public void setBouncersNumber(int bouncersNumber) {
		this.bouncersNumber = bouncersNumber;
	}

	public Bouncers[] getBouncers() {
		return bouncers;
	}

	public void setBouncers(Bouncers[] bouncers) {
		this.bouncers = bouncers;
	}


}
