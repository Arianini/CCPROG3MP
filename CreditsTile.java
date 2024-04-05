import java.awt.Color;

public class CreditsTile extends Tile {
    public CreditsTile() {
        super(false);
    }

    @Override
    public Color getColor() {
        return hasPlayer() ? Color.PINK : Color.MAGENTA;
    }

    @Override
    public void interact(Floor1StormController controller) {
       //do nothing
    }
    @Override
    public void interact(Floor2StormController controller2) {
        //do nothing
 
    }
    @Override
    public void interact(Floor3StormController controller3) {
       //do nothing
    }
    @Override
    public void interact(Floor1RayaController controller4) {
         //do nothing
    }
    @Override
    public void interact(Floor2RayaController controller5) {
         //do nothing
    }
    @Override
    public void interact(Floor3RayaController controller6) {
         //do nothing
    }
    @Override
    public void interact(Floor4RayaController controller7) {
       //do nothing
    }
    @Override
    public void interact(Floor5RayaController controller8) {
        //do nothing
    }
    @Override
    public void interact(Floor1EldenController controller9) {
        //do nothing
    }
    @Override
    public void interact(Floor2EldenController controller10) {
         //do nothing
    }
    @Override
    public void interact(Floor3EldenController controller11) {
        controller11.handleCreditInteraction();
    }
}
