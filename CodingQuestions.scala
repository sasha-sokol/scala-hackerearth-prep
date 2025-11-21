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

    class Node(var value: Int) {
        private var nextNode: Node = null

        var hasNext: Boolean = false

        def next = nextNode

        def setNext(n: Node): Node = {
            nextNode = n
            hasNext = true
            return this
        }

        def removeNext() = {
            hasNext = false
        }

        override def toString(): String =
            (if (hasNext) nextNode.toString() else "")
            + value.toString()
    }

    def q2(x0: Node, y0: Node): Node = {
        var result: Node = null
        var resultTail: Option[Node] = None

        var x: Node = x0  // iterates through the list
        var y: Node = y0  // iterates through the list

        var sum = 0
        var carry = 0
        var complete = false
        while (!complete) {
            sum += x.value
            sum += y.value
            while (sum >= 10) {
                sum -= 10
                carry += 1
            }  // Sum now contains the correct digit
            
            resultTail match {
                case None => {
                    result = Node(sum)
                    resultTail = Some(result)
                }
                case Some(n) => {
                    val n1 = Node(sum)
                    n.setNext(n1)
                    resultTail = Some(n1)
                }
            }

            if (x.hasNext) x = x.next
            else x = Node(0)  // End of list
            if (y.hasNext) y = y.next
            else y = Node(0)  // End of list

            complete = !x.hasNext && !y.hasNext && carry == 0

            sum = carry  // Reset sum for the next iteration
            carry = 0
        }

        return result
    }

    def q3() = {}

    def q4(nums1: Array[Int], nums2: Array[Int]) = {
        // val m = nums1.length
        // val n = nums2.length

        // var med1 = nums1(m/2)
        // var med2 = nums2(n/2)


    }

    def main(args: Array[String]): Unit = {
        print(q2(Node(2).setNext(Node(4).setNext(Node(3))),
            Node(5).setNext(Node(6).setNext(Node(4)))))
    }

}