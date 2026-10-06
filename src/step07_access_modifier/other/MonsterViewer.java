package step07_access_modifier.other;

import step07_access_modifier.Monster;

/** 상속 관계가 없는 다른 패키지의 클래스가 접근할 수 있는 범위를 보여 줍니다. */
public class MonsterViewer {

    public void print(Monster monster) {
        System.out.println("외부에서 확인한 이름: " + monster.name);
        monster.printStatus();

        // System.out.println(monster.hp);      // protected라 일반 외부 객체에서는 접근할 수 없습니다.
        // System.out.println(monster.defense); // package-private라 다른 패키지에서는 접근할 수 없습니다.
        // System.out.println(monster.attack);  // private라 Monster 밖에서는 접근할 수 없습니다.
    }
}
