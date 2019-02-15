/*
* Nom de classe : Commande.java
*
* Description   : Classe qui sert à la gestion d'une commande
*
* Version       : 1.0
*
* Date          : 2019/02/10
*
* Programmeurs	: Jonathan Martel-Raiche et Rayane Taleb
*/

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Commande {
	private Client client;
	private Plat plat;
	private int quantite;

	public Commande(Client client, Plat plat, int quantite) {
		this.client = client;
		this.plat = plat;
		this.quantite = quantite;
	}

	public boolean Contains(Client client) {
		return this.client.Equals(client);
	}

	public Plat getPlat() {
		return this.plat;
	}

	public Client getClient() {
		return this.client;
	}

	public int getQuantitePlat() {
		return this.quantite;
	}

	public String getFacture() {
		NumberFormat nbFormat = new DecimalFormat("#0.00");
		return nbFormat.format(getPlat().getPrix()*getQuantitePlat());
	}
}
