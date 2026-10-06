package step06_constructor;

/** 생성자 오버로딩과 this(...)를 이용한 생성자 연결을 보여 주는 자동차 클래스입니다. */
public class Car {

    String name;
    String color;

    /**
     * 인자가 없는 생성자입니다.
     * 직접 선언한 생성자이므로 컴파일러가 자동으로 만드는 기본 생성자와는 구분해야 합니다.
     */
    public Car() {
        this("이름 없는 자동차", "WHITE");
    }

    /** 자동차 이름만 받으면 색상은 WHITE를 사용합니다. */
    public Car(String name) {
        this(name, "WHITE");
    }

    /** 모든 필드 값을 전달받는 생성자가 실제 초기화를 담당합니다. */
    public Car(String name, String color) {
        this.name = name;
        this.color = color;
    }

    /** 현재 객체가 생성자를 통해 받은 값을 출력합니다. */
    public void printInfo() {
        System.out.println("자동차 이름: " + name + ", 색상: " + color);
    }
}
