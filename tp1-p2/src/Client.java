/*
* Nom de classe : Client.java
*
* Description   : Classe qui sert à la gestion d'un client
*
* Version       : 1.0
*
* Date          : 2019/02/10
*
* Programmeurs	: Jonathan Martel-Raiche et Rayane Taleb
*/


public class Client{
	private String nom;

	public Client(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public boolean Equals(Client client) {
		return nom.equals( client.getNom() );
	}
}