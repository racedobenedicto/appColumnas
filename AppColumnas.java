package columnas;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

class AppColumnas {
	protected int getColumns() throws Exception {
		//Nombre de columnes de la pantalla sencera
		int c = Toolkit.getDefaultToolkit().getScreenSize().width;
		System.out.println("Columnas pantalla: " + c);
		
		//Nombre de columnes del terminal de linux
		Process colsProcess = new ProcessBuilder("bash", "-c", "tput cols 2> /dev/tty").start();
		BufferedReader colsReader = new BufferedReader(new InputStreamReader(colsProcess.getInputStream(), Charset.forName("utf-8")));
		String cols = colsReader.readLine();
		return Integer.parseInt(cols);
	}
	
	public static void main(String[] args) {
		try {
			//Mostrem per pantalla l'amplada del terminal
			AppColumnas cols = new AppColumnas();
			int widthTerminal = cols.getColumns();
			System.out.println("Columnas Terminal: " + widthTerminal);
		} catch (Exception ex){
			ex.printStackTrace();
		}	
	}
}
