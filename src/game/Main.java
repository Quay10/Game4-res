package game;
import java.awt.event.*;
import java.util.*;

import javax.swing.Timer;

import acm.graphics.*;
import acm.program.*;

public class Main extends GraphicsProgram implements ActionListener{
	Timer runTimer = new Timer(1, this);
    static int windowHeight = 500;
    static int windowWidth = 1000;
    private boolean inventoryDisplayed = false;
    private boolean canChangeInventoryDisplayed = true;
    Window window = new Window(windowWidth, windowHeight);
    Game game = new Game(windowWidth, windowHeight);
    private ArrayList < String > key_manager = new ArrayList < String > ();
    public void init() {
        setSize(windowWidth, windowHeight);
        requestFocus();
    }
    //Hi...
    //for testing
    GLabel tileLabel;
    @Override
    public void run() {
        addKeyListeners();
        addMouseListeners();
        drawTiles();
        add(game.getPlayer().getPlayerGCompound());
        tileLabel = new GLabel(String.valueOf(game.getPlayer().getTile().get(0)) + ", " + String.valueOf(
            game.getPlayer().getTile().get(1)));
        add(tileLabel);
        for (Enemy e: game.getCurrentTile().getEnemies()) {
            add(e.getBody());
        }
        
        runTimer.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        	if (checkTileCrossing()) {
                removeAll();
                drawTiles();
                add(tileLabel);
                add(game.getPlayer().getPlayerGCompound());
                for (Enemy enemy: game.getCurrentTile().getEnemies()) {
                    add(enemy.getBody());
                }
            }
            for (Enemy enemy: game.getCurrentTile().getEnemies()) {
            	enemy.tickai(game.getPlayer().getPlayerCenter().getX(), game.getPlayer().getPlayerCenter()
                    .getY(), game.getCurrentTile().getEnemies());
            }
            handleKeyStrokes();
            tileLabel.setLocation(windowWidth / 2, windowHeight / 2);
        
    }
    public void handleKeyStrokes() {
        if (key_manager.contains("w")) {
            game.getPlayer().moveY(-5);
        }
        if (key_manager.contains("s")) {
            game.getPlayer().moveY(5);
        }
        if (key_manager.contains("a")) {
            game.getPlayer().moveX(-5);
        }
        if (key_manager.contains("d")) {
            game.getPlayer().moveX(5);
        }
        if(key_manager.contains("e")) {
        	this.game.getPlayer().getInventory().updateGraphicalInterface();
        	calculateDisplayingInventory();
        }else {
        	canChangeInventoryDisplayed = true;
        }
    }
    public void calculateDisplayingInventory() {
    	if(inventoryDisplayed && canChangeInventoryDisplayed) {
    		remove(this.game.getPlayer().getInventory().getGraphicalInterface());
    		inventoryDisplayed = false;
    		canChangeInventoryDisplayed = false;
    	}else if(canChangeInventoryDisplayed){
            add(this.game.getPlayer().getInventory().getGraphicalInterface());
            inventoryDisplayed = true;
            canChangeInventoryDisplayed = false;
    	}
    }
    public void drawTiles() {
        for (GObject object: game.getCurrentTile().getObjects()) {
            add(object);
        }
    }
    public boolean checkTileCrossing() {
        //remove tile label lines for production
        if (game.getPlayer().getX() > windowWidth - game.getPlayer().getPlayerWidth()) {
            game.moveTiles(1, 0);
            tileLabel.setLabel((game.getPlayer().getTile().get(0)) + ", " + String.valueOf(game
                .getPlayer().getTile().get(1)));
            return true;
        }
        if (game.getPlayer().getX() < 0) {
            game.moveTiles(-1, 0);
            tileLabel.setLabel((game.getPlayer().getTile().get(0)) + ", " + String.valueOf(game
                .getPlayer().getTile().get(1)));
            return true;
        }
        if (game.getPlayer().getY() < 0) {
            game.moveTiles(0, 1);
            tileLabel.setLabel((game.getPlayer().getTile().get(0)) + ", " + String.valueOf(game
                .getPlayer().getTile().get(1)));
            return true;
        }
        if (game.getPlayer().getY() > windowHeight - game.getPlayer().getPlayerHeight()) {
            game.moveTiles(0, -1);
            tileLabel.setLabel((game.getPlayer().getTile().get(0)) + ", " + String.valueOf(game
                .getPlayer().getTile().get(1)));
            return true;
        } else {
            return false;
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
    	this.game.getPlayer().attackPressed(this.game);
    	
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_W) {
            if (!key_manager.contains("w")) {
                key_manager.add("w");
            }
        }
        if (keyCode == KeyEvent.VK_S) {
            if (!key_manager.contains("s")) {
                key_manager.add("s");
            }
        }
        if (keyCode == KeyEvent.VK_A) {
            if (!key_manager.contains("a")) {
                key_manager.add("a");
            }
        }
        if (keyCode == KeyEvent.VK_D) {
            if (!key_manager.contains("d")) {
                key_manager.add("d");
            }
        }
        if (keyCode == KeyEvent.VK_E) {
            if (!key_manager.contains("e")) {
                key_manager.add("e");
            }
        }
    }
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_W) {
            key_manager.remove("w");
        }
        if (keyCode == KeyEvent.VK_S) {
            key_manager.remove("s");
        }
        if (keyCode == KeyEvent.VK_A) {
            key_manager.remove("a");
        }
        if (keyCode == KeyEvent.VK_D) {
            key_manager.remove("d");
        }
        if (keyCode == KeyEvent.VK_E) {
            key_manager.remove("e");
        }
    }
    public static void main(String[] args) {
        new Main().start();
    }
}