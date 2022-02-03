package fr.ensma.a3.ia.testapp.fragments.login;

import android.app.Fragment;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.testapp.composants.login.ILoginObserver;
import fr.ensma.a3.ia.testapp.composants.login.Login;

public class FragLogin extends Fragment implements ILoginObserver {

    private Login compoLogin;
    private List<ILoginObserver> mesObs = new ArrayList<ILoginObserver>();

    @Override
    public View onCreateView(){

    }

    @Override
    public void loginOk(String user){

    }
}
