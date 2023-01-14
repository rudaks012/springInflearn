package hello.core.singleton;

public class SingletonService {

    //1. static 영역에 객체를 딱 1개만 생성(자기 자신을 생성)
    private static final SingletonService instance = new SingletonService();

    //2. public 으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용
    public static SingletonService getInstance() {
        return instance;
    }
    //3. 생성자를 private 으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막음
    private SingletonService() {
    }
    //4. 이 객체 인스턴스가 필요하면 오직 logic() 메서드를 통해서만 조회할 수 있음
    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
