package step01_inheritance;

/**
 * 여러 직업 클래스가 공통으로 가지는 사람의 상태와 행동을 정의합니다.
 * 자식 클래스는 Person의 필드와 메서드를 물려받아 다시 선언하지 않고 사용할 수 있습니다.
 */
public class Person {

    public String name;
    public int age;

    /** 모든 사람이 할 수 있는 공통 행동입니다. */
    public void walk() {
        System.out.println(name + "이(가) 걷습니다.");
    }

    /** 모든 사람이 할 수 있는 공통 행동입니다. */
    public void eat() {
        System.out.println(name + "이(가) 식사합니다.");
    }
}
