package com.github.sync.odontolocico.interfaces;


import jakarta.servlet.http.HttpServletRequest;

public abstract class ServiceImp<E,D> {
    protected void save(E entity) {
    }
    protected void update(E entity, HttpServletRequest request) {
    }
    protected void delete(E entity) {}
    protected void disable(E entity) {}

}
