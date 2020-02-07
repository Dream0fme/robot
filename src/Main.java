public class Main {
    public static void main(String[] args) {
        SmartRobot r = new SmartRobot();
        System.out.println("Текущие положение {" + r.getX() + ";" + r.getY() + "}");
        r.moveTo(3, 5);
        System.out.println("Итоговое положение {" + r.getX() + ";" + r.getY() + "}");
    }
}
