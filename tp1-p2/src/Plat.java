/*
* Nom de classe : Plat.java
*
* Description   : Classe qui sert à la gestion d'un plat
*
* Version       : 1.0
*
* Date          : 2019/02/10
*
* Programmeurs	: Jonathan Martel-Raiche et Rayane Taleb
*/


public class Plat{
	private String nomPlat;
	private double prix = 0.0;

	public Plat(String nomPlat, double prix) {
		this.nomPlat = nomPlat;
		this.prix = prix;
	}

	public double getPrix() {
		return this.prix;
	}

	public boolean Equals(String string) {
		return nomPlat.equals(string.toString());
	}
}