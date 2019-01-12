package garg.hackfest;

public class UserData {
    private String UserNumber;
    private String UserName;
    private String UserState;
    private String UserDistrict;

    public UserData() {
    }

    public UserData(String userNumber, String userName, String userState, String userDistrict) {
        UserNumber = userNumber;
        UserName = userName;
        UserState = userState;
        UserDistrict = userDistrict;
    }

    public String getUserNumber() {
        return UserNumber;
    }

    public String getUserName() {
        return UserName;
    }

    public String getUserState() {
        return UserState;
    }

    public String getUserDistrict() {
        return UserDistrict;
    }

    public void setUserNumber(String userNumber) {
        UserNumber = userNumber;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setUserState(String userState) {
        UserState = userState;
    }

    public void setUserDistrict(String userDistrict) {
        UserDistrict = userDistrict;
    }
}
