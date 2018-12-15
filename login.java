import java.util.Scanner;

class Login extends Get_a_login
{
    public static void main(String[] args)  {

        for (int missmatch_times=0;missmatch_times<3;missmatch_times++){
            String temp_name=get_a_name();
            String temp_password=get_a_password();
            if (temp_name.equals(accountname)&&temp_password.equals(accountpassword))
            {
                System.out.println("用户"+accountname+"登录成功!");
                break;
            }
            else if (missmatch_times!=2)
                System.out.println("用户名或密码错误，剩余"+(2-missmatch_times)+"次尝试机会");
                else {System.out.println("用户名或密码错误，剩余"+(2-missmatch_times)+"次尝试机会");
                System.out.println("今日尝试次数已经完，请明天再试");}
        }







    }
}
class Account{
     static String accountname="Admin";
     static String accountpassword="Admin";

}
class Get_a_login extends Account{
     static String get_a_name() {
        System.out.println("请输入用户名，以enter键结束");
        Scanner name_scan_obj = new Scanner(System.in);
        return name_scan_obj.nextLine();
    }
      static String get_a_password(){
        System.out.println("请输入密码，以enter键结束");
        Scanner password_scan_obj = new Scanner(System.in);
        return  password_scan_obj.nextLine();

    }
}