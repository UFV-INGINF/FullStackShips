package es.ufv.dis.fullstack;

import es.ufv.dis.fullstack.inputOutput.InputOutput;
import es.ufv.dis.fullstack.model.Ship;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class FullstackApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullstackApplication.class, args);
		InputOutput io = new InputOutput();
		System.out.println(io.readShips("ships.json"));

		ArrayList<Ship> ships = io.readShips("ships.json");

		ships = io.addId(ships);

		io.writeShips("ships.json", ships);
	}

}
