package es.ufv.dis.fullstack.controllers;


import es.ufv.dis.fullstack.model.Ship;
import es.ufv.dis.fullstack.model.ShipTransfer;
import es.ufv.dis.fullstack.services.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/ships")
public class ShipsController {

    ShipService shipService;

    @Autowired
    public ShipsController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping
    public ArrayList<Ship> getShips() {

        return shipService.getShips();
    }

    @PostMapping
    public ArrayList<Ship> addShip(@RequestBody ShipTransfer shipIncoming) {
        Ship ship = new Ship(shipIncoming.getName(), shipIncoming.getModel(), shipIncoming.getCrew());
        return shipService.addShip(ship);
    }
}
