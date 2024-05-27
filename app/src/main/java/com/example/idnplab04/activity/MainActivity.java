package com.example.idnplab04.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.idnplab04.R;
import com.example.idnplab04.entity.AccountEntity;
import com.example.idnplab04.fragment.AccountFragment;
import com.example.idnplab04.fragment.LoginFragment;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private LoginFragment loginFragment;
    private AccountFragment accountFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loginFragment = new LoginFragment();
        accountFragment = new AccountFragment();

        //Open Login fragment
        openLoginFragment(null);

    }

    public void replaceToAccountFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main, accountFragment)
                .addToBackStack(null)
                .commit();

    }


    //Open Login fragment
    public void openLoginFragment(AccountEntity accountEntity) {
        if(accountEntity != null) {
            //Show Activity afte invoque fillFields method
            loginFragment.fillInputFields(accountEntity);
        }

        getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main, loginFragment)
                    .addToBackStack(null)
                    .commit();
        }

    }
}