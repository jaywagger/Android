package exam.day03.view.selectview.view.adapter;

//row에 출력할 데이터 정보를 담는 객체
public class User {
    int myImg; //리소스에서 가져올꺼고 리소스는 모두 int
    String name;
    String telNum;

    public User(int myImg, String name, String telNum) {
        this.myImg = myImg;
        this.name = name;
        this.telNum = telNum;
    }

    @Override
    public String toString() {
        return "User{" +
                "myImg=" + myImg +
                ", name='" + name + '\'' +
                ", telNum='" + telNum + '\'' +
                '}';
    }
}
