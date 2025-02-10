package solarsystem;

/**
 The type Star with parent Celestial Body.

 @author Abel Lagonell
 U0000011730
 2/10/25 */
public class Star extends CelestialBody {
    private final int surfaceTemp;

    /**
     Instantiates a new Star with the type Star and with a particular temperature.

     @param newName        the new name
     @param newSurfaceTemp the new surface temp
     */
    public Star (String newName, int newSurfaceTemp) {
        super(newName, "Star");
        surfaceTemp = newSurfaceTemp;
    }

    /**
     Gets surface temp.

     @return the surface temp
     */
    public int getSurfaceTemp () {return surfaceTemp;}
}
