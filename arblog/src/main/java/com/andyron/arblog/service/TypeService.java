package com.andyron.arblog.service;

import com.andyron.arblog.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {

    Type saveType(Type type);

    Type getType(Long id);

    Type updateType(Long id, Type type);

    void deleteType(Long id);

    Page<Type> listType(Pageable pageable);

    List<Type> listType();

    Type getTypeByName(String name);

    List<Type> listTypeTop(Integer size);
}
