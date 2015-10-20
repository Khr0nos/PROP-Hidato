package domini;

import java.lang.String;
import java.io.*;

class Driver{
  public static void main(String args[]){
    try{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String in = "";
      int x = 0;
      User u;
      while(x != 9){
	System.out.println("Si vols crear un usuari buit prem 1.");
	System.out.println("Si vols crear un usuari amb username i password predeterminats prem 2.");
	System.out.println("Si vols sortir del driver prem 9.");
	in = br.readLine();
	x = Integer.parseInt(in);
	if (x == 1 || x == 2){
	  if (x == 1){
	    u = new User();
	  }
	  else{
	    System.out.println("Escriu el username:");
	    String nom = br.readLine();
	    System.out.println("Escriu el password:");
	    String pwd = br.readLine();
	    u = new User(nom,pwd);
	  }
	  int y = 0;
	  int i = 0;
	  while (y != 8 && y != 9){
	    if (i == 0){
	    System.out.println("Si vols consultar el username de l'usuari que has creat prem 1.");
	    System.out.println("Si vols consultar el seu password prem 2.");
	    System.out.println("Si vols modificar el seu password prem 3.");
	    System.out.println("Si vols verificar el seu password prem 4.");
	    System.out.println("Si vols crear un altre usuari prem 8.");
	    System.out.println("Si vols sortir del driver prem 9.");
	    }
	    else {
	      System.out.println("Prem un altre numero.");
	    }
	    in = br.readLine();
	    y = Integer.parseInt(in);
	    if (y == 1){
	      String s = u.getUsername();
	      System.out.println("Username: " + s);
	    }
	    else if (y == 2) {
	      String s = u.getPassword();
	      System.out.println("Password: " + s);
	    }
	    else if (y == 3){
	      System.out.println("Escriu el nou password:");
	      String s = br.readLine();
	      u.setPassword(s);
	    }
	    else if (y == 4){
	      System.out.println("Escriu el password de l'usuari:");
	      String s = br.readLine();
	      Boolean b = u.testPassword(s);
	      if (b){
		System.out.println("Password correcte.");
	      }
	      else {
		System.out.println("Password incorrecte.");
	      }
	    }
	    else if (y == 9){
	      x = 9;
	    }
	    ++i;
	  }
	}
      }
      System.out.println("Sortint del Driver...");
    }
    catch (IOException e){}
  }
}
