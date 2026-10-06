package step05_composition;

/** 객체가 다른 객체를 필드로 포함하고 협력하는 방법을 확인합니다. */
public class CompositionExample {

    public static void main(String[] args) {
        Address homeAddress = new Address();
        homeAddress.city = "서울특별시";
        homeAddress.district = "마포구";

        Person person = new Person();
        person.name = "김러키";

        /* Person 안에 Address 객체를 넣어 has-a 관계를 만듭니다. */
        person.address = homeAddress;
        person.printProfile();

        /* 같은 Address 객체의 상태가 바뀌면 Person이 출력하는 주소에도 반영됩니다. */
        homeAddress.district = "종로구";
        person.printProfile();
    }
}
