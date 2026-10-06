package step07_access_modifier;

import step07_access_modifier.other.FireMonster;
import step07_access_modifier.other.MonsterViewer;

/** 같은 패키지, 다른 패키지, 상속 관계에 따른 접근 가능 범위를 확인합니다. */
public class AccessModifierExample {

    public static void main(String[] args) {
        Monster slime = new Monster("슬라임", 100, 5, 10);

        /* 같은 패키지에서는 public, protected, package-private 멤버에 접근할 수 있습니다. */
        System.out.println(slime.name);
        System.out.println(slime.hp);
        System.out.println(slime.defense);
        // System.out.println(slime.attack); // private 멤버는 같은 패키지에서도 접근할 수 없습니다.

        FireMonster dragon = new FireMonster("화염 드래곤", 500, 30, 80);
        dragon.rest();

        /* 상속 관계가 없는 다른 패키지의 객체에는 public 기능만 공개됩니다. */
        MonsterViewer viewer = new MonsterViewer();
        viewer.print(dragon);
    }
}
