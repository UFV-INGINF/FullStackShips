package es.ufv.dis.fullstack.front;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import es.ufv.dis.fullstack.front.model.Ship;
import es.ufv.dis.fullstack.front.model.ShipTransfer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ShipService implements Serializable {

    public void sendShip(String name, String model, int crew) {

        String url = "http://localhost:8080/api/v1/ships"; // Reemplaza con la URL de tu API

        ShipTransfer ship = new ShipTransfer(name, crew, model);
        Gson gson = new Gson();

        try {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(ship)))
                    .setHeader("Content-Type", "application/json")
                    .build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


            ArrayList<Ship> ships = gson.fromJson(response.body(), new TypeToken<ArrayList<Ship>>() {
            }.getType());

            System.out.println(ships);


        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        // Maneja la respuesta según sea necesario

    }

}
