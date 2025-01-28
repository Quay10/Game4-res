# Game-4
Game-4 project for COMP55

Team:
    - Samuel Wan
    - Andrew Lewis
    - Juan Cuevas
    - Christopher Chew

This is a java based open world exploration sandbox game.
In this game the player fights enemies and explores castles, collecting fun and powerful items
along the way. Eventually, the player will come face-to-face with the boss in one of the castles.
Once defeated, the boss will drop a special trophy to commemorate the endgame challenge and the player can either continue to explore the world or end their game.

The game is in a complete state. All features that have been planned to be implemented were made such as
saving, randomly generating structures and biomes as the player progresses, a functioning main menu, inventory menu with hotbar extension, and more.

Of course, there can always be more things to add. For example:

  - A resource meter for magic when using the ice and fire rods to mitigate spamming.

  - Addtional unique items to keep the players invested.

  - More enemies and bosses to increase the challege within the game.

  - More structures and locations to expand the identity of the world generated.
    
  - Including SoundFx

  - Cleaner and more organized UI

  - More animations

Maybe in the future, someone from the team (or maybe even everyone that was involved) can come back together to
have fun improving the game and seeing where they take the game from there.

Addition of ranged enemy:
	This enemy is implemented to be navigating the world like the other enemies that are not in the castles.
	This new enemy will do ranged damage to the player forcing them to change their strategy when exploring
	and encountering these enemies.

Psuedocode:
	1. Measure the distance between the enemy and the player.
	2. If the player is within enemy attack range:
		- check if enemy is ready to attack (not in cooldown):
			- fire projectile:
				- calculate the angle between the player and the enemy
				- add the projectile to the active projectile list
	
	3. Reset the enemy's attack by setting a cooldown.
	
Recap of what was added and it's implementation:
	- We added a ranged enemy that does damage from a distance and gave it a cooldown of 25 seconds
	before it attacks again. It will spawn with the enemy triangles and was set to do 0 damage for
	for testing purposes. We used shootProjectile() to calculate the distance between the target
	and the enemy to have it shoot in the players direction. In the attackPlayer() method is where
	we dedicated the cool down timer of 25. To test the cooldown and if it worked I changed how long
	it would take to shoot another attack at the player or commented it out to see what the enemy did
	without a cooldown timer. The other feature that was added was the enemyStats.properties file that
	we actually had to go and change in other files (all enemyRect & enemyTri) files to make sure the changes
	actually took effect. We implemented this using a loader to fetch the stats that we created in the
	enemyStats.properties. From here we used .getStats() to call either the damage stat or health stat from
	the correct enemy in the .properties file.
	
Steps to show implementation:
	- After having the project ready to run, click on the EnemyHex.java, this is the ranged enemy that was added.
	- To test if the stat changes work, click on src, then enemyStats.properties, and change the damage to something like
	3 to 6 just to make sure when you test it you don't die instantly. You can also change the enemy health
	using the same steps those stats would be in the same file.
	- As mentioned before EnemyHex is at 0 damage for testing reasons feel free to change it.

You can play the game by downloading the game4_final_final.zip folder, extracting it, and running the jar.


![alt text](https://github.com/comp55/final-project-team-4/blob/main/media/Screenshot1.png)
![alt text](https://github.com/comp55/final-project-team-4/blob/main/media/Screenshot2.png)
![alt text](https://github.com/comp55/final-project-team-4/blob/main/media/Screenshot3.png)

----------------------------------------------------------------------------------------------------------------------
Controls:

  W - Move Up
  S - Move Down
  A - Move Left
  D - Move Right

  Left Click - Attack / Use
  E - Inventory
    -> Click and drag items within the inventory to either organize or throw away items.
    -> Combine identical weapons to create a slightly more powerful version of it.
  Num Keys (0 - 9) - Select Item

  Escape - Pause Menu
  
