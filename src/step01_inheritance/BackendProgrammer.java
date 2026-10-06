package step01_inheritance;

/**
 * Programmer를 다시 상속한 다단계 상속 예제입니다.
 * BackendProgrammer는 Programmer의 code()와 Person의 walk(), eat()을 모두 물려받습니다.
 */
public class BackendProgrammer extends Programmer {

    /** 백엔드 프로그래머에게만 있는 행동입니다. */
    public void buildApi() {
        System.out.println(name + "이(가) API를 개발합니다.");
    }
}
