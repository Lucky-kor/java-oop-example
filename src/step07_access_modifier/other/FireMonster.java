package step07_access_modifier.other;

import step07_access_modifier.Monster;

/** 다른 패키지에 있지만 Monster를 상속한 클래스입니다. */
public class FireMonster extends Monster {

    public FireMonster(String name, int hp, int defense, int attack) {
        super(name, hp, defense, attack);
    }

    /** 자식 클래스는 상속받은 객체의 protected 멤버에 접근할 수 있습니다. */
    public void rest() {
        recover(10);
        System.out.println(name + "이(가) 쉬어서 체력을 회복했습니다. 현재 HP: " + hp);

        // System.out.println(defense); // 다른 패키지의 package-private 필드라 접근할 수 없습니다.
        // System.out.println(attack);  // private 필드라 자식 클래스에서도 접근할 수 없습니다.
    }
}
