
#include <iostream>

using namespace::std;

struct nodo{
	int dato;
	nodo* siguiente;
	nodo* atras;
} *primero, *ultimo;

void insertarNodo();

void desplegarListaPU();
void desplegarListaUP();

int main(){
	insertarNodo();
	insertarNodo();
	insertarNodo();
	insertarNodo();
	insertarNodo();
	cout << " Lista Primero al ultimo\n";
	desplegarListaPU();
	cout << " Lista Ultimo al Primero\n";
	desplegarListaUP();
	return 0;
}

void insertarNodo(){
	nodo* nuevo = new nodo();
	cout <<"Ingrese el dato que contendra el nuevo Nodo: ";
	cin >> nuevo->dato;

	if(primero==NULL){
		primero = nuevo;
		primero->siguiente = NULL;
		primero->atras = NULL;
		ultimo = primero;
	}else{
		ultimo->siguiente = nuevo;
		nuevo->siguiente = NULL;
		nuevo->atras= ultimo;
		ultimo = nuevo;
	}
	cout << "\n Nodo Ingresado \n\n";
}

void desplegarListaPU(){
	nodo* actual = new nodo();
	actual = primero;
	if(primero!=NULL){
		
		while(actual!=NULL){
			cout << "\n " << actual->dato;
			actual = actual ->siguiente ; 
		}
		
	}else{
		cout << "\n La lista se encuentra Vacia\n\n";
	}
	
}

void desplegarListaUP(){
	nodo* actual = new nodo();
	actual = ultimo;
	if(primero!=NULL){
		
		while(actual!=NULL){
			cout << "\n " << actual->dato;
			actual = actual ->atras; 
		}
		
	}else{
		cout << "\n La lista se encuentra Vacia\n\n";
	}
	
}



