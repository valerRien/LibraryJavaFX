package fx.project.javafxtest.animations;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shake {
    private TranslateTransition transition;

    public Shake(Node node) {
        transition = new TranslateTransition(Duration.millis(100), node);
        transition.setToX(3f);
        transition.setToY(3f);
        transition.setAutoReverse(true);
        transition.setCycleCount(4);

    }

    public void playAnim() {
        transition.playFromStart();
    }
}
