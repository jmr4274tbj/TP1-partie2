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
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
			
			String lignePrecedente = null;	
			
			String ligneActuelle = null;
			
			ficLecture = new BufferedReader( new FileReader( nomFicCommande ) );

			while ( ( ligneActuelle = ficLecture.readLine() ) != null ) {

				if ( ligneActuelle.endsWith( ":" ) ) {

					lignePrecedente = ligneActuelle.replace( " :", "" );

				} else if ( lignePrecedente.equals( "Clients" ) ) {

					Client client = new Client( ligneActuelle );
					
					listeClients.add( client );

				} else if ( lignePrecedente.equals( "Plats" ) ) {

					Plat plat = new Plat( ligneActuelle.split( " " )[0], 
							Double.parseDouble( ligneActuelle.split( " " )[1] ) );
					
					listePlats.add( plat );

				} else if ( lignePrecedente.equals( "Commandes" ) ) {

					for ( Client client : listeClients ) {

						if ( client.getNom().equals( ligneActuelle.split( " " )[0] ) ) {

							for ( Plat plat : listePlats ) {

								if ( plat.Equals( ligneActuelle.split( " " )[1] ) ) {

									Commande commande = new Commande( client, plat, Integer
											.parseInt( ligneActuelle.split( " " )[2] ) );
									
									listeCommandes.add( commande );
									
									break;
								}
							}
						}
					}
				}
			}

			System.out.println( " " );
			
		} catch( Exception ex ) {
			
			BufferedWriter ficEcriture = new BufferedWriter( new FileWriter( nomFicFacture ) );
			
			ficEcriture.write( "Le fichier ne respecte pas le format demandé !" );
				
			System.out.println( "Le fichier ne respecte pas le format demandé !" );
				
			ficEcriture.close();
				
			System.exit( 0 );
		}
		
		BufferedWriter ficEcriture = null;
		
		ficEcriture = new BufferedWriter( new FileWriter( nomFicFacture ) );
			
		ficEcriture.write( "Bienvenue chez Barette !\r\n" + "Factures:\n" );
			
		for ( Client clientCourrant : listeClients ) {
				
			ficEcriture.write( clientCourrant.getNom() + " " );

			for ( Commande commande : listeCommandes ) {
					
				if ( commande.Contains( clientCourrant ) ) {
						
					ficEcriture.write( commande.getFacture() + "$\n" );
						
					break;
					
				} else if ( commande == listeCommandes.get( listeCommandes.size() - 1 ) ) {
						
					ficEcriture.write( "0.00$\n" );						
				}
			}
		}
			
		ficEcriture.close();		
	}
}

