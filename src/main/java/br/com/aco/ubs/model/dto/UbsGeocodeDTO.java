package br.com.aco.ubs.model.dto;

import br.com.aco.ubs.model.Ubs;
import lombok.Getter;

@Getter
public class UbsGeocodeDTO {

    private double latitude;
    private double longetude;


    public UbsGeocodeDTO(double vlr_latitude, double vlr_longitude) {
        this.latitude = vlr_latitude;
        this.longetude = vlr_longitude;
    }
}
