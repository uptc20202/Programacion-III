package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Eps;
import model.User;

public class TestEps {
	public static void main(String[] args) {
		Eps sanitas = new Eps();
		TestEps testEps = new TestEps();
		int numberTurn = 0;
		
		BufferedReader entrada = new BufferedReader( new
				InputStreamReader(System.in));
		
		int option = 0;
		while(option != 3) {
			System.out.println("Digite una opcion");
			System.out.println("1.Apartar turno \n 2.Llamar Usuario \n 3. Cerrar");
			try {
				option = Integer.parseInt(entrada.readLine());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			switch(option) {
				case 1:
					testEps.takeTurn(entrada,sanitas);
					numberTurn++;
					System.out.println("Turno signado: " +numberTurn);
					break;
				case 2:
					testEps.callUser(sanitas);
					break;
				case 3:
					break;
			
			}
		}
		
		
	}
	
	public void takeTurn(BufferedReader entrada, Eps sanitas) {
		String name = "";
		int identificationNumber = 0;
		int numberPriority = 0;
		
		
		System.out.println("Señor usuario digite su nombre");
		try {
			name = entrada.readLine();
			System.out.println("Digite su numero de identificacion");
			identificationNumber = Integer.parseInt(entrada.readLine());
			System.out.println("Indique a que grupo pertenece \n 1.Discapacitados "
					+ "\n 2.Personas de tercera edada \n 3.No pertezco a ningun grupo");
			numberPriority = Integer.parseInt(entrada.readLine());
			
		}catch (IOException e) {;}
		
		sanitas.takeTurn(new User(identificationNumber,name,numberPriority));
	}
	
	public void callUser( Eps sanitas) {
		System.out.println("Señor");
		System.out.println(sanitas.callUser());
		System.out.println("Puede acercarse para ser atendido");
	}
}
