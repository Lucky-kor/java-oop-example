package step07_access_modifier;

/** 네 가지 접근 제어자가 허용하는 접근 범위를 비교하기 위한 클래스입니다. */
public class Monster {

    public String name;
    protected int hp;
    int defense;
    private int attack;

    public Monster(String name, int hp, int defense, int attack) {
        this.name = name;
        this.hp = hp;
        this.defense = defense;
        this.attack = attack;
    }

    /** private 필드도 클래스 내부에서는 자유롭게 사용할 수 있습니다. */
    public void printStatus() {
        System.out.printf("%s - HP: %d, 방어력: %d, 공격력: %d%n", name, hp, defense, attack);
    }

    /** 다른 패키지의 자식 클래스가 호출할 수 있도록 protected로 선언합니다. */
    protected void recover(int amount) {
        hp += amount;
    }
}
