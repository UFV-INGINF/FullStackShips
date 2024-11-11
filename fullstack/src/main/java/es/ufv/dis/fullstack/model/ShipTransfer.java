package es.ufv.dis.fullstack.model;

public class ShipTransfer {

    private String name;
    private int crew;
    private String model;

    public ShipTransfer(String name, int crew, String model) {
        this.name = name;
        this.crew = crew;
        this.model = model;
    }

    public ShipTransfer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "ShipTransfer{" +
                "name='" + name + '\'' +
                ", crew=" + crew +
                ", model='" + model + '\'' +
                '}';
    }
}
