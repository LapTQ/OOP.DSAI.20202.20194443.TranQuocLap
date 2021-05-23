package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.exception.DuplicateException;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.playable.Playable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {

    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));;

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN,20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAddCart = new JButton("Add to cart");
        container.add(btnAddCart);
        btnAddCart.addActionListener(new ButtonListener());


        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            container.add(btnPlay);
            btnPlay.addActionListener(new ButtonListener());
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
    }


    public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String button = e.getActionCommand();

            if (button.equals("Play")) {
                try {
                    String msg = ((Disc) media).play();
                    JOptionPane.showMessageDialog(null, msg, "Play", JOptionPane.PLAIN_MESSAGE);
                } catch (PlayerException exp) {
                    JOptionPane.showMessageDialog(null, exp.getMessage(), "Illegal Length", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if (button.equals("Add to cart")) {
                try {
                    StoreScreen.cart.addMedia(media);
                } catch (DuplicateException duplicateException) {
                    JOptionPane.showMessageDialog(null, duplicateException.getMessage(), "Duplicate Media", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }


}
