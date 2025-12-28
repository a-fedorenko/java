package mvc.controller;

import mvc.model.*;
import mvc.view.ShapeView;
import java.util.Arrays;
import java.util.Comparator;

public class ShapeController {
    private Shape[] model;
    private ShapeView view;

    public ShapeController() {
        this.view = new ShapeView();
        this.model = new Shape[]{
                new Rectangle("Red", 5, 4),
                new Circle("Blue", 3),
                new Triangle("Green", 4, 6),
                new Rectangle("Yellow", 2, 8),
                new Circle("White", 5),
                new Triangle("Black", 3, 3),
                new Rectangle("Red", 10, 2),
                new Circle("Green", 2.5),
                new Triangle("Blue", 7, 2),
                new Rectangle("Purple", 4, 4)
        };
    }

    public void run() {
        view.printMessage("--- Список фігур ---");
        view.printShapes(model);

        view.printMessage(String.format("\nСумарна площа: %.2f", sumArea(model)));

        view.printMessage("\n--- Сортування за площею ---");
        Arrays.sort(model, Comparator.comparingDouble(Shape::calcArea));
        view.printShapes(model);

        view.printMessage("\n--- Сортування за кольором ---");
        Arrays.sort(model, Comparator.comparing(Shape::getShapeColor));
        view.printShapes(model);
    }

    private double sumArea(Shape[] shapes) {
        double sum = 0;
        for (Shape s : shapes) sum += s.calcArea();
        return sum;
    }
}
