package mvc.model.people;
import java.io.Serializable;

public abstract class Human implements Serializable {
    private String name;
    
    public Human(String name) { this.name = name; }
    
    public String getName() { return name; }
    
    @Override
    public String toString() { return getClass().getSimpleName() + " " + name; }
}
