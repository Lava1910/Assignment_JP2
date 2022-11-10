package assignment_jp2.factory;

import assignment_jp2.dao.impls.StudentRepository;
import assignment_jp2.dao.interfaces.IStudentRepository;
import assignment_jp2.enums.RepoType;
import assignment_jp2.enums.RepoType;

public class RepositoryFactory {

    private RepositoryFactory(){
    }

    public static StudentRepository createRepository(RepoType type){
        switch (type){
            case STUDENT: return new StudentRepository();
            default: throw new IllegalArgumentException("Thiếu tham số rồi");
        }
    }
}
