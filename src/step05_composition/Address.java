package step05_composition;

/** 주소와 관련된 상태와 표시 방법을 하나의 객체로 묶습니다. */
public class Address {

    public String city;
    public String district;

    /** 주소 필드를 사람이 읽기 좋은 한 문장으로 조합합니다. */
    public String getFullAddress() {
        return city + " " + district;
    }
}
