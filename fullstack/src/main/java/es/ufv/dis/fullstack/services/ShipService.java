package es.ufv.dis.fullstack.services;

import es.ufv.dis.fullstack.inputOutput.InputOutput;
import es.ufv.dis.fullstack.model.Ship;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ShipService {

    InputOutput io = new InputOutput();

    public ArrayList<Ship> getShips() {
        return io.readShips("ships.json");

    }

    public ArrayList<Ship> addShip(Ship ship) {
        ArrayList<Ship> ships = io.readShips("ships.json");
        ships.add(ship);
        io.writeShips("ships.json", ships);
        return ships;
    }


}
