package model;

public enum SHIP {

	BLUE("file:///C:/Users/91915/eclipse-workspace/SpaceRunnergame/src/resources/blue_ship.png","file:///C:/Users/91915/eclipse-workspace/SpaceRunnergame/src/resources/blue_life.png"),
	GREEN("file:///C:/Users/91915/eclipse-workspace/SpaceRunnergame/src/resources/green_ship.png","file:///C:/Users/91915/eclipse-workspace/SpaceRunnergame/src/resources/green_life.png"),
	ORANGE("file:///C:/Users/91915/eclipse-workspace/SpaceRunnergame/src/resources/orange_ship.png","file:///C:/Users/91915/eclipse-workspace/SpaceRunnergame/src/resources/orange_life.png"),
	RED("file:///C:/Users/91915/eclipse-workspace/SpaceRunnergame/src/resources/red_ship.png","file:///C:/Users/91915/eclipse-workspace/SpaceRunnergame/src/resources/red_life.png");
	
	private String urlShip;
	private String urlLife;
	
	private SHIP(String urlShip,String urlLife)
	{
		 this.urlShip=urlShip;
		 this.urlLife=urlLife;
	}
	
	public String getUrl(){
		return this.urlShip;
	}
	
	public String getUrlLife() {
		return urlLife;
	}
}
