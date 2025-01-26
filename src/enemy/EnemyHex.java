package enemy;

import acm.graphics.GImage;
import game.*;
import items.*;



public class EnemyHex extends Enemy {
	public EnemyHex (int x, int y, Game game) {
		super(x, y, game);
		this.setHealth(16);
		this.isRanged = true;
	}
	
	@Override
	protected void addObjectsToCompound(int x, int y) {
		GImage body = new GImage ("media/terrain/snowman_4_winter_biome.png");
		body.setSize(50,50);
		this.bodyCompound.add(body,x-50,y-50);
	}
	
	@Override
	public void shootProjectile(double targetx, double targety) {
		double x = this.getX();
		double y = this.getY();
		double dx = targetx - x;
		double dy = targety - y;
		double angle = Math.atan2(dy, dx);
		
		EnemyProjectileFire p = new EnemyProjectileFire(x, y, angle, this.game);
		this.game.add(p.getCompound());
		this.game.getEnemyProjectiles().add(p);
	}
	
	int animationStage = 1;
	boolean finishedAnimation = true;
	public void animateShooting(int deltaTick) {
		if(deltaTick%5==0){
			if(!finishedAnimation){
				if(animationStage == 1){
					((GImage)this.bodyCompound.getElement(0)).setImage("media/terrain/snowman_4_winter_biome.png");
					animationStage = 2;
					((GImage) this.bodyCompound.getElement(0)).setSize(50,50);
				}else if(animationStage == 2){
					((GImage)this.bodyCompound.getElement(0)).setImage("media/terrain/snowman_4_winter_biome.png");
					((GImage) this.bodyCompound.getElement(0)).setSize(50,50);
					animationStage = 3;
				}else if(animationStage == 3){
					((GImage)this.bodyCompound.getElement(0)).setImage("media/terrain/snowman_4_winter_biome.png");
					((GImage) this.bodyCompound.getElement(0)).setSize(50,50);
					animationStage = 1;
					finishedAnimation = true;
				}
			}else{
				((GImage)this.bodyCompound.getElement(0)).setImage("media/terrain/snowman_4_winter_biome.png");
				((GImage) this.bodyCompound.getElement(0)).setSize(50,50);
			}
		}
	}
	
	@Override
	public void attackPlayer(double targetx, double targety, int deltaTick) {
		if (this.distanceTo(targetx, targety) > 400) {
			this.moveToward(targetx, targety);
		}
		else {
			this.shootProjectile(targetx, targety);
		}
	}
	
	@Override
	protected Item calculateDrop() {
		if(percentChance(5)){
			return new Bow();
		}
		if(percentChance(15)){
			return new Cherries();
		}
		if(percentChance(75)){
			return new Arrow();
		}

		else{
			return null;
		}
		
	}
}
