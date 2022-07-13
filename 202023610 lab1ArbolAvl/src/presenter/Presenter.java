package presenter;

import model.Contact;
import model.Directory;
import view.ViewConsole;

public class Presenter {
	
	private ViewConsole view;
	private Directory directory;
	
	public Presenter() {
		view = new ViewConsole();
		directory = new Directory();
		run();
	}
	
	public void run() {
		String option = "";
		do {
			String menu = "1. Crear un nuevo contacto.\r\n"
					+ "2. Mostrar la información de un contacto.\r\n"
					+ "3. Eliminar un contacto.\r\n"
					+ "4. Mostrar la lista de contactos ordenada por nombre\n"
					+ "5. Primer contacto\n"
					+ "6. Ultimo Contacto\n"
					+ "7. Contactos guardados\n"
					+ "8. Salir\n";
			System.out.println(menu);
			option = view.readString("Digite la opcion desea: ");
			switch(option) {
				case "1":
					insetContact();
					break;
				case "2":
					searchContact();
					break;
				case "3":
					deteleContact();
					break;
				case "4":
					showContacts();
					break;	
				case "5":
					contactMinimum();
					break;
				case "6":
					contactMax();
					break;
				case "7":
					countContacts();
					break;	
				
				default:
					System.out.println("Seleccione una opción correcta");
					break;
			}
		}while(option != "8");
		
	}
	
	public void insetContact() {
		directory.addContact(view.readString("Digite el nombre del Nuevo contacto"));
		System.out.println("Contacto agregado con exito");
	}
	
	public void searchContact() {
		Contact contact = directory.searchContact(
				view.readString("Digite el nombre del contacto que desea Consulta"));
		System.out.println("Se encontro el contacto: "+contact);
	}
	
	public void deteleContact() {
		try {
			directory.deteleContact(view.readString("Digite el nombre del contacto que desea Eliminar"));
			System.out.println("Contacto Eliminado");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error Al Eliminar Contacto");
			e.printStackTrace();			
		}
	}
	
	public void showContacts() {
		for(Contact sheet2 : directory.showContacts()) {
			System.out.println(sheet2);
		}
	}
	
	public void contactMinimum() {
		System.out.println(directory.minimumContact());
	}
	
	public void contactMax() {
		System.out.println(directory.maxContact());
	}
	
	public void countContacts() {
		System.out.println(directory.countContact()+" Contactos Guardados");
	}
	
	public static void main(String [] args) {
		new Presenter();
		
	}
}
