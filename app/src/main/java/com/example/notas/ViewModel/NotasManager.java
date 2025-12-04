package com.example.notas.ViewModel;

import android.content.Context;

import com.example.notas.Model.EstadoNota;
import com.example.notas.Model.Notas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NotasManager {
    private final File notasFile;

    public NotasManager(Context context){
        File directory = new File(context.getFilesDir(),"TicketDBB");

        if(!directory.exists()){
            directory.mkdir();
        }
        notasFile = new File(directory,"notas.txt");

        try{
            if(!notasFile.exists()){
                notasFile.createNewFile();
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void saveNotas(List<Notas> notasList){

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(notasFile))){
            for(Notas t : notasList){
                String line = t.getTitulo() + "/" + t.getDescripcion() + "/" + t.getEstado().name();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<Notas> loadNotas(){
        List<Notas> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader (new FileReader(notasFile))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("/");

                if (parts.length == 4){
                    Notas t = new Notas(parts[0], parts[1], parts[2]);
                    t.setEstado(EstadoNota.valueOf(parts[3]));
                    list.add(t);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
