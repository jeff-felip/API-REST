package com.projeto.userdepet.repositories;

import com.projeto.userdepet.entities.Department;
import com.projeto.userdepet.entities.User;
import org.hibernate.query.NativeQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT obj FROM User obj WHERE obj.salary >= :minSalary AND obj.salary <= :maxSalary")
    Page<User> searchSalary(Double minSalary, Double maxSalary, Pageable pageable);

    //metodo faz a busca pelo salario que estao entre os argumentos minSalary e maxSalary, sem precisar passar o sql no query
    Page<User> findBySalaryBetween(Double minSalary, Double maxSalary, Pageable pageable);

    @Query(value = "SELECT obj FROM User obj WHERE LOWER(obj.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    Page<User> searchName(String name, Pageable pageable);

    //metodo faz a busca pelo nome ignorando maiusculas ou minusculas, sem precisar passar o sql no query
    Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT * FROM TB_USER WHERE EMAIL = :email")
    Page<User> searchEmail(String email, Pageable pageable);

    //busca todos os users pelo nome do department, como so se tem a chave estrangeira do departement na tabela,
    //é feito a junção das tabelas para obter o usuario que tenha determinado department.
    @Query(nativeQuery = true, value = "SELECT * FROM TB_USER INNER JOIN TB_DEPARTMENT ON TB_USER.DEPARTMENT_ID = DEPARTMENT_ID WHERE TB_DEPARTMENT.NAME = :name")
    Page<User> searchDepartment(String name, Pageable pageable);


}