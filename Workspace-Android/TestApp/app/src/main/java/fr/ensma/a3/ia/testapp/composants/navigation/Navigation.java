package fr.ensma.a3.ia.testapp.composants.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.testapp.R;

public class Navigation extends LinearLayout {

    SwitchCompat menuSwitch;
    TextView menuTextView;

    private TypedArray att;
    private List<INavigationObserver> mesObs;

    public Navigation(@NonNull Context context){
        super(context);
        LayoutInflater.from(context).inflate(R.layout.compo_navigation, this);
        mesObs = new ArrayList<INavigationObserver>();
    }

    public Navigation(@NonNull Context context, @NonNull AttributeSet attrs){
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.compo_navigation, this);
        setCompo(context, attrs);
    }

    private void setCompo(Context context, AttributeSet attrs){
        mesObs = new ArrayList<INavigationObserver>();
        att = context.obtainStyledAttributes(attrs, R.styleable.Navigation);
        menuSwitch = (SwitchCompat) findViewById(R.id.switchNav);
        menuTextView = (TextView) findViewById(R.id.descNav);
        menuTextView.setText("Login ...");
    }
}
