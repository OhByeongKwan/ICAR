package com.example.icar.service;

import com.example.icar.domain.Icar;
import com.example.icar.repasitory.MainRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class MainService {
    private final MainRepository mainRepository;

    public String test(Icar icar){
        System.out.println(icar);
        Icar newIcar = new Icar();

        newIcar.setIdx(icar.getIdx());
        newIcar.setTest_name(icar.getTest_name());

        mainRepository.save(newIcar);
        return "저장 성공";
    }
}
