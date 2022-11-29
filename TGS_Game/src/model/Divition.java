package model;

public class Divition {
	
	public DivitionName calculateDivition(int points) {
		if(points >= 120) {
			return DivitionName.Disenador;
		}else if(points >= 80) {
			return DivitionName.Gobernante;
		}else if(points > 40) {
			return DivitionName.Administrador;
		}else if(points < 40) {
			return DivitionName.Observador;
		}
		return null;
	}		
}
