package step01_inheritance;

/** Person을 상속하면서 프로그래머에게만 필요한 상태와 행동을 추가합니다. */
public class Programmer extends Person {

    public String companyName;

    /** Programmer 객체와 그 자식 객체가 사용할 수 있는 행동입니다. */
    public void code() {
        System.out.println(name + "이(가) " + companyName + "에서 코드를 작성합니다.");
    }
}
