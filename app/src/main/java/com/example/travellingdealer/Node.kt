package com.example.travellingdealer

import kotlin.math.pow
import kotlin.math.sqrt

class Node(var x: Int, var y: Int) {

    var distance: Double? = null
    private var following: Node? = null

    fun appendToEnd(x: Int, y: Int) {

        //Bulunduğum konumdan (x,y) - hedeflediğimiz konumu çıkartıyoruz. (x,y).
        //Çıkan x ve y değerlerinin toplamlarının karakökü alınır. Kök dışarı çıkartılır ve mesafe bulunur.

        var currentNode: Node? = this
        val newNode = Node(x = x, y = y)

        val xvalue = (currentNode!!.x - x).toDouble().pow(2)
        val yValue = (currentNode.y - y).toDouble().pow(2)
        newNode.distance = sqrt((xvalue + yValue))

        while (currentNode!!.following != null) {
            currentNode = currentNode.following
        }

        //Düğümün sonuna geldiğinde son node un followingine eklenir.

        currentNode.following = newNode
    }

    fun printNodes(): String {

        var nodesData = "Factory(3, 7)"

        val currentNode = this

        var nextNode: Node? = currentNode.following
        while (nextNode != null) {
            val stringPath = String.format("%.2f", nextNode.distance)
            nodesData =
                "$nodesData\nCustomer(${nextNode.x}, ${nextNode.y}) - $stringPath"
            nextNode = nextNode.following //Düğümün sonuna geldiğinde, en son datadan sonra bir yeni data olmayınca null atanır.
        }
        return nodesData
    }

    fun length(): Int {
        var length = 0
        var currentNode: Node? = this
        while (currentNode != null) {
            length++
            currentNode = currentNode.following //Düğümün sonuna geldiğinde, en son datadan sonra bir yeni data olmayınca null atanır.
        }
        return length
    }

    fun sumOfNodes(): Double {
        var distance = 0.0
        var currentNode: Node? = this
        while (currentNode != null) {
            distance += currentNode.distance!!
            currentNode = currentNode.following //Düğümün sonuna geldiğinde, en son datadan sonra bir yeni data olmayınca null atanır.
        }
        return distance
    }

    fun deleteNode(x: Int, y: Int): String {
        var currentNode: Node? = this

        var prevNode: Node? = null

        if (currentNode != null && currentNode.x == x && currentNode.y == y) {
            return "Factory position cannot be deleted"
        }

        while (currentNode != null && !(currentNode.x == x && currentNode.y == y)) {
            prevNode = currentNode
            currentNode = currentNode.following
        }

        if (currentNode == null)
            return "($x, $y) previously deleted"

        prevNode?.following = currentNode.following // Silinen node un öncesi, siline node un sonrasına bağlandı.
        return "($x, $y) deleted"
    }
}
