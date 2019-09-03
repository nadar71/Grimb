package com.indiewalkabout.grimb.counter;

import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;

import com.indiewalkabout.grimb.R;
import com.indiewalkabout.grimb.engine.GameEngine;
import com.indiewalkabout.grimb.engine.GameObject;
import com.indiewalkabout.grimb.sound.GameEvent;

/**
 *
 */
public class LivesCounter extends GameObject {

    private final LinearLayout mLayout;

    public LivesCounter(View view, int viewResId) {
        mLayout = (LinearLayout) view.findViewById(viewResId);
    }

    @Override
    public void startGame(GameEngine gameEngine) {}

    @Override
    public void onUpdate(long elapsedMillis, GameEngine gameEngine) {}

    @Override
    public void onDraw(Canvas canvas) {}

    @Override
    public void onGameEvent(GameEvent gameEvent) {
        if (gameEvent == GameEvent.LifeLost) {
            mLayout.post(mRemoveLifeRunnable);
        }
        else if (gameEvent == GameEvent.LifeAdded) {
            mLayout.post(mAddLifeRunnable);
        }
    }

    private Runnable mRemoveLifeRunnable = new Runnable() {
        @Override
        public void run() {
            // Remove one life from the layout
            if (mLayout.getChildCount() > 0) {
                mLayout.removeViewAt(mLayout.getChildCount() - 1);
            }
        }
    };

    private Runnable mAddLifeRunnable = new Runnable() {
        @Override
        public void run() {
            // Remove one life from the layout
            View spaceship = View.inflate(mLayout.getContext(), R.layout.view_spaceship, mLayout);
        }
    };
}
