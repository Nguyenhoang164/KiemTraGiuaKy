package com.example.qlnv.Model;

import javax.persistence.*;
import java.util.Date;

@Entity

@Table(name = "computer")
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String houseProduct;
    private String kind;
    private String cpu;
    private String HDH;
    private String ram;
    private String rom;
    private String card;
    private String screen;
    private String price;
    private String status;
    private String detail;

    public Computer(int id, String name, String houseProduct, String kind, String cpu, String HDH, String ram, String rom, String card, String screen, String price, String status, String detail) {
        this.id = id;
        this.name = name;
        this.houseProduct = houseProduct;
        this.kind = kind;
        this.cpu = cpu;
        this.HDH = HDH;
        this.ram = ram;
        this.rom = rom;
        this.card = card;
        this.screen = screen;
        this.price = price;
        this.status = status;
        this.detail = detail;
    }

    public Computer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHouseProduct() {
        return houseProduct;
    }

    public void setHouseProduct(String houseProduct) {
        this.houseProduct = houseProduct;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getHDH() {
        return HDH;
    }

    public void setHDH(String HDH) {
        this.HDH = HDH;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
