public class CharacterCreationController {
    private CharacterCreationView view;
    private CharacterModel model;

    public CharacterCreationController(CharacterCreationView view, CharacterModel model) {
        this.view = view;
        this.model = model;
        initView();
    }

    private void initView() {
        view.getConfirmButton().addActionListener(e -> confirmCharacter());
        view.getBackButton().addActionListener(e -> goBack());
    }

    private void confirmCharacter() {
        String name = view.getNameField().getText();
        String jobClass = (String) view.getJobClassComboBox().getSelectedItem();
        System.out.println("Name: " + name + ", Job Class: " + jobClass); 
    }

    private void goBack() {
        view.setVisible(false);
    }
}
