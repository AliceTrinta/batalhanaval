package model;

import java.io.*;

class PartidaSalvarCarregar {

	static void saveTabuleiroToFile(Tabuleiro tabuleiro, BufferedWriter writer) throws IOException {
		char[][] matrix = tabuleiro.tabuleiro;
		for (char[] row : matrix) {
			for (char value : row) {
				writer.write(value + " ");
			}
			writer.newLine();
		}
		writer.newLine();
	}
	
	static void savePartidaToFile(Player player1, Player player2, String filePath) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(filePath));

			if (player1.getTurno()) {
				writer.write(1 + "\n");
			} else {
				writer.write(2 + "\n");
			}

			saveTabuleiroToFile(player1.getTabuleiro_proprio(), writer);
			saveTabuleiroToFile(player1.getTabuleiro_ataque(), writer);

			saveTabuleiroToFile(player2.getTabuleiro_proprio(), writer);
			saveTabuleiroToFile(player2.getTabuleiro_ataque(), writer);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	static Tabuleiro loadTabuleiroFromFile(BufferedReader reader) throws IOException {
		char[][] matrix = new char[15][15];
		int rowIdx = 0;
		String line;
		while ((line = reader.readLine()) != null) {
			if (rowIdx >= 15) {
				break;
			}
			String[] rowValues = line.trim().split(" ");
			for (int j = 0; j < 15; j++) {
				if (rowValues.length > j && !rowValues[j].isEmpty()) {
					matrix[rowIdx][j] = rowValues[j].charAt(0);
				} else {
					matrix[rowIdx][j] = '0';
				}
			}
			rowIdx++;
		}
		Tabuleiro tabuleiro = new Tabuleiro(matrix);
		return tabuleiro;
	}

	static Player[] loadPartidaFromFile(String filePath) {
		Player player1 = new Player();
		Player player2 = new Player();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filePath));

			// Read and set the turno
			String turnoStr = reader.readLine();
			if (turnoStr != null) {
				int turno = Integer.parseInt(turnoStr);
				if (turno == 1) {
					player1.setTurno(true);
					player2.setTurno(false);
				} else {
					player1.setTurno(false);
					player2.setTurno(true);
				}
			}

			// Read player1's tabuleiros
			Tabuleiro tabuleiro_proprio_p1 = loadTabuleiroFromFile(reader);
			Tabuleiro tabuleiro_ataque_p1 = loadTabuleiroFromFile(reader);
			player1.setTabuleiro_proprio(tabuleiro_proprio_p1);
			player1.setTabuleiro_ataque(tabuleiro_ataque_p1);

			// Read player2's tabuleiros
			Tabuleiro tabuleiro_proprio_p2 = loadTabuleiroFromFile(reader);
			Tabuleiro tabuleiro_ataque_p2 = loadTabuleiroFromFile(reader);
			player2.setTabuleiro_proprio(tabuleiro_proprio_p2);
			player2.setTabuleiro_ataque(tabuleiro_ataque_p2);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Player[] array_players = { player1, player2 };
		return array_players;
	}
}