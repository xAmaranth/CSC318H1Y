import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *  The primary means of navigating through the app, allowing access to the different parts of the system at any time.
 *
 *  The NavBarUI creates a neat row of buttons.
 */
public class NavBarView extends JPanel{

    private final MainFrame mainFrame;
    private NavBarButton currentSection = null;

    public NavBarView(MainFrame mainFrame, ArrayList<NavBarButton> navBarButtons) {
        super(new GridBagLayout());

        this.mainFrame = mainFrame;

        setNavBarLayout();
        addButtons(navBarButtons);
    }

    private void setNavBarLayout() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
    }

    private void addButtons(ArrayList<NavBarButton> navBarButtons){
        for (NavBarButton navBarButton : navBarButtons){
            if (currentSection == null){
                currentSection = navBarButton;
                navBarButton.setEnabled(false);
            }

            navBarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    navBarButtonPressed();
                }

                private void navBarButtonPressed() {
                    currentSection.setPreviousView(mainFrame.getView());
                    currentSection.setEnabled(true);

                    mainFrame.setView(navBarButton.getPreviousView());
                    navBarButton.setEnabled(false);
                    currentSection = navBarButton;
                }

            });

            add(navBarButton);
        }
    }

}
