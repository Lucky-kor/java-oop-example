package step02_parent_reference;

/** 부모 타입 참조가 공통으로 다룰 수 있는 상태와 행동을 정의합니다. */
public class Person {

    public String name;

    /** Person과 모든 자식 객체가 공통으로 사용할 수 있는 메서드입니다. */
    public void introduce() {
        System.out.println("안녕하세요. " + name + "입니다.");
    }
}
