package com.example.qlnv.Service;

import com.example.qlnv.Model.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IComputerService {
    Iterable<Computer> showAllComputer();
    void save(Computer computer);
    void delete(Computer computer);
    Page<Computer> findAll(Pageable pageable);
    Optional<Computer> findById(int id);
    Iterable<Computer> findAllByNameContaining(String name);
    Iterable<Computer> findAllByHouseProductContaining(String houseProduct);
    Iterable<Computer> findAllByKindContaining(String kind);
}
