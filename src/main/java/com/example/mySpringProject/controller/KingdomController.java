package com.example.mySpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.mySpringProject.repository.MonarchRepository;
import com.example.mySpringProject.model.MonarchModel;
import com.example.mySpringProject.model.PrimeMinisterModel;
import com.example.mySpringProject.repository.PrimeMinisterRepository;

import java.util.Calendar;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/kingdom/api/v1")
public class KingdomController {
    @Autowired
    private MonarchRepository monarchRepository;
    @Autowired
    private PrimeMinisterRepository pmRepository;

    @GetMapping("/find-all-monarch")
    public ResponseEntity<List<MonarchModel>> getAllMonarch() {
        List<MonarchModel> allMonarch = monarchRepository.findAll();
        return ResponseEntity.status(200).body(allMonarch);
    }

    @GetMapping("/monarch-of-year/{year}")
    public ResponseEntity<List<MonarchModel>> getMonarchOfYear(@PathVariable(name = "year") String targetYear) {
        try {
            int year = Integer.parseInt(targetYear);
            Calendar c = Calendar.getInstance();
            if (year < 1952 || year > c.get(Calendar.YEAR)) {
                throw new RuntimeException("year out of range");
            }
            List<MonarchModel> targetMonarch =  monarchRepository.findMonarchByYear(year);
            return ResponseEntity.status(HttpStatus.OK).body(targetMonarch);
        } catch(Exception  e) {
            return ResponseEntity.status(BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/get-monarch/{name}")
    public ResponseEntity<MonarchModel> getMonarchByName(@PathVariable(name = "name") String targetName) {
        MonarchModel targetMonarch = monarchRepository.getMonarchByName(targetName);
        if (targetMonarch == null) {
           return ResponseEntity.status(NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(OK).body(targetMonarch);
        }
    }

    @GetMapping("/find-all-pm")
    public ResponseEntity<List<PrimeMinisterModel>> getAllPrimeMinister() {
        List<PrimeMinisterModel> allPM = pmRepository.findAll();
        return ResponseEntity.status(200).body(allPM);
    }

    @GetMapping("/find-pm-by-monarch/{monarch}")
    public ResponseEntity<List<PrimeMinisterModel>> getPMByMonarch(@PathVariable(name = "monarch") String monarch) {
        List<PrimeMinisterModel> pms = pmRepository.findPMByMonarch(monarch);
        if (pms == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(pms);
    }

    @GetMapping("/find-pm-by-year/{year}")
    public ResponseEntity<List<PrimeMinisterModel>> getPMByYear(@PathVariable(name = "year") String targetYear) {
        try {
            int year = Integer.parseInt(targetYear);
            Calendar c = Calendar.getInstance();
            if (year < 1951 || year > c.get(Calendar.YEAR)) {
                throw new RuntimeException("year out of range");
            }
            System.out.print("the year is: " + year + "\n");
            List<PrimeMinisterModel> targetPMs =  pmRepository.findPMByYear(year);
            return ResponseEntity.status(HttpStatus.OK).body(targetPMs);
        } catch(Exception  e) {
            return ResponseEntity.status(BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/latest-pm")
    public ResponseEntity<PrimeMinisterModel> getLatestPM() {
        PrimeMinisterModel lastPM = pmRepository.getLatestPM();
        return ResponseEntity.status(200).body(lastPM);
    }

}
