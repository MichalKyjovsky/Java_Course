
public class City implements Comparable<City> {

    private int coordX;
    private int coordY;
    private int ID;
    private boolean visited;

    public City(int ID,int coordX, int coordY) {
        this.ID = ID;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getCoordX() {
        return coordX;
    }
    public int getCoordY() { return coordY; }


    public double distanceTo(City city){
        double coordX = Math.abs(city.getCoordX() - this.getCoordX());
        double coordY = Math.abs(city.getCoordY() - this.getCoordY());

        return Math.sqrt(Math.pow(coordX,2) + Math.pow(coordY,2));
    }

    @Override
    public int compareTo(City city){
        return this.getCoordX() - city.getCoordX();
        }
    }




