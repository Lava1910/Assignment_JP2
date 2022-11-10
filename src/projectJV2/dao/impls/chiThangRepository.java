package projectJV2.dao.impls;


import projectJV2.entities.chiThang;
import projectJV2.dao.interfaces.IRepository;
import projectJV2.entities.chiThang;
import projectJV2.helper.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class chiThangRepository implements IRepository<chiThang> {
    @Override
    public ArrayList<chiThang> all() {
        ArrayList<chiThang> ls = new ArrayList<>();
        try {
            String sql_txt = "select * from spending";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String sname = rs.getString("sname");
                int spending = rs.getInt("spending");
                String date = rs.getString("date");
                chiThang ct = new chiThang(id,sname,spending,date);
                ls.add(ct);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ls;
    }

    @Override
    public boolean create(chiThang chiThang) {
        try {
            String sql_txt = "insert into spending(sname,spending,date) values(?,?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(chiThang.getSname());
            arr.add(chiThang.getSpending());
            arr.add(chiThang.getDate());
            if(conn.execute(sql_txt,arr)) {
                return true;
            }
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public boolean update(chiThang chiThang) {
        try {
            String sql_txt = "update spending set sname=?, spending=?,date=? where id=?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(chiThang.getSname());
            arr.add(chiThang.getSpending());
            arr.add(chiThang.getDate());
            arr.add(chiThang.getId());
            if(conn.execute(sql_txt,arr)){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(chiThang chiThang) {
        try {
            String sql_txt = "delete from spending where id=? ";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(chiThang.getId());
            if(conn.execute(sql_txt,arr)) {
                return true;
            }
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public chiThang findOne(Integer id) {
        try {
            String sql_txt = "select * from spending where id=? ";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(id);
            ResultSet rs = conn.executeQuery(sql_txt,arr);
            while (rs.next()){
                int Id = rs.getInt("id");
                String sname = rs.getString("sname");
                String spend = rs.getString("spending");
                int date = rs.getInt("date");
                return new chiThang(id,sname,spend,date);

            }

        }catch (Exception e){

        }
        return null;
    }
}
