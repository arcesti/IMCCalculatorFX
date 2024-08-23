package br.unoeste.imccalculatorfx.util;

import br.unoeste.imccalculatorfx.repository.PessoaRepo;

public class Singleton {
    static private PessoaRepo repo = new PessoaRepo();
    static public PessoaRepo getRepo() {
        return repo;
    }

    private Singleton() {
    }
}
