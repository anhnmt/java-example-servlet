package com.example.javaexampleservlet.repo;

import com.example.javaexampleservlet.model.Computer;

import java.util.List;

public interface IComputer {
    List<Computer> findAll();

    Computer findById(Integer id);

    boolean createNew(Computer c);
}
