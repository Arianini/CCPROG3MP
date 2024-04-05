import javax.swing.SwingUtilities;

public class CreditsTileController {
    private CreditsTileView view;
   
    public CreditsTileController(CreditsTileView view) {
        this.view = view;
        initView();
    }

    private void initView() {
        // Initialization code, such as setting up listeners
        view.getExitButton().addActionListener(e -> System.exit(0));
    }

    public void showCreditScreen() {
        view.setVisible(true);
    }
}
