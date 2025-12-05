package com.github.sync.odontolocico.interfaces;

import com.github.sync.odontolocico.dto.ClientDto;

import java.util.List;

public interface  ServiceGetImp<O,D> {
    List<D> searchList(O object);
    long count(O object);
}
