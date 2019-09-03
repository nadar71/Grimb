package com.indiewalkabout.grimb;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;

import com.indiewalkabout.grimb.engine.BaseCustomDialog;

/**
 *
 */
public class GrimbBaseFragment extends Fragment {

    BaseCustomDialog mCurrentDialog;

    public void showDialog (BaseCustomDialog newDialog) {
        showDialog(newDialog, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getYassActivity().applyTypeface(view);
        final ViewTreeObserver obs = view.getViewTreeObserver();
        obs.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public synchronized void onGlobalLayout() {
                ViewTreeObserver viewTreeObserver = getView().getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    } else {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    }
                    onLayoutCompleted();
                }
            }
        });
    }

    protected void onLayoutCompleted() {
    }

    public void showDialog (BaseCustomDialog newDialog, boolean dismissOtherDialog) {
        getYassActivity().showDialog(newDialog, dismissOtherDialog);
    }

    public GrimbActivity getYassActivity() {
        return (GrimbActivity) getActivity();
    }

    public void onSignInFailed() {
        
    }

    public void onSignInSucceeded() {

    }

    public boolean onBackPressed() {
        return false;
    }
}
