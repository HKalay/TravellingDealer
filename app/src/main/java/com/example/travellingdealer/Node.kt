package com.example.travellingdealer

class Node(var x: Int, var y: Int) {

    var following: Node? = null

    fun appendToEnd(x: Int, y: Int) {
        val end = Node(x = x, y = y)

        var n: Node? = this

        while (n!!.following != null) {
            n = n.following
        }

        n.following = end
    }

    // TODO:: Implement to return the length of the SinglyLinkedList
    // For example:: --> 5 --> 6 --> 7 --> 3 --> .
    fun printNodes() {}

    // TODO:: Implement to return the length of the SinglyLinkedList
    fun length(h: Node?): Int {
        return 0
    }

    // TODO:: Implement to return the sum of the Nodes
    fun sumOfNodes(): Int {
        return 0
    }

    fun deleteNode(head: Node, x: Int, y: Int): Node? {
        val n: Node = head

        if (n.x == x && n.y == y) {
            return head.following
        }
        // TODO:: Implement the proper loop in order to remove given data

        //
        return head
    }
}