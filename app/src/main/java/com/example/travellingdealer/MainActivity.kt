package com.example.travellingdealer

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var node: Node? = null
    private var nodeList = ArrayList<Node>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAddCustomerLocation.setOnClickListener {
            addCustomerLocation()
        }

        btnCalculate.setOnClickListener {
            calculateDistance()
        }

        btnShowCalculations.setOnClickListener {
            showAlertDialog(title = "Locations - Calculations", message = node?.printNodes())
        }

        btnLocationCount.setOnClickListener {
            showAlertDialog(title = "Location Count", message = node?.length().toString())
        }

        btnDeleteLocation.setOnClickListener {
            nodeList.shuffle()
            showAlertDialog(title = "Delete Location Info",message= node?.deleteNode(x = nodeList[0].x, y = nodeList[0].y))
        }

        node = Node(3, 7)
        nodeList.add(Node(3, 7))
        node?.distance = 0.0
    }

    private fun calculateDistance() {
        val distance = node?.sumOfNodes()
        val stringTotalDistance = String.format("%.5f", distance?.times(2))
        showAlertDialog(
            title = "Total Distance",
            message = "Distance: $stringTotalDistance"
        )
    }

    private fun addCustomerLocation() {
        node?.appendToEnd(1, 4)
        node?.appendToEnd(1, 10)
        node?.appendToEnd(2, 1)
        node?.appendToEnd(5, 2)
        node?.appendToEnd(6, 5)
        node?.appendToEnd(8, 4)
        node?.appendToEnd(8, 9)
        node?.appendToEnd(9, 2)


        nodeList.add(Node(1, 4))
        nodeList.add(Node(1, 10))
        nodeList.add(Node(2, 1))
        nodeList.add(Node(5, 2))
        nodeList.add(Node(6, 5))
        nodeList.add(Node(8, 4))
        nodeList.add(Node(8, 9))
        nodeList.add(Node(9, 2))

        showAlertDialog(title = "Message", message = "Customer locations added")
    }

    private fun showAlertDialog(message: String?, title: String?) {
        AlertDialog.Builder(this)
            .setMessage(message)
            .setTitle(title)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }.show()
    }
}