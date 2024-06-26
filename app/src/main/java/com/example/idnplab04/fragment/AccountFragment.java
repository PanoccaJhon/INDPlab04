package com.example.idnplab04.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.idnplab04.R;
import com.example.idnplab04.activity.MainActivity;
import com.example.idnplab04.entity.AccountEntity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AccountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
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
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        //Create a AccountEntity with input values using builder pattern
        AccountEntity accountEntity = AccountEntity.builder()
                .name(view.findViewById(R.id.editName).toString())
                .surname(view.findViewById(R.id.editSurname).toString())
                .email(view.findViewById(R.id.editEmail).toString())
                .username(view.findViewById(R.id.editUserName).toString())
                .phone(view.findViewById(R.id.editPhone).toString())
                .password(view.findViewById(R.id.editPassword).toString())
                .build();
        //Send accountEntity LoginFragment by click btnCreateAccount (replace this fragment and open Login fragment)
        view.findViewById(R.id.btnCreateAccount).setOnClickListener(v -> {
            ((MainActivity) requireActivity()).openLoginFragment(accountEntity);
        });
        // Inflate the layout for this fragment
        return view;
    }
}