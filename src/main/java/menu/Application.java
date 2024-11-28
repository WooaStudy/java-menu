package menu;

import menu.domain.MenuController;
import menu.util.InputValidator;
import menu.util.Parser;
import menu.view.InputView;

public class Application {
    public static void main(String[] args) {
        Parser parser = new Parser();
        InputView inputView = new InputView(parser);
        InputValidator inputValidator = new InputValidator(parser);
        MenuController menuController = new MenuController(inputView, inputValidator);

        menuController.start();
    }
}
