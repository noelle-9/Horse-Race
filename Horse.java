import java.util.Random;

public class Horse 
{
    // Class variables
    private String name;
    private int distanceCovered;
    private Random random;

    /**
     * Constructor: Creates a new Horse object
     * @param name;
     * @return a private variable name
     */
    public Horse(String name)
    {
        this.name = name;
        this.distanceCovered = 0;
        this.random = new Random();
    }

    /** Getter (accessors) methods 
     * @return the horse names
     * **/
    public String getName() {
        return name; 
    } 
    

    /** Getter (accessors) methods 
     * @return the distance covered
     * **/
    public int getDistanceCovered() {
        return this.distanceCovered; 
    } 

    /** I have to be honest, I got help for this because mine wasn't running properly
     *  I'm not quite sure what this is for but I needed a string to use for my drawDistanceLine
     * @return
     */
    public String getDistanceCoveredString(){
        return ".".repeat(this.distanceCovered);
    }

    /** Makes the horses run at different "speeds"
     * 
     */
    public void run()
    {
        int distance = (this.random.nextInt(2));
        this.distanceCovered += distance;

    } 
}
