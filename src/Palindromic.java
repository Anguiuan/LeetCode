import java.util.Scanner;

public class Palindromic {
    /**
     *
     * @author: yuan
     * @date: 2022/12/28
     * Description: 回文数,
     */

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int i ,temp, num  , number = 0 ;
        System.out.println("请输入一个数：");
        num = scanner.nextInt();
        temp = num ;   //暂存这个数
        while(num != 0){
            i = num % 10; //低位拿出来
            number = number*10 + i  ; //左移一位、累加
            num = num / 10 ; //修改num，右移一位
        }
        if(temp == number){ //与原数比较
            System.out.println("该数是回文数");
        }else{
            System.out.println("该数不是回文数");
        }
    }
}
