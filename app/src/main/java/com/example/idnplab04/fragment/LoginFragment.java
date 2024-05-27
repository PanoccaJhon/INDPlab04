package com.example.idnplab04.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.idnplab04.R;
import com.example.idnplab04.activity.MainActivity;
import com.example.idnplab04.entity.AccountEntity;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }


    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        //Replace this fragment and open Account fragment by click text view textToCreateAccount
        TextView createAccount = view.findViewById(R.id.textToCreateAccount);
        createAccount.setOnClickListener(v -> {
            ((MainActivity) requireActivity()).replaceToAccountFragment();
        });
        // Inflate the layout for this fragment
        return view;
    }

    public void fillInputFields(AccountEntity account){
        EditText usernameField = requireView().findViewById(R.id.edtLoginUsername);
        EditText passwordField = requireView().findViewById(R.id.edtLoginPassword);

        usernameField.setText(account.getUsername());
        passwordField.setText(account.getPassword());
    }
}