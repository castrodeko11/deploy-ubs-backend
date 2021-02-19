package br.com.aco.ubs.service;

import br.com.aco.ubs.model.Ubs;
import br.com.aco.ubs.repository.UbsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UbsService {

    @Autowired
    private UbsRepository ubsRepository;

    public Page<Ubs> findAllUbsByLogAndLat(double log, double lat, Pageable page){
        return  ubsRepository.findByVlr_longitudeBetween(log,lat, page);
    }

}
