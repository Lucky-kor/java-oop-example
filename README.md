# 자바 OOP 학습 가이드

이 프로젝트는 자바의 기본 문법과 클래스·객체 학습을 마친 뒤, 객체지향 프로그래밍의 핵심 개념을 순서대로 연습하기 위한 예제입니다.

상속을 시작으로 부모 타입 참조, 메서드 오버라이딩, 컴포지션, 생성자, 접근 제어자, 캡슐화까지 이어집니다. 각 단계를 실행하기 전에 출력 결과를 먼저 예상하고, 실행 후에는 어떤 타입의 어떤 메서드가 호출되었는지 말로 설명해 보세요.

## 선수 지식

이 프로젝트를 시작하기 전에 다음 내용을 알고 있으면 좋습니다.

- 클래스와 객체의 차이
- 필드와 지역 변수의 차이
- 인스턴스 메서드와 static 메서드
- 매개변수, 인자, 반환값
- 메서드 오버로딩
- 객체를 생성하는 `new` 키워드

## 학습 목표

모든 단계를 마치면 다음 내용을 설명할 수 있어야 합니다.

- 상속의 is-a 관계를 설명하고 공통 코드를 부모 클래스로 분리할 수 있다.
- 부모 타입 참조와 실제 객체 타입의 차이를 설명할 수 있다.
- 메서드 오버라이딩과 동적 메서드 호출을 설명할 수 있다.
- 인스턴스 메서드 오버라이딩과 static 메서드 숨김을 구분할 수 있다.
- 상속과 컴포지션을 상황에 맞게 선택할 수 있다.
- 생성자 오버로딩과 `this(...)`를 이용해 중복 초기화를 줄일 수 있다.
- `public`, `protected`, package-private, `private`의 범위를 설명할 수 있다.
- 캡슐화를 이용해 객체가 자신의 상태를 안전하게 관리하게 할 수 있다.

## 권장 학습 순서

| 순서 | 실행 클래스 | 핵심 주제 |
| --- | --- | --- |
| 1 | `step01_inheritance.InheritanceExample` | 상속과 다단계 상속 |
| 2 | `step02_parent_reference.ParentReferenceExample` | 부모 타입 참조와 실제 객체 |
| 3 | `step03_method_overriding.MethodOverridingExample` | 메서드 오버라이딩과 동적 호출 |
| 4 | `step04_static_method_hiding.StaticMethodHidingExample` | static 메서드 숨김 |
| 5 | `step05_composition.CompositionExample` | 객체 포함과 컴포지션 |
| 6 | `step06_constructor.ConstructorExample` | 생성자 오버로딩과 `this(...)` |
| 7 | `step07_access_modifier.AccessModifierExample` | 접근 제어자 |
| 8 | `step08_encapsulation.EncapsulationExample` | 캡슐화와 유효한 상태 관리 |

## 예제 실행 방법

### IntelliJ IDEA에서 실행

1. `src` 폴더에서 학습할 `step` 패키지를 엽니다.
2. 이름이 `Example`로 끝나는 Java 파일을 엽니다.
3. `main` 메서드 왼쪽의 실행 아이콘을 누릅니다.
4. **Run** 창에서 출력 결과를 확인합니다.

### 터미널에서 실행

프로젝트 루트에서 전체 소스를 컴파일합니다.

```bash
mkdir -p out/learning
javac -encoding UTF-8 -d out/learning $(find src -name "*.java")
```

학습 순서 표에 있는 클래스를 지정해 실행합니다.

```bash
java -cp out/learning step01_inheritance.InheritanceExample
```

다른 단계를 실행하려면 마지막 클래스 이름을 변경합니다.

## 1. 상속

학습 파일:

- [`src/step01_inheritance/Person.java`](src/step01_inheritance/Person.java)
- [`src/step01_inheritance/Dancer.java`](src/step01_inheritance/Dancer.java)
- [`src/step01_inheritance/Programmer.java`](src/step01_inheritance/Programmer.java)
- [`src/step01_inheritance/BackendProgrammer.java`](src/step01_inheritance/BackendProgrammer.java)
- [`src/step01_inheritance/InheritanceExample.java`](src/step01_inheritance/InheritanceExample.java)

### 공통 코드를 부모 클래스로 분리하기

댄서와 프로그래머는 모두 이름과 나이를 가지고 걷거나 식사할 수 있습니다. 각 클래스에 같은 필드와 메서드를 반복하지 않고 `Person`에 공통 코드를 정의할 수 있습니다.

```java
public class Person {
    public String name;
    public int age;

    public void walk() {
        System.out.println(name + "이(가) 걷습니다.");
    }
}
```

`Dancer`는 `extends Person`으로 `Person`을 상속하고 자신의 상태와 행동을 추가합니다.

```java
public class Dancer extends Person {
    public String groupName;

    public void dance() {
        System.out.println(name + "이(가) 춤을 춥니다.");
    }
}
```

`Dancer`에 `name`과 `walk()`가 직접 선언되어 있지 않아도 `Person`에서 물려받아 사용할 수 있습니다.

상속은 다음과 같은 is-a 관계가 자연스러울 때 사용합니다.

```text
Dancer는 Person이다.
Programmer는 Person이다.
BackendProgrammer는 Programmer이다.
```

`BackendProgrammer`는 `Programmer`를 상속하고, `Programmer`는 다시 `Person`을 상속합니다. 따라서 `BackendProgrammer` 객체는 `walk()`, `code()`, `buildApi()`를 모두 사용할 수 있습니다. 이를 다단계 상속이라고 합니다.

### 직접 해보기

- `Singer extends Person`을 만들고 `sing()`을 추가합니다.
- `Dancer`에서 `eat()`을 호출할 수 있는 이유를 설명합니다.
- `BackendProgrammer`가 어떤 클래스의 멤버를 물려받는지 정리합니다.
- 상속 단계가 지나치게 깊어지면 어떤 문제가 생길지 생각해 봅니다.

## 2. 부모 타입 참조

학습 파일:

- [`src/step02_parent_reference/Person.java`](src/step02_parent_reference/Person.java)
- [`src/step02_parent_reference/Dancer.java`](src/step02_parent_reference/Dancer.java)
- [`src/step02_parent_reference/ParentReferenceExample.java`](src/step02_parent_reference/ParentReferenceExample.java)

자식 객체는 부모 타입 변수에 저장할 수 있습니다.

```java
Dancer dancer = new Dancer();
Person person = dancer;
```

이 코드에서 객체를 두 개 만든 것이 아닙니다. `dancer`와 `person`은 같은 `Dancer` 객체를 가리킵니다.

```java
System.out.println(person == dancer); // true
```

다만 참조변수로 호출할 수 있는 멤버는 변수의 선언 타입을 기준으로 검사합니다.

```java
person.introduce(); // Person에 선언되어 있으므로 가능
// person.dance();  // Person에는 dance()가 없으므로 컴파일 오류
dancer.dance();     // Dancer 타입이므로 가능
```

정리하면 다음 두 타입을 구분해야 합니다.

```text
Person person = new Dancer();
^^^^^^              ^^^^^^
선언 타입            실제 객체 타입
```

### 직접 해보기

- `person == dancer`가 `true`인 이유를 객체와 참조변수 그림으로 표현합니다.
- `Person another = new Dancer();`를 추가하고 기존 객체와 비교합니다.
- 주석 처리된 `person.dance()`를 실행해 컴파일 오류를 확인한 뒤 되돌립니다.
- 부모 타입으로 여러 종류의 자식 객체를 담을 수 있는 이유를 설명합니다.

## 3. 메서드 오버라이딩

학습 파일:

- [`src/step03_method_overriding/Person.java`](src/step03_method_overriding/Person.java)
- [`src/step03_method_overriding/Dancer.java`](src/step03_method_overriding/Dancer.java)
- [`src/step03_method_overriding/Programmer.java`](src/step03_method_overriding/Programmer.java)
- [`src/step03_method_overriding/MethodOverridingExample.java`](src/step03_method_overriding/MethodOverridingExample.java)

오버라이딩은 부모에게 물려받은 인스턴스 메서드를 자식 클래스에 맞게 다시 구현하는 것입니다.

```java
public class Programmer extends Person {
    @Override
    public void work() {
        System.out.println(name + "이(가) 프로그램을 개발합니다.");
    }
}
```

`@Override`를 붙이면 컴파일러가 부모 메서드를 올바르게 재정의했는지 검사합니다. 이름이나 매개변수를 잘못 작성하면 컴파일 오류로 알려 주므로 사용하는 것이 좋습니다.

### 선언 타입과 실제 실행 메서드

```java
Person firstPerson = new Dancer();
Person secondPerson = new Programmer();

firstPerson.work();  // Dancer의 work()
secondPerson.work(); // Programmer의 work()
```

`work()`를 호출할 수 있는지는 선언 타입인 `Person`을 기준으로 검사합니다. 실제 실행되는 오버라이딩 메서드는 실제 객체 타입인 `Dancer`와 `Programmer`에 따라 결정됩니다. 이를 동적 메서드 디스패치라고 합니다.

### 직접 해보기

- `Singer`를 추가하고 `work()`를 오버라이딩합니다.
- `@Override`를 붙인 상태에서 메서드 이름을 바꾸어 컴파일 오류를 확인합니다.
- 자식의 `work()`에서 `super.work()`를 먼저 호출하고 실행 결과를 비교합니다.
- 오버로딩과 오버라이딩의 차이를 정리합니다.

## 4. static 메서드 숨김

학습 파일:

- [`src/step04_static_method_hiding/Parent.java`](src/step04_static_method_hiding/Parent.java)
- [`src/step04_static_method_hiding/Child.java`](src/step04_static_method_hiding/Child.java)
- [`src/step04_static_method_hiding/StaticMethodHidingExample.java`](src/step04_static_method_hiding/StaticMethodHidingExample.java)

static 메서드는 객체가 아니라 클래스에 속합니다. 자식 클래스가 부모와 같은 static 메서드를 선언해도 인스턴스 메서드처럼 오버라이딩되지 않고 메서드 숨김이 발생합니다.

```java
Parent.printType(); // Parent의 static 메서드
Child.printType();  // Child의 static 메서드
```

반면 인스턴스 메서드는 실제 객체에 따라 선택됩니다.

```java
Parent parentReference = new Child();
parentReference.introduce(); // Child의 인스턴스 메서드
```

static 메서드는 객체 변수로도 호출할 수 있지만 실제 객체와 무관하게 선언 타입을 따르므로 혼동하기 쉽습니다. `Parent.printType()`처럼 클래스 이름으로 호출하는 것이 좋습니다.

| 구분 | 인스턴스 메서드 | static 메서드 |
| --- | --- | --- |
| 자식의 같은 메서드 | 오버라이딩 | 메서드 숨김 |
| 선택 기준 | 실제 객체 타입 | 적어 준 클래스 또는 선언 타입 |
| `@Override` | 사용 가능 | 사용 불가 |

### 직접 해보기

- `Child.printType()`에 `@Override`를 붙여 컴파일 오류를 확인합니다.
- `introduce()`의 `@Override`를 제거해도 실행 결과가 같은 이유를 설명합니다.
- static 메서드를 객체 변수로 호출했을 때 IDE가 표시하는 경고를 확인합니다.
- 오버라이딩과 메서드 숨김의 결정 시점을 비교합니다.

## 5. 컴포지션

학습 파일:

- [`src/step05_composition/Address.java`](src/step05_composition/Address.java)
- [`src/step05_composition/Person.java`](src/step05_composition/Person.java)
- [`src/step05_composition/CompositionExample.java`](src/step05_composition/CompositionExample.java)

컴포지션은 한 객체가 다른 객체를 필드로 포함해 기능을 조합하는 방식입니다.

```java
public class Person {
    public String name;
    public Address address;
}
```

사람은 주소의 한 종류가 아니므로 `Person extends Address`는 자연스럽지 않습니다. 사람은 주소를 가진다는 has-a 관계가 자연스럽습니다.

```text
Dancer is a Person.   → 상속
Person has an Address. → 컴포지션
```

`Person.printProfile()`은 주소 문자열을 직접 조립하지 않고 `Address.getFullAddress()`에 요청합니다. 이처럼 객체가 다른 객체의 메서드를 호출해 함께 작업하는 것을 객체의 협력이라고 합니다.

예제에서는 `Person`과 외부 변수가 같은 `Address` 객체를 참조합니다. 따라서 외부에서 주소 객체의 상태를 바꾸면 `Person`이 출력하는 주소도 바뀝니다. 이 문제는 8단계 캡슐화와 연결해 생각할 수 있습니다.

### 직접 해보기

- `Address`에 우편번호 필드를 추가합니다.
- 같은 `Address` 객체를 두 `Person` 객체에 넣고 주소를 변경해 봅니다.
- `Person`에 `Company` 객체를 포함시켜 직장 정보를 출력합니다.
- 상속보다 컴포지션이 자연스러운 현실 사례를 하나 더 찾아봅니다.

## 6. 생성자

학습 파일:

- [`src/step06_constructor/Car.java`](src/step06_constructor/Car.java)
- [`src/step06_constructor/ConstructorExample.java`](src/step06_constructor/ConstructorExample.java)

생성자는 `new`로 객체를 만들 때 초기 상태를 설정합니다. 클래스 이름과 같고 반환 타입을 작성하지 않습니다.

```java
public Car(String name, String color) {
    this.name = name;
    this.color = color;
}
```

- `this.name`: 현재 자동차 객체의 필드
- `name`: 생성자가 전달받은 매개변수

필드와 매개변수의 이름이 같을 때 `this`로 구분합니다.

### 생성자 오버로딩과 `this(...)`

생성자도 매개변수가 다르면 오버로딩할 수 있습니다.

```java
public Car() {
    this("이름 없는 자동차", "WHITE");
}

public Car(String name) {
    this(name, "WHITE");
}
```

`this(...)`는 같은 클래스의 다른 생성자를 호출합니다. 실제 필드 대입을 두 값을 모두 받는 생성자 한 곳에서 담당하게 하면 초기화 코드의 중복을 줄일 수 있습니다.

클래스에 생성자를 하나도 선언하지 않았을 때만 컴파일러가 인자 없는 기본 생성자를 자동으로 만듭니다. 예제의 `public Car()`는 직접 선언했으므로 정확히는 인자 없는 생성자입니다.

> Java 24 이하에서는 `this(...)`와 `super(...)`가 반드시 생성자의 첫 문장이어야 합니다. Java 25부터는 제한된 문장을 앞에 둘 수 있지만, 이 예제는 여러 버전에서 실행할 수 있도록 첫 문장에 둡니다.

### 직접 해보기

- 세 생성자가 최종적으로 어떤 생성자에 도달하는지 따라가 봅니다.
- 연식 필드를 추가하고 모든 생성자에서 중복 없이 초기화합니다.
- `this.name = name`을 `name = this.name`으로 바꾼 뒤 결과가 달라지는 이유를 설명합니다.
- 모든 생성자를 지운 경우와 하나만 선언한 경우 `new Car()`의 결과를 비교합니다.

## 7. 접근 제어자

학습 파일:

- [`src/step07_access_modifier/Monster.java`](src/step07_access_modifier/Monster.java)
- [`src/step07_access_modifier/other/FireMonster.java`](src/step07_access_modifier/other/FireMonster.java)
- [`src/step07_access_modifier/other/MonsterViewer.java`](src/step07_access_modifier/other/MonsterViewer.java)
- [`src/step07_access_modifier/AccessModifierExample.java`](src/step07_access_modifier/AccessModifierExample.java)

접근 제어자는 클래스의 필드, 메서드, 생성자를 어느 범위까지 공개할지 결정합니다.

| 접근 제어자 | 같은 클래스 | 같은 패키지 | 다른 패키지의 자식 클래스 | 그 밖의 외부 |
| --- | --- | --- | --- | --- |
| `public` | 가능 | 가능 | 가능 | 가능 |
| `protected` | 가능 | 가능 | 자신이 상속받은 멤버에 접근 가능 | 불가능 |
| 생략(package-private) | 가능 | 가능 | 불가능 | 불가능 |
| `private` | 가능 | 불가능 | 불가능 | 불가능 |

`Monster`는 비교를 위해 필드마다 다른 접근 제어자를 사용합니다.

```java
public String name;
protected int hp;
int defense;
private int attack;
```

- 같은 패키지의 `AccessModifierExample`은 `name`, `hp`, `defense`에 접근할 수 있습니다.
- 다른 패키지의 일반 클래스 `MonsterViewer`는 public 멤버만 사용할 수 있습니다.
- 다른 패키지의 자식 클래스 `FireMonster`는 자신이 상속받은 protected 멤버를 사용할 수 있습니다.
- private인 `attack`은 `Monster` 클래스 내부에서만 사용할 수 있습니다.

### 직접 해보기

- 주석 처리된 접근 코드를 한 줄씩 해제해 컴파일 오류를 확인합니다.
- `defense`를 protected로 바꾸고 `FireMonster`에서 사용합니다.
- `printStatus()`를 package-private으로 바꾸고 `MonsterViewer`의 오류를 확인합니다.
- 모든 필드를 public으로 열었을 때 외부에서 만들 수 있는 잘못된 상태를 생각해 봅니다.

## 8. 캡슐화

학습 파일:

- [`src/step08_encapsulation/Person.java`](src/step08_encapsulation/Person.java)
- [`src/step08_encapsulation/EncapsulationExample.java`](src/step08_encapsulation/EncapsulationExample.java)

캡슐화는 객체의 내부 상태를 감추고, 객체가 허용한 방법으로만 상태를 조회하거나 변경하게 하는 것입니다.

```java
private final String name;
private int age;
private String address;
```

필드가 private이므로 외부에서 다음과 같은 잘못된 대입을 할 수 없습니다.

```java
// person.age = -1; // 컴파일 오류
```

필요한 값은 조회 메서드로 제공하고, 상태 변경은 의미가 드러나는 행동으로 제공합니다.

```java
public int getAge() {
    return age;
}

public void celebrateBirthday() {
    age++;
}
```

모든 필드에 getter와 setter를 만드는 것이 캡슐화의 목표는 아닙니다. `setAge(-1)`처럼 어떤 값이든 넣을 수 있게 하면 필드는 private이어도 객체가 유효한 상태를 지키기 어렵습니다.

예제의 `Person`은 다음 방법으로 자신의 상태를 보호합니다.

- 생성자에서 빈 이름과 음수 나이를 거부합니다.
- 이름은 `final`로 선언하고 변경 기능을 제공하지 않습니다.
- 나이는 `celebrateBirthday()`를 통해서만 증가시킵니다.
- 주소는 `moveTo()`에서 빈 값인지 검사한 뒤 변경합니다.

### 직접 해보기

- 음수 나이로 객체를 생성해 어떤 예외가 발생하는지 확인합니다.
- 빈 문자열을 `moveTo()`에 전달해 주소가 변경되지 않는지 확인합니다.
- `setAge(int age)`보다 `celebrateBirthday()`가 안전한 이유를 설명합니다.
- 주소 변경 횟수를 기록하는 private 필드를 만들고 `moveTo()`에서만 증가시킵니다.

## 보충 예제

핵심 단계를 마친 뒤 다음 예제를 추가로 살펴볼 수 있습니다.

| 주제 | 실행 클래스 | 살펴볼 내용 |
| --- | --- | --- |
| 참조값 복사 | `supplementary.reference_copy.ReferenceCopyExample` | 두 변수가 같은 객체를 가리킬 때의 상태 공유 |
| 싱글턴 | `supplementary.singleton.SingletonExample` | private 생성자와 static 메서드로 객체 하나 공유 |

싱글턴은 객체를 하나만 만들도록 제한하는 대표적인 패턴이지만, 전역 상태와 강한 결합을 만들 수 있으므로 무조건 사용하는 방식은 아닙니다. 여기서는 생성자와 접근 제어자의 응용 사례로 살펴봅니다.

## 핵심 용어 정리

| 용어 | 의미 |
| --- | --- |
| 상속 | 부모 클래스의 상태와 행동을 자식 클래스가 물려받는 것 |
| 부모 클래스 | 공통 상태와 행동을 제공하는 상위 클래스 |
| 자식 클래스 | 부모를 상속하고 기능을 사용하거나 확장하는 클래스 |
| 부모 타입 참조 | 자식 객체를 부모 타입 변수로 가리키는 것 |
| 선언 타입 | 참조변수를 선언할 때 작성한 타입 |
| 실제 객체 타입 | `new`로 실제 생성한 객체의 타입 |
| 오버라이딩 | 부모의 인스턴스 메서드를 자식 클래스에 맞게 재정의하는 것 |
| 동적 메서드 디스패치 | 실행할 오버라이딩 메서드를 실제 객체 타입에 따라 결정하는 것 |
| 메서드 숨김 | 자식의 static 메서드가 같은 선언의 부모 static 메서드를 가리는 것 |
| 컴포지션 | 객체가 다른 객체를 필드로 포함해 기능을 조합하는 것 |
| 생성자 | 객체를 만들 때 초기 상태를 설정하는 특별한 코드 |
| 접근 제어자 | 클래스와 멤버를 사용할 수 있는 범위를 정하는 키워드 |
| 캡슐화 | 내부 상태를 감추고 허용한 기능으로만 사용하거나 변경하게 하는 것 |

## 전체 학습 확인 질문

1. 상속을 사용하기에 적절한 is-a 관계는 무엇인가?
2. `BackendProgrammer`가 `Person`의 메서드를 사용할 수 있는 이유는 무엇인가?
3. `Person person = new Dancer();`에서 선언 타입과 실제 객체 타입은 각각 무엇인가?
4. 부모 타입 변수로 자식 클래스에만 선언된 메서드를 직접 호출할 수 없는 이유는 무엇인가?
5. 부모 타입으로 `work()`를 호출해도 자식의 메서드가 실행되는 이유는 무엇인가?
6. 오버로딩과 오버라이딩은 무엇이 다른가?
7. static 메서드 숨김과 인스턴스 메서드 오버라이딩은 무엇이 다른가?
8. 상속의 is-a 관계와 컴포지션의 has-a 관계는 어떻게 다른가?
9. `this(name, "WHITE")`는 무엇을 호출하는가?
10. 컴파일러가 인자 없는 기본 생성자를 자동으로 만드는 조건은 무엇인가?
11. `public`, `protected`, package-private, `private`의 범위는 어떻게 다른가?
12. 모든 필드를 private으로 바꾸고 setter를 제공하는 것만으로 충분한 캡슐화가 되지 않는 이유는 무엇인가?

답하기 어려운 질문이 있다면 해당 단계를 다시 실행하고, 참조변수의 선언 타입과 실제 객체 타입, 호출 전후의 필드 상태를 직접 적어 보세요.
