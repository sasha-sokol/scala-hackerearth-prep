import scala.collection.Searching._
import scala.util.control.Breaks._

object CodingQuestions {

    def q1(nums: Array[Int], target: Int): Array[Int] = {  //  nlog(n) using binary search
        val numsSorted = nums.sorted
        var result = new Array[Int](2)
        breakable {
            for (i <- 0 until nums.length) {
                numsSorted.search(target - nums(i)) match {  // binary search
                    case Found(j) => {  // j is the index of (target - nums(i)) in the sorted list
                        result(0) = i
                        result(1) = nums.indexOf(target - nums(i))
                        break()
                    }
                    case InsertionPoint(_) => 
                }
            }
        }
        return result
    }

    def q2() = {}

    def q3() = {}

    def q4(nums1: Array[Int], nums2: Array[Int]) = {
        // val m = nums1.length
        // val n = nums2.length

        // var med1 = nums1(m/2)
        // var med2 = nums2(n/2)


    }

    def main(args: Array[String]): Unit = {
        print("Hello world")
    }

}