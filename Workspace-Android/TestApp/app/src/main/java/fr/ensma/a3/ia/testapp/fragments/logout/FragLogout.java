package fr.ensma.a3.ia.testapp.fragments.logout;

import android.app.Fragment;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.core.view.GestureDetectorCompat;

public class FragLogout extends Fragment implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    GestureDetectorCompat mDetector;
    ImageView imageBye;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        imageBye = (ImageView) getActivity().findViewById(R.id.imageLog);
        mDetector = new GestureDetectorCompat(getActivity(), this);
        mDetector.setOnDoubleTapListener(this);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mDetector.onTouchEvent(motionEvent);
                return true;
            }
        });
    }

    public void addObserver(){}

}
