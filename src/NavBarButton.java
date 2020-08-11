import javax.swing.*;

/**
 * NavBarButton can save what view was just left, and restores that view when clicked.
 */
public class NavBarButton extends JButton {

    private JPanel previousView;

    public NavBarButton(String text, Icon icon) {
        super(text, icon);
        setVerticalTextPosition(BOTTOM);
        setHorizontalTextPosition(CENTER);
        setSize(93, 99);
    }

    public void setPreviousView(JPanel previousView) {
        this.previousView = previousView;
    }

    public JPanel getPreviousView() {
        return previousView;
    }
}
