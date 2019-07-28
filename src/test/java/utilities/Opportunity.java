package utilities;

import java.util.Objects;

public class Opportunity implements Comparable<Opportunity> {
    public String name;
    public double revenue;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Opportunity)) return false;
        Opportunity that = (Opportunity) o;
        return Double.compare(that.revenue, revenue) == 0 &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, revenue);
    }

    @Override
    public String toString() {
        return "Opportunity{" +
                "name='" + name + '\'' +
                ", revenue=" + revenue +
                '}';
    }

    public Opportunity(String name, double revenue) {
        this.name = name;
        this.revenue = revenue;
    }

    @Override
    public int compareTo(Opportunity o) {
        return this.name.compareTo(o.name);
    }
}
