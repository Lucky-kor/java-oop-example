package supplementary.reference_copy;

import step02_parent_reference.Person;

/**
 * 부모 타입 참조 학습을 마친 뒤 보면 좋은 추가 예제입니다.
 * 객체 변수 사이에 참조값을 복사하면 어떤 일이 생기는지 확인합니다.
 */
public class ReferenceCopyExample {

    public static void main(String[] args) {
        Person original = new Person();
        original.name = "김러키";

        /* new를 사용하지 않았으므로 새 Person 객체를 만드는 코드가 아닙니다. */
        Person copiedReference = original;

        System.out.println("같은 객체를 가리키는가? " + (original == copiedReference)); // true

        /* 두 변수가 같은 객체를 가리키므로 한쪽에서 바꾼 값이 다른 쪽에서도 보입니다. */
        copiedReference.name = "김행운";

        System.out.println("original로 읽은 값");
        original.introduce();

        System.out.println("copiedReference로 읽은 값");
        copiedReference.introduce();
    }
}
