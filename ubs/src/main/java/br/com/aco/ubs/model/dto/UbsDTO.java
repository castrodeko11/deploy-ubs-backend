package br.com.aco.ubs.model.dto;

import br.com.aco.ubs.model.Ubs;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UbsDTO {

    private int id;
    private String name;
    private String address;
    private String city;
    private String phone;
    private UbsGeocodeDTO geocode;

    public UbsDTO(Ubs ubs) {
        this.id = ubs.getCod_cnes();
        this.name = ubs.getNom_estab();
        this.address = ubs.getDsc_endereco();
        this.city = ubs.getDsc_cidade();
        this.phone = ubs.getDsc_telefone();
        geocode = new UbsGeocodeDTO(ubs.getVlr_latitude(),ubs.getVlr_longitude());
    }

    public static List<UbsDTO> converter(List<Ubs> ubs) {
        return ubs.stream().map(UbsDTO::new).collect(Collectors.toList());
    }

}
