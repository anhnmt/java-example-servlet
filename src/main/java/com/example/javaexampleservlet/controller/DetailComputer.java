package com.example.javaexampleservlet.controller;

import com.example.javaexampleservlet.model.Computer;
import com.example.javaexampleservlet.repo.ComputerImpl;
import com.example.javaexampleservlet.repo.IComputer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DetailComputer", value = "/Computer/Detail")
public class DetailComputer extends HttpServlet {
    private IComputer computerRepo;

    public void init() {
        computerRepo = new ComputerImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Computer c = computerRepo.findById(id);
        request.setAttribute("c", c);
        RequestDispatcher dispatcher = request.getRequestDispatcher("detail.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}