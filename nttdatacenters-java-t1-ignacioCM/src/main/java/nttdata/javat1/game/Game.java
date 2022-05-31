package nttdata.javat1.game;

import java.util.Scanner;

public class Game {
	private int money;
	private int score;
	private Board board;
	private Ball ball;
	private boolean finished;

	/**
	 * Contructor del juego con el dinero (tiradas) y el tablero
	 * 
	 * @param board
	 * @param money
	 */
	public Game(Board board, int money) {
		this.money = money;
		this.score = 0;
		this.board = board;
		this.ball = new Ball();
		this.finished = false;
	}

	/**
	 * Metodo que simula el juego. Cada vez que la bola cae, se crea un nuevo tablero para tener un numero distinto de bouncers dispuestos de una manera distinta
	 */
	public void launchAndStart() {
		Scanner scan = new Scanner(System.in);
		while (money > 0) {
			restart();
			boolean up = true;
			System.out.println("\n\nLe quedan " + money + " bolas");
			while (!this.finished) {
				this.ball.setPosX((int) (Math.random() * (this.board.getWidth() + 1)));
				if (up) {
					this.ball.setPosY(this.ball.getPosY() + 1);
					if (this.ball.getPosY() >= this.board.getHeight()) {
						up = false;
					}
				} else {
					this.ball.setPosY(this.ball.getPosY() - 1);
					if (this.ball.getPosY() <= 0) {
						up = true;
					}
				}
				checkBounce();
				checkBottomBounce(scan);
			}
			setMoney(money - 1);
		}
		System.out.println("\nYa se ha terminado el juego... :(. Has conseguido un total de " + this.score + " puntos!");
	}

	/**
	 * Reseta el juego y crea un tablero nuevo
	 */
	public void restart() {
		this.board = new Board();
		this.ball.setPosX(0);
		this.ball.setPosY(0);
		this.finished = false;

	}

	/**
	 * Cuando la bola vuelve abajo, compruba si bota, si cae o si tenemos que pulsar algun flipper
	 * 
	 * @param scan
	 */
	public void checkBottomBounce(Scanner scan) {
		if (this.ball.getPosY() <= 0) {
			if (this.ball.getPosX() >= 200 && this.ball.getPosX() <= 300) {
				isHole();
			} else if (this.ball.getPosX() >= 50 && this.ball.getPosX() <= 450) {
				checkFlipper(scan);
			}
		}
	}

	/**
	 * Comprueba si queremos pulsar el flipper, si no lo activamos se cae por el agujero
	 * 
	 * @param scan
	 */
	public void checkFlipper(Scanner scan) {
		System.out.print("Quiere activar el Flipper? S[%] para activar, cualquier otra cosa no lo activa --> ");
		String flipper = scan.nextLine();
		if (flipper.toUpperCase().charAt(0) != 'S') {
			isHole();
		}
	}
	
	public void isHole() {
		System.out.println("---- La bola ha caido por el centro ----\nLleva " + this.score + " puntos");
		this.finished = true;
	}

	/**
	 * Comrpueba los rebotes con los bouncers y lleva el recuento de puntos
	 */
	public void checkBounce() {
		for (int i = 0; i < this.board.getBouncers().length; i++) {
			if (this.board.getBouncers()[i].bounce(this.ball)) {
				this.score += 50;
				System.out.println("     +50 puntos!");
			}
		}
	}
	
	// Getters y Setters
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

}
