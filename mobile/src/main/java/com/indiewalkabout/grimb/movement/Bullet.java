package com.indiewalkabout.grimb.movement;

import com.indiewalkabout.grimb.R;
import com.indiewalkabout.grimb.engine.BodyType;
import com.indiewalkabout.grimb.engine.GameEngine;
import com.indiewalkabout.grimb.engine.ScreenGameObject;
import com.indiewalkabout.grimb.engine.Sprite;
import com.indiewalkabout.grimb.sound.GameEvent;

/**
 * Created by Raul Portales on 12/03/15.
 */
public class Bullet extends Sprite {

    private double mSpeedFactor;

    private Player mParent;

    public Bullet(GameEngine gameEngine) {
        super(gameEngine, R.drawable.bullet, BodyType.Rectangular);
        mSpeedFactor = gameEngine.mPixelFactor * -300d / 1000d;
    }

    @Override
    public void startGame(GameEngine gameEngine) {

    }

    @Override
    public void onUpdate(long elapsedMillis, GameEngine gameEngine) {
        mY += mSpeedFactor * elapsedMillis;
        if (mY < -mHeight) {
            removeFromGameEngine(gameEngine);
            gameEngine.onGameEvent(GameEvent.BulletMissed);
        }
    }

    @Override
    public void onRemovedFromGameEngine() {
        mParent.releaseBullet(this);
    }

    public void init(Player parent, double positionX, double positionY) {
        mX = positionX - mWidth /2;
        mY = positionY - mHeight /2;
        mParent = parent;
    }

    @Override
    public void onCollision(GameEngine gameEngine, ScreenGameObject otherObject) {
        if (otherObject instanceof Asteroid) {
            // Remove both from the game (and return them to their pools)
            removeFromGameEngine(gameEngine);
            Asteroid a = (Asteroid) otherObject;
            a.explode(gameEngine);
            a.removeFromGameEngine(gameEngine);
            gameEngine.onGameEvent(GameEvent.AsteroidHit);
            // Add some score
        }
    }
}
