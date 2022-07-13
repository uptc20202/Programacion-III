package model;

import java.util.ArrayList;
import java.util.Comparator;

import resources.AVLTree;

public class Directory {
	private AVLTree contacts;
	private Comparator comparatorSearch;

	public Directory() {
		super();
		this.contacts = new AVLTree(new Comparator<Contact>() {
            @Override
            public int compare(Contact t1, Contact t2) {
                return t1.getName().compareToIgnoreCase(t2.getName());
            }
        });
		
		comparatorSearch = new Comparator<Contact>() {
            @Override
            public int compare(Contact t1, Contact t2) {
                return t1.getName().equalsIgnoreCase(t2.getName())?0:1;
            }
        };
	}
	
	public void addContact(String name) {
		contacts.insert(new Contact(name));
	}
	
	public Contact searchContact(String name) {
		return (Contact) contacts.search(comparatorSearch, name);
	}
	
	public void deteleContact(String name) throws Exception {
		contacts.detele(name);
	}
	
	public int countContact() {
		return contacts.showInorder().size();
	}
	
	public ArrayList<Contact> showContacts(){
		return contacts.showInorder();
	}
	
	public Contact minimumContact() {
		return (Contact) contacts.showInorder().get(0);
	}
	
	public Contact maxContact() {
		ArrayList<Contact> contacts1 = contacts.showInorder();
		return (Contact) contacts1.get(contacts1.size()-1);
	}
}
