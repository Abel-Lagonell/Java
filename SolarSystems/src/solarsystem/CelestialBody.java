package solarsystem;

import exceptions.DuplicateCelestialBodyException;

import java.util.ArrayList;


/**
 The parent class for any celestial bodies in a solar system.

 @author Abel Lagonell
 U0000011730
 2/10/25 */
public class CelestialBody {
    private final String name;
    private final String type;
    private ArrayList<CelestialBody> children;

    /**
     Instantiates a new Celestial body.

     @param newName the new name
     @param newType the new type
     */
    public CelestialBody (String newName, String newType) {
        name = newName;
        type = newType;
    }

    /**
     Gets name.

     @return the name
     */
    public String getName () {return name;}

    /**
     Gets type.

     @return the type
     */
    public String getType () {return type;}

    /**
     Gets children.

     @return the children
     */
    public ArrayList<CelestialBody> getChildren () {return children;}

    @Override
    public String toString () {
        return type + " " + name;
    }

    /**
     Adds a celestial body to the objects orbiting the current Celestial body

     @param child the child
     @throws DuplicateCelestialBodyException the duplicate celestial body exception
     */
    public void add (CelestialBody child) throws DuplicateCelestialBodyException {
        if (children == null) {
            children = new ArrayList<CelestialBody>();
        }
        for (CelestialBody cb : children) {
            if (cb.getName().equals(child.getName())) {
                throw new DuplicateCelestialBodyException(
                        "The " + getType() + " " + getName() + "is already in the collection");
            }
        }
        children.add(child);
        System.out.println("The " + child.type + " " + child.name + " has been added to " + name + ".");
    }


}
