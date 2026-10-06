package step02_parent_reference;

/** 자식 객체를 부모 타입 변수로 참조할 때 사용할 수 있는 멤버를 확인합니다. */
public class ParentReferenceExample {

    public static void main(String[] args) {
        Dancer dancer = new Dancer();
        dancer.name = "김댄서";

        /* Dancer는 Person의 한 종류이므로 부모 타입 변수에 저장할 수 있습니다. */
        Person person = dancer;

        /* 두 변수는 타입은 다르지만 같은 Dancer 객체를 가리킵니다. */
        System.out.println("같은 객체인가? " + (person == dancer));
        person.introduce();

        /* 호출 가능한 멤버는 참조변수의 선언 타입을 기준으로 검사합니다. */
        // person.dance(); // Person 타입에는 dance()가 없으므로 컴파일되지 않습니다.
        dancer.dance();
    }
}
