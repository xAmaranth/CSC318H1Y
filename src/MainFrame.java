import javax.swing.*;
import java.util.ArrayList;

/**
 *  The frame in which all views are displayed.
 */
public class MainFrame {

    private JFrame staticFrame;
    private JPanel mainView;

    public MainFrame() {
        createFrame();
        populateFrame();
        showFrame();
    }

    /**
     *  Creates a new frame. Also sets its title and its size.
     */
    private void createFrame() {
        staticFrame = new JFrame("Wellness Garden");
        staticFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        staticFrame.setSize(375, 812);
    }

    private void populateFrame() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        mainView = new JPanel();
        mainView.setSize(375, 713);

        ArrayList<NavBarButton> navBarButtons = new ArrayList<>();

        //TODO: Set the PreviousView to a non-placeholder.
        NavBarButton garden = new NavBarButton("Garden", new ImageIcon("gardenIcon.png"));
        garden.setPreviousView(new GardenView());
        navBarButtons.add(garden);

        NavBarButton cook = new NavBarButton("Cook", new ImageIcon("cookIcon.png"));
        cook.setPreviousView(new CookView());
        navBarButtons.add(cook);

        NavBarButton meditate = new NavBarButton("Meditate", new ImageIcon("meditateIcon.png"));
        meditate.setPreviousView(new GardenView());
        navBarButtons.add(meditate);

        NavBarButton settings = new NavBarButton("Settings", new ImageIcon("settingsIcon.png"));
        settings.setPreviousView(new GardenView());
        navBarButtons.add(settings);

        mainPanel.add(mainView);
        mainPanel.add(new NavBarView(this, navBarButtons));

        staticFrame.add(mainPanel);
    }

    public void setView(JPanel newView){
        mainView = newView;
    }

    public JPanel getView(){
        return mainView;
    }

    private void showFrame() {
        staticFrame.setVisible(true);
    }


    public static void main(String[] args){
        new MainFrame();
    }

}
