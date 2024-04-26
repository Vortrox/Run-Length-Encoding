package edu.deakin.sit333.sample;

public interface StudentRepository {

    public Student findByID(Long id);

    public Long save(Student student);

}
