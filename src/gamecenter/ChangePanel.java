
package gamecenter;

import javax.swing.JPanel;

/**
 *
 * @author Team3
 */
public class ChangePanel {

    public void panelChange(JPanel main, JPanel newPanel) {
        main.removeAll();
        main.add(newPanel);
        main.revalidate();
        main.repaint();
    }
}
