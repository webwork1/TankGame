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
	public int goodTankX = 500;
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
	
	//extra tank power up
	public int extraTankPowerUpX;
	public int extraTankPowerUpY = -200;
	public int extraTankRandomV;
	public int extraTankStart;
	public int extraTankDirection;
	public int extraTankTimeLeft;
	
	//players in game
	public int players = 1;
	
	//int for pausing
	public int pause = 0;
	
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
	
	//player 2 stuff
	public int goodTankPlayer2X = 700;
	public int goodTank2KeyMovement = 2;
	public int keyMovement2X;
	public int keyMovement2Y;
	
		public double tank2SideShootLeftX;
		public double tank2SideShootLeftY = -200;
		public int tank2SideSLV;
		public int tank2SideSLV2;
		public int tank2SideShootLeftV;
		public int tank2SideShootLeftMV;
		
		public double tank2SideShootRightX;
		public double tank2SideShootRightY = -200;
		public int tank2SideSRV;
		public int tank2SideSRV2;
		public int tank2SideShootRightV;
		public int tank2SideShootRightMV;
		
		public int good2BulletV;
		public double good2BulletY;
		public int good2BY = -200;
		public int good2BulletX;
		
		public int good2TankMaxHealth = 10;
		public int good2TankCurrentHealth = 10;
		public int good2TankHitV;
		
		//extra player stuff
		public int extraTankX = 500;
		public int extragoodTankKeyMovement = 2;
		
		public double extratankSideShootLeftX;
		public double extratankSideShootLeftY = -200;
		public int extratankSideSLV;
		public int extratankSideSLV2;
		public int extratankSideShootLeftV;
		public int extratankSideShootLeftMV;
		
		public double extratankSideShootRightX;
		public double extratankSideShootRightY = -200;
		public int extratankSideSRV;
		public int extratankSideSRV2;
		public int extratankSideShootRightV;
		public int extratankSideShootRightMV;
		
		public int extragoodBulletV;
		public double extragoodBulletY;
		public int extragoodBY = -200;
		public int extragoodBulletX;
		
		public int extraTankMV;
		public int extraTankVV;
		
		//autoshoot variables
		public int autoShoot1;
		public int autoShoot2;

	//images for good tank 1
	Image goodTank;
	Image goodBullet1;
	Image goodBullet2;
	Image tankSideShootLeft;
	Image tankSideShootRight;
	Image tankSideShootLeft2;
	Image tankSideShootRight2;
	Image goodBullet3;
	
	//images for good tank 2
	Image goodTankPlayer2;
	Image good2Bullet1;
	Image good2Bullet2;
	Image tank2SideShootLeft;
	Image tank2SideShootRight;
	Image tank2SideShootLeft2;
	Image tank2SideShootRight2;
	Image good2Bullet3;
	
	//images for extra tank
	Image extragoodTankPlayer;
	Image extragoodBullet1;
	Image extragoodBullet2;
	Image extratankSideShootLeft;
	Image extratankSideShootRight;
	Image extratankSideShootLeft2;
	Image extratankSideShootRight2;
	Image extragoodBullet3;
	
	Image badTank;
	Image badBullet1;
	Image goodTankShield;
	Image badTankSideShootLeft;
	Image badTankSideShootRight;
	Image badBullet2;
	Image movementPowerUp;
	Image bulletPowerUp;
	Image badBullet3;
	Image badBullet4;
	Image healthPowerUp;
	Image badTankSideShootLeft2;
	Image badTankSideShootLeft3;
	Image badTankSideShootRight2;
	Image badTankSideShootRight3;
	Image extraTankPowerUp;
	
	Random rr = new Random();
	
	public void init(){
		
		//init for images
		//pics for good tank 2 ( player 1 )
		goodTank=getImage(getDocumentBase(), "updatedGoodTank.png");
		goodBullet1=getImage(getDocumentBase(), "goodBullet1.png");
		goodBullet2=getImage(getDocumentBase(), "goodBullet2.png");
		tankSideShootLeft=getImage(getDocumentBase(), "tankSideShoot.png");
		tankSideShootRight=getImage(getDocumentBase(), "tankSideShoot.png");
		tankSideShootLeft2=getImage(getDocumentBase(), "tankSideShoot2.png");
		tankSideShootRight2=getImage(getDocumentBase(), "tankSideShoot2.png");
		goodBullet3=getImage(getDocumentBase(), "goodBullet3.png");
		
		badTank=getImage(getDocumentBase(), "badTank.png");
		badBullet1=getImage(getDocumentBase(), "badBullet1.png");
		goodTankShield=getImage(getDocumentBase(), "shield.png");
		badTankSideShootLeft=getImage(getDocumentBase(), "badTankSideShoot.png");
		badTankSideShootRight=getImage(getDocumentBase(), "badTankSideShoot.png");
		badBullet2=getImage(getDocumentBase(), "badBullet2.png");
		movementPowerUp=getImage(getDocumentBase(), "movementPowerUp.png");
		bulletPowerUp=getImage(getDocumentBase(), "bulletPowerUp.png");
		badBullet3=getImage(getDocumentBase(), "badBullet3.png");
		badBullet4=getImage(getDocumentBase(), "badBullet4.png");
		healthPowerUp=getImage(getDocumentBase(), "healthPowerUp.png");
		badTankSideShootLeft2=getImage(getDocumentBase(), "badTankSideShoot2.png");
		badTankSideShootRight2=getImage(getDocumentBase(), "badTankSideShoot2.png");
		badTankSideShootLeft3=getImage(getDocumentBase(), "badTankSideShoot3.png");
		badTankSideShootRight3=getImage(getDocumentBase(), "badTankSideShoot3.png");
		extraTankPowerUp=getImage(getDocumentBase(), "extraTankPowerUp.png");
		
		//pics for good tank 2 ( player 2 )
		 goodTankPlayer2=getImage(getDocumentBase(), "updatedgoodTankPlayer2.png");
		 good2Bullet1=getImage(getDocumentBase(), "goodBullet1.png");
		 good2Bullet2=getImage(getDocumentBase(), "goodBullet2.png");
		 tank2SideShootLeft=getImage(getDocumentBase(), "tankSideShoot.png");
		 tank2SideShootRight=getImage(getDocumentBase(), "tankSideShoot.png");
		 tank2SideShootLeft2=getImage(getDocumentBase(), "tankSideShoot2.png");
		 tank2SideShootRight2=getImage(getDocumentBase(), "tankSideShoot2.png");
		 good2Bullet3=getImage(getDocumentBase(), "goodBullet3.png");
		 
		 //pics for extra tank
			//pics for good tank 2 ( player 2 )
		 extragoodTankPlayer=getImage(getDocumentBase(), "extraTank.png");
		 extragoodBullet1=getImage(getDocumentBase(), "goodBullet1.png");
		 extragoodBullet2=getImage(getDocumentBase(), "goodBullet2.png");
		 extratankSideShootLeft=getImage(getDocumentBase(), "tankSideShoot.png");
		 extratankSideShootRight=getImage(getDocumentBase(), "tankSideShoot.png");
		 extratankSideShootLeft2=getImage(getDocumentBase(), "tankSideShoot2.png");
		 extratankSideShootRight2=getImage(getDocumentBase(), "tankSideShoot2.png");
		 extragoodBullet3=getImage(getDocumentBase(), "goodBullet3.png");
		
		this.addMouseListener(this);
		this.addKeyListener(this);
		
	}
	
	public void paint(Graphics g){
		
		setFont(new Font("Serif", Font.BOLD, 25)); 
		setSize(1200, 700);
		switch(stage){
		
		case 0:
			//starting update function
			if(UpdateV == 0){
				update();
				UpdateV++;
				}
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
			if(pause == 0){
			//player 2 tank stuff
			//game (playing) state
			g.setColor(Color.ORANGE);
			g.fillRect(0, 0, 1200, 700);
			g.drawImage(goodTank, goodTankX,550,this);
			g.setColor(Color.red);
			
			//BEGIN PLAYER 2 STUFF
			if(players == 2){
				g.drawImage(goodTankPlayer2, goodTankPlayer2X, 550, this);
				if(goodBulletDamage == 1){
					g.drawImage(good2Bullet1, good2BulletX, good2BY, this);
					}else{
						g.drawImage(good2Bullet1, -100, -100, this);
					}
					if(goodBulletDamage == 2){
					g.drawImage(good2Bullet2, good2BulletX, good2BY, this);
					}
					if(goodBulletDamage >= 3){
					g.drawImage(good2Bullet3, good2BulletX, good2BY, this);
					}
					
					if(sideBulletDamage == 1){
						g.drawImage(tank2SideShootLeft, tank2SideSLV2, tank2SideSLV, this);
						g.drawImage(tank2SideShootRight, tank2SideSRV2, tank2SideSRV, this);
					
					}else{
						g.drawImage(tank2SideShootLeft, -100, -100, this);
						g.drawImage(tank2SideShootRight, -100, -100, this);
					
					}
					if(sideBulletDamage >= 2){				
						g.drawImage(tank2SideShootLeft2, tank2SideSLV2, tank2SideSLV, this);
						g.drawImage(tank2SideShootRight2, tank2SideSRV2, tank2SideSRV, this);
					}
					
					if(good2BulletV == 1){
						good2BulletY-=goodBulletM;
						good2BY = (int) (Math.ceil(good2BulletY));
					}
					if(good2BY < -250){
						good2BulletV = 0;
					}
					
					g.setColor(Color.gray);
					g.fillRect(350, 675, 100, 25);
		 			g.setColor(Color.blue);
					g.fillRect(350, 675, good2TankCurrentHealth*100/good2TankMaxHealth, 25);
					g.setColor(Color.black);
					g.drawString(good2TankCurrentHealth + " / " + good2TankMaxHealth, 360, 695);
			}
			//PLAYER 2 STUFF END
			//EXTRA PLAYER STUFF STARTS
			if(extraTankTimeLeft > 0){
				g.drawImage(extragoodTankPlayer, extraTankX, 550, this);
				if(goodBulletDamage == 1){
					g.drawImage(extragoodBullet1, extragoodBulletX, extragoodBY, this);
					}else{
						g.drawImage(extragoodBullet1, -100, -100, this);
					}
					if(goodBulletDamage == 2){
					g.drawImage(extragoodBullet2, extragoodBulletX, extragoodBY, this);
					}
					if(goodBulletDamage >= 3){
					g.drawImage(extragoodBullet3, extragoodBulletX, extragoodBY, this);
					}
					
					if(sideBulletDamage == 1){
						g.drawImage(extratankSideShootLeft, extratankSideSLV2, extratankSideSLV, this);
						g.drawImage(extratankSideShootRight, extratankSideSRV2, extratankSideSRV, this);
					
					}else{
						g.drawImage(extratankSideShootLeft, -100, -100, this);
						g.drawImage(extratankSideShootRight, -100, -100, this);
					
					}
					if(sideBulletDamage >= 2){				
						g.drawImage(extratankSideShootLeft2, extratankSideSLV2, extratankSideSLV, this);
						g.drawImage(extratankSideShootRight2, extratankSideSRV2, extratankSideSRV, this);
					}
					
					if(extragoodBulletV == 1){
						extragoodBulletY-=goodBulletM;
						extragoodBY = (int) (Math.ceil(extragoodBulletY));
					}
					if(extragoodBY < -250){
						extragoodBulletV = 0;
					}
			}
			//EXTRA PLAYER STUFF ENDS
			if(goodBulletDamage == 1){
			g.drawImage(goodBullet1, goodBulletX, goodBY, this);
			}else{
				g.drawImage(goodBullet1, -100, -100, this);
			}
			if(goodBulletDamage == 2){
			g.drawImage(goodBullet2, goodBulletX, goodBY, this);
			}
			if(goodBulletDamage >= 3){
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
			
			//PLAYER 2 
			if(tank2SideShootLeftV == 1){
				tank2SideShootLeftY -= goodBulletM;
				tank2SideSLV2 =(int) (Math.ceil(tank2SideShootLeftX));
				tank2SideSLV = (int) (Math.ceil(tank2SideShootLeftY));
			}
			if(tank2SideShootLeftY < -250){
				tank2SideShootLeftV = 0;
			}
			if(tank2SideShootLeftX <= 0){
				tank2SideShootLeftMV = 1;
				
			}
			if(tank2SideShootLeftMV == 0){
				tank2SideShootLeftX -= goodBulletM + .03;
			}else{
				tank2SideShootLeftX += goodBulletM - .03;
			}
			
			if(tank2SideShootRightV == 1){
				tank2SideShootRightY -= goodBulletM;
				tank2SideSRV2 =(int) (Math.ceil(tank2SideShootRightX));
				tank2SideSRV = (int) (Math.ceil(tank2SideShootRightY));
			}
			if(tank2SideShootRightY < -250){
				tank2SideShootRightV = 0;
			}
			if(tank2SideShootRightX > 1200){
				tank2SideShootRightMV = 1;
				
			}
			if(tank2SideShootRightMV == 0){
				tank2SideShootRightX += goodBulletM - .03;
			}else{
				tank2SideShootRightX -= goodBulletM + .03;
			}
			
			//EXTRA GOOD PLAYER
			if(extraTankTimeLeft > 0){
			if(extratankSideShootLeftV == 1){
				extratankSideShootLeftY -= goodBulletM;
				extratankSideSLV2 =(int) (Math.ceil(extratankSideShootLeftX));
				extratankSideSLV = (int) (Math.ceil(extratankSideShootLeftY));
			}
			if(extratankSideShootLeftY < -250){
				extratankSideShootLeftV = 0;
			}
			if(extratankSideShootLeftX <= 0){
				extratankSideShootLeftMV = 0;
				
			}
			if(extratankSideShootLeftMV == 1){
				extratankSideShootLeftX -= goodBulletM + .03;
			}else{
				extratankSideShootLeftX += goodBulletM - .03;
			}
			
			if(extratankSideShootRightV == 1){
				extratankSideShootRightY -= goodBulletM;
				extratankSideSRV2 =(int) (Math.ceil(extratankSideShootRightX));
				extratankSideSRV = (int) (Math.ceil(extratankSideShootRightY));
			}
			if(extratankSideShootRightY < -250){
				extratankSideShootRightV = 0;
			}
			if(extratankSideShootRightX > 1200){
				extratankSideShootRightMV = 0;
				
			}
			if(extratankSideShootRightMV == 1){
				extratankSideShootRightX += goodBulletM - .03;
			}else{
				extratankSideShootRightX -= goodBulletM + .03;
			}
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
			if(shieldTestV == 1){
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
			g.drawString("Time Remaining : " + bulletTimeLeft, 25, 665);
			}
			if(extraTankTimeLeft > 0){
				g.setColor(Color.white);
			g.drawString("Time Remaining : " + extraTankTimeLeft, 25, 635);
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
			if(good2TankCurrentHealth <=2 && players == 2){
				stage = 2;
			}
			//POWER UPS
			g.drawImage(movementPowerUp, movementPowerUpX, movementPowerUpY, this);
			g.drawImage(bulletPowerUp, bulletPowerUpX, bulletPowerUpY, this);
			g.drawImage(healthPowerUp, healthPowerUpX, healthPowerUpY, this);
			g.drawImage(extraTankPowerUp, extraTankPowerUpX, extraTankPowerUpY, this);
			}else{
				g.setColor(Color.BLACK);
				g.drawString("Paused", 500, 300);
			}
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
		//moving good tank 1
	if(e.getKeyCode() == KeyEvent.VK_LEFT){
		goodTankKeyMovement = 1;

	}
	if(e.getKeyCode() == KeyEvent.VK_RIGHT){
		goodTankKeyMovement = -1;
	}
	if(e.getKeyCode() == KeyEvent.VK_DOWN){
		goodTankKeyMovement = 0;
	}
	//moving player 2
	if(e.getKeyCode() == KeyEvent.VK_A){
		goodTank2KeyMovement = 1;
	}
	if(e.getKeyCode() == KeyEvent.VK_D){
		goodTank2KeyMovement = -1;
	}
	if(e.getKeyCode() == KeyEvent.VK_S){
		goodTank2KeyMovement = 0;
	}
	if(e.getKeyCode() == KeyEvent.VK_P){
		if(stage == 1){
		if(pause == 1){
			pause = 0;
		}else{
			pause = 1;
			repaint();
		}
		}
		
	}
	if(e.getKeyCode() == KeyEvent.VK_SPACE){
		autoShoot1 = 1;
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
	}
	if(e.getKeyCode() == KeyEvent.VK_SHIFT){
		autoShoot2 = 1;
		if(stage == 1 && good2BulletV == 0){
			good2BulletV = 1;
			good2BulletY = 540;
			good2BulletX = goodTankPlayer2X+40;
		}
		if(stage == 1 && tank2SideShootLeftV == 0){
			tank2SideShootLeftMV = 0;
			tank2SideShootLeftV = 1;
			tank2SideShootLeftX = goodTankPlayer2X;
			tank2SideShootLeftY = 540;
		}
		if(stage == 1 && tank2SideShootRightV == 0){
			tank2SideShootRightMV = 0;
			tank2SideShootRightV = 1;
			tank2SideShootRightX = goodTankPlayer2X+75;
			tank2SideShootRightY = 540;
		}
	}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		//stopping autoshoot for player 1
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			autoShoot1=0;
		}
		//stopping autoshoot for player 2
		if(e.getKeyCode() == KeyEvent.VK_SHIFT){
			autoShoot2=0;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		mouseV = 0;
		repaint();
		//firing good tank bullet
		
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
		if(stage == 4){
			if(x > 150 && x < 300){
				if(y > 100 && y < 175){
					if(players == 1){
						players = 2;
					}else{
						players = 1;
					}
				}
			}
			//back to main menu button
			if(x > 150 && x < 275){
				if(y > 600 && y < 650){
					stage = 0;
				}
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
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
	}
	
	public void update(){

		Thread t = new Thread(){
		public void run(){
		for(int counter = 1; 1 < 2; counter++){
		try{
			if(pause == 0){
			//making good tank move properly with key listener
			if(keyMovementX < 50){
				goodTankX+=goodTankMovement;
				keyMovementX=50;
			}
			if(keyMovementY < 50){
				goodTankX-=goodTankMovement;
				keyMovementY=50;
			}
			if(goodTankX < 0){
				goodTankX+=5 + goodTankMovement;
			}
			if(goodTankX > 1100){
				goodTankX-=5 + goodTankMovement;
			}
			
			//making good tank 2 move properly with key listener
			
			if(keyMovement2X < 50){
				goodTankPlayer2X+=goodTankMovement;
				keyMovement2X=50;
			}
			if(keyMovement2Y < 50){
				goodTankPlayer2X-=goodTankMovement;
				keyMovement2Y=50;
			}
			if(goodTankPlayer2X < 0){
				goodTankPlayer2X+=5 + goodTankMovement;
			}
			if(goodTankPlayer2X > 1100){
				goodTankPlayer2X-=5 + goodTankMovement;
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
			autoShooting();
		}
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
		
		//moving extra tank randomly
		extraTankMV = rr.nextInt(10);
		if(extraTankVV == 0){
			if(extraTankMV  >= 5){
				extraTankVV=-75;
			}else{
				extraTankVV=75;
			}
		}
		if(extraTankVV > 0){
			extraTankX+=2;
			extraTankVV--;
		}else{
			extraTankX-=2;
			extraTankVV++;
		}
		if(extraTankX < 0){
			extraTankX+=2;
		}
		if(extraTankX > 1090){
			extraTankX-=2;
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
		
		//making extra tank fire
		if(stage == 1 && extragoodBulletV == 0){
			extragoodBulletV = 1;
			extragoodBulletY = 540;
			extragoodBulletX = extraTankX+40;
		}
		if(stage == 1 && extratankSideShootLeftV == 0){
			extratankSideShootLeftMV = 1;
			extratankSideShootLeftV = 1;
			extratankSideShootLeftX = extraTankX-40;
			extratankSideShootLeftY = 600;
		}
		if(stage == 1 && extratankSideShootRightV == 0){
			extratankSideShootRightMV = 1;
			extratankSideShootRightV = 1;
			extratankSideShootRightX = extraTankX+100;
			extratankSideShootRightY = 600;
		}
		
	}
	
	public void collisionDetectionInGame(){
		//collision between good tank and bad tank bullet
		if(badBulletX >goodTankX-25 && badBulletX < goodTankX+85){
			if(badBulletY > 550 && badBulletY < 600){
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
				balance+=15*goodBulletDamage+1000;
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
			balance+=50;
			goodTankMovement=3;
			movementPowerUpY += 250;
			movementTimeLeft = 1750;
		}
	}
	//collision between good tank and bullet speed power up
	if(bulletPowerUpX > goodTankX-65 && bulletPowerUpX < goodTankX+130){
		if(bulletPowerUpY > 520 && bulletPowerUpY < 600){
			balance+=50;
			goodBulletM+=goodBulletVersion;
			bulletVV = 1;
			bulletPowerUpY += 250;
			bulletTimeLeft = 2500;
		}
	}
	//collision between good tank and health power up
	if(healthPowerUpX > goodTankX-65 && healthPowerUpX < goodTankX+130){
		if(healthPowerUpY > 520 && healthPowerUpY < 600){
			balance+=50;
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
	//collision between good tank and extra tank power up
	if(extraTankPowerUpX > goodTankX-65 && extraTankPowerUpX < goodTankX+130){
		if(extraTankPowerUpY > 520 && extraTankPowerUpY < 600){
			balance+=50;
			extraTankPowerUpY += 250;
			extraTankTimeLeft = 2500;
		}
	}
	
	//EXTRA PLAYER COLLISION STUFF
	
	//collision between good tank EXTRA bullet LEFT and bad tank
	if(extratankSideShootLeftX > badTankX-20 && extratankSideShootLeftX < badTankX+87){
		if(extratankSideShootLeftY < 150 && extratankSideShootLeftY > 25){
			if(badTankHitV == 0){
				extratankSideShootLeftY-=250;
				badTankCurrentHealth-=sideBulletDamage;
				badTankHitV=1;
				balance+=15*sideBulletDamage;
			}
		}
	}
	//collision between good tank EXTRA bullet RIGHT and bad tank
	if(extratankSideShootRightX > badTankX-20 && extratankSideShootRightX < badTankX+87){
		if(extratankSideShootRightY < 150 && extratankSideShootRightY > 25){
			if(badTankHitV == 0){
				extratankSideShootRightY-=250;
				badTankCurrentHealth-=sideBulletDamage;
				badTankHitV=1;
				balance+=15*sideBulletDamage;
			}
		}
	}
	
	//collision between bad tank and good tank EXTRA bullet
	if(extragoodBulletX > badTankX-23 && extragoodBulletX < badTankX+95){
		if(extragoodBulletY < 150 && extragoodBulletY > 25){
			if(badTankHitV == 0){
				extragoodBulletY-=250;
				badTankCurrentHealth-=goodBulletDamage;
				badTankHitV = 1;
				balance+=15*goodBulletDamage;
			}
		}
	}
	
	
	//PLAYER 2 COLLISION DETECTION STUFF
	
	
	//collision between good tank and extra tank power up
	if(extraTankPowerUpX > goodTankPlayer2X-65 && extraTankPowerUpX < goodTankPlayer2X+130){
		if(extraTankPowerUpY > 520 && extraTankPowerUpY < 600){
			balance+=50;
			extraTankPowerUpY += 250;
			extraTankTimeLeft = 2500;
		}
	}
	
	//collision between good tank PLAYER 2 and bad tank bullet
	if(badBulletX >goodTankPlayer2X-25 && badBulletX < goodTankPlayer2X+85){
		if(badBulletY >550 && badBulletY < 600){
			if(good2TankHitV == 0){
		badBulletY+=150;
		good2TankCurrentHealth-=badBulletDamage;
		good2TankHitV = 1;
			}
		}
	}
if(badBulletY < 300){
	good2TankHitV = 0;
}
//collision between bad tank and good tank PLAYER 2 bullet
if(good2BulletX > badTankX-23 && good2BulletX < badTankX+95){
	if(good2BulletY < 150 && good2BulletY > 25){
		if(badTankHitV == 0){
			good2BulletY-=250;
			badTankCurrentHealth-=goodBulletDamage;
			badTankHitV = 1;
			balance+=15*goodBulletDamage;
		}
	}
}
if(good2BulletY < -10){
	badTankHitV = 0;
}

//collision between good tank PLAYER 2 bullet LEFT and bad tank
if(tank2SideShootLeftX > badTankX-20 && tank2SideShootLeftX < badTankX+87){
	if(tank2SideShootLeftY < 150 && tank2SideShootLeftY > 25){
		if(badTankHitV == 0){
			tank2SideShootLeftY-=250;
			badTankCurrentHealth-=sideBulletDamage;
			badTankHitV=1;
			balance+=15*sideBulletDamage;
		}
	}
}
//collision between good tank PLAYER 2 bullet RIGHT and bad tank
if(tank2SideShootRightX > badTankX-20 && tank2SideShootRightX < badTankX+87){
	if(tank2SideShootRightY < 150 && tank2SideShootRightY > 25){
		if(badTankHitV == 0){
			tank2SideShootRightY-=250;
			badTankCurrentHealth-=sideBulletDamage;
			badTankHitV=1;
			balance+=15*sideBulletDamage;
		}
	}
}

//collision between bad tank bullet RIGHT and good tank PLAYER 2
if(badTankSideShootRightX > goodTankPlayer2X-25 && badTankSideShootRightX < goodTankPlayer2X+110){
	if(badTankSideShootRightY >  550 && badTankSideShootRightY < 600){
		if(goodTankHitVR == 0){
			badTankSideShootRightY += 250;
			good2TankCurrentHealth -= badSideBulletDamage;
			goodTankHitVR = 1;
			
		}
	}
}
if(badTankSideShootRightY < 400){
	goodTankHitVR = 0;
}
//collision between bad tank bullet LEFT and good tank PLAYER 2
if(badTankSideShootLeftX > goodTankPlayer2X-25 && badTankSideShootLeftX < goodTankPlayer2X+110){
if(badTankSideShootLeftY >  550 && badTankSideShootLeftY < 600){
	if(goodTankHitVL == 0){
		badTankSideShootLeftY += 250;
		good2TankCurrentHealth -= badSideBulletDamage;
		goodTankHitVL = 1;
	}
}
}
if(badTankSideShootLeftY < 400){
goodTankHitVL = 0;
}

//collision between good tank and movement speed power up PLAYER 2 
if(movementPowerUpX > goodTankPlayer2X-65 && movementPowerUpX < goodTankPlayer2X+130){
	if(movementPowerUpY > 520 && movementPowerUpY < 600){
		balance+=50;
		goodTankMovement=3;
		movementPowerUpY += 250;
		movementTimeLeft = 1750;
	}
}
//collision between good tank and bullet speed power up PLAYER 2
if(bulletPowerUpX > goodTankPlayer2X-65 && bulletPowerUpX < goodTankPlayer2X+130){
	if(bulletPowerUpY > 520 && bulletPowerUpY < 600){
		balance+=50;
		goodBulletM+=goodBulletVersion;
		bulletVV = 1;
		bulletPowerUpY += 250;
		bulletTimeLeft = 2500;
	}
}
//collision between good tank and health power up PLAYER 2
if(healthPowerUpX > goodTankPlayer2X-65 && healthPowerUpX < goodTankPlayer2X+130){
	if(healthPowerUpY > 520 && healthPowerUpY < 600){
		balance+=50;
		healthPowerUpY += 250;
		if(good2TankCurrentHealth == good2TankMaxHealth-1){
			good2TankCurrentHealth++;
		}else if(good2TankCurrentHealth == good2TankMaxHealth-2){
			good2TankCurrentHealth+=2;
		}else if(good2TankCurrentHealth == good2TankMaxHealth-3){
			good2TankCurrentHealth+=3;
		}else if(good2TankCurrentHealth == good2TankMaxHealth-4){
			good2TankCurrentHealth+=4;
		}else if(good2TankCurrentHealth <= good2TankMaxHealth-5 && good2TankCurrentHealth != good2TankMaxHealth){
			good2TankCurrentHealth+=5;
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
						goodTankMaxHealth+=2;
						good2TankMaxHealth+=2;
						healthPrice+=75;
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
					good2TankCurrentHealth = good2TankMaxHealth;
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
		   
		   //extra tank power up
		   if(extraTankTimeLeft <= 0){
		  extraTankRandomV = rr.nextInt(10000);
		   if(extraTankRandomV == 1 && extraTankStart == 0){
			   extraTankPowerUpY = -100;
			   extraTankPowerUpX = rr.nextInt(1100);
			   extraTankStart = 1;
		   }
		   if(extraTankStart == 1){
			   extraTankPowerUpY+=2;
			   if(extraTankPowerUpX < 0){
				   extraTankDirection = 1;
			   }
			   if(extraTankPowerUpX > 1110){
				   extraTankDirection = 0;
			   }
			   if(extraTankDirection == 1){
				   extraTankPowerUpX+=2;
			   }else{
				   extraTankPowerUpX-=2;
			   }
			   if(extraTankPowerUpY > 800){
				   extraTankStart = 0;
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
		   //extra tank power up
		   if(extraTankTimeLeft > 0){
			   extraTankTimeLeft -= 1;
		   }
		   if(extraTankTimeLeft == 1){
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
				goodBulletVersion = .3;
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
		if(goodTank2KeyMovement == 1){
			goodTankPlayer2X-=goodTankMovement;
			keyMovement2Y = 0;
			keyMovement2X = 50;
		}
		if(goodTank2KeyMovement == -1){
			goodTankPlayer2X+=goodTankMovement;
			keyMovement2Y = 50;
			keyMovement2X = 0;
		}
	}
	public void autoShooting(){
		//auto shoot for player 1
		if(autoShoot1 == 1){
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
		}
		//auto shoot for player 2
		if(autoShoot2 == 1){
			if(stage == 1 && good2BulletV == 0){
				good2BulletV = 1;
				good2BulletY = 540;
				good2BulletX = goodTankPlayer2X+40;
			}
			if(stage == 1 && tank2SideShootLeftV == 0){
				tank2SideShootLeftMV = 0;
				tank2SideShootLeftV = 1;
				tank2SideShootLeftX = goodTankPlayer2X;
				tank2SideShootLeftY = 540;
			}
			if(stage == 1 && tank2SideShootRightV == 0){
				tank2SideShootRightMV = 0;
				tank2SideShootRightV = 1;
				tank2SideShootRightX = goodTankPlayer2X+75;
				tank2SideShootRightY = 540;
			}
		}
	}
}
