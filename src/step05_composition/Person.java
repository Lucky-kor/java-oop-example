package step05_composition;

/**
 * Person이 Address를 필드로 가지는 컴포지션 예제입니다.
 * 사람은 주소의 한 종류가 아니라 주소를 가지므로 상속보다 포함 관계가 자연스럽습니다.
 */
public class Person {

    public String name;
    public Address address;

    /** Person이 가진 Address 객체에 일을 위임해 전체 주소를 출력합니다. */
    public void printProfile() {
        System.out.println("이름: " + name);
        System.out.println("주소: " + address.getFullAddress());
    }
}
