package projectJV2.dao.impls;

import projectJV2.dao.interfaces.IRepository;
import projectJV2.entities.SoDu;
import projectJV2.helper.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class soDuRepository implements IRepository<SoDu> {

    @Override
    public ArrayList<SoDu> all() {
        return null;
    }

    @Override
    public boolean create(SoDu soDu) {
        return false;
    }

    @Override
    public boolean update(SoDu soDu) {
        return false;
    }

    @Override
    public boolean delete(SoDu soDu) {
        return false;
    }

    @Override
    public SoDu findOne(Integer id) {
        return null;
    }

    public int tongchi() {
        int tc = 0;
        try {
            String sql_txt = "select sum(spending) as tc from spending ";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                tc = rs.getInt("tc");
            }

        } catch (Exception e) {
            System.out.println("ko dc");
        }
        return tc;
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

}
