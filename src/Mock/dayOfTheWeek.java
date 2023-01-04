package Mock;

/**
 * @ClassName:dayOfTheWeek
 * @Auther: yyj
 * @Description:
 * @Date: 03/01/2023 12:49
 * @Version: v1.0
 */
public class dayOfTheWeek {

    public static void main(String[] args) {
        dayOfTheWeek(31,8,2019);
    }
    static public String dayOfTheWeek(int day, int month, int year) {
        boolean leap=(year%400==0||(year%4==0&&year%100!=0));//判断是否为闰年
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday"};
        int[] dayOfMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        int total = 0;
        for (int i=1971; i<year; i++) {
            if (i%4 == 0) {
                total++;
            }
            total += 365;
        }
        if (leap) {
            dayOfMonth[1] = 29;
        }
        for(int i  =0;i<month -1;i++){
            total += dayOfMonth[i];
        }
        total += day - 1;
        return week[(total + 5)%7];


    }
}
