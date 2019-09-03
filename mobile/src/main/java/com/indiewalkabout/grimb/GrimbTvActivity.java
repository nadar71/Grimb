package com.indiewalkabout.grimb;

import android.app.Fragment;

import com.indiewalkabout.grimb.tv.GameTvFragment;
import com.indiewalkabout.grimb.tv.MainMenuTvFragment;

/**
 *
 */
public class GrimbTvActivity extends GrimbActivity {

    public void startGame() {
        // Navigate the the game fragment, which makes the start automatically
        navigateToFragment( new GameTvFragment());
    }

    protected Fragment createMenuFragment() {
        return new MainMenuTvFragment();
    }
}
