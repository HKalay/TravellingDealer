package com.example.travellingdealer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.bntAddNode

class MainActivity : AppCompatActivity() {

    private var node = Node(x = 3, y = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initClickListener()

    }

    private fun initClickListener(){
        bntAddNode.setOnClickListener {
            addNode()
        }
    }

    private fun addNode() {
        node.appendToEnd(x = 1, y = 4)
        node.appendToEnd(x = 1, y = 10)
        node.appendToEnd(x = 2, y = 1)
        node.appendToEnd(x = 5, y = 2)
        node.appendToEnd(x = 6, y = 5)
        node.appendToEnd(x = 8, y = 4)
        node.appendToEnd(x = 8, y = 9)
        node.appendToEnd(x = 9, y = 2)
    }
}