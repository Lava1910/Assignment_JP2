package projectJV2.dao.impls;


import projectJV2.entities.ThuThang;
import projectJV2.dao.interfaces.IRepository;
import projectJV2.entities.ThuThang;
import projectJV2.helper.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class ThuThangRepository implements IRepository<ThuThang> {
    @Override
    public ArrayList<ThuThang> all() {
        ArrayList<ThuThang> ls = new ArrayList<>();
        try {
            String sql_txt = "select * from income";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String role = rs.getString("role");
                int income = rs.getInt("income");
                Date date = rs.getDate("date");
                ThuThang ct = new ThuThang(id,role,income,date);
                ls.add(ct);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ls;
    }

    @Override
    public boolean create(ThuThang ThuThang) {
        try {
            String sql_txt = "insert into spending(role,spending,date) values(?,?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(ThuThang.getRole());
            arr.add(ThuThang.getIncome());
            arr.add(ThuThang.getDate());
            if(conn.execute(sql_txt,arr)) {
                return true;
            }
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public boolean update(ThuThang ThuThang) {
        try {
            String sql_txt = "update income set roleid=?, role = ?, income=?,date=? where id=?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(ThuThang.getRole());
            arr.add(ThuThang.getIncome());
            arr.add(ThuThang.getDate());
            arr.add(ThuThang.getId());
            arr.add(ThuThang.getRoleId());
            if(conn.execute(sql_txt,arr)){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(ThuThang ThuThang) {
        try {
            String sql_txt = "delete from income where id=? ";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(ThuThang.getId());
            if(conn.execute(sql_txt,arr)) {
                return true;
            }
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public ThuThang findOne(Integer id) {
        try {
            String sql_txt = "select * from income where id=? ";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(id);
            ResultSet rs = conn.executeQuery(sql_txt,arr);
            while (rs.next()){
                int Id = rs.getInt("id");
                String role = rs.getString("role");
                int income = rs.getInt("income");
                Date date = rs.getDate("date");
                return new ThuThang(id,role,income,date);

            }

        }catch (Exception e){

        }
        return null;
    }
}
