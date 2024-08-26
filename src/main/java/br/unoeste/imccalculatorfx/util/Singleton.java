package br.unoeste.imccalculatorfx.util;

import br.unoeste.imccalculatorfx.repository.PessoaRepo;

import java.io.*;

public class Singleton {
    static private PessoaRepo repo = new PessoaRepo();
    static public PessoaRepo getRepo() {
        return repo;
    }

    private Singleton() {
    }

    public static boolean ler() {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream("dados.obj");
            objectInputStream = new ObjectInputStream(fileInputStream);
            repo = (PessoaRepo) objectInputStream.readObject();
            return true;
        } catch (Exception e) {}
        return false;
    }

    public static boolean salvar() {
        //Serialzar o objeto repo
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream;
        try {
            fileOutputStream = new FileOutputStream("dados.obj");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(repo);
            objectOutputStream.close();
            return true;
        } catch (Exception e) {}
        return false;
    }
}
