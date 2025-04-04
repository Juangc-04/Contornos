package proyectos;

import java.util.Scanner;

public class Sokobanhecho {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		boolean[][] paredes = {
				{ false, false, false, false, true, true, true, true, true, false, false, false, false, false, false,
						false, false, false, false },
				{ false, false, false, false, true, false, false, false, true, false, false, false, false, false, false,
						false, false, false, false },
				{ false, false, false, false, true, false, false, false, true, false, false, false, false, false, false,
						false, false, false, false },
				{ false, false, true, true, true, false, false, false, true, true, false, false, false, false, false,
						false, false, false, false },
				{ false, false, true, false, false, false, false, false, false, true, false, false, false, false, false,
						false, false, false, false },
				{ true, true, true, false, true, false, true, true, false, true, false, false, false, true, true, true,
						true, true, true },
				{ true, false, false, false, true, false, true, true, false, true, true, true, true, true, false, false,
						false, false, true },
				{ true, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, true },
				{ true, true, true, true, true, false, true, true, true, false, true, false, true, true, false, false,
						false, false, true },
				{ false, false, false, false, true, false, false, false, false, false, true, true, true, true, true,
						true, true, true, true },
				{ false, false, false, false, true, true, true, true, true, true, true, false, false, false, false,
						false, false, false, false } };

		boolean[][] objetivo = {
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, true, true, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, true, true, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, true, true, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false } };

		boolean[][] cajas = {
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false },
				{ false, false, false, false, false, true, false, false, false, false, false, false, false, false,
						false, false, false, false, false },
				{ false, false, false, false, false, false, false, true, false, false, false, false, false, false,
						false, false, false, false, false },
				{ false, false, false, false, false, true, false, true, false, false, false, false, false, false, false,
						false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false },
				{ false, false, true, false, false, true, false, false, false, false, false, false, false, false, false,
						false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false } };

		int filaSokoban = 8;
		int columnaSokoban = 11;

		mostrarNivel(paredes, objetivo, cajas, filaSokoban, columnaSokoban);

		boolean jugando = true;
	
		while (jugando) {
			String movimiento = scanner.nextLine();
			
			if(hasGanado(cajas,objetivo))
				System.out.println("Victoria");
		
			

			if (sePuedeMover(paredes, cajas, filaSokoban, columnaSokoban, DIRECCION_ARRIBA)
					&& movimiento.equals(DIRECCION_ARRIBA)) {
				if (cajas[filaSokoban - 1][columnaSokoban]) {
					cajas[filaSokoban - 1][columnaSokoban] = false;
					cajas[filaSokoban - 2][columnaSokoban] = true;
				}

				filaSokoban--;
				mostrarNivel(paredes, objetivo, cajas, filaSokoban, columnaSokoban);

			} else if (sePuedeMover(paredes, cajas, filaSokoban, columnaSokoban, DIRECCION_ABAJO)
					&& movimiento.equals(DIRECCION_ABAJO)) {
				if (cajas[filaSokoban + 1][columnaSokoban]) {
					cajas[filaSokoban + 1][columnaSokoban] = false;
					cajas[filaSokoban + 2][columnaSokoban] = true;
				}

				filaSokoban++;
				mostrarNivel(paredes, objetivo, cajas, filaSokoban, columnaSokoban);
			} else if (sePuedeMover(paredes, cajas, filaSokoban, columnaSokoban, DIRECCION_DERECHA)
					&& movimiento.equals(DIRECCION_DERECHA)) {
				if (cajas[filaSokoban][columnaSokoban + 1]) {
					cajas[filaSokoban][columnaSokoban + 1] = false;
					cajas[filaSokoban][columnaSokoban + 2] = true;
				}
				columnaSokoban++;
				mostrarNivel(paredes, objetivo, cajas, filaSokoban, columnaSokoban);
			} else if (sePuedeMover(paredes, cajas, filaSokoban, columnaSokoban, DIRECCION_IZQUIERDA)
					&& movimiento.equals(DIRECCION_IZQUIERDA)) {
				if (cajas[filaSokoban][columnaSokoban - 1]) {
					cajas[filaSokoban][columnaSokoban - 1] = false;
					cajas[filaSokoban][columnaSokoban - 2] = true;
				}
				columnaSokoban--;
				mostrarNivel(paredes, objetivo, cajas, filaSokoban, columnaSokoban);
				
				
			} else
				mostrarNivel(paredes, objetivo, cajas, filaSokoban, columnaSokoban);

			if (movimiento.equals(FIN_JUEGO)) {
				jugando = false;
			}
		}
		System.out.println("Fin del juego");
	}

	public static void mostrarNivel(boolean paredes[][], boolean objetivo[][], boolean cajas[][], int filaSokoban,
			int columnaSokoban) {

		for (int i = 0; i < paredes.length; i++) {
			System.out.println();
			for (int j = 0; j < paredes[0].length; j++) {

				if (i == filaSokoban && j == columnaSokoban) {
					System.out.print("()");
				} else if (paredes[i][j]) {
					System.out.print('\u2588');
					System.out.print('\u2588');
				} else if (cajas[i][j]) {
					System.out.print("[]");
				} else if (objetivo[i][j]) {
					System.out.print("<>");
				} else
					System.out.print("  ");
			}

		}
	}

	public static final String DIRECCION_ARRIBA = "w";
	public static final String DIRECCION_DERECHA = "d";
	public static final String DIRECCION_ABAJO = "s";
	public static final String DIRECCION_IZQUIERDA = "a";
	public static final String FIN_JUEGO = "e";
	
	
	
	
	
	public static boolean hasGanado(boolean cajas[][],boolean objetivo[][]) {
		
		boolean hasGanado=true;
		for(int i=0;i<cajas.length;i++) 
			for(int j=0;j<cajas[0].length;j++) 
				
				if(cajas[i][j]&& !objetivo[i][j])
					hasGanado=false;
					
			
		return hasGanado;
	

	
		}
	
	
	
	
	public static boolean sePuedeMover(boolean paredes[][], boolean cajas[][], int filaSokoban, int columnaSokoban,
			String direccion) {

		boolean mover = true;

		if ((direccion == DIRECCION_ARRIBA) && (paredes[filaSokoban - 1][columnaSokoban] == true)
				|| (direccion == DIRECCION_ABAJO) && (paredes[filaSokoban + 1][columnaSokoban] == true)
				|| (direccion == DIRECCION_DERECHA) && (paredes[filaSokoban][columnaSokoban + 1] == true)
				|| (direccion == DIRECCION_IZQUIERDA) && (paredes[filaSokoban][columnaSokoban - 1] == true))
			mover = false;

		if ((direccion == DIRECCION_ARRIBA) && (cajas[filaSokoban - 1][columnaSokoban] == true)
				&& (paredes[filaSokoban - 2][columnaSokoban] == true)
				|| (direccion == DIRECCION_ABAJO) && (cajas[filaSokoban + 1][columnaSokoban] == true)
						&& (paredes[filaSokoban + 2][columnaSokoban] == true)
				|| (direccion == DIRECCION_DERECHA) && (cajas[filaSokoban][columnaSokoban + 1] == true)
						&& (paredes[filaSokoban][columnaSokoban + 2] == true)
				|| (direccion == DIRECCION_IZQUIERDA) && (cajas[filaSokoban][columnaSokoban - 1] == true)
						&& (paredes[filaSokoban][columnaSokoban - 2] == true))
			mover = false;

		if ((direccion == DIRECCION_ARRIBA) && (cajas[filaSokoban - 1][columnaSokoban] == true)
				&& (cajas[filaSokoban - 2][columnaSokoban] == true)
				|| (direccion == DIRECCION_ABAJO) && (cajas[filaSokoban + 1][columnaSokoban] == true)
						&& (cajas[filaSokoban + 2][columnaSokoban] == true)
				|| (direccion == DIRECCION_DERECHA) && (cajas[filaSokoban][columnaSokoban + 1] == true)
						&& (cajas[filaSokoban][columnaSokoban + 2] == true)
				|| (direccion == DIRECCION_IZQUIERDA) && (cajas[filaSokoban][columnaSokoban - 1] == true)
						&& (cajas[filaSokoban][columnaSokoban - 2] == true))
			mover = false;

		return mover;
	}

	public static boolean moverCaja(boolean paredes[][], boolean cajas[][], int filaSokoban, int columnaSokoban,
			String direccion) {

		boolean moverCaja = false;

		if ((direccion == DIRECCION_ARRIBA) && (cajas[filaSokoban - 1][columnaSokoban] == true)
				&& (paredes[filaSokoban - 2][columnaSokoban] == false)) {
			moverCaja = true;

		}
		if ((direccion == DIRECCION_ABAJO) && (cajas[filaSokoban + 1][columnaSokoban] == true)
				&& (paredes[filaSokoban + 2][columnaSokoban] == false)) {
			moverCaja = true;

		}
		if ((direccion == DIRECCION_DERECHA) && (cajas[filaSokoban][columnaSokoban + 1] == true)
				&& (paredes[filaSokoban][columnaSokoban + 2] == false)) {
			moverCaja = true;

		}
		if ((direccion == DIRECCION_IZQUIERDA) && (cajas[filaSokoban][columnaSokoban - 1] == true)
				&& (paredes[filaSokoban][columnaSokoban - 2] == false)) {
			moverCaja = true;

		}
		return moverCaja;
	}
}
