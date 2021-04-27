import java.awt.*;
import java.awt.event.*;
public class MouseEventDemo extends Frame {
    private TextField tfMouseX;
    private TextField tfMouseY;

    //setup the UI components and event handlers
    public MouseEventDemo() {
        setLayout(new FlowLayout());
        add(new Label("X-Click: "));
        tfMouseX = new TextField(10);
// 10 columns
        tfMouseX.setEditable(false); add(tfMouseX);
        add(new Label("Y-Click: "));
        tfMouseY = new TextField(10);
        tfMouseY.setEditable(false);
        add(tfMouseY);
/* "super" frame (source) fires the MouseEvent and adds an anonymous
instance of MyMouseListener as a MouseEvent listener */
        addMouseListener(new MyMouseListener());
        setTitle("MouseEvent Demo");
        setSize(350, 100); setVisible(true);
    }
    public static void main(String[] args) {
        new MouseEventDemo();
// Let the constructor do the job
    }
}