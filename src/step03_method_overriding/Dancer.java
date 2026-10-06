package step03_method_overriding;

/** Person의 work()를 댄서에게 맞는 동작으로 재정의합니다. */
public class Dancer extends Person {

    @Override
    public void work() {
        System.out.println(name + "이(가) 무대에서 공연합니다.");
    }
}
