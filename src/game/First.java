package game;import java.applet.AudioClip;
import java.awt.Color; 
import java.awt.Font; 
import java.awt.Graphics; 
import java.awt.Graphics2D; 
import java.awt.Image; 
import java.awt.event.KeyEvent; 
import java.awt.event.KeyListener; 
import java.awt.event.MouseEvent; 
import java.awt.event.MouseListener; 
import java.io.*; 
import java.util.Random;

import javax.swing.JApplet;

public class First extends JApplet implements MouseListener, KeyListener{
	
	//setup variables
	public int stage;
	public int keyMovementX;
	public int keyMovementY;
	public int UpdateV;
	public int shopCooldownClick;
	
	//good tank variables
	public int goodTankX;
	public int goodTankMovement = 2;
	
	//good tank bullet variables
	public int goodBulletV;
	public double goodBulletY;
	public int goodBY = -200;
	public int goodBulletX;
	public int goodBulletDamage = 1;
	public int sideBulletDamage = 0;
	
	//good tank LEFT side bullet variables
	
	public double tankSideShootLeftX;
	public double tankSideShootLeftY = -200;
	public int tankSideSLV;
	public int tankSideSLV2;
	public int tankSideShootLeftV;
	public int tankSideShootLeftMV;
	
	//good tank RIGHT side bullet variables
	public double tankSideShootRightX;
	public double tankSideShootRightY = -200;
	public int tankSideSRV;
	public int tankSideSRV2;
	public int tankSideShootRightV;
	public int tankSideShootRightMV;
	
	//BAD Tank RIGHT side bullet variables
	
	public double badTankSideShootRightX;
	public double badTankSideShootRightY = -200;
	public int badTankSideSRV;
	public int badTankSideSRV2;
	public int badTankSideShootRightV;
	public int badTankSideShootRightMV;
	public int goodTankHitVR;
	
	//BAD Tank LEFT side bullet variables
	
	public double badTankSideShootLeftX;
	public double badTankSideShootLeftY = -200;
	public int badTankSideSLV;
	public int badTankSideSLV2;
	public int badTankSideShootLeftV;
	public int badTankSideShootLeftMV;
	public int badSideBulletDamage;
	public int goodTankHitVL;
	
	//good bullet movement speed
	public double goodBulletM = 6;
	public int badTankX;
	public int badTankMV;
	public int badTankVV;
	
	//bad tank bullet variables
	public int badBulletX;
	public int badBY = -200;
	public int badBulletV;
	public double badBulletY;
	public int badBulletDamage;
	
	//bad Bullet movement speed
	public double badBulletM = 4;
	
	//bad tank bullet random firing variable
	public int badBR;
	
	//good tank health and collision variables
	public int goodTankMaxHealth = 10;
	public int goodTankCurrentHealth = 10;
	public int goodTankHitV;
	
	//bad tank health and collision variables
	public int badTankMaxHealth = 8;
	public int badTankCurrentHealth = 8;
	public int badTankHitV;
	
	//shop items cost
	public int healthPrice=50;
	public int bulletMovementPrice=75;
	public int bulletDamagePrice=500;
	public int spreadBulletPrice = 1000;
	public int shieldPrice = 1000;
	
	//x and y variables to access mouse cordinates
	public int MouseX;
	public int MouseY;
	public int mouseV = 1;
	//balance player accumulates throught play state
	public int balance = 250;
	
	//variable for auto shoot
	public int autoShootV;
	
	//current round of game state
	public int currentRound = 1;
	
	//shield variables
	public int shieldX;
	public int shieldXMV;
	public int shieldMaxHealth;
	public int shieldCurrentHealth;
	
	//good tank movement speed power up
	public int movementPowerUpX;
	public int movementPowerUpY = -200;
	public int movementRandomV;
	public int movementStart;
	public int movementDirection;
	public int movementTimeLeft;
	
	//good tank bullet speed power up
	public int bulletPowerUpX;
	public int bulletPowerUpY = -200;
	public int bulletRandomV;
	public int bulletStart;
	public int bulletDirection;
	public int bulletTimeLeft;
	public int bulletVV;
	
	//health power up
	public int healthPowerUpX;
	public int healthPowerUpY = -200;
	public int healthRandomV;
	public int healthStart;
	public int healthDirection;
	
	//players in game
	public int players = 1;
	
	//variables for testing mac of windows ( mostly to determine bullet speed )
	public int bulletTestV;
	public int bulletTestTimer = 5;
	public double bulletAdderV;
	public double badBulletAdderV;
	public double goodBulletVersion;
	public double shieldTestV;
	public int shieldBV;
	
	//key movement variables
	public int goodTankKeyMovement;
	
	//images
	Image goodTank;
	Image goodBullet1;
	Image badTank;
	Image badBullet1;
	Image goodBullet2;
	Image tankSideShootLeft;
	Image tankSideShootRight;
	Image tankSideShootLeft2;
	Image tankSideShootRight2;
	Image goodTankShield;
	Image badTankSideShootLeft;
	Image badTankSideShootRight;
	Image badBullet2;
	Image goodBullet3;
	Image movementPowerUp;
	Image bulletPowerUp;
	Image badBullet3;
	Image badBullet4;
	Image healthPowerUp;
	Image badTankSideShootLeft2;
	Image badTankSideShootLeft3;
	Image badTankSideShootRight2;
	Image badTankSideShootRight3;
	Image goodTankPlayer2;
	
	Random rr = new Random();
	
	public void init(){
		
		//init for images
		goodTank=getImage(getDocumentBase(), "goodTank.png");
		goodBullet1=getImage(getDocumentBase(), "goodBullet1.png");
		badTank=getImage(getDocumentBase(), "badTank.png");
		badBullet1=getImage(getDocumentBase(), "badBullet1.png");
		goodBullet2=getImage(getDocumentBase(), "goodBullet2.png");
		tankSideShootLeft=getImage(getDocumentBase(), "tankSideShoot.png");
		tankSideShootRight=getImage(getDocumentBase(), "tankSideShoot.png");
		tankSideShootLeft2=getImage(getDocumentBase(), "tankSideShoot2.png");
		tankSideShootRight2=getImage(getDocumentBase(), "tankSideShoot2.png");
		goodTankShield=getImage(getDocumentBase(), "shield.png");
		badTankSideShootLeft=getImage(getDocumentBase(), "badTankSideShoot.png");
		badTankSideShootRight=getImage(getDocumentBase(), "badTankSideShoot.png");
		badBullet2=getImage(getDocumentBase(), "badBullet2.png");
		goodBullet3=getImage(getDocumentBase(), "goodBullet3.png");
		movementPowerUp=getImage(getDocumentBase(), "movementPowerUp.png");
		bulletPowerUp=getImage(getDocumentBase(), "bulletPowerUp.png");
		badBullet3=getImage(getDocumentBase(), "badBullet3.png");
		badBullet4=getImage(getDocumentBase(), "badBullet4.png");
		healthPowerUp=getImage(getDocumentBase(), "healthPowerUp.png");
		badTankSideShootLeft2=getImage(getDocumentBase(), "badTankSideShoot2.png");
		badTankSideShootRight2=getImage(getDocumentBase(), "badTankSideShoot2.png");
		badTankSideShootLeft3=getImage(getDocumentBase(), "badTankSideShoot3.png");
		badTankSideShootRight3=getImage(getDocumentBase(), "badTankSideShoot3.png");
		goodTankPlayer2=getImage(getDocumentBase(), "goodTankPlayer2.png");
		
		this.addMouseListener(this);
		this.addKeyListener(this);
		
	}
	
	public void paint(Graphics g){
		
		setFont(new Font("Serif", Font.BOLD, 25)); 
		setSize(1200, 700);
		switch(stage){
		
		case 0:
			//start screen
			g.setColor(Color.CYAN);
			g.fillRect(0, 0, 1200, 700);
			g.setColor(Color.RED);
			g.drawString("WELCOME TO TANK BATTLE", 400, 30);
			
			g.setColor(Color.YELLOW);
			g.fillRect(250, 200, 150, 75);
			g.fillRect(700, 200, 150, 75);
			g.setColor(Color.RED);
			g.drawString("PLAY", 285, 245);
			g.drawString("SETTINGS", 715, 245);
			break;
		
		case 1:
			//starting update function
			if(UpdateV == 0){
				update();
				UpdateV++;
				}
			//game (playing) state
			g.setColor(Color.ORANGE);
			g.fillRect(0, 0, 1200, 700);
			g.drawImage(goodTank, goodTankX,550,this);
			g.setColor(Color.red);
			
			//drawing correct good bullet
			if(goodBulletDamage == 1){
			g.drawImage(goodBullet1, goodBulletX, goodBY, this);
			}else{
				g.drawImage(goodBullet1, -100, -100, this);
			}
			if(goodBulletDamage == 2){
			g.drawImage(goodBullet2, goodBulletX, goodBY, this);
			}
			if(goodBulletDamage == 3){
			g.drawImage(goodBullet3, goodBulletX, goodBY, this);
			}
			//drawing correct LEFT and RIGHT side bullet
			
			if(sideBulletDamage == 1){
				g.drawImage(tankSideShootLeft, tankSideSLV2, tankSideSLV, this);
				g.drawImage(tankSideShootRight, tankSideSRV2, tankSideSRV, this);
			
			}else{
				g.drawImage(tankSideShootLeft, -100, -100, this);
				g.drawImage(tankSideShootRight, -100, -100, this);
			
			}
			if(sideBulletDamage >= 2){				
				g.drawImage(tankSideShootLeft2, tankSideSLV2, tankSideSLV, this);
				g.drawImage(tankSideShootRight2, tankSideSRV2, tankSideSRV, this);
			}
			
			//making bad side bullets show correct image
			
			if(currentRound <= 4){
				g.drawImage(badTankSideShootLeft, -100, -100, this);
				g.drawImage(badTankSideShootRight, -100, -100, this);
			}
			if(currentRound > 5 && currentRound < 12){
				badSideBulletDamage = 1;
				g.drawImage(badTankSideShootLeft, badTankSideSLV2, badTankSideSLV, this);
				g.drawImage(badTankSideShootRight, badTankSideSRV2, badTankSideSRV, this);
			}
			if(currentRound >= 12 && currentRound < 21){
				badSideBulletDamage = 2;
				g.drawImage(badTankSideShootLeft2, badTankSideSLV2, badTankSideSLV, this);
				g.drawImage(badTankSideShootRight2, badTankSideSRV2, badTankSideSRV, this);
			}
			if(currentRound >= 21){
				badSideBulletDamage = 3;
				g.drawImage(badTankSideShootLeft3, badTankSideSLV2, badTankSideSLV, this);
				g.drawImage(badTankSideShootRight3, badTankSideSRV2, badTankSideSRV, this);
			}
			//drawing bad tank 
			g.drawImage(badTank, badTankX, 10, this);
			
			//drawing bad tank bullet
			if(currentRound < 5){
			g.drawImage(badBullet1, badBulletX, badBY, this);
			badBulletDamage=1;
			}
			if(currentRound >=5 && currentRound < 12){
			g.drawImage(badBullet2, badBulletX, badBY, this);
			badBulletDamage=2;
			}
			if(currentRound >= 12 && currentRound < 17){
				g.drawImage(badBullet3, badBulletX, badBY, this);
				badBulletDamage=3;
			}
			if(currentRound >= 17){
				g.drawImage(badBullet4, badBulletX, badBY, this);
				badBulletDamage=4;
			}
			
			if(badBulletV == 1){
				badBulletY+=badBulletM;
				badBY = (int) (Math.ceil(badBulletY));
			}
			if(badBY > 800+badBR){
				badBulletV = 0;
				badBR=rr.nextInt(500);
			}
			
			//making good and bad tank bullets reset and move properly
			if(goodBulletV == 1){
				goodBulletY-=goodBulletM;
				goodBY = (int) (Math.ceil(goodBulletY));
			}
			if(goodBY < -250){
				goodBulletV = 0;
			}
			//tank LEFT side shoot
			if(tankSideShootLeftV == 1){
				tankSideShootLeftY -= goodBulletM;
				tankSideSLV2 =(int) (Math.ceil(tankSideShootLeftX));
				tankSideSLV = (int) (Math.ceil(tankSideShootLeftY));
			}
			if(tankSideShootLeftY < -250){
				tankSideShootLeftV = 0;
			}
			if(tankSideShootLeftX <= 0){
				tankSideShootLeftMV = 1;
				
			}
			if(tankSideShootLeftMV == 0){
				tankSideShootLeftX -= goodBulletM + .03;
			}else{
				tankSideShootLeftX += goodBulletM - .03;
			}
			// tank RIGHT side shoot
			if(tankSideShootRightV == 1){
				tankSideShootRightY -= goodBulletM;
				tankSideSRV2 =(int) (Math.ceil(tankSideShootRightX));
				tankSideSRV = (int) (Math.ceil(tankSideShootRightY));
			}
			if(tankSideShootRightY < -250){
				tankSideShootRightV = 0;
			}
			if(tankSideShootRightX > 1200){
				tankSideShootRightMV = 1;
				
			}
			if(tankSideShootRightMV == 0){
				tankSideShootRightX += goodBulletM - .03;
			}else{
				tankSideShootRightX -= goodBulletM + .03;
			}
			
			// BAD tank LEFT side shoot
			if(badTankSideShootLeftV == 1){
				badTankSideShootLeftY += badBulletM;
				badTankSideSLV2 =(int) (Math.ceil(badTankSideShootLeftX));
				badTankSideSLV = (int) (Math.ceil(badTankSideShootLeftY));
			}
			if(badTankSideShootLeftY > 900){
				badTankSideShootLeftV = 0;
			}
			if(badTankSideShootLeftX <= 0){
				badTankSideShootLeftMV = 0;
				
			}
			if(badTankSideShootLeftMV == 0){
				badTankSideShootLeftX += badBulletM + .03;
			}else{
				badTankSideShootLeftX -= badBulletM - .03;
			}
			//BAD tank RIGHT side shoot
			if(badTankSideShootRightV == 1){
				badTankSideShootRightY += badBulletM;
				badTankSideSRV2 =(int) (Math.ceil(badTankSideShootRightX));
				badTankSideSRV = (int) (Math.ceil(badTankSideShootRightY));
			}
			if(badTankSideShootRightY > 900){
				badTankSideShootRightV = 0;
			}
			if(badTankSideShootRightX >= 1200){
				badTankSideShootRightMV = 0;
				
			}
			if(badTankSideShootRightMV == 0){
				badTankSideShootRightX -= badBulletM - .03;
			}else{
				badTankSideShootRightX += badBulletM + .03;
			}
			//making shield move back and forth
			
			if(shieldCurrentHealth > 0){
				
				//shield health bar
				
				g.drawImage(goodTankShield, shieldX, 400, this);
				g.setColor(Color.gray);
				g.fillRect(shieldX + 93, 518, 75, 25);
				g.setColor(Color.red);
				g.fillRect(shieldX + 93, 518, shieldCurrentHealth*75/shieldMaxHealth, 25);
				
			if(shieldX > 950){
				shieldXMV = 0;
			}
			if(shieldX < 0){
				shieldXMV = 1;
			}
			if(shieldBV == 1){
			if(shieldXMV == 0){
				shieldX-=1;
			}
			if(shieldXMV == 1){
				shieldX+= 1;
			}
			}else{
				shieldX = goodTankX - 85;
			}
			}
			//good tank health
			g.setColor(Color.gray);
			g.fillRect(550, 675, 100, 25);
 			g.setColor(Color.green);
			g.fillRect(550, 675, goodTankCurrentHealth*100/goodTankMaxHealth, 25);
			
			//bad tank health
			g.setColor(Color.gray);
			g.fillRect(550, 0, 100, 25);
			g.setColor(Color.red);
			g.fillRect(550, 0, badTankCurrentHealth*100/badTankMaxHealth, 25);
			
			//misc
			g.setColor(Color.black);
			g.drawString("Round : " + currentRound, 1020, 550);
			g.drawString("Balance : " + balance, 1020, 520);
			g.drawString(goodTankCurrentHealth + " / " + goodTankMaxHealth, 560, 695);
			g.drawString(badTankCurrentHealth + " / " + badTankMaxHealth, 560, 20);
			
			//drawing power up time remaining
			if(movementTimeLeft > 0){
				g.setColor(Color.white);
			g.drawString("Time Remaining : " + movementTimeLeft, 25, 695);
			}
			if(bulletTimeLeft > 0){
				g.setColor(Color.white);
			g.drawString("Time Remaining : " + bulletTimeLeft, 25, 695);
			}
			//testing for game over state
			if(badTankCurrentHealth <= 0){
			if(bulletVV == 1){
				bulletVV = 0;
				goodBulletM-=goodBulletVersion;
			}
				balance+=goodTankCurrentHealth;
				balance+=currentRound;
				shopCooldownClick = 75;
				stage = 3;
			}
			if(goodTankCurrentHealth <= 0){
				stage = 2;
			}
			//POWER UPS
			g.drawImage(movementPowerUp, movementPowerUpX, movementPowerUpY, this);
			g.drawImage(bulletPowerUp, bulletPowerUpX, bulletPowerUpY, this);
			g.drawImage(healthPowerUp, healthPowerUpX, healthPowerUpY, this);
			break;
		
		case 2:
			//game over state
			g.setColor(Color.red);
			g.fillRect(0, 0, 1200, 700);
			g.setColor(Color.BLACK);
			g.drawString("Game Over!", 500, 100);
			break;
			
		case 3:
			//store state
			g.setColor(Color.blue);
			g.fillRect(0, 0, 1200, 700);
			
			//rectangles for shop items
			
			g.setColor(Color.CYAN);
			g.fillRect(500, 600, 150, 75);
			
			g.setColor(Color.orange);
			g.fillRect(150, 50, 250, 100);
			g.fillRect(750, 50, 250, 100);
			g.fillRect(150, 250, 250, 100);
			g.fillRect(750, 250, 250, 100);
			g.fillRect(150, 450, 250, 100);
			g.fillRect(750, 450, 250, 100);
			
			//string for showing balance
			g.setColor(Color.GREEN);
			g.drawString("Current Balance : " + balance, 530, 25);
			
			//strings for buying health
			g.setColor(Color.black);
			g.drawString("Buy Health", 190, 75);
			g.drawString("Current : " + goodTankMaxHealth, 190, 105);
			g.drawString("Cost : " + healthPrice, 190, 135);
			
			//strings for buying movement speed
			g.drawString("Buy Bullet Speed", 765, 75);
			g.drawString("Current : " + Math.ceil(goodBulletM*100), 765, 105);
			g.drawString("Cost : " + bulletMovementPrice, 765, 135);
			
			//strings for buying bullet damage
			g.drawString("Buy Bullet Damage", 170, 275);
			g.drawString("Current : " + goodBulletDamage, 170, 310);
			g.drawString("Cost : " + bulletDamagePrice, 170, 345);
			
			//strings for buying side bullet damage
			g.drawString("Buy Side Damage", 765, 275);
			g.drawString("Current : " + sideBulletDamage, 765, 310);
			g.drawString("Cost : " + spreadBulletPrice, 765, 345);
			
			//strings for buying shield health
			g.drawString("Buy Shield Health", 170, 475);
			g.drawString("Current : " + shieldMaxHealth, 170, 510);
			g.drawString("Cost : " + shieldPrice, 170, 545);
			//next round string
			g.drawString("Next Round", 510, 640);
			break;
			
		case 4:
			g.setColor(Color.CYAN);
			g.fillRect(0, 0, 1200, 700);
			g.setColor(Color.yellow);
			g.fillRect(150, 100, 150, 75);
			g.setColor(Color.red);
			g.drawString("Players : " + players, 175, 130);
			
			//making back to stage 1 code
			g.setColor(Color.green);
			g.fillRect(150, 600, 125, 50);
			g.setColor(Color.yellow);
			g.drawString("Back", 180, 630);
			
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//moving good tank
	if(e.getKeyCode() == KeyEvent.VK_LEFT){
		goodTankKeyMovement = 1;

	}
	if(e.getKeyCode() == KeyEvent.VK_RIGHT){
		goodTankKeyMovement = -1;
	}
	if(e.getKeyCode() == KeyEvent.VK_DOWN){
		goodTankKeyMovement = 0;
	}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		mouseV = 0;
		mouseDetectionSettings();
		repaint();
		//firing good tank bullet
		if(stage == 1 && goodBulletV == 0){
			goodBulletV = 1;
			goodBulletY = 540;
			goodBulletX = goodTankX+40;
		}
		if(stage == 1 && tankSideShootLeftV == 0){
			tankSideShootLeftMV = 0;
			tankSideShootLeftV = 1;
			tankSideShootLeftX = goodTankX;
			tankSideShootLeftY = 540;
		}
		if(stage == 1 && tankSideShootRightV == 0){
			tankSideShootRightMV = 0;
			tankSideShootRightV = 1;
			tankSideShootRightX = goodTankX+75;
			tankSideShootRightY = 540;
		}
		
		int x = e.getX();
		int y = e.getY();
		
		MouseY = y;
		MouseX = x;
		
		if(stage == 0){
			if(x > 250 && x < 400 && y > 200 && y < 275){
				stage = 1;
			}
			if(x > 700 && x < 850 && y > 200 && y < 275){
				stage = 4;
			}
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		autoShootV = 1;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		autoShootV = 0;
		
	}
	
	public void update(){

		Thread t = new Thread(){
		public void run(){
		for(int counter = 1; 1 < 2; counter++){
		try{
			//making good tank move properly with key listener
			if(keyMovementX < 50){
				goodTankX+=goodTankMovement;
				keyMovementX++;
			}
			if(keyMovementY < 50){
				goodTankX-=goodTankMovement;
				keyMovementY++;
			}
			if(goodTankX < 0){
				goodTankX+=5 + goodTankMovement;
			}
			if(goodTankX > 1100){
				goodTankX-=5 + goodTankMovement;
			}
			if(shopCooldownClick > 0){
				shopCooldownClick--;
			}
			moveBadTank();
			collisionDetectionInGame();
			shopMouseDetection();
			movingPowerUps();
			powerUpTimeLeft();
			repaint();
			testingVersion();
			keyTestingInGame();
		sleep(13);
		}catch(InterruptedException e){
		e.printStackTrace();
		}
		}
		}
		
		};t.start();}
	
	public void moveBadTank(){
		//moving bad tank randomly
		badTankMV = rr.nextInt(10);
		if(badTankVV == 0){
			if(badTankMV  >= 5){
				badTankVV=-75;
			}else{
				badTankVV=75;
			}
		}
		if(badTankVV > 0){
			badTankX+=2;
			badTankVV--;
		}else{
			badTankX-=2;
			badTankVV++;
		}
		if(badTankX < 0){
			badTankX+=2;
		}
		if(badTankX > 1090){
			badTankX-=2;
		}
		//making bad tank bullet fire
		if(stage == 1 && badBulletV == 0){
			badBulletV = 1;
			badBulletY = 130;
			badBulletX = badTankX+40;
		}
		if(stage == 1 && badTankSideShootLeftV == 0){
			badTankSideShootLeftMV = 1;
			badTankSideShootLeftV = 1;
			badTankSideShootLeftX = badTankX-40;
			badTankSideShootLeftY = 100;
		}
		if(stage == 1 && badTankSideShootRightV == 0){
			badTankSideShootRightMV = 1;
			badTankSideShootRightV = 1;
			badTankSideShootRightX = badTankX+100;
			badTankSideShootRightY = 100;
		}
		//making good tank  side shoot and bullet shoot
		if(stage == 1 && goodBulletV == 0 && autoShootV == 1){
			goodBulletV = 1;
			goodBulletY = 540;
			goodBulletX = goodTankX+40;
		}
		if(stage == 1 && tankSideShootLeftV == 0 && autoShootV == 1){
			tankSideShootLeftMV = 0;
			tankSideShootLeftY = 540;
			tankSideShootLeftX  = goodTankX;
			tankSideShootLeftV = 1;
		}
		if(stage == 1 && tankSideShootRightV == 0 && autoShootV == 1){
			tankSideShootRightMV = 0;
			tankSideShootRightY = 540;
			tankSideShootRightX  = goodTankX+75;
			tankSideShootRightV = 1;
		}
	}
	
	public void collisionDetectionInGame(){
		//collision between good tank and bad tank bullet
		if(badBulletX >goodTankX-20 && badBulletX < goodTankX+80){
			if(badBulletY >550 && badBulletY < 600){
				if(goodTankHitV == 0){
			badBulletY+=150;
			goodTankCurrentHealth-=badBulletDamage;
			goodTankHitV = 1;
				}
			}
		}
	if(badBulletY < 300){
		goodTankHitV = 0;
	}
	//collision between bad tank and good tank bullet
	if(goodBulletX > badTankX-23 && goodBulletX < badTankX+95){
		if(goodBulletY < 150 && goodBulletY > 25){
			if(badTankHitV == 0){
				goodBulletY-=250;
				badTankCurrentHealth-=goodBulletDamage;
				badTankHitV = 1;
				balance+=15*goodBulletDamage;
			}
		}
	}
	if(goodBulletY < -10){
		badTankHitV = 0;
	}
	//collision between good tank bullet LEFT and bad tank
	if(tankSideShootLeftX > badTankX-20 && tankSideShootLeftX < badTankX+87){
		if(tankSideShootLeftY < 150 && tankSideShootLeftY > 25){
			if(badTankHitV == 0){
				tankSideShootLeftY-=250;
				badTankCurrentHealth-=sideBulletDamage;
				badTankHitV=1;
				balance+=15*sideBulletDamage;
			}
		}
	}
	//collision between good tank bullet RIGHT and bad tank
	if(tankSideShootRightX > badTankX-20 && tankSideShootRightX < badTankX+87){
		if(tankSideShootRightY < 150 && tankSideShootRightY > 25){
			if(badTankHitV == 0){
				tankSideShootRightY-=250;
				badTankCurrentHealth-=sideBulletDamage;
				badTankHitV=1;
				balance+=15*sideBulletDamage;
			}
		}
	}
	//collision between shield and bad tank
	if(badBulletX > shieldX && badBulletX < shieldX+300){
		if(badBulletY > 470 && badBulletY < 500){
			if(shieldCurrentHealth > 0){
				shieldCurrentHealth-=badBulletDamage;
				balance+=3;
				badBulletY+=300;
			}
		}
	}
	//collision between bad tank bullet RIGHT and good tank
		if(badTankSideShootRightX > goodTankX-25 && badTankSideShootRightX < goodTankX+110){
			if(badTankSideShootRightY >  550 && badTankSideShootRightY < 600){
				if(goodTankHitVR == 0){
					badTankSideShootRightY += 250;
					goodTankCurrentHealth -= badSideBulletDamage;
					goodTankHitVR = 1;
					
				}
			}
		}
		if(badTankSideShootRightY < 400){
			goodTankHitVR = 0;
		}
	//collision between bad tank bullet LEFT and good tank
	if(badTankSideShootLeftX > goodTankX-25 && badTankSideShootLeftX < goodTankX+110){
		if(badTankSideShootLeftY >  550 && badTankSideShootLeftY < 600){
			if(goodTankHitVL == 0){
				badTankSideShootLeftY += 250;
				goodTankCurrentHealth -= badSideBulletDamage;
				goodTankHitVL = 1;
			}
		}
	}
	if(badTankSideShootLeftY < 400){
		goodTankHitVL = 0;
	}
	
	//collision between bad tank bullet LEFT and shield
	if(badTankSideShootLeftX > shieldX-5 && badTankSideShootLeftX < shieldX+310){
		if(badTankSideShootLeftY > 470 && badTankSideShootLeftY < 500){
			if(shieldCurrentHealth > 0){
				shieldCurrentHealth-=1;
				balance+=3;
				badTankSideShootLeftY+=300;
			}
		}
	}
	
	//collision between bad tank bullet RIGHT and shield
	if(badTankSideShootRightX > shieldX-5 && badTankSideShootRightX < shieldX+310){
		if(badTankSideShootRightY > 470 && badTankSideShootRightY < 500){
			if(shieldCurrentHealth > 0){
				shieldCurrentHealth-=1;
				balance+=3;
				badTankSideShootRightY+=300;
			}
		}
	}
	//collision between good tank and movement speed power up
	if(movementPowerUpX > goodTankX-65 && movementPowerUpX < goodTankX+130){
		if(movementPowerUpY > 520 && movementPowerUpY < 600){
			goodTankMovement=5;
			movementPowerUpY += 250;
			movementTimeLeft = 2500;
		}
	}
	//collision between good tank and bullet speed power up
	if(bulletPowerUpX > goodTankX-65 && bulletPowerUpX < goodTankX+130){
		if(bulletPowerUpY > 520 && bulletPowerUpY < 600){
			goodBulletM+=goodBulletVersion;
			bulletVV = 1;
			bulletPowerUpY += 250;
			bulletTimeLeft = 1750;
		}
	}
	//collision between good tank and health power up
	if(healthPowerUpX > goodTankX-65 && healthPowerUpX < goodTankX+130){
		if(healthPowerUpY > 520 && healthPowerUpY < 600){
			healthPowerUpY += 250;
			if(goodTankCurrentHealth == goodTankMaxHealth-1){
				goodTankCurrentHealth++;
			}else if(goodTankCurrentHealth == goodTankMaxHealth-2){
				goodTankCurrentHealth+=2;
			}else if(goodTankCurrentHealth == goodTankMaxHealth-3){
				goodTankCurrentHealth+=3;
			}else if(goodTankCurrentHealth == goodTankMaxHealth-4){
				goodTankCurrentHealth+=4;
			}else if(goodTankCurrentHealth <= goodTankMaxHealth-5 && goodTankCurrentHealth != goodTankMaxHealth){
				goodTankCurrentHealth+=5;
			}
		}
	}
	}
	
	/*
	g.fillRect(150, 50, 250, 100);
	g.fillRect(750, 50, 250, 100);
	g.fillRect(150, 250, 250, 100);
	g.fillRect(750, 250, 250, 100);
	g.fillRect(150, 450, 250, 100);
	g.fillRect(750, 450, 250, 100);
	  g.fillRect(500, 600, 150, 75);
	*/
	
	public void shopMouseDetection(){
		if(stage == 3 && mouseV == 0 && shopCooldownClick == 0){
			mouseV = 1;
			//buying health
			if(MouseX > 150 && MouseX < 400){
				if(MouseY > 50 && MouseY < 150){
					if(balance >= healthPrice){
						balance-=healthPrice;
						goodTankMaxHealth++;
						healthPrice+=50;
					}
				}
			}
			//buying movement speed
			if(MouseX > 750 && MouseX < 1000){
				if(MouseY > 50 && MouseY < 150){
					if(balance >= bulletMovementPrice){
						balance-=bulletMovementPrice;
						goodBulletM+=bulletAdderV;
						bulletMovementPrice+=150;
					}
				}
			}
			//buying bullet damage
			if(MouseX > 150 && MouseX < 400){
				if(MouseY > 250 && MouseY < 350){
					if(balance >= bulletDamagePrice){
						balance -= bulletDamagePrice;
						goodBulletDamage++;
						bulletDamagePrice += 2000;
					}
				}
			}
			//buying spread shot 
			if(MouseX > 750 && MouseX < 1000){
				if(MouseY > 250 && MouseY < 350){
					if(balance >= spreadBulletPrice){
						balance -= spreadBulletPrice;
						sideBulletDamage++;
						spreadBulletPrice+= 2500;
					}
				}
			}
			//buying shield
			if(MouseX > 150 && MouseX < 400){
				if(MouseY > 450 && MouseY < 550){
					if(balance >= shieldPrice){
						balance -= shieldPrice;
						shieldPrice+=750;
						shieldMaxHealth += 15;
					}
				}
			}
			//starting new round / bad tank upgrades
			if(MouseX > 500 && MouseX < 650){
				if(MouseY > 600 & MouseY < 675){
					//bad tank upgrades and resetting variables for next round 
					badTankMaxHealth += 2;
					goodTankCurrentHealth = goodTankMaxHealth;
					shieldCurrentHealth = shieldMaxHealth;
					badTankCurrentHealth = badTankMaxHealth;
					badBulletM += badBulletAdderV;
					
					//misc changes when next round starts
					goodTankX = 700;
					badTankX = 500;
					currentRound++;
					stage = 1;
				}
			}
		}
	}
	   public void movingPowerUps(){
		   //movement speed power up
		   movementRandomV = rr.nextInt(10000);
		   if(movementRandomV == 1 && movementStart == 0){
			   movementPowerUpY = -100;
			   movementPowerUpX = rr.nextInt(1100);
			   movementStart = 1;
		   }
		   if(movementStart == 1){
			   movementPowerUpY+=2;
			   if(movementPowerUpX < 0){
				   movementDirection = 1;
			   }
			   if(movementPowerUpX > 1110){
				   movementDirection = 0;
			   }
			   if(movementDirection == 1){
				   movementPowerUpX+=2;
			   }else{
				   movementPowerUpX-=2;
			   }
			   if(movementPowerUpY > 800){
				   movementStart = 0;
			   }
		   }
		   
		   //bullet movement power up
		   if(bulletTimeLeft <= 0){
		  bulletRandomV = rr.nextInt(10000);
		   if(bulletRandomV == 1 && bulletStart == 0){
			   bulletPowerUpY = -100;
			   bulletPowerUpX = rr.nextInt(1100);
			   bulletStart = 1;
		   }
		   if(bulletStart == 1){
			   bulletPowerUpY+=2;
			   if(bulletPowerUpX < 0){
				   bulletDirection = 1;
			   }
			   if(bulletPowerUpX > 1110){
				   bulletDirection = 0;
			   }
			   if(bulletDirection == 1){
				   bulletPowerUpX+=2;
			   }else{
				   bulletPowerUpX-=2;
			   }
			   if(bulletPowerUpY > 800){
				   bulletStart = 0;
			   }
		   }
		   }
		   
		   //health power up
		   healthRandomV = rr.nextInt(10000);
		   if(healthRandomV == 1 && healthStart == 0){
			   healthPowerUpY = -100;
			   healthPowerUpX = rr.nextInt(1100);
			   healthStart = 1;
		   }
		   if(healthStart == 1){
			   healthPowerUpY+=2;
			   if(healthPowerUpX < 0){
				   healthDirection = 1;
			   }
			   if(healthPowerUpX > 1110){
				   healthDirection = 0;
			   }
			   if(healthDirection == 1){
				   healthPowerUpX+=2;
			   }else{
				   healthPowerUpX-=2;
			   }
			   if(healthPowerUpY > 800){
				   healthStart = 0;
			   }
		   }
		   
	   }
	   public void powerUpTimeLeft(){
		   //movement speed power up
		   if(movementTimeLeft > 0){
			   movementTimeLeft -= 1;
		   }else{
			   goodTankMovement = 1;
		   }
		   //bullet movement power up
		   if(bulletTimeLeft > 0){
			   bulletTimeLeft -= 1;
		   }
		   if(bulletTimeLeft == 1 && bulletVV == 1){
			   goodBulletM-=goodBulletVersion;
			   bulletVV = 0;
		   }
	   }
	   
	public void testingVersion(){
		if(bulletTestTimer > 0){
			bulletTestTimer--;
		}
		if(bulletTestTimer == 1){
			if(badBY > 150){
				badBulletM = .08;
				goodBulletM = .11;
				badBulletAdderV = .01;
				goodBulletVersion = .015;
				bulletAdderV = .02;
				shieldTestV = 2;
			}else{
				badBulletM = 4;
				goodBulletM = 6;
				bulletAdderV = .2;
				goodBulletVersion = 3;
				badBulletAdderV = .1;
				shieldTestV = 1;
			}
		}
	}
	
	public void keyTestingInGame(){
		if(goodTankKeyMovement == 1){
			goodTankX-=goodTankMovement;
			keyMovementX = 50;
			keyMovementY = 0;
		}
		if(goodTankKeyMovement == -1){
			goodTankX+=goodTankMovement;
			keyMovementY = 50;
			keyMovementX = 0;
		}
		if(goodTankKeyMovement == 0){
			keyMovementX = 0;
			keyMovementY = 0;
		}
	}
	
	public void mouseDetectionSettings(){
		if(stage == 4){
		//toggle players button
		if(MouseX > 150 && MouseX < 300){
			if(MouseY > 100 && MouseY < 175){
				if(players == 1){
					players = 2;
				}else{
					players = 1;
				}
			}
		}
		//back to main menu button
		if(MouseX > 150 && MouseX < 275){
			if(MouseY > 600 && MouseY < 650){
				stage = 0;
			}
		}
	}
	}
}
