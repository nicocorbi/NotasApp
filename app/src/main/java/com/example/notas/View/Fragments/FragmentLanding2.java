package com.example.notas.View.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.notas.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentLanding2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentLanding2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentLanding2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentLanding2.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentLanding2 newInstance(String param1, String param2) {
        FragmentLanding2 fragment = new FragmentLanding2();
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
        View view = inflater.inflate(R.layout.fragment_landing2,container,false);
        Button button = view.findViewById(R.id.Siguiente2);
        button.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction().replace(R.id.fragmentLandingContainer, new FragmentLanding3()).addToBackStack(null).commit();
        });
        // Inflate the layout for this fragment
        return view;
    }
}