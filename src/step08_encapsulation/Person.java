package step08_encapsulation;

/**
 * 필드를 private으로 감추고 유효한 메서드를 통해서만 상태를 변경하게 합니다.
 * 캡슐화는 단순히 getter와 setter를 만드는 것이 아니라 객체가 자신의 상태를 지키게 하는 것입니다.
 */
public class Person {

    private final String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
        }
        if (age < 0) {
            throw new IllegalArgumentException("나이는 0보다 작을 수 없습니다.");
        }

        this.name = name;
        this.age = age;
        this.address = address;
    }

    /** 이름은 생성 후 바꿀 수 없으므로 조회 기능만 제공합니다. */
    public String getName() {
        return name;
    }

    /** 외부에서 나이를 읽을 수 있도록 현재 값을 반환합니다. */
    public int getAge() {
        return age;
    }

    /** 외부에서 주소를 읽을 수 있도록 현재 값을 반환합니다. */
    public String getAddress() {
        return address;
    }

    /** 나이를 임의의 값으로 대입하지 않고 생일이라는 의미 있는 행동으로 변경합니다. */
    public void celebrateBirthday() {
        age++;
    }

    /** 주소가 비어 있는 상태가 되지 않도록 검사한 뒤 변경합니다. */
    public void moveTo(String newAddress) {
        if (newAddress == null || newAddress.isBlank()) {
            throw new IllegalArgumentException("주소는 비어 있을 수 없습니다.");
        }
        address = newAddress;
    }
}
