import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
    try {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Poggi\\Documents\\JAVA\\tpprueba\\partidos.txt"));
        BufferedReader reader2 = new BufferedReader(new FileReader("C:\\Users\\Poggi\\Documents\\JAVA\\tpprueba\\pronosticos.txt"));
        String line = reader.readLine();
        String line2 = reader2.readLine();
        int puntaje = 0;
        while (((line = reader.readLine()) != null) && ((line2 = reader2.readLine()) != null)) {
            String[] parts = line.split(",");
            String equipo1 = parts[0];
	   	        int goles1 = Integer.parseInt(parts[1]);
	   	        int goles2 = Integer.parseInt(parts[2]);
	   	        String equipo2 = parts[3];

                   equipo miequipo1 = new equipo (equipo1, "descripcion del equipo");
                   equipo miequipo2 = new equipo (equipo2, "descripcion del equipo numero 2");
                   partido partido= new partido(miequipo1, miequipo2, goles1, goles2);

                   String[] parts2 = line2.split(",");
                   String renglon1 = parts2[1];
                   String renglon2 = parts2[2];
                   String renglon3 = parts2[3];

                   System.out.println("Partido: " + equipo1 + " vs " + equipo2);
                   System.out.println("Goles: " + equipo1 + " " + goles1 + " - " + goles2 + " " + equipo2);

                   if (renglon1.equalsIgnoreCase("x")) {
                       pronostico pronostico = new pronostico(partido, miequipo1, resultadoenum.GANADOR);
                       puntaje = puntaje + pronostico.puntos();
                       System.out.println("Pronóstico: " + miequipo1.getNombre() + " ganador");
                   }
                   else {
                       if (renglon2.equalsIgnoreCase("x")) {
                           pronostico pronostico = new pronostico(partido, miequipo1, resultadoenum.EMPATE);
                           puntaje = puntaje + pronostico.puntos();
                            System.out.println("Pronóstico: empate");
                       } else {
                           if (renglon3.equalsIgnoreCase("x")) {
                               pronostico pronostico = new pronostico(partido, miequipo2, resultadoenum.GANADOR);
                               puntaje = puntaje + pronostico.puntos();
                               System.out.println("Pronóstico: " + miequipo2.getNombre() + " ganador");
                           }
                       }
                   }
        }
        System.out.println("con el pronostico ganaste " + puntaje + " puntos");
        reader.close();
        reader2.close();
    } catch (IOException e) {
        System.out.println("Error al leer archivo");
    }

    }
}