public class BattleController {
    private CharacterModel player;
    private Enemy enemy;
    private BattleView view;

    public BattleController(CharacterModel player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        this.view = new BattleView();
        
        setupViewActions();
        updateViewStats();
        view.setVisible(true);
    }

    private void setupViewActions() {
        view.getPhysicalAttackButton().addActionListener(e -> handleAttack("Physical"));
        view.getSorceryAttackButton().addActionListener(e -> handleAttack("Sorcery"));
        view.getIncantationAttackButton().addActionListener(e -> handleAttack("Incantation"));
        view.getDodgeButton().addActionListener(e -> handleDodge());
        
        view.setIncomingEnemyDamage(calculateIncomingEnemyDamage());
    }

    private void handleAttack(String attackType) {
        int damage = player.calculateDamage(attackType, enemy);
        enemy.takeDamage(damage, attackType);
        view.appendSystemMessage("You dealt " + damage + " " + attackType + " damage to the enemy.");
    
        if (!enemy.isAlive()) {
            view.appendSystemMessage(enemy.getName() + " defeated!");
            view.dispose();
        } else {
            enemyTurn();
        }
    }

    private void handleDodge() {
        if (player.attemptDodge(enemy)) {
            view.appendSystemMessage("Dodge successful! No damage taken.");
        } else {
            enemyTurn();
        }
    }
    
    private void enemyTurn() {
        if (!player.attemptDodge(enemy)) {
            int damage = calculateIncomingEnemyDamage();
            player.takeDamage(damage);
            view.appendSystemMessage("Enemy attacks! You took " + damage + " damage.");
        } else {
            view.appendSystemMessage("You successfully dodged the enemy's attack!");
        }
        
        if (!player.isAlive()) {
            view.appendSystemMessage("You died!");
            view.dispose();
        }
    }

    private int calculateIncomingEnemyDamage() {
        return enemy.getBaseAttack();
    }

    private void updateViewStats() {
        view.setPlayerHealth(player.getCurrentHealth());
        view.setEnemyHealth(enemy.getHealth());
    }

    public void showBattleScreen() {
        view.setVisible(true);
    }
}
