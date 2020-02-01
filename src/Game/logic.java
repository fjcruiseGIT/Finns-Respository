package Game;

import java.awt.Color;
import java.util.Random;

import Game.Window.Window;

public class logic {
	private Color[] mainCode = new Color[4];
	private Color[] smainCode = mainCode;
	private Color[] compCode = new Color[4];
	private int[] hint = { 0, 0, 0, 0 };
	private Window window;
	private boolean gewonnen;
	private Color[] Colors = { Color.white, Color.red, Color.orange, Color.green, Color.blue, Color.magenta };

	public logic(Color[] compColors, Color[] mainCode) {
//		mainCode[0] = Color.blue;
//		mainCode[1] = Color.green;
//		mainCode[2] = Color.blue;
//		mainCode[3] = Color.red;
		this.compCode = compColors;
		this.mainCode = mainCode;
		smainCode = mainCode;
//		compCode[0] = Color.green;
//		compCode[1] = Color.green;
//		compCode[2] = Color.red;
//		compCode[3] = Color.blue;
//		compCode = MasterMindPanel.getbColors();

	}

	public int ausfuehren() {
		colorout(mainCode);
		colorout(compCode);

		int i = 0;
		i = gewonnen(mainCode, compCode);
		if (i == 1) {
			i = 1;
		}
		if (i != 1) {
			compare(mainCode, compCode);
			i = 0;
		}
		hintout(hint);
		return i;
//		colorout(mainCode);
//		colorout(compCode);
//		hintout(hint);

	}

	private int gewonnen(Color[] mainCode2, Color[] compCode2) {
		// TODO Auto-generated method stub
		int gewonnen = 0;
		int intg = 0;
		for (int i = 0; i < 4; i++) {
			Color c1 = smainCode[i];
			Color c2 = compCode[i];
			if (c1 != null && c1 != null && c1.equals(c2)) {
				gewonnen++;
			}
		}
		if (gewonnen == 4) {
			this.gewonnen = true;
			intg = 1;
		}
		return intg;
	}

	public int[] returnHint() {
		// TODO Auto-generated method stub
		return hint;
	}

	private void compare(Color[] mainCode, Color[] compCode) {

		for (int i = 0; i < 4; i++) {
			if ((smainCode[i] != null) && (smainCode[i].equals(compCode[i]))) {
				hint[i] = 2;
				smainCode[i] = null;
				compCode[i] = null;
			}
		}

		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 4; j++) {
				if (smainCode[i] != null && smainCode[i].equals(compCode[j])) {
					hint[i] = 1;
					smainCode[i] = null;
					compCode[j] = null;
				} else {
					if (hint[i] == 0)
						hint[i] = 0;
				}
			}
		}
	}

	private void colorout(Color[] mainCode2) {
		for (int i = 0; i < mainCode2.length; i++) {
			System.out.print(mainCode2[i] + " | ");
		}
		System.out.println(" ");
	}

	private void hintout(int[] hint2) {
		shuffle(hint2);
		for (int i : hint2) {
			System.out.print(i + " | ");
		}
		System.out.println(" ");
	}

	private void shuffle(int[] array) {
		// TODO Auto-generated method stub
		Random rgen = new Random(); // Random number generator

		for (int i = 0; i < array.length; i++) {
			int randomPosition = rgen.nextInt(array.length);
			int temp = array[i];
			array[i] = array[randomPosition];
			array[randomPosition] = temp;
		}
	}

	public void random() {
		// TODO Auto-generated method stub
		mainCode[0] = Colors[(int) (Math.random() * 4)];
		mainCode[1] = Colors[(int) (Math.random() * 4)];
		mainCode[2] = Colors[(int) (Math.random() * 4)];
		mainCode[3] = Colors[(int) (Math.random() * 4)];
	}
}
