//Approach-3 (Using Bit and Maths)
//T.C : O(1)
class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n - 1) % 3 == 0;
    }
}


// //Approach-2 (Using Maths)
// //T.C : O(log(a)) -> pow(4, a),the exponentiation operation still requires logarithmic time with respect to the value of a.
// class Solution {
//     public boolean isPowerOfFour(int n) {
//         if (n <= 0) {
//             return false;
//         }
        
//         int a = (int) (Math.log(n) / Math.log(4));
//         /*
//             4^a = n
//             a = log(n) to base 4
//             a = log(n) to base e / log(4) to base e
//         */
        
//         return n == Math.pow(4, a);
//     }
// }



// //Approach-1 (Simplest for loop)
// //T.C : log(n) to base 4
// class Solution {
//     public boolean isPowerOfFour(int n) {
//         if (n==1) return true;
//         if (n<=0) return false;

//         return n%4==0 && isPowerOfFour(n/4);
//     }
// }


// class Solution {
//     public boolean isPowerOfFour(int n) {
//         if(n<=0) return false;
        
//         while(n%4==0){
//             n = n/4;
//         }
//         return n==1;
//     }
// }