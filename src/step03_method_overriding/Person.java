package step03_method_overriding;

/** 자식 클래스들이 공통으로 상속할 상태와 기본 동작을 정의합니다. */
public class Person {

    public String name;

    /** 모든 자식 클래스가 그대로 사용할 수 있는 공통 메서드입니다. */
    public void introduce() {
        System.out.println("안녕하세요. " + name + "입니다.");
    }

    /** 자식 클래스가 자신의 직업에 맞게 재정의할 기본 동작입니다. */
    public void work() {
        System.out.println(name + "이(가) 일합니다.");
    }
}
