package com.example.memorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.memorygame.databinding.EasyModeBinding
import com.example.memorygame.databinding.MidModBinding

class InGameActivity : AppCompatActivity() {
    lateinit var binding : Any
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        when(intent.extras!!.getInt("difficulty")){
           0 -> {
               binding = EasyModeBinding.inflate(layoutInflater)
               setContentView((binding as EasyModeBinding).root)
           }
           1 -> {
               binding = MidModBinding.inflate(layoutInflater)
               setContentView((binding as MidModBinding).root)
           }
//           2 -> {
//               binding = HardModeBinding.inflate(layoutInflater)
//               setContentView((binding as HardModeBinding).root)
//           }
        }

    }

    fun adaptLayout(difficulty: Int){

    }
    fun easyModeLayout(){
        val viewNeeded = 2
        var linearLayout: LinearLayout
        for (i in 1..2) {
            linearLayout = createLinearLayout(i, viewNeeded)

        }
    }
    private fun createLinearLayout(id:Int, viewNeeded:Int): LinearLayout {
        val linearLayout = LinearLayout(this)
        linearLayout.id = id
        linearLayout.gravity = Gravity.CENTER_VERTICAL
        linearLayout.addChildrenForAccessibility( getImageViews(id,viewNeeded))

        return linearLayout
    }

    private fun getImageViews(parentId:Int,totalViews:Int): ArrayList<View> {
        val imageViewList = mutableListOf<View>()
        for (i in 1..totalViews){
            createImageView(parentId, i)
        }
        return imageViewList as ArrayList<View>
    }
    private fun createImageView(rowId:Int, id:Int){
        val imageView = ImageView(this)
        imageView.id = ("$rowId$id").toInt()
        imageView.layoutParams.width = 100
        imageView.layoutParams.height = 150
        imageView.setImageResource(R.drawable.digimon)

    }
}
