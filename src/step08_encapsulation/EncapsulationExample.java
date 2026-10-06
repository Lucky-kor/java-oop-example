package step08_encapsulation;

/** private 필드가 외부의 잘못된 변경을 막고 객체의 메서드가 상태를 관리하는지 확인합니다. */
public class EncapsulationExample {

    public static void main(String[] args) {
        Person person = new Person("김러키", 20, "서울특별시 마포구");

        printPerson(person);

        /* 필드에 직접 대입하지 않고 Person이 공개한 행동을 통해 상태를 바꿉니다. */
        person.celebrateBirthday();
        person.moveTo("서울특별시 종로구");

        printPerson(person);

        // person.age = -1; // private 필드이므로 외부에서 잘못된 값을 직접 넣을 수 없습니다.
    }

    /** 공개된 조회 메서드만 사용해 Person의 현재 상태를 출력합니다. */
    private static void printPerson(Person person) {
        System.out.println(person.getName() + ", " + person.getAge() + "세, " + person.getAddress());
    }
}
