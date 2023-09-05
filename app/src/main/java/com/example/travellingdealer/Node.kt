package com.example.travellingdealer

import kotlin.math.pow
import kotlin.math.sqrt

class Node(var x: Int, var y: Int) {

    var distance: Double? = null
    private var following: Node? = null

    fun appendToEnd(x: Int, y: Int) {

        //Bulunduğum konumdan (x,y) - hedeflediğimiz konumu çıkartıyoruz. (x,y).
        //Çıkan x ve y değerlerinin toplamlarının karakökü alınır. Kök dışarı çıkartılır ve mesafe bulunur.

        val end = Node(x = x, y = y)
        var n: Node? = this

        val xvalue = (n!!.x - x).toDouble().pow(2)
        val yValue = (n.y - y).toDouble().pow(2)
        end.distance = sqrt((xvalue + yValue))

        while (n!!.following != null) {
            n = n.following
        }
        n.following = end
    }

    // TODO:: Implement to return the length of the SinglyLinkedList
    // For example:: --> 5 --> 6 --> 7 --> 3 --> .
    fun printNodes(): String {

        var nodesData = "Factory(3, 7)"

        val node = this

        var n: Node? = node.following
        while (n != null) {
            val stringPath = String.format("%.2f", n.distance)
            nodesData =
                "$nodesData\nCustomer(${n.x}, ${n.y}) - $stringPath"
            n = n.following
        }
        return nodesData
    }

    fun length(): Int {

        var length = 0
        var tempNode: Node? = this
        while (tempNode != null) {
            length++
            tempNode = tempNode.following
        }
        return length
    }

    fun sumOfNodes(): Double {

        var distance = 0.0

        val node = this

        var n: Node? = node
        while (n != null) {
            distance += n.distance!!
            n = n.following
        }
        return distance
    }

    fun deleteNode(x: Int, y: Int): String {

        val node = this

        var tempNode: Node? = node
        var prevNode: Node? = null

        if (tempNode != null && tempNode.x == x && tempNode.y == y) {
            return "You can't delete the factory"
        }

        while (tempNode != null && !(tempNode.x == x && tempNode.y == y)) {
            prevNode = tempNode
            tempNode = tempNode.following
        }

        if (tempNode == null)
            return "($x, $y) not found"

        prevNode?.following = tempNode.following
        return "($x, $y) deleted"
    }
}
