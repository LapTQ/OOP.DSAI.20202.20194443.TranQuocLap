import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MyMouseMotionListener implements MouseMotionListener {
    @Override
    public void mouseDragged(MouseEvent e)
    {
        System.out.println("Mouse Dragging!");
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        System.out.println("Mouse Moving!");
    }
}
