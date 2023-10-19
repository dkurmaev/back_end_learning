import models.Student;
import repositories.StudentRepository;
import repositories.StudentRepositoryFileImpl;
import servises.StudentService;
import servises.StudentServiceImp;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentRepository repository = new StudentRepositoryFileImpl("D:/ait-tr/gits/cohort28/back_end/students.txt");
        List<Student> all = repository.findAll();
        System.out.println(all);
        System.out.println("---------------------------------");

        StudentService service = new StudentServiceImp(repository);
        Map<String, Integer> mapCount = service.countGradeByStudent();
        System.out.println(mapCount);


    }
}