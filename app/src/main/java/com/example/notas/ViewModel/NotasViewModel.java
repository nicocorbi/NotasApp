package com.example.notas.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.notas.Model.EstadoNota;
import com.example.notas.Model.Notas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NotasViewModel extends AndroidViewModel {
    private final MutableLiveData<List<Notas>> notas = new MutableLiveData<>();
    private final MutableLiveData<Notas> selectedNotas = new MutableLiveData<>();
    private final NotasManager NotasManager;

    public NotasViewModel(@NonNull Application application) {
        super(application);

        NotasManager = new NotasManager(application);

        List<Notas> initialNotas = NotasManager.loadNotas();
        if (initialNotas == null) {
            initialNotas = new ArrayList<>();
        }
        notas.setValue(initialNotas);
    }

    public LiveData<List<Notas>> getNotas() {
        return notas;
    }

    public void addNotas(Notas nota) {
        List<Notas> currentList = notas.getValue();
        if (currentList == null) {
            currentList = new ArrayList<>();
        }
        currentList.add(nota);
        notas.setValue(currentList);
        NotasManager.saveNotas(currentList);
    }

    public void updateNotas(Notas oldNotas, String newTitle, String newDescription, EstadoNota newStatus) {
        List<Notas> currentList = notas.getValue();
        if (currentList != null && oldNotas != null) {
            for (Notas t : currentList) {
                if (Objects.equals(t.getTitulo(), oldNotas.getTitulo()) &&
                        Objects.equals(t.getDescripcion(), oldNotas.getDescripcion()) &&
                        t.getEstado() == oldNotas.getEstado()) {

                    t.setTitulo(newTitle);
                    t.setDescripcion(newDescription);
                    t.setEstado(newStatus);
                    break;
                }
            }
            notas.setValue(currentList);
            NotasManager.saveNotas(currentList);
        }
    }

    public void selectNotas(Notas notas) {
        selectedNotas.setValue(notas);
    }

    public LiveData<Notas> getSelectedNotas() {
        return selectedNotas;
    }

    public void clearSelectedNotas() {
        selectedNotas.setValue(null);
    }
}