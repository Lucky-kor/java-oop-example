package step01_inheritance;

/** 상속으로 공통 코드가 재사용되고 자식 클래스에 기능이 추가되는 과정을 확인합니다. */
public class InheritanceExample {

    public static void main(String[] args) {
        Dancer dancer = new Dancer();
        dancer.name = "김댄서";
        dancer.age = 20;
        dancer.groupName = "자바 비트";

        /* Dancer에 선언된 메서드뿐 아니라 Person에서 물려받은 메서드도 호출할 수 있습니다. */
        dancer.walk();
        dancer.dance();

        BackendProgrammer programmer = new BackendProgrammer();
        programmer.name = "이개발";
        programmer.age = 28;
        programmer.companyName = "코덱스 소프트";

        /* 두 단계를 상속해도 조상 클래스의 멤버를 사용할 수 있습니다. */
        programmer.eat();
        programmer.code();
        programmer.buildApi();
    }
}
