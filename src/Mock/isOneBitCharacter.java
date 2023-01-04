package Mock;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:isOneBitCharacter
 * @Auther: yyj
 * @Description:
 * @Date: 31/12/2022 14:02
 * @Version: v1.0
 */
public class isOneBitCharacter {
    public static void main(String[] args) {
        isOneBitCharacter(new int[]{0,0,1,1,1,0});
    }

    //1,1,1,1,0
    //1,0,0
    static  public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        int index = 0;
        boolean flag = false;
        int times =0;
        while (index < len){
            if(bits[index] == 1){
                flag = true;
                if(times == 2){
                    times = 1;
                }else {
                    times++;
                }
            }else  if(bits[index] == 0){
                if(flag){
                    if(index + 1 == len && times !=2 ){
                        return false;
                    }
                    flag = false;
                }
                times = 0;

            }
            index++;
        }
        return  true;
    }

}
