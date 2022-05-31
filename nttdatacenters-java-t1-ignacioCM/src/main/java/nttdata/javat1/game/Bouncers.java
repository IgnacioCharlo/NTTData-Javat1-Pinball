package nttdata.javat1.game;

public class Bouncers {
	private int posX;
	private int posY;

	private boolean bounced;

	/**
	 * Contructor del bouncer con unas coordenadas y tamaño fijo de 2x5
	 * 
	 * @param posX
	 * @param posY
	 */
	public Bouncers(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.bounced = false;
	}

	/**
	 * Comprueba si la bola choca con el bouncer
	 * 
	 * @param ball
	 * @return
	 */
	public boolean bounce(Ball ball) {
		bounced = false;
		if (ball.getPosX() >= this.posX && ball.getPosX() <= (this.posX + 2) && ball.getPosY() >= this.posY && ball.getPosY() <= (this.posY + 5)) {
			bounced = true;
		}
		return bounced;
	}
	
	// Getters y Setters
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
