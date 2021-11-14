package com.example.javaexampleservlet.repo;

import com.example.javaexampleservlet.model.Computer;
import com.example.javaexampleservlet.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComputerImpl implements IComputer {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public List<Computer> findAll() {
        List<Computer> list = new ArrayList<>();

        try {
            conn = DbUtil.getInstance().getConnection();
            ps = conn.prepareStatement("select * from TblComputers");
            rs = ps.executeQuery();
            while (rs.next()) {
                Computer c = new Computer(
                        rs.getInt("ComId"),
                        rs.getString("ComName"),
                        rs.getString("Producer"),
                        rs.getString("Description"),
                        rs.getDate("YearMaking").toLocalDate(),
                        rs.getFloat("Price")
                );
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }

        return list;
    }

    @Override
    public Computer findById(Integer id) {
        Computer c = null;

        try {
            conn = DbUtil.getInstance().getConnection();
            ps = conn.prepareStatement("select * from TblComputers where ComId = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                c = new Computer(
                        rs.getInt("ComId"),
                        rs.getString("ComName"),
                        rs.getString("Producer"),
                        rs.getString("Description"),
                        rs.getDate("YearMaking").toLocalDate(),
                        rs.getFloat("Price")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }

        return c;
    }

    @Override
    public boolean createNew(Computer c) {
        boolean result = false;

        try {
            conn = DbUtil.getInstance().getConnection();
            ps = conn.prepareStatement("insert into TblComputers values (?,?,?,?,?)");
            ps.setString(1, c.getComName());
            ps.setString(2, c.getProducer());
            ps.setString(3, c.getDescription());
            ps.setString(4, c.getYearMaking().toString());
            ps.setFloat(5, c.getPrice());

            int i = ps.executeUpdate();
            if (i > 0) result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }

        return result;
    }
}
