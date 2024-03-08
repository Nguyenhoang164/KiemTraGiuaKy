package com.example.qlnv.Controller;

import com.example.qlnv.Model.Computer;
import com.example.qlnv.Model.PageRequestDTO;
import com.example.qlnv.Service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/computers")
public class computerController {
    @Autowired
    private IComputerService computerService;
    @GetMapping("")
    public ResponseEntity<Iterable<Computer>> showAllcomputer(@RequestBody PageRequestDTO pageRequest){
        Pageable pageable = PageRequest.of(pageRequest.getPage(), pageRequest.getSize(), Sort.by("id"));
        Page<Computer> computers = computerService.findAll(pageable);
        List<Computer> computerList = new ArrayList<>();
        for (Computer computer : computers){
            computerList.add(computer);
        }
        if (computerList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(computerList,HttpStatus.OK);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<String> createComputer(@RequestBody Computer computer){
        String nameRegex = "^[A-Z].*";
        String numberRegex = "^[0-9]{11}$";
        if(computer.getName().matches(nameRegex) && computer.getCard().matches(numberRegex)){
            computerService.save(computer);
            return new ResponseEntity<>("create computer complete",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("name or number, card was error",HttpStatus.EXPECTATION_FAILED);
        }
    }
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<String> deleteComputer(@PathVariable("id") int id){
        Optional<Computer> computer = computerService.findById(id);
        if (!computer.isPresent()){
            return new ResponseEntity<>("computer id not exit",HttpStatus.NO_CONTENT);
        }
        computerService.delete(computer.get());
        return new ResponseEntity<>("delete computer complete",HttpStatus.OK);

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateComputerById(@PathVariable("id")int id,@RequestBody Computer computer){
        Optional<Computer> computerOptional = computerService.findById(id);
        if (!computerOptional.isPresent()){
            return new ResponseEntity<>("computer id not exit",HttpStatus.NO_CONTENT);
        }else {
            computerOptional.get().setId(id);
            computerService.save(computerOptional.get());
            return new ResponseEntity<>("computer is update",HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/search/{variable}")
    public ResponseEntity<Iterable<Computer>> showAllComputerBySearch(@PathVariable("variable") String variable){
        Iterable<Computer> computers = computerService.findAllByNameContaining(variable);
        Iterable<Computer> computerList = computerService.findAllByKindContaining(variable);
        Iterable<Computer> computerPrice = computerService.findAllByHouseProductContaining(variable);
        List<Computer> list = new ArrayList<>();
        for (Computer computer : computers){
            list.add(computer);
        }
        for (Computer computer : computerList){
            list.add(computer);
        }
        for (Computer computer : computerPrice){
            list.add(computer);
        }
        if (list == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
    }
}
