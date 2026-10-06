package step03_method_overriding;

/** 부모 타입으로 호출해도 실제 객체의 재정의된 메서드가 실행되는지 확인합니다. */
public class MethodOverridingExample {

    public static void main(String[] args) {
        Dancer dancer = new Dancer();
        dancer.name = "김댄서";

        Programmer programmer = new Programmer();
        programmer.name = "이개발";

        /* 부모 타입 변수에 서로 다른 자식 객체를 저장합니다. */
        Person firstPerson = dancer;
        Person secondPerson = programmer;

        printDailyWork(firstPerson);
        printDailyWork(secondPerson);
    }

    /**
     * 매개변수 타입은 Person이지만 실행할 work()는 실제 객체 타입에 따라 결정됩니다.
     * 이것을 동적 메서드 디스패치라고 합니다.
     */
    private static void printDailyWork(Person person) {
        person.introduce();
        person.work();
    }
}
