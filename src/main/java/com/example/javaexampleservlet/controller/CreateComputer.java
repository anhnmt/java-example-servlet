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
import java.time.LocalDate;

@WebServlet(name = "CreateComputer", value = "/Computer/Create")
public class CreateComputer extends HttpServlet {
    private IComputer computerRepo;

    public void init() {
        computerRepo = new ComputerImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Computer c = new Computer(
                request.getParameter("ComName"),
                request.getParameter("Producer"),
                request.getParameter("Description"),
                LocalDate.parse(request.getParameter("YearMaking")),
                Float.parseFloat(request.getParameter("Price"))
        );
        computerRepo.createNew(c);
        response.sendRedirect(request.getContextPath() + "/Computer");
    }
}
