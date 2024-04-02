package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.time.Year

class MainActivity : AppCompatActivity() {
    enum class HistoricalFigures(val age: Int, val description: String){
        EVENT_1(46, "John F. Kennedy who was the 35th president of the United States of America. He died at the age of 46."),
        EVENT_2(67, "Leonardo Da Vinci who was a famous artist who painted the Mona Lisa in 1503. He died at the age of 67."),
        EVENT_3(39, "Dr Martin luther king jr who was a civil rights activist in the United States. he died at the age of 39."),
        EVENT_4(55, "Julius Caesar who was a roman. He died at the age of 55."),
        EVENT_5(95, "Nelson Mandela who was an anti-apartheid activist and served as the first president of South Africa. He died at the age of 95. "),
        EVENT_6(39, "Cleopatra VII who was the last ruler of the Ptolemaic Kingdom in Egypt and the remnants of her legacy are found in statues across museums. She died at the age of 39. "),
        EVENT_7(76, "Muhammad Ali who was a boxer and an activist who received the title of the greatest heavy weight boxer of all time. He died at the age of 76"),
        EVENT_8(81, "Queen Victoria who was the ruler of Great Britain and ireland from 1837 to 1901. She died at the age of 81."),
        EVENT_9(76, "Albert Einstein who was a German physicist that won a nobel peace prize for his theory of relativity. He died at the age of 76"),
        EVENT_10(20, "Joan of Arc who was a defender of France and later became a military leader despite her being a woman. She died at the age of 20 "),
        EVENT_11(84, "Pope John Paul II who was the sovereign leader of the Vatican city in Rome, Italy. He died at the age of 84"),
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //Declare variables used in your program.
        val edtAge = findViewById<EditText>(R.id.edtNumber)
        val resultView = findViewById<TextView>(R.id.resultsView)
        val generateButton = findViewById<Button>(R.id.generateButton)
        val clearButton = findViewById<Button>(R.id.clearButton)

        //We the add a button to generate the results.
        generateButton?.setOnClickListener()
        {
            val userAge = edtAge.text.toString().toInt()

            if (userAge != null && userAge in 20..100){

                val figureAge = HistoricalFigures.values().map { it.age}

                val historicalFigure = when (userAge)
                {

                    in figureAge -> { val history = HistoricalFigures.values().find {it.age == userAge}
                        listOf("You are $userAge old, the same age as " + "${history?.description?:"event"} ")
                    }

                    in figureAge.map {it -1} -> { val history = HistoricalFigures.values().find {it.age == userAge + 1}
                        listOf("You are one year younger than " + "${history?.description?:"event"} ")
                    }

                    in figureAge.map {it -2} -> { val history = HistoricalFigures.values().find {it.age == userAge + 2}
                        listOf("You are 2 years younger than " + "${history?.description?:"event"} ")
                    }

                    in figureAge.map { it +1} -> { val history = HistoricalFigures.values().find { it.age == userAge - 1}
                        listOf("You are one year older than " + "${history?.description?:"event"} ")
                    }

                    in figureAge.map { it +2} -> { val history = HistoricalFigures.values().find { it.age == userAge - 2}
                        listOf("You are two years older than " + "${history?.description?:"event"} ")
                    }

                    else -> listOf("There is not historical figure that is $userAge years old")

                }

                    resultView.text = historicalFigure.joinToString("\n")


            }



        }

       clearButton?.setOnClickListener {
           edtAge.text.clear()
           resultView.text = ""
       }



    }
}