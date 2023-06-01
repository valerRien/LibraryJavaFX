package fx.project.javafxtest.animations;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shake {
    private TranslateTransition transition;

    public Shake(Node node) {
        transition = new TranslateTransition(Duration.millis(100), node);
        transition.setFromX(0f);
        transition.setFromY(0f);
        transition.setByX(5f);
        transition.setByY(3f);
        transition.setCycleCount(3);
    }

    public void playAnim() {
        transition.playFromStart();
    }
}
