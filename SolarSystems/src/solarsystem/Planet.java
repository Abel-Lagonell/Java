package solarsystem;

import exceptions.DuplicateCelestialBodyException;
import exceptions.InvalidCelestialBodyException;

/**
 The type Planet that orbits a Star.

 @author Abel Lagonell
 U0000011730
 2/10/25 */
public class Planet extends CelestialBody implements IOrbit {
    private final CelestialBody orbits;

    /**
     Instantiates a new Planet.

     @param newName   the new name
     @param newOrbits the new orbits
     @throws InvalidCelestialBodyException   the invalid celestial body exception
     @throws DuplicateCelestialBodyException the duplicate celestial body exception
     */
    public Planet (String newName, CelestialBody newOrbits) throws InvalidCelestialBodyException, DuplicateCelestialBodyException {
        super(newName, "Planet");
        if ("Star".equals(newOrbits.getType())) {
            orbits = newOrbits;
            orbits.add(this);
        } else {
            throw new InvalidCelestialBodyException("A planet must orbit a star");
        }
    }


    @Override
    public void getOrbit () {
        System.out.println(getName() + " is orbiting the " + orbits.getType() + " " + orbits.getName());
    }
}
