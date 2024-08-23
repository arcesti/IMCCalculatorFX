package br.unoeste.imccalculatorfx.repository;

import br.unoeste.imccalculatorfx.entity.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaRepo {
    private List<Pessoa> list;

    public PessoaRepo() {
        list = new ArrayList<>();
    }
    public void add(Pessoa pessoa) {
        list.add(pessoa);
    }

    public List<Pessoa> getList() {
        return list;
    }
}
