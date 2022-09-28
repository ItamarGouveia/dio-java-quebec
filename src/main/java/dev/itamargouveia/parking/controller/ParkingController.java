package dev.itamargouveia.parking.controller;


import java.util.List;

import dev.itamargouveia.parking.controller.dto.ParkingDTO;
import dev.itamargouveia.parking.controller.mapper.ParkingMapper;
import dev.itamargouveia.parking.model.Parking;
import dev.itamargouveia.parking.service.ParkingService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    
    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;
    
    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper){
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    public List<ParkingDTO> findAll(){
        List<Parking> parkingList = parkingService.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
        return result;
    }
}
