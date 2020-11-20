/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duynk.util.test;


import duynk.util.MathUtility;
import static duynk.util.MathUtility.getFactorial;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author duyuminh11
 */
public class MathUtilityTest {
    
   
        @Test // biiến hàm ở trong class này thanh public static void main()
        // nhờ bộ thư viện JUnit
        // trong khi đó mình cần test thử hàm thoi, k can thiệp main()
        // vậy mình cần main() khác, @Test giúp điều đó
        // nhưng vì có nhiều main() CPU bị bối rối khi nhấn F6
        //F6 dành cho main() default
        //Shift F6 dành cho bên này
        public void getFactorial_RunsWell_IfValidArgument(){
            assertEquals(120, MathUtility.getFactorial(5));
            assertEquals(5040, MathUtility.getFactorial(7));
            
    }
        
        @Test(expected = SQLException.class)
        public void GetFactorial_ThrowsException_IfInvalidArgument(){
            //ngoại lệ ko phải là value để assert()
            //chỉ có thể chụp nó lại
            getFactorial(-5);
        }
    
}
