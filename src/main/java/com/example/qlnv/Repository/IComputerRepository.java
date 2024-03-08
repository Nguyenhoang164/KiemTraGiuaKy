package com.example.qlnv.Repository;

import com.example.qlnv.Model.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface IComputerRepository extends CrudRepository<Computer, Integer> {
    Page<Computer> findAll(Pageable pageable);
    Iterable<Computer> findAllByNameContaining(String name);
    Iterable<Computer> findAllByHouseProductContaining(String houseProduct);
    Iterable<Computer> findAllByKindContaining(String kind);
}
