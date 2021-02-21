import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

class appColumnas {
	public static void main(String[] args) {
		int c = Toolkit.getDefaultToolkit().getScreenSize().width;
		System.out.println("Columnas pantalla: " + c);
		try {
			Process colsProcess = new ProcessBuilder("bash", "-c", "tput cols 2> /dev/tty").start();
			BufferedReader colsReader = new BufferedReader(new InputStreamReader(colsProcess.getInputStream(), Charset.forName("utf-8")));
			String cols = colsReader.readLine();
			int width = Integer.parseInt(cols);
			System.out.println("Columnas Terminal: " + width);
		} catch (Exception ex){
			System.out.println(ex);
		}
	}
}
