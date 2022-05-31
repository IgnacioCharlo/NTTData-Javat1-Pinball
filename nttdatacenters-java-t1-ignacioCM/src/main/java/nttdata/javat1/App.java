package nttdata.javat1;

import java.util.Scanner;

import nttdata.javat1.game.Board;
import nttdata.javat1.game.Game;

public class App {
	public static void main(String[] args) {
		Scanner scanStr = new Scanner(System.in);
		Scanner scan = new Scanner(System.in);

		System.out.print("Por favor introduzca nombre: ");
		String name = scanStr.nextLine();
		System.out.print("Bienvenido " + name + ", Cuanto dinero quiere introducir? Cada bola cuesta 1: ");
		int money = scan.nextInt();
		System.out.print("Genial, empecemos!");

		Board board = new Board();
		Game game = new Game(board, money);

		game.launchAndStart();
		System.out.println("Adios " + name + ", espero verle por aqui pronto!");
	}
}
