import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Flat implements Serializable
{
    private int Numberofapartament, area;
    private List<Person> Buyers;

    Flat() {
        Numberofapartament = 0;
        area = 0;
        Buyers = new ArrayList<>();
    }

    public Flat(int Numberofapartament, int area, List<Person> buyers) {
        this.Numberofapartament = Numberofapartament;
        this.area = area;
        this.Buyers = buyers;
    }

    public void setNumberofapartament(int numberofapartament) {
        this.Numberofapartament = numberofapartament;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
    public List<Person> getBuyers() {
        return Buyers;
    }

    public void setBuyers(List<Person> buyers) {
        Buyers = buyers;
    }

    public int getNumberofapartament() {
        return Numberofapartament;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return Numberofapartament == flat.Numberofapartament && area == flat.area && Buyers.equals(flat.Buyers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Numberofapartament, area, Buyers);
    }

    @Override
    public String toString() {
        return "Flat{" +
                "apartmentNumber=" + Numberofapartament +
                ", area=" + area +
                ", Owners=" + Buyers +
                '}';
    }
}