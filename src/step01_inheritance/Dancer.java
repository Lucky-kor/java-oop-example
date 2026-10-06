package step01_inheritance;

/** Person을 상속하면서 댄서에게만 필요한 상태와 행동을 추가합니다. */
public class Dancer extends Person {

    public String groupName;

    /** Dancer 객체만 가지는 고유한 행동입니다. */
    public void dance() {
        System.out.println(name + "이(가) " + groupName + "의 안무를 춥니다.");
    }
}
