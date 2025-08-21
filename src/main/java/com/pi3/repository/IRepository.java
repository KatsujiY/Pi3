package com.pi3.repository;

import java.util.List;

public interface IRepository<T> {
    void salvar(List<T> lista);
    List<T> carregar();
}
