package es.ufv.dis.fullstack.inputOutput;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import es.ufv.dis.fullstack.model.Ship;

import java.io.*;
import java.util.ArrayList;

public class InputOutput {

    Gson gson = new Gson();
    public ArrayList<Ship> readShips(String path) {
        ArrayList<Ship> ships = new ArrayList<Ship>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            ships = gson.fromJson(br, new TypeToken<ArrayList<Ship>>(){}.getType());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ships;

    }

    public void writeShips(String path, ArrayList<Ship> ships) {
        try {
            FileWriter writer = new FileWriter(path);
            gson.toJson(ships, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Ship> addId(ArrayList<Ship> ships) {
        for (Ship ship : ships) {
            if (ship.get_id() == null) {
                ship.set_id(java.util.UUID.randomUUID().toString());
            }
        }
        return ships;
    }
}
