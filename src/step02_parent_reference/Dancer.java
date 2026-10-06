package step02_parent_reference;

/** Person의 기능을 물려받고 춤추는 기능을 추가한 자식 클래스입니다. */
public class Dancer extends Person {

    /** Dancer 타입에만 선언된 고유 메서드입니다. */
    public void dance() {
        System.out.println(name + "이(가) 춤을 춥니다.");
    }
}
