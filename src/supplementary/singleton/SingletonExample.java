package supplementary.singleton;

/** 여러 번 조회해도 같은 객체가 반환되는지만 확인하는 선택 학습 예제입니다. */
public class SingletonExample {

    public static void main(String[] args) {
        AppSettings firstSettings = AppSettings.getInstance();
        AppSettings secondSettings = AppSettings.getInstance();

        System.out.println("같은 객체인가? " + (firstSettings == secondSettings)); // true

        firstSettings.theme = "dark";
        System.out.println("두 번째 변수로 읽은 테마: " + secondSettings.theme);
    }
}
