package com.example.notas.View.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.notas.Model.Notas;
import com.example.notas.R;
import com.example.notas.View.Main1Activity;
import com.example.notas.ViewModel.NotasManager;
import com.example.notas.ViewModel.NotasViewModel;
import java.util.ArrayList;
import java.util.List;

public class ListaFragment extends Fragment {

    private NotasViewModel notasViewModel;
    private ArrayAdapter<Notas> adapter;
    private List<Notas> notasList = new ArrayList<>();

    public ListaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notasViewModel = new ViewModelProvider(requireActivity()).get(NotasViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView listView = view.findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, notasList);
        listView.setAdapter(adapter);

        notasViewModel.getNotas().observe(getViewLifecycleOwner(), notas -> {
            notasList.clear();
            notasList.addAll(notas);
            adapter.notifyDataSetChanged();
        });

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            Notas selectedNotas = notasList.get(position);
            notasViewModel.selectNotas(selectedNotas);
        });
    }
}