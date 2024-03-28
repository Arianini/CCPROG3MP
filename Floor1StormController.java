import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Floor1StormController {
    private Floor1StormModel model;
    private Floor1StormView view;

    public Floor1StormController(Floor1StormModel model, Floor1StormView view) {
        this.model = model;
        this.view = view;
        initView();
    }

    private void initView() {
        view.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int newRow = model.playerRow;
                int newCol = model.playerColumn;
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W -> newRow--;
                    case KeyEvent.VK_S -> newRow++;
                    case KeyEvent.VK_A -> newCol--;
                    case KeyEvent.VK_D -> newCol++;
                }
                model.movePlayer(newRow, newCol);
                view.updateView();
            }
        });
        view.setFocusable(true);
        view.requestFocusInWindow();
    }
}
