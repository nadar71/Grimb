package com.indiewalkabout.grimb;

import android.view.View;

import com.indiewalkabout.grimb.counter.GameFragment;
import com.indiewalkabout.grimb.engine.BaseCustomDialog;

/**
 *
 */
public class GameOverDialog extends BaseCustomDialog implements View.OnClickListener {

    private GameOverDialogListener mListener;
    private int mSelectedId;

    public GameOverDialog(GameFragment parent) {
        super(parent.getYassActivity());
        setContentView(R.layout.dialog_game_over);
        findViewById(R.id.btn_exit).setOnClickListener(this);
        findViewById(R.id.btn_resume).setOnClickListener(this);
     }

    public void setListener (GameOverDialogListener listener) {
        mListener = listener;
    }

    @Override
    public void dismiss() {
        super.dismiss();
        mSelectedId = R.id.btn_exit;
    }

    @Override
    public void onClick(View v) {
        mSelectedId = v.getId();
        super.dismiss();
    }

    @Override
    protected void onDismissed() {
        if (mSelectedId == R.id.btn_exit) {
            mListener.exitGame();
        }
        else if (mSelectedId == R.id.btn_resume) {
            mListener.startNewGame();
        }
    }

    public interface GameOverDialogListener {
        void exitGame();

        void startNewGame();
    }
}
