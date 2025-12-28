package mvc.view;

import mvc.model.Shape;

public class ShapeView {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printShapes(Shape[] shapes) {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
