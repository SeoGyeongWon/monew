package com.team03.monew.interest.service;

import com.team03.monew.interest.dto.InterestDto;
import com.team03.monew.interest.dto.InterestRegisterRequest;
import com.team03.monew.interest.repository.InterestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BasicInterestService implements InterestService {

    private InterestRepository interestRepository;


    @Override
    public InterestDto interestCreate(InterestRegisterRequest request) {
        boolean NameDuplication = interestRepository.findAll().stream()
                .anyMatch( interest -> interest.nameEquals(request.name()));


        if(NameDuplication){
            // 커스텀 에러 추가 예정
        }

        return null;
    }
}
