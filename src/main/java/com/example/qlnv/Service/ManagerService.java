package com.example.qlnv.Service;

import com.example.qlnv.Model.Computer;
import com.example.qlnv.Repository.IComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManagerService implements IComputerService {
@Autowired
private IComputerRepository computerRepository;

    @Override
    public Iterable<Computer> showAllComputer() {
        return computerRepository.findAll();
    }

    @Override
    public void save(Computer computer) {
      computerRepository.save(computer);
    }

    @Override
    public void delete(Computer computer) {
computerRepository.save(computer);
    }

    @Override
    public Page<Computer> findAll(Pageable pageable) {
        return computerRepository.findAll(pageable);
    }

    @Override
    public Optional<Computer> findById(int id) {
        return computerRepository.findById(id);
    }

    @Override
    public Iterable<Computer> findAllByNameContaining(String name) {
        return computerRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Computer> findAllByHouseProductContaining(String houseProduct) {
        return computerRepository.findAllByHouseProductContaining(houseProduct);
    }

    @Override
    public Iterable<Computer> findAllByKindContaining(String kind) {
        return computerRepository.findAllByKindContaining(kind);
    }


}
