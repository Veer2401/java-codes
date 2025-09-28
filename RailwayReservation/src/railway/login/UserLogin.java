package RailwayReservation.src.railway.login;

public class UserLogin extends Login {
    
    @Override
    public boolean login(String username,String password){
        if(username.equals("user") && password.equals("1234")){
            return true;
        } else{
            return false;
        }
    }
}
