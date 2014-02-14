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
	public int round;
	public int keyMovementX;
	public int keyMovementY;
	public int UpdateV;
	
	//good tank variables
	public int goodTankX;
	
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
	
	//good bullet movement speed
	public double goodBulletM =.15;
	public int badTankX;
	public int badTankMV;
	public int badTankVV;
	
	//bad tank bullet variables
	public int badBulletX;
	public int badBY = -200;
	public int badBulletV;
	public double badBulletY;
	
	//bad Bullet movement speed
	public double badBulletM = .1;
	
	//bad tank bullet random firing variable
	public int badBR;
	
	//good tank health and collision variables
	public int goodTankMaxHealth = 10;
	public int goodTankCurrentHealth = 10;
	public int goodTankHitV;
	
	//bad tank health and collision variables
	public int badTankMaxHealth = 10;
	public int badTankCurrentHealth = 10;
	public int badTankHitV;
	
	//shop items cost
	public int healthPrice=50;
	public int bulletMovementPrice=75;
	public int bulletDamagePrice=500;
	public int spreadBulletPrice = 1500;
	
	//x and y variables to access mouse cordinates
	public int MouseX;
	public int MouseY;
	public int mouseV = 1;
	//balance player accumulates throught play state
	public int balance = 10000;
	
	//variable for auto shoot
	public int autoShootV;
	
	//current round of game state
	public int currentRound = 1;
	
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
			if(goodBulletDamage >= 2){
			g.drawImage(goodBullet2, goodBulletX, goodBY, this);
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
			
			//drawing bad tank stuff
			g.drawImage(badTank, badTankX, 10, this);
			g.drawImage(badBullet1, badBulletX, badBY, this);
			
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
			
			//testing for game over state
			if(badTankCurrentHealth <= 0){
				balance+=goodTankCurrentHealth;
				stage = 3;
			}
			if(goodTankCurrentHealth <= 0){
				stage = 2;
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
			g.drawString("Current Balance : " + balance, 550, 25);
			
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
			
			//next round string
			g.drawString("Next Round", 510, 640);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//moving good tank
	if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT){
		goodTankX-=2;
		keyMovementX = 50;
		keyMovementY = 0;

	}
	if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT){
		goodTankX+=2;
		keyMovementY = 50;
		keyMovementX = 0;
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
		shopMouseDetection();
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
				goodTankX+=2;
				keyMovementX++;
			}
			if(keyMovementY < 50){
				goodTankX-=2;
				keyMovementY++;
			}
			if(goodTankX < 0){
				goodTankX+=4;
			}
			if(goodTankX > 1100){
				goodTankX-=4;
			}
			moveBadTank();
			collisionDetectionInGame();
			repaint();
			
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
			goodTankCurrentHealth-=1;
			goodTankHitV = 1;
				}
			}
		}
	if(badBulletY < 300){
		goodTankHitV = 0;
	}
	//collision between bad tank and good tank bullet
	if(goodBulletX > badTankX-20 && goodBulletX < badTankX+87){
		if(goodBulletY < 150 && goodBulletY > 25){
			if(badTankHitV == 0){
				goodBulletY-=250;
				badTankCurrentHealth-=goodBulletDamage;
				badTankHitV = 1;
				balance+=12*goodBulletDamage;
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
				balance+=12*goodBulletDamage;
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
				balance+=12*goodBulletDamage;
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
		if(stage == 3 && mouseV == 0){
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
						goodBulletM+=.01;
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
						spreadBulletPrice+= 5000;
					}
				}
			}
			//starting new round / bad tank upgrades
			if(MouseX > 500 && MouseX < 650){
				if(MouseY > 600 & MouseY < 675){
					//bad tank upgrades
					badTankMaxHealth += 2;
					goodTankCurrentHealth = goodTankMaxHealth;
					badTankCurrentHealth = badTankMaxHealth;
					badBulletM += .01;
					
					//misc changes when next round starts
					goodTankX = 700;
					badTankX = 500;
					currentRound++;
					stage = 1;
				}
			}
		}
	}
	   
}
