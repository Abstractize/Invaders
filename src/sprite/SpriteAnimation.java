package sprite;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import timer.Timer;

public class SpriteAnimation {
	
	private ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();
	private byte currentSprite;
	
	private boolean loop = false;
	private boolean play = false;
	private boolean destroyAfterAnim = false;
	
	private Timer timer;
	private int animationSpeed;
	private double xPos, yPos;
	//private int width, height;
	private int limit;
	
	public SpriteAnimation(double xPos, double yPos,int animationSpeed, String imgPath) {
		this.setAnimationSpeed(animationSpeed);
		this.setxPos(xPos);
		this.setyPos(yPos);
		
		timer = new Timer();
		
	}
	public void draw(Graphics2D g) {
		if (isSpriteAnimDestroyed())
			return;
		
		g.drawImage(sprites.get(currentSprite), (int) getxPos() , (int) getyPos(), null);
	}
	public void update(double delta) {
		if (isSpriteAnimDestroyed())
			return;
		if (loop && !play)
			loopAnimation();
		if (play && !loop);
			playAnimation();
	}
	
	public void stopAnimation() {
		setLoop(false);
		setPlay(false);
	}
	public void resetSprite() {
		setLoop(false);
		setPlay(false);
		currentSprite = 0;
	}
	
	private void loopAnimation() {
		if(timer.isTimerReady(animationSpeed) && currentSprite == sprites.size()-1) {
			currentSprite = 0;
			timer.resetTimer();
		} else if(timer.timerEvent(animationSpeed) && currentSprite != sprites.size()-1) {
			currentSprite++;
		}
	}
	private void playAnimation() {
		if (timer.isTimerReady(animationSpeed) && currentSprite != limit && !isDestroyAfterAnim()) {
			play = false;
			currentSprite = 0;
		} else if (timer.isTimerReady(animationSpeed) && currentSprite == limit && isDestroyAfterAnim()) {
			sprites = null;
		}else if (timer.timerEvent(animationSpeed) && currentSprite != limit) {
			currentSprite++;
		}
	}
	public boolean isSpriteAnimDestroyed() {
		if (sprites == null)
			return true;

		return false;
	}
	public void addSprite(BufferedImage spriteMap, int xPos, int yPos, int width, int height) {
		sprites.add(spriteMap.getSubimage(xPos, yPos, width, height));
		
	}
	
	
	public void PlayerAnimation(boolean play, boolean destroyAfterAnim) {
		this.setPlay(play);
		this.setDestroyAfterAnim(destroyAfterAnim);
	}
	public boolean Loop() {
		return loop;
	}
	public void setLoop(boolean loop) {
		this.loop = loop;
	}
	public boolean isPlay() {
		return play;
	}
	public void setPlay(boolean play) {
		this.play = play;
	}
	public double getyPos() {
		return yPos;
	}
	public void setyPos(double yPos) {
		this.yPos = yPos;
	}
	public double getxPos() {
		return xPos;
	}
	public void setxPos(double xPos) {
		this.xPos = xPos;
	}
	public boolean isDestroyAfterAnim() {
		return destroyAfterAnim;
	}
	public void setDestroyAfterAnim(boolean destroyAfterAnim) {
		this.destroyAfterAnim = destroyAfterAnim;
	}
	public int getAnimationSpeed() {
		return animationSpeed;
	}
	public void setAnimationSpeed(int animationSpeed) {
		this.animationSpeed = animationSpeed;
	}

}
