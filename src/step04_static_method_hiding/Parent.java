package step04_static_method_hiding;

/** static 메서드 숨김과 인스턴스 메서드 오버라이딩을 비교하기 위한 부모 클래스입니다. */
public class Parent {

    /** static 메서드는 객체가 아니라 Parent 클래스에 속합니다. */
    public static void printType() {
        System.out.println("Parent의 static 메서드");
    }

    /** 인스턴스 메서드는 자식 클래스에서 오버라이딩할 수 있습니다. */
    public void introduce() {
        System.out.println("Parent의 인스턴스 메서드");
    }
}
