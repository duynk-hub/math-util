/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duynk.util;

/**
 *
 * @author duyuminh11
 */
public class MathUtility {
    // mình sẽ làm class này fake giống như class Math của JDK
    // Math.PI .abs()   .sqrt() .pow()  .sin()
    //cái gì mà là đồ sài chung, ko lưu trữ riêng lẻ info ta sẽ chơi static

    public static final double PI = 3.1415;

    // xài : MathUtility.PI y chang Math.PI
    //hàm tính n! = 1.2.3.4.5...n
    //ta chỉ tính n! từ 0...20
    //ngoài vùng này, dù âm hay lố 20, k tính, chửi = Exception
    //quy ước 0! = 1! = 1;
    // học cách ném ngoại lệ
    public static long getFactorial(int n) {
        if(n<0 || n>20)
            throw new IllegalArgumentException("n must be between 0..20");
        
        if (n==0 || n ==1)
            return 1; //1 lệnh trong ì ko xài ngoặc
        
        // chỗ này thằng nào xài else bị trừ điểm
        // ngay chổ này chính là n=2..20
        long result =1;
        for (int i = 2; i <= n; i++) 
            result *= i;
            
        return result;
        
    }

        // ta tự tin gáy hàm ta chạy ngon, chạy đúng
        //nhưng: team thì cần chứng minh điều đó, đảm bảo chất lượng code, chất lượng 
        // muốn chứng minh hàm chạy đúng hay ko ta cần test thử
        //test nghĩa là đưa hàm ra xài, gọi với các tham số khác nhau
    // ví dụ gọi hàm getFactorial( với các số khác đưa vào)
    // getF(-5), getF(-1) getF(0), getF(5), getF(20), getF(21), ....
    //các giá trị đầu vào đại diện cho việc xài hàm,
    // ta còn gọi là test cases, các tình huống cần test, các tình huống xài hàm
    // khi ta test hàm, ta cần quan tâm 2 việc
    // 1. dự kiến trả về giá trị gì khi hàm chạy vs 1 đầu vào nào đó
    //    dự kiến trả về giá trị, tui gọi là EXPECTED VALUE
    //    ví dụ: hàm sẽ trả về 120 khi gọi getF(5!)
    // 2. hàm khi chạy vs 1 đầu vào nào đó, thì sẽ ói/ return về 1 value
    //    cái value trả về của hàm khi chạy đc gọi là ACTUAL VALUE
    
    // NGHỀ TEST CHÍNH LÀ: SO SÁNH COI EXPECTED VALUE CÓ BẰNG VS ACTUAL VALUE K?
    // NẾU CÓ BẰNG, HÀM ĐÚNG CHO CASE/ TÌNH HUỐNG NÀY
    // NẾU K BẰNG, HÀM TÍNH TOÁN SAI, HOẶC KÌ VỌNG SAI
    
    // HÀM MÀ TỐT THÌ PHẢI LÀ EXPECTED == ACTUAL MỌI TÌNH HUỐNG
    // NẾU TỐT TA MỚI ĐEM RA XÀI, BÁN, PUBLIC CỘNG ĐỒNG XÀI
    
    // LÀM SAO ĐỂ TEST HÀM COI CÓ TỐT K, EXPECTED == ACTUAL
    // HAI KĨ THUẬT ĐC ÁP DỤNG
    // KỈ THUẬT 1: nhìn bằng mắt và so sánh từng cặp expected vs actual
    //             chính là kỉ thuật sout(expected), sout(actual- hàm ói về j khi chạy)
    // kỉ thuật này đơn giản, dễ làm, nhưng mắc sai sót do có quá nhiều cặp
    // expected actual cần so sánh = mắt
    
    // kỉ thuật 2: nhìn bằng mắt, ko cần so sánh từng cặp, để máy so sánh giùm luôn
    //             mắt nhìn 2 màu XANH-ĐỎ duy nhất
    // nếu tất cả các cặp actual vs expecteđ đều thỏa, có 1 vài cái k thỏa
    // THÌ KẾT LUẬN NGÀY, HÀM SAI, MÀU ĐỎ CHO TẤT CẢ
    // điều này giải thích là: đúng thì phải đúng cho tất cả mọi tình huống hàm chạy 
    // chỉ cần 1 thằng sai, hàm sai
    
    // tương đương câu: hàm tui chạy ngon lắm, đúng 99%, lâu lâu sai tí?
    // Kỉ THUẬT 2 NÀY DÙNG MÀU SẮC, MUỐN LÀM VẬY THÌ PHẢI XÀI THƯ VIỆ BỔ XUNG THÊM
    // CHÍNH LÀ FILE, .JAR, .DLL ĐC CUNG CẤP THÊM NGOÀI JDK
    // các thư viện này tùy thuộc ngôn ngữ lập trình , đc gọi là 
    // C#: thư viện cụ thể NUnit, MSUnit, xUnit
    // Java: thư viện cụ thể JUnit, TestNG, xUnit
    // PHP: PHPUnit
    // C++: CPPUnit
    //...
    
    public static void main(String[] args) {
        long expected = 120;                        //hi vọng 120 đc ói về nếu
        long actual = MathUtility.getFactorial(5);  // gọi hàm 5!
        System.out.println("5!? expected " + expected + "; actual: " + actual);
        // đúng cho case tình huống đầu tiên
        
        expected = 720;                         // hy vọng đc ói về 720 nếu
        actual = MathUtility.getFactorial(6);  // gọi hàm 6!
        System.out.println("5!? expected " + expected + "; actual: " + actual);
        // đúng case 2
        
        //case 3:
        System.out.println("0! expected: 1; actual: " + MathUtility.getFactorial(0));
        
        
        //case 4:
        // tao kì vọng nhận về ngoại lệ IllegalArgumentException
        // nếu t gọi -5!
        MathUtility.getFactorial(-50);
        //thấy ngoại lệ lại mừng vì hàm chạy như thiết kế
        
    }
}


//cất code lên server GitHub
//cần:
// nhớ kho trên GitHub, url: https://github.com/duynk-hub/math-util.git
// nhớ username và pass và email vào GitHub của mình 
// cần tool để đồng bộ code từ máy mình (local) lên server (GitHub, GitLab, Git)
// tool có thể là: cmd, GUI(Git Desktop, Source Tree), chính IDE(cmd, click)
// vì ta pro, ta chơi cmd
// cài git scm đã nói download sẵn