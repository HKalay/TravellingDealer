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
        init()
        initClickListener()
    }

    private fun init() {
        node = Node(x = 3, y = 7)
        nodeList.add(Node(x = 3, y = 7))
        node?.distance = 0.0
    }

    private fun initClickListener() {
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
            showAlertDialog(
                title = "Delete Location Info",
                message = node?.deleteNode(x = nodeList[0].x, y = nodeList[0].y)
            )
        }
    }

    private fun addCustomerLocation() {
        node?.appendToEnd(x = 1, y = 4)
        node?.appendToEnd(x = 1, y = 10)
        node?.appendToEnd(x = 2, y = 1)
        node?.appendToEnd(x = 5, y = 2)
        node?.appendToEnd(x = 6, y = 5)
        node?.appendToEnd(x = 8, y = 4)
        node?.appendToEnd(x = 8, y = 9)
        node?.appendToEnd(x = 9, y = 2)


        nodeList.add(Node(x = 1, y = 4))
        nodeList.add(Node(x = 1, y = 10))
        nodeList.add(Node(x = 2, y = 1))
        nodeList.add(Node(x = 5, y = 2))
        nodeList.add(Node(x = 6, y = 5))
        nodeList.add(Node(x = 8, y = 4))
        nodeList.add(Node(x = 8, y = 9))
        nodeList.add(Node(x = 9, y = 2))

        showAlertDialog(title = "Message", message = "Customer locations added")
    }

    private fun calculateDistance() {
        val distance = node?.sumOfNodes()
        val stringTotalDistance = String.format("%.2f", distance?.times(2))
        showAlertDialog(
            title = "Total Distance",
            message = "Distance: $stringTotalDistance"
        )
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