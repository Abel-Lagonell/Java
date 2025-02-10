package solarsystem;

import exceptions.DuplicateCelestialBodyException;
import exceptions.InvalidCelestialBodyException;

/**
 The type Moon that orbits a Planet.

 @author Abel Lagonell
 U0000011730
 2/10/25 */
public class Moon extends CelestialBody implements IOrbit {
    private final CelestialBody orbits;


    /**
     Instantiates a new Moon.

     @param newName   the new name
     @param newOrbits the new orbits
     @throws DuplicateCelestialBodyException the duplicate celestial body exception
     @throws InvalidCelestialBodyException   the invalid celestial body exception
     */
    public Moon (String newName, CelestialBody newOrbits) throws DuplicateCelestialBodyException, InvalidCelestialBodyException {
        super(newName, "Moon");
        if (newOrbits.getType().equals("Planet")) {
            orbits = newOrbits;
            orbits.add(this);
        } else {
            throw new InvalidCelestialBodyException("A moon must orbit a planet.");
        }
    }

    @Override
    public void getOrbit () {
        System.out.println(getName() + " is orbiting the " + orbits.getType() + " " + orbits.getName());
    }
}
