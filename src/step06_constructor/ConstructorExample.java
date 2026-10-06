package step06_constructor;

/** 전달하는 인자에 따라 서로 다른 생성자가 선택되는 과정을 확인합니다. */
public class ConstructorExample {

    public static void main(String[] args) {
        Car defaultCar = new Car();
        Car namedCar = new Car("김러키의 자동차");
        Car customCar = new Car("이라떼의 자동차", "BLUE");

        defaultCar.printInfo();
        namedCar.printInfo();
        customCar.printInfo();

        /*
         * this(...)는 같은 클래스의 다른 생성자를 호출합니다.
         * Java 24 이하에서는 반드시 생성자의 첫 문장이어야 합니다.
         */
    }
}
