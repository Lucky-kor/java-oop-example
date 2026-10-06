package step03_method_overriding;

/** Person의 work()를 프로그래머에게 맞는 동작으로 재정의합니다. */
public class Programmer extends Person {

    @Override
    public void work() {
        System.out.println(name + "이(가) 프로그램을 개발합니다.");
    }
}
