import exceptions.DuplicateCelestialBodyException;
import exceptions.InvalidCelestialBodyException;
import solarsystem.CelestialBody;
import solarsystem.Moon;
import solarsystem.Planet;
import solarsystem.Star;

/**
 The type Solar system.

 @author Abel Lagonell
 U0000011730
 2/10/25 */
public class SolarSystem {
    /**
     The entry point of application.

     @param args the input arguments
     */
    public static void main (String[] args) {
        Star sun = new Star("Sun", 5778000);
        try {
            Planet mercury = new Planet("Mercury", sun);
            Planet venus = new Planet("Venus", sun);
            Planet earth = new Planet("Earth", sun);
            Planet mars = new Planet("Mars", sun);
            Planet jupiter = new Planet("Jupiter", sun);
            Planet saturn = new Planet("Saturn", sun);
            Planet uranus = new Planet("Uranus", sun);
            Planet neptune = new Planet("Neptune", sun);

            Moon moon = new Moon("Moon", earth);
            Moon Phobos = new Moon("Phobos", mars);
            Moon Deimos = new Moon("Deimos", mars);

        } catch (DuplicateCelestialBodyException | InvalidCelestialBodyException e) {
            System.out.println(e);
        }

        System.out.println();
        System.out.println(sun + " with a temperature of about " + sun.getSurfaceTemp() + " K");
        System.out.println();
        for (CelestialBody planet : sun.getChildren()) {
            if (planet instanceof Planet) {
                ((Planet) planet).getOrbit();
                if (planet.getChildren() != null) {
                    for (CelestialBody moon : planet.getChildren()) {
                        if (moon instanceof Moon) ((Moon) moon).getOrbit();
                    }
                }
                System.out.println();
            }
        }
    }
}
