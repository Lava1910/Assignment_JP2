package projectJV2.dao.interfaces;

import projectJV2.entities.chiThang;

import java.util.ArrayList;

public interface IChiThangRepository extends IRepository<chiThang> {
    ArrayList<chiThang> search(String q);
    int tongchi();
    boolean create(chiThang chiThang);
    boolean update(chiThang chiThang);
    boolean delete(chiThang chiThang);
    chiThang findOne(Integer id);
}
