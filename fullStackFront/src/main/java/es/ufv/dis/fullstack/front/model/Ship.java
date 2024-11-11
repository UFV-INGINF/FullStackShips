package es.ufv.dis.fullstack.front.model;

import java.util.UUID;

public class Ship {

    private String _id;
    private String name;
    private String model;
    private int crew;

    public Ship() {
    }

    public Ship(String _id, String name, String model, int crew) {
        this._id = _id;
        this.name = name;
        this.model = model;
        this.crew = crew;
    }

    public Ship(String name, String model, int crew) {
        this._id = UUID.randomUUID().toString();
        this.name = name;
        this.model = model;
        this.crew = crew;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", crew=" + crew +
                '}';
    }
}
