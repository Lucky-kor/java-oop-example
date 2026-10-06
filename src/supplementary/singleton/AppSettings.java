package supplementary.singleton;

/**
 * static 멤버를 응용해 하나의 객체를 공유하는 싱글턴 추가 예제입니다.
 */
public class AppSettings {

    private static AppSettings instance;

    public String theme = "light";

    /* 다음 주에 배울 생성자와 접근 제어자가 사용되므로 지금은 구조만 관찰합니다. */
    private AppSettings() {
    }

    public static AppSettings getInstance() {
        if (instance == null) {
            instance = new AppSettings();
        }
        return instance;
    }
}
