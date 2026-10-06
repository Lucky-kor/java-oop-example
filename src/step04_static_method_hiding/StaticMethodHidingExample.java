package step04_static_method_hiding;

/** static 메서드 숨김과 인스턴스 메서드 오버라이딩의 차이를 확인합니다. */
public class StaticMethodHidingExample {

    public static void main(String[] args) {
        Parent parentReference = new Child();

        /* static 메서드는 실제 객체가 아니라 적어 준 클래스에 따라 선택됩니다. */
        Parent.printType();
        Child.printType();

        /* 인스턴스 메서드는 실제 객체가 Child이므로 Child의 메서드가 실행됩니다. */
        parentReference.introduce();

        /* 객체 변수로 static 메서드를 호출할 수도 있지만 의미가 흐려지므로 권장하지 않습니다. */
        // parentReference.printType(); // Parent.printType()이 실행됩니다.
    }
}
