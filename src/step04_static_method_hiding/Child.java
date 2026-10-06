package step04_static_method_hiding;

/** Parent의 static 메서드는 숨기고, 인스턴스 메서드는 오버라이딩합니다. */
public class Child extends Parent {

    /**
     * 부모와 같은 선언이지만 오버라이딩이 아니라 메서드 숨김입니다.
     * 따라서 @Override를 붙이면 컴파일 오류가 발생합니다.
     */
    public static void printType() {
        System.out.println("Child의 static 메서드");
    }

    @Override
    public void introduce() {
        System.out.println("Child의 인스턴스 메서드");
    }
}
