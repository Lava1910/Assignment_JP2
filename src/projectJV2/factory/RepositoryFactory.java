package projectJV2.factory;

import projectJV2.dao.impls.TVRepository;
import projectJV2.dao.impls.ThuThangRepository;
import projectJV2.dao.impls.chiThangRepository;
import projectJV2.dao.interfaces.IRepository;
import projectJV2.enums.RepoType;

public class RepositoryFactory {
    private RepositoryFactory(){

    }
    public static IRepository createRepository(RepoType type){
        switch (type){
            case CHITHANG: return new chiThangRepository();
            case THUTHANG: return new ThuThangRepository();
            case THANHVIEN: return new TVRepository();
            default:throw new  IllegalArgumentException("thieu tham so roi");
        }
    }
}
