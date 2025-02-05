package enemy;


import acm.graphics.GImage;
import config.StatsLoader;
import game.*;
import items.*;
public class EnemyTri4 extends Enemy{
	public EnemyTri4(int x, int y, int damage, Game game) {
		super(x, y, StatsLoader.getStat("EnemyTri4.damage"), game);
		this.setHealth(StatsLoader.getStat("EnemyTri4.health"));
	}
	
	@Override
	protected void addObjectsToCompound(int x, int y) {
		GImage body = new GImage("media/Characters/DoritoSV/DoritoSV_FaceFront4.png");
		body.setSize(50,50);
		this.bodyCompound.add(body,x-25,y-25);
	}
	
	@Override
	public void attackEvent(Player player){
		player.setHealth(player.getHealth()-2);
		player.getHealthPoints().updateHealthPointsIcons(player.getHealth());
		player.setInvurnerableCooldown(100);
		player.setVelX((int)((player.getPlayerCenter().getX() - this.x) /7));
		player.setVelY((int)((player.getPlayerCenter().getY() - this.y) / 7));
	}


	@Override
	protected Item calculateDrop() {
		if(percentChance(10)){
			return new Cherries();
		}else if(percentChance(10)){
			return new Sword5();
		}
		else if(percentChance(5)){
			return new Arrow();
		}
		else if(percentChance(1)){
 			return new Sword6();		
		}else{
			return null;
		}
	}
}
