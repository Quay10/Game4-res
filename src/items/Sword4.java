package items;

import java.util.ArrayList;

import acm.graphics.*;
import game.Enemy;
import game.Item;
import userinterface.ToolTip;

public class Sword4 extends Item implements Melee{
	public Sword4() {
		this.damage = 11;
		this.name = "Ruby Sword";
		GImage image = new GImage("media/Items/Weapons/Sword/Sword_Left4.png");
		GImage imageRight = new GImage("media/Items/Weapons/Sword/Sword_Right4.png");
		this.combinable = true;
		this.label.setLabel("1");
		image.setSize(75,75);
		imageRight.setSize(75,75);
		this.getItemBody().add(image);
		this.getItemBodyRight().add(imageRight);
		updateToolTip();
	}

	@Override
	public void attackEvent(ArrayList<Enemy> enemies) {
		
	}

	@Override
	public int getKnockback() {
		return 5;
	}
	@Override
	public int getDamage() {
		return this.damage+ Integer.parseInt(this.label.getLabel());
	}
	@Override
	public void updateToolTip() {
		this.toolTip = new ToolTip("A Resilient Ruby Sword that does " + String.valueOf(damage) + " +"+this.label.getLabel() + " damage per hit. Combine with another sword to upgrade it.", this);
	}
	@Override
	public void setLabel(String label) {
		super.setLabel(label);
		updateToolTip();
	}
}
