package com.example.photo_editor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), EditingToolsAdapter.OnItemSelected {
    private var mStickerBSFragment: StickerBSFragment? = null
    private val mEditingToolsAdapter = EditingToolsAdapter(this)

    override fun onToolSelected(toolType: ToolType) {
        when (toolType) {

//            TEXT -> {
//                val textEditorDialogFragment = TextEditorDialogFragment.show(this)
//                textEditorDialogFragment.setOnTextEditorListener(object :
//                    TextEditorDialogFragment.TextEditor() {
//                    fun onDone(inputText: String, colorCode: Int) {
//                        val styleBuilder = TextStyleBuilder()
//                        styleBuilder.withTextColor(colorCode)
//
//                        mPhotoEditor.addText(inputText, styleBuilder)
//                        mTxtCurrentTool.setText(R.string.label_text)
//                    }
//                })
//            }

            ToolType.STICKER -> mStickerBSFragment?.show(
                supportFragmentManager,
                mStickerBSFragment!!.tag
            )
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val llmTools = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvConstraintTools.layoutManager = llmTools
        rvConstraintTools.adapter = mEditingToolsAdapter
        mStickerBSFragment = StickerBSFragment()
    }
}
