package projectJV2.dao.impls;

import projectJV2.dao.interfaces.IRepository;
import projectJV2.entities.ThanhVien;
import projectJV2.helper.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class TVRepository implements IRepository<ThanhVien> {

    @Override
    public ArrayList<ThanhVien> all() {
        ArrayList<ThanhVien> ls = new ArrayList<>();
        try {
            String sql_txt = "select * from member";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String role = rs.getString("role");
                int salary = rs.getInt("salary");
                ThanhVien t = new ThanhVien(id,role,salary);
                ls.add(t);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ls;
    }

    public int tongthu() {
        int t = 0;
        try {
            String sql_txt = "select sum(salary) as tc from member ";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                t = rs.getInt("tc");
            }

        } catch (Exception e) {
            System.out.println("ko dcc");
        }
        return t;
    }

    @Override
    public boolean create(ThanhVien thanhVien) {
        try {
            String sql_txt = "insert into member(role, salary) value(?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(thanhVien.getRole());
            arr.add(thanhVien.getSalary());

            if (conn.execute(sql_txt, arr)){
                return true;
            }
        }catch (Exception e){
        }
        return false;
    }

    @Override
    public boolean update(ThanhVien thanhVien) {
        try {
            String sql_txt = "update member set role = ?, salary= ? where id =?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(thanhVien.getRole());
            arr.add(thanhVien.getSalary());
            arr.add(thanhVien.getId());
            if (conn.execute(sql_txt, arr)){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(ThanhVien thanhVien) {
        try {
            String sql_txt = "delete from member where id = ?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(thanhVien.getId());
            if (conn.execute(sql_txt, arr)){
                return true;
            }
        }catch (Exception e){
        }
        return false;
    }

    @Override
    public ThanhVien findOne(Integer id) {
        try {
            String sql_txt = "select * from member where id=?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(id);
            ResultSet rs = conn.executeQuery(sql_txt, arr);
            while(rs.next()){
                int Id = rs.getInt("id");
                String role = rs.getString("role");
                int salary = rs.getInt("salary");
                return new ThanhVien(id,role,salary);
            }
        }catch (Exception e){
        }
        return null;
    }


}