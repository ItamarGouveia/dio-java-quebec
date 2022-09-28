package dev.itamargouveia.parking.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import dev.itamargouveia.parking.model.Parking;
import org.springframework.stereotype.Service;

@Service
public class ParkingService {
    public static Map<String, Parking> parkingMap = new HashMap<>();

    static{
        var id=getUUID();
        Parking parking = new Parking(id,"DSD-2222","MG","CELTA","PRETO");
        parkingMap.put(id,parking);
    }


    public List<Parking> findAll(){
        return parkingMap.values().stream().collect(Collectors.toList());
    }

    private static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
