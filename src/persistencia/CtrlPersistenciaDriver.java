package persistencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CtrlPersistenciaDriver
{
	public static void main(String[] args)
	{
		ArrayList<ArrayList<String>> taula;
	
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String in = "";
			
			System.out.println("Introdueix 1 per carregar una taula");
			System.out.println("Introdueix 2 per guardar una taula");
			System.out.println("Introdueix 3 per canviar separador");
			in = br.readLine();

			switch (in)
			{
				case "1":
					System.out.println("Introdueix el nom de la taula a carregar");
					in = br.readLine();

					taula = CtrlPersistencia.loadTable(in);
	
					System.out.println("S'ha llegit l'arxiu " + in);
					System.out.println("Bolcat:");
	
					for (ArrayList<String> fila : taula)
					{
						for (String cella : fila)
						{
							System.out.print(cella);
							System.out.print(" ");
						}
						System.out.println("");
					}
		
					System.out.println("Fi de l'arxiu " + in);
					break;
				case "2":
					System.out.println("Introdueix el nombre de columnes");
					in = br.readLine();
					int cols = Integer.parseInt(in);
					System.out.println("Introdueix el nombre de files");
					in = br.readLine();
					int files = Integer.parseInt(in);
			
					taula = new ArrayList<ArrayList<String>>();
			
					System.out.println("Introdueix les dades");
					for (int i = 0; i < files; ++i)
					{
						ArrayList<String> linia = new ArrayList<String>();
			
						in = br.readLine();
				
						String[] dades = in.split(" ");
						for (String cella : dades)
						{
							linia.add(cella);
						}
				
						taula.add(linia);
					}
			
					System.out.println("Introdueix el nom de l'arxiu per la taula");
					in = br.readLine();
					CtrlPersistencia.storeTable(in, taula);
					System.out.println("Taula guardada");
					break;
				case "3":
					System.out.println("Introdueix el nou separador");
					in = br.readLine();
					CtrlPersistencia.setSeparator(in);
					System.out.println("El nou separador es " + in);
					break;
				default:
					System.out.println("Opcio no valida");
					break;	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
