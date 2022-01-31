package fr.ensma.a3.ia.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import fr.ensma.a3.ia.testapp.fragments.login.FragLogin;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button monBouton;
    private EditText chp1;
    private TextView chp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monBouton = (Button) findViewById(R.id.UnBouton);
        monBouton.setOnClickListener(this);
        chp1 = (EditText) findViewById(R.id.champText);
        chp2 = (TextView) findViewById(R.id.unLabel);

        getSupportFragmentManager().beginTransaction().replace(
                R.id.fragmentLayout, new FragLogin(), "FragLogin_Tag"
        ).addToBackStack(null).commit();

        getSupportFragmentManager().executePendingTransactions();

    }

    @Override
    public void onClick(View view) {
        chp2.setText(chp1.getText());
        Log.i("TestApp", "onClick: sur le Bouton");
    }
}