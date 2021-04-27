import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class MyMouseListener implements MouseListener {
    @Override
    public void mousePressed(MouseEvent e)
    {
        System.out.println("Mouse-button pressed!");
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse-button released!");
    }
    @Override
    public void mouseClicked(MouseEvent e)
    {
        System.out.println("Mouse-button clicked (pressed and released)!");
    }
    @Override
    public void mouseEntered(MouseEvent e)
    {
        System.out.println("Mouse-pointer entered the source component!");
    }
    @Override
    public void mouseExited(MouseEvent e)
    {
        System.out.println( "Mouse exited-pointer the source component!");
    }
}