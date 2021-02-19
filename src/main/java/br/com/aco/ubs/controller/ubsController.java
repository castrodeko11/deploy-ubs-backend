package br.com.aco.ubs.controller;

import br.com.aco.ubs.model.Ubs;
import br.com.aco.ubs.model.dto.UbsDTO;
import br.com.aco.ubs.service.UbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/find_ubs")
public class ubsController {

    @Autowired
    private UbsService ubsService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllTutorials(
            @RequestParam String query,
            @RequestParam int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        try {
            String[] parts = query.split(",");
            List<Ubs> ubsList;
            Pageable paging = PageRequest.of(page, size);

            Page<Ubs> ubsPage;
            ubsPage = ubsService.findAllUbsByLogAndLat(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]), paging);

            ubsList = ubsPage.getContent();

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("current_page", ubsPage.getNumber());
            response.put("per_page", ubsPage.getTotalElements());
            response.put("totalPages", ubsPage.getTotalPages());
            response.put("entries", UbsDTO.converter(ubsList));

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}


