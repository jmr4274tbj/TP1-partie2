/*
* Nom de classe : Main.java
*
* Description   : Classe qui permet de lire un fichier et de créer un fichier de facture
*
* Version       : 1.0
*
* Date          : 2019/02/10
*
* Programmeurs	: Jonathan Martel-Raiche et Rayane Taleb
*/

//Note : Le notepad de windows n'affiche pas correctement la facture (eclipse ou notepad++ oui)

import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.IOException;

public class Main {

	public static void main( String[] args ) throws IOException {
		
		ArrayList<Client> listeClients = new ArrayList<Client>();
		
		ArrayList<Plat> listePlats = new ArrayList<Plat>();
		
		ArrayList<Commande> listeCommandes = new ArrayList<Commande>();
		
		String nomFicCommande = "fichier.txt";
		
		String nomFicFacture = "facture.txt";

		BufferedReader ficLecture;
		
		try {
			
		} catch( Exception ex ) {}
		
	}
}

