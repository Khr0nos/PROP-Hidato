package persistencia;

import java.io.*;
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
						System.out.print(cella + " ");
					}
					System.out.println("");
				}
			
				System.out.println("Fi de l'arxiu " + in);
				break;
			case "2":
				System.out.println("Introdueix les dades");
				System.out.println("';' per nova linia, '.' per fi");
				taula = new ArrayList<ArrayList<String>>();
				ArrayList<String> linia = new ArrayList<String>();
				
				in = br.readLine();
				while (in != ".")
				{
					if (in == ";")
					{
						taula.add(linia);
						linia = new ArrayList<String>();
					}
					else
					{
						linia.add(in);
					}
				}
				
				System.out.println("Introdueix el nom de l'arxiu per la taula");
				in = br.readLine();
				CtrlPersistencia.storeTable(in, taula);
				System.out.println("Taula guardada");
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
